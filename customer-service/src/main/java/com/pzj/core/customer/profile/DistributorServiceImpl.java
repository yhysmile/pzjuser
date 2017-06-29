package com.pzj.core.customer.profile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.common.global.UserGlobalDict;
import com.pzj.base.entity.SysUser;
import com.pzj.common.service.RpcCaller;
import com.pzj.commons.utils.CheckUtils;
import com.pzj.core.customer.channel.ChannelDistributorWriteEngine;
import com.pzj.core.customer.common.exception.CustomerException;
import com.pzj.core.customer.common.exception.CustomerExceptionCode;
import com.pzj.core.customer.commons.ChannelResellerQueryModel;
import com.pzj.core.customer.commons.PageBean;
import com.pzj.core.customer.entitys.CustomerExtendsEntity;
import com.pzj.core.customer.profile.mq.CreateCustomer;
import com.pzj.core.customer.profile.mq.CustomerMqMessage;
import com.pzj.core.customer.utils.QueryUtil;
import com.pzj.framework.context.Result;
import com.pzj.framework.converter.JSONConverter;
import com.pzj.framework.entity.QueryResult;
import com.pzj.service.Impl.UserServiceImpl;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * Created by Administrator on 2017-2-16.
 */
@Service("newUserService")
public class DistributorServiceImpl implements DistributorService {
	private static final Logger logger = LoggerFactory.getLogger(DistributorServiceImpl.class);
	@Resource
	private UserServiceImpl userService;
	@Resource
	private CustomerQueryService customerQueryService;
	@Resource
	private CustomerUpdateEngine customerUpdateEngine;
	@Resource
	private CustomerExtendsService customerExtendsService;
	@Resource
	private CustomerMqMessage customerMqMessage;
	@Resource
	private CustomerCreateEngine customerCreateEngine;
	@Resource
	private CustomerWriteEngine customerWriteEngine;
	@Resource
	private PlatformTransactionManager platformTransactionManager;
	@Resource
	private ChannelDistributorWriteEngine channelDistributorWriteEngine;

	@Override
	public Result<QueryResult<QueryCustomerResponse>> queryDistributorsOfMaster(final QueryCustomerRequest param,
			final PageBean page) {
		logger.info("查询SaaS账号的绑定分销商参数：{}，分页：{}", JSONConverter.toJson(param), JSONConverter.toJson(page));

		Result<QueryResult<QueryCustomerResponse>> result = new RpcCaller<QueryResult<QueryCustomerResponse>>() {
			@Override
			public QueryResult<QueryCustomerResponse> call() {
				PageBean pageBeanParam = QueryUtil.defaultPageBean(page);

				QueryResult<QueryCustomerResponse> queryResult = customerQueryService.queryResellerListByPage(param,
						pageBeanParam);
				return queryResult;
			}
		}.args(param, page).run();

		logger.info("查询SaaS账号的绑定分销商结果：{}", JSONConverter.toJson(result));

		return result;
	}

	public Result<QueryDetailCustomerResponse> queryDistributorById(final Long id) {
		return RpcCaller.call(new RpcCaller<QueryDetailCustomerResponse>() {
			@Override
			public QueryDetailCustomerResponse call() {
				SysUser user = userService.getById(id);

				if (user == null) {
					return null;
				}

				QueryDetailCustomerResponse response = new QueryDetailCustomerResponse();

				response.setId(user.getId());
				response.setLoginName(user.getLoginName());
				response.setName(user.getName());
				response.setUserRelationCreateDate(user.getUserRelationCreateDate());
				response.setIdentifyType(user.getIdentifyType());
				if (user.getResellerType() != null) {
					response.setResellerType(Integer.valueOf(user.getResellerType()));
				}
				response.setSupplierNormal(user.getSupplierNormal());
				response.setCorporater(user.getCorporater());
				response.setCorporaterMobile(user.getCorporaterMobile());
				response.setBusinessCertificate(user.getBusinessCertificate());
				response.setBusinessLicense(user.getBusinessLicense());
				response.setGuideCertificate(user.getGuideCertificate());
				response.setCorporaterCredentials(user.getCorporaterCredentials());
				response.setHotlineReseller(user.getHotlineReseller());
				response.setHotlineSupplier(user.getHotlineSupplier());
				response.setLastLoginTime(user.getLastLoginTime());
				response.setSupplierId(user.getSupplierId());
				response.setOperChargerEmail(user.getOperChargerEmail());
				response.setOperChargerFax(user.getOperChargerFax());
				response.setOperChargerPhone(user.getOperChargerPhone());
				response.setProvince(user.getProvince());
				response.setCity(user.getCity());
				response.setCounty(user.getCounty());
				response.setAddress(user.getAddress());
				response.setLogo(user.getLogo());
				response.setBusinessQualification(user.getBusinessQualification());
				response.setHotlineSupplier(user.getHotlineSupplier());
				response.setHotlineReseller(user.getHotlineReseller());

				if (user.getName() == null || user.getName().trim().length() == 0) {
					response.setName(user.getCorporater());
				}

				return response;
			}
		});
	}

	@Override
	public Result<Long> createDistributor(final CreateCustomerRequest distributor) {

		Result<Long> result = new RpcCaller<Long>() {

			@Override
			public Long call() {
				CreateCustomerRequest result = customerCreateEngine.createDistributor(distributor);

				//创建成功发送mq消息
				sendCreateCustomer(result.getUserId(), result.getSupplierId(), result.getCreateBy());

				PassWordInfo passWordInfo = result.getPassWordInfo();
				// 是否需要发送密码的短信
				if (CheckUtils.isNotNull(passWordInfo) && CheckUtils.isNotNull(passWordInfo.getPassWord())) {
					// 发送短信
					sendPasswordSM(distributor, passWordInfo.getPassWord());
				}

				return result.getUserId();
			}
		}.args(distributor).run();

		return result;
	}

	private void sendCreateCustomer(Long customerId, Long supplierId, Long operId) {
		List<Long> customerIds = new ArrayList<>(1);
		customerIds.add(customerId);
		CreateCustomer createCustomer = new CreateCustomer(customerIds, supplierId, operId, new Date());
		customerMqMessage.sendCreateCustomerMsg(createCustomer);

	}

	private void sendPasswordSM(CreateCustomerRequest distributor, String initPassword) {
		//给用户发送短信
		distributor.setUserPassword(initPassword);
		Boolean sendSmsFlag = customerUpdateEngine.sendSms(distributor);
		logger.info("create distributor success!send message param:{}, result:{}", distributor, sendSmsFlag);
	}

	@Override
	public Result<ArrayList<CreateCustomerReport>> createDistributor(
			final CreateManyCustomerRequest createManyCustomerRequest) {
		logger.info("开始导入用户，入参：{}", JSONConverter.toJson(createManyCustomerRequest));

		Result<ArrayList<CreateCustomerReport>> result = new Result<>();

		try {
			if (createManyCustomerRequest == null) {
				throw new CustomerException(CustomerExceptionCode.PARAMETER_EMPTY);
			}
			List<CreateCustomerRequest> distributors = createManyCustomerRequest.getCreateCustomerRequests();
			if (distributors == null || distributors.isEmpty()) {
				throw new CustomerException(CustomerExceptionCode.CUSTOMER_CREATE_PARAM_NULL);
			}
			if (createManyCustomerRequest.getCreateBy() == null) {
				throw new CustomerException(CustomerExceptionCode.VISITOR_OPERATOR_NULL);
			}
			SysUser createByUser = userService.getById(createManyCustomerRequest.getCreateBy());
			if (createByUser == null) {
				throw new CustomerException(CustomerExceptionCode.OPERATOR_NOT_EXIST);
			}
			if (!GlobalParam.FLAG.start().equals(createByUser.getAccountState())) {
				throw new CustomerException(CustomerExceptionCode.OPERATOR_DISABLE);
			}

			ArrayList<CreateCustomerReport> createCustomerReports = new ArrayList<>();

			int createCount = distributors.size();
			for (int i = 0; i < createCount; i++) {
				CreateCustomerRequest createCustomerRequest = distributors.get(i);
				createCustomerRequest.setSupplierId(createByUser.getSupplierId());
				createCustomerRequest.setCreateBy(createManyCustomerRequest.getCreateBy());
				CreateCustomerReport createCustomerReport = createDistributorOfBatchDoThrowable(createCustomerRequest);
				if (createCustomerReport != null) {
					createCustomerReport.setParamIndex(i);
					createCustomerReports.add(createCustomerReport);
				}
			}

			if (!createCustomerReports.isEmpty()) {
				result.setData(createCustomerReports);
				result.setErrorCode(CustomerExceptionCode.CUSTOMER_BATCH_CREATE_ERROR.getCode());
				int successCount = createCount - createCustomerReports.size();
				result.setErrorMsg(CustomerExceptionCode.CUSTOMER_BATCH_CREATE_ERROR.getTemplateMessage(createCount,
						successCount));
				logger.error("批量创建用户失败，Reseult： {}", JSONConverter.toJson(result));
			} else {
				result.setErrorMsg("用户全部导入成功");
			}

		} catch (CustomerException e) {
			RpcCaller.catchCustomerException(result, e);
			logger.error(e.getMessage(), e);
		} catch (Throwable throwable) {
			RpcCaller.catchThrowable(result);
			logger.error(throwable.getMessage(), throwable);
		}

		logger.info("结束导入用户，结果为：{}", JSONConverter.toJson(result));
		return result;
	}

	private CreateCustomerReport createDistributorOfBatchDoThrowable(CreateCustomerRequest distributor) {
		Result<Long> result = null;

		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

		TransactionStatus transaction = platformTransactionManager.getTransaction(def);

		try {
			result = createDistributor(distributor);
			platformTransactionManager.commit(transaction);
		} catch (CustomerException e) {
			platformTransactionManager.rollback(transaction);
			result = new Result<>();
			RpcCaller.catchCustomerException(result, e);
			logger.error(e.getMessage(), e);
		} catch (Throwable throwable) {
			platformTransactionManager.rollback(transaction);
			result = new Result<>();
			RpcCaller.catchThrowable(result);
			logger.error(throwable.getMessage(), throwable);
		}
		if (result != null && !result.isOk()) {
			CreateCustomerReport createCustomerReport = new CreateCustomerReport();
			createCustomerReport.setLoginName(distributor.getLoginName());
			createCustomerReport.setErrorCode(result.getErrorCode());
			createCustomerReport.setErrorMsg(result.getErrorMsg());
			logger.error(result.getErrorMsg());
			return createCustomerReport;
		}
		return null;
	}

	private SysUser modifUser(ModifyCustomerRequest distributor, SysUser oldDistributor) {
		SysUser updateUser = new SysUser();
		updateUser.setId(distributor.getId());
		updateUser.setCorporater(distributor.getCorporater());
		updateUser.setCorporaterMobile(distributor.getCorporaterMobile());
		updateUser.setCorporaterCredentials(distributor.getCorporaterCredentials());
		updateUser.setGuideCertificate(distributor.getGuideCertificate());
		updateUser.setName(distributor.getName());
		updateUser.setBusinessCertificate(distributor.getBusinessCertificate());
		updateUser.setBusinessLicense(distributor.getBusinessLicense());
		updateUser.setBusinessQualification(distributor.getBusinessQualification());
		updateUser.setIdentifyType(distributor.getIdentifyType());
		if (distributor.getResellerType() != null) {
			updateUser.setResellerType(distributor.getResellerType().toString());
		}
		updateUser.setOperChargerPhone(distributor.getOperChargerPhone());
		updateUser.setOperChargerFax(distributor.getOperChargerFax());
		updateUser.setOperChargerEmail(distributor.getOperChargerEmail());
		updateUser.setSupplierNormal(distributor.getSupplierNormal());
		updateUser.setCity(distributor.getCity());
		updateUser.setProvince(distributor.getProvince());
		updateUser.setCounty(distributor.getCounty());
		updateUser.setAddress(distributor.getAddress());
		updateUser.setUpdateDate(new Date());
		updateUser.setHotlineReseller(distributor.getHotlineReseller());
		updateUser.setHotlineSupplier(distributor.getHotlineSupplier());
		if (distributor.getUpdateBy() != null) {
			updateUser.setUpdateBy(distributor.getUpdateBy().toString());
		}
		updateUser.setLogo(distributor.getLogo());

		if (UserGlobalDict.personal.equals(oldDistributor.getIdentifyType()) && distributor.getName() == null) {
			updateUser.setName(distributor.getCorporater());
		}
		return updateUser;
	}

	private void checkModifyDistributor(ModifyCustomerRequest distributor) {
		if (distributor.getId() == null) {
			throw new CustomerException(CustomerExceptionCode.ERROR, "用户id不能为空");
		}
		if (distributor.getUpdateBy() == null) {
			throw new CustomerException(CustomerExceptionCode.ERROR, "操作人不能为空");
		}
	}

	@Override
	public Result<Boolean> modifyDistributorBeforeFirstLogin(final ModifyCustomerRequest distributor) {
		return RpcCaller.call(new RpcCaller<Boolean>() {
			@Override
			public Boolean call() {
				checkModifyDistributor(distributor);

				SysUser oldDistributor = userService.getById(distributor.getId());
				if (oldDistributor == null) {
					return false;
				}

				SysUser updateUser = null;
				SysUser updateBy = userService.getById(Long.valueOf(distributor.getUpdateBy()));
				Long supplierId = CustomerUtil.masterId(updateBy);

				if (oldDistributor.getLastLoginTime() == null) {
					if (!oldDistributor.getCreateBy().equals(distributor.getUpdateBy().toString())) {
						SysUser createBy = userService.getById(Long.valueOf(oldDistributor.getCreateBy()));
						if (createBy.getSupplierId().equals(updateBy.getSupplierId())) {
							updateUser = modifUser(distributor, oldDistributor);
						}
					} else {
						updateUser = modifUser(distributor, oldDistributor);
					}
				}
				Integer update = 0;
				if (updateUser != null) {
					update = userService.updateByPrimaryKey(updateUser);
				}

				if (distributor.getRefereeId() != null || distributor.getBusinessId() != null) {
					modifyCustomerExtends(distributor, supplierId);
				}

				return update == null ? Boolean.FALSE : update >= 1;
			}
		});
	}

	private void modifyCustomerExtends(ModifyCustomerRequest distributor, Long supplierId) {
		if (distributor.getRefereeId() != null || distributor.getBusinessId() != null
				|| distributor.getHotlineReseller() != null || distributor.getHotlineSupplier() != null) {

			CustomerExtendsEntity extendsInfoModel = null;
			try {
				extendsInfoModel = customerExtendsService.queryCustomerExtendsByCustomerId(distributor.getId(),
						supplierId);
			} catch (CustomerException e) {
				if (e.getCode() != CustomerExceptionCode.QUERY_EXTENDS_ERROR.getCode()) {
					throw e;
				}
			} catch (Throwable throwable) {
				throw throwable;
			}

			if (extendsInfoModel != null) {
				extendsInfoModel = buildExtendsInfoModel(distributor, supplierId);
				customerExtendsService.updateCustomerExtends(extendsInfoModel);
			} else {
				if (distributor.getBusinessId() == null) {
					distributor.setBusinessId(distributor.getRefereeId());
				}
				extendsInfoModel = buildExtendsInfoModel(distributor, supplierId);
				customerExtendsService.intserCustomerExtends(extendsInfoModel);
			}
		}
	}

	@Override
	public Result<Boolean> modifyCustomer(final ModifyCustomerRequest distributor) {
		return RpcCaller.call(new RpcCaller<Boolean>() {
			@Override
			public Boolean call() {
				checkModifyDistributor(distributor);
				SysUser oldDistributor = userService.getById(distributor.getId());
				if (oldDistributor == null) {
					return false;
				}

				SysUser operator = userService.getById(distributor.getUpdateBy());
				Long supplierId = CustomerUtil.masterId(operator);

				if (!distributor.getUpdateBy().equals(distributor.getId())) {
					if (!(operator.getSupplierId().equals(distributor.getId()) || operator.getId().equals(
							oldDistributor.getSupplierId()))) {
						return false;
					}
				}

				SysUser updateUser = modifUser(distributor, oldDistributor);
				Integer update = 0;
				if (updateUser != null) {
					update = userService.updateByPrimaryKey(updateUser);
				}

				if (distributor.getRefereeId() != null || distributor.getBusinessId() != null) {
					modifyCustomerExtends(distributor, supplierId);
				}
				return update == null ? Boolean.FALSE : update >= 1;
			}
		});
	}

	private CustomerExtendsEntity buildExtendsInfoModel(ModifyCustomerRequest distributor, Long supplierId) {
		CustomerExtendsEntity extendsInfoModel = new CustomerExtendsEntity();
		extendsInfoModel.setCustomerId(distributor.getId());
		extendsInfoModel.setRefereeId(distributor.getRefereeId());
		extendsInfoModel.setBusinessId(distributor.getBusinessId());
		extendsInfoModel.setSupplierId(supplierId);
		return extendsInfoModel;
	}

	@Override
	public Result<Long> checkUserNameMobileMate(String name, String phone) {
		if (logger.isDebugEnabled()) {
			logger.debug("check user mobile mate,name:{},phone:{}", name, phone);
		}
		Result<Long> result = new Result<Long>();
		if (name == null || "".equals(name.trim())) {
			result.setErrorCode(CustomerExceptionCode.PARAMETER_EMPTY.getCode());
			result.setErrorMsg(CustomerExceptionCode.PARAMETER_EMPTY.getMsg());
			logger.error("query distributor by name param error!param:{}", name);
			return result;
		}

		Long id = customerQueryService.checkUserMobileMate(name, phone);
		result.setData(id);
		return result;
	}

	@Override
	public Result<Long> bindDirectDistributor(final BindCustomerRequest distributor) {

		Result<Long> result = new RpcCaller<Long>() {
			@Override
			public Long call() {
				return customerWriteEngine.bindDirectDistributor(distributor);
			}
		}.run();

		return result;
	}

	@Override
	public Result<Boolean> unbindDirectDistributor(BindCustomerRequest distributor) {
		Long supplierId = distributor.getSupplierId();
		Long resellerId = distributor.getResellerId();
		Long operateId = distributor.getOperateId();
		Date currentDate = new Date();

		// 解绑SaaS用户与分销商
		boolean result = customerWriteEngine.unbindDirectDistributor(supplierId, resellerId, operateId, currentDate);

		if (result) {
			// 解绑SaaS用户的渠道与分销商
			channelDistributorWriteEngine.unbindDistributorForMasterId(supplierId, resellerId, operateId, currentDate);
		}

		return new Result<>(result);
	}

	@Override
	public Result<QueryResult<QueryCustomerResponse>> queryChannelContainDistributors(
			ChannelResellerQueryModel requestModel, PageBean page) {
		if (logger.isDebugEnabled()) {
			logger.debug("query channel contains distributors request param:{}", JSONConverter.toJson(requestModel));
		}
		Result<QueryResult<QueryCustomerResponse>> result = new Result<QueryResult<QueryCustomerResponse>>();

		Boolean flag = checkChannelRelDistributor(requestModel);
		if (!flag) {
			result.setErrorCode(CustomerExceptionCode.PARAMETER_EMPTY.getCode());
			result.setErrorMsg(CustomerExceptionCode.PARAMETER_EMPTY.getMsg());
			logger.error("query channel contains distributors param error!param:{}", JSONConverter.toJson(requestModel));
			return result;
		}

		PageBean pageBeanParam = QueryUtil.defaultPageBean(page);

		QueryResult<QueryCustomerResponse> queryResult = customerQueryService.queryChannelRelUserPage(requestModel,
				pageBeanParam);
		result.setData(queryResult);
		if (logger.isDebugEnabled()) {
			logger.debug("query channel contains distributors result:{}", JSONConverter.toJson(result));
		}
		return result;
	}

	private Boolean checkChannelRelDistributor(ChannelResellerQueryModel requestModel) {
		Boolean flag = Boolean.TRUE;
		if (requestModel == null) {
			return Boolean.FALSE;
		}
		if (requestModel.getRootId() == null && requestModel.getChannelId() == null) {
			flag = Boolean.FALSE;
		}
		return flag;
	}

	private Boolean checkChannelNotRelDistributor(ChannelResellerQueryModel requestModel) {
		Boolean flag = Boolean.TRUE;
		if (requestModel == null) {
			return Boolean.FALSE;
		}
		if (requestModel.getRootId() == null) {
			flag = Boolean.FALSE;
		}
		return flag;
	}

	@Override
	public Result<QueryResult<QueryCustomerResponse>> queryChannelNotContainDistributors(
			ChannelResellerQueryModel requestModel, PageBean page) {
		if (logger.isDebugEnabled()) {
			logger.debug("query channel not contains distributors request param:{}", JSONConverter.toJson(requestModel));
		}
		Result<QueryResult<QueryCustomerResponse>> result = new Result<QueryResult<QueryCustomerResponse>>();

		Boolean flag = checkChannelNotRelDistributor(requestModel);
		if (!flag) {
			result.setErrorCode(CustomerExceptionCode.PARAMETER_EMPTY.getCode());
			result.setErrorMsg(CustomerExceptionCode.PARAMETER_EMPTY.getMsg());
			logger.error("query channel not contains distributors param error!param:{}",
					JSONConverter.toJson(requestModel));
			return result;
		}

		PageBean pageBeanParam = QueryUtil.defaultPageBean(page);

		QueryResult<QueryCustomerResponse> queryResult = customerQueryService.queryChannelNotRelUserPage(requestModel,
				pageBeanParam);
		result.setData(queryResult);

		if (logger.isDebugEnabled()) {
			logger.debug("query channel not contains distributors result:{}", JSONConverter.toJson(result));
		}
		return result;
	}

	@Override
	public Result<QueryDetailCustomerResponse> queryDistributorDetail(Long resellerId) {
		Result<QueryDetailCustomerResponse> result = new Result<QueryDetailCustomerResponse>();
		if (resellerId == null) {
			result.setErrorCode(CustomerExceptionCode.PARAMETER_EMPTY.getCode());
			result.setErrorMsg(CustomerExceptionCode.PARAMETER_EMPTY.getMsg());
			logger.error("query distributor detail param error!resellerId:{}", resellerId);
			return result;
		}
		Result<QueryDetailCustomerResponse> resellerBaseResult = queryDistributorById(resellerId);

		return resellerBaseResult;
	}

	private Boolean checkQueryResellerMarketing(Long resellerId, Long rootId) {
		if (resellerId == null || rootId == null) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	@Override
	public Result<CustomerMarketingResponse> queryDistributorMarketing(Long resellerId, Long rootId) {
		Result<CustomerMarketingResponse> result = new Result<CustomerMarketingResponse>();
		if (!checkQueryResellerMarketing(resellerId, rootId)) {
			result.setErrorCode(CustomerExceptionCode.PARAMETER_EMPTY.getCode());
			result.setErrorMsg(CustomerExceptionCode.PARAMETER_EMPTY.getMsg());
			logger.error("query distributor marketing param error!resellerId:{},rootId:{}", resellerId, rootId);
			return result;
		}

		Result<QueryDetailCustomerResponse> resellerBaseResult = queryDistributorById(resellerId);
		QueryDetailCustomerResponse customerDetail = resellerBaseResult.getData();
		if (customerDetail != null) {
			CustomerMarketingResponse marketing = new CustomerMarketingResponse();
			marketing.setId(customerDetail.getId());
			marketing.setLoginName(customerDetail.getLoginName());
			marketing.setName(customerDetail.getName());
			marketing.setUserRelationCreateDate(customerDetail.getUserRelationCreateDate());
			marketing.setIdentifyType(customerDetail.getIdentifyType());
			if (customerDetail.getResellerType() != null) {
				marketing.setResellerType(Integer.valueOf(customerDetail.getResellerType()));
			}
			marketing.setSupplierNormal(customerDetail.getSupplierNormal());
			marketing.setCorporater(customerDetail.getCorporater());
			marketing.setCorporaterMobile(customerDetail.getCorporaterMobile());
			marketing.setBusinessCertificate(customerDetail.getBusinessCertificate());
			marketing.setBusinessLicense(customerDetail.getBusinessLicense());
			marketing.setGuideCertificate(customerDetail.getGuideCertificate());
			marketing.setCorporaterCredentials(customerDetail.getCorporaterCredentials());
			marketing.setHotlineReseller(customerDetail.getHotlineReseller());
			marketing.setHotlineSupplier(customerDetail.getHotlineSupplier());
			marketing.setLastLoginTime(customerDetail.getLastLoginTime());
			marketing.setSupplierId(customerDetail.getSupplierId());
			marketing.setOperChargerEmail(customerDetail.getOperChargerEmail());
			marketing.setOperChargerFax(customerDetail.getOperChargerFax());
			marketing.setOperChargerPhone(customerDetail.getOperChargerPhone());
			marketing.setProvince(customerDetail.getProvince());
			marketing.setCity(customerDetail.getCity());
			marketing.setCounty(customerDetail.getCounty());
			marketing.setAddress(customerDetail.getAddress());
			marketing.setLogo(customerDetail.getLogo());
			marketing.setBusinessQualification(customerDetail.getBusinessQualification());
			marketing.setHotlineSupplier(customerDetail.getHotlineSupplier());
			marketing.setHotlineReseller(customerDetail.getHotlineReseller());

			result.setData(marketing);
			CustomerExtendsEntity customerExtendsEntity = customerExtendsService.queryCustomerExtendsByCustomerId(
					resellerId, rootId);
			if (customerExtendsEntity != null) {
				marketing.setBusinessId(customerExtendsEntity.getBusinessId());
				marketing.setRefereeId(customerExtendsEntity.getRefereeId());
			}
		}

		return result;
	}
}
