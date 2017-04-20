package com.pzj.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.pzj.base.entity.SysUserMicroshop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.common.global.PasswordGenerateUtil;
import com.pzj.base.common.global.UserGlobalDict;
import com.pzj.base.entity.SysUser;
import com.pzj.base.entity.SysUserRelation;
import com.pzj.base.service.sys.ISysUserRelationService;
import com.pzj.core.customer.common.exception.CustomerException;
import com.pzj.core.customer.common.exception.CustomerExceptionCode;
import com.pzj.core.customer.commons.ChannelResellerQueryModel;
import com.pzj.core.customer.profile.BindCustomerRequest;
import com.pzj.core.customer.profile.CreateCustomerReport;
import com.pzj.core.customer.profile.CreateCustomerRequest;
import com.pzj.core.customer.profile.CreateManyCustomerRequest;
import com.pzj.core.customer.profile.CustomerExtendsEntity;
import com.pzj.core.customer.profile.CustomerExtendsService;
import com.pzj.core.customer.profile.CustomerMarketingResponse;
import com.pzj.core.customer.profile.CustomerQueryService;
import com.pzj.core.customer.profile.CustomerUpdateService;
import com.pzj.core.customer.profile.DistributorService;
import com.pzj.core.customer.profile.ModifyCustomerRequest;
import com.pzj.core.customer.profile.PageBean;
import com.pzj.core.customer.profile.QueryCustomerRequest;
import com.pzj.core.customer.profile.QueryCustomerResponse;
import com.pzj.core.customer.profile.QueryDetailCustomerResponse;
import com.pzj.core.customer.utils.ModelConvert;
import com.pzj.core.customer.utils.UserConfig;
import com.pzj.core.customer.utils.UserRelationEnum;
import com.pzj.core.customer.utils.UserRelationStatusEnum;
import com.pzj.core.customer.utils.UserRootEnum;
import com.pzj.framework.context.Result;
import com.pzj.framework.converter.JSONConverter;
import com.pzj.framework.entity.QueryResult;
import com.pzj.framework.idgen.IDGenerater;
import com.pzj.framework.toolkit.Check;
import com.pzj.framework.toolkit.RandomHelper;

/**
 * Created by Administrator on 2017-2-16.
 */
@Service("newUserService")
public class NewUserServiceImpl implements DistributorService {
	private static final Logger logger = LoggerFactory.getLogger(NewUserServiceImpl.class);
	@Resource
	private UserServiceImpl userService;
	@Resource(name = "customerQueryService")
	private CustomerQueryService customerQueryService;
	@Resource(name = "customerUpdateService")
	private CustomerUpdateService customerUpdateService;
	@Resource(name = "sysUserRelationService")
	private ISysUserRelationService sysUserRelationService;
	@Resource(name = "customerExtendsService")
	private CustomerExtendsService customerExtendsService;
	@Autowired
	private UserMicroshopServiceImpl userMicroshopService;

	@Resource(name = "userConfig")
	private UserConfig userConfig;
	@Resource(name = "idGenerater")
	private IDGenerater idGenerater;

	@Override
	public Result<QueryResult<QueryCustomerResponse>> queryDistributorsOfMaster(QueryCustomerRequest param,
			PageBean page) {

		Result<QueryResult<QueryCustomerResponse>> result = new Result<QueryResult<QueryCustomerResponse>>();
		if (param == null || param.getSupplierId() == null) {
			result.setErrorCode(CustomerExceptionCode.PARAMETER_EMPTY.getCode());
			result.setErrorMsg(CustomerExceptionCode.PARAMETER_EMPTY.getMsg());
			logger.error("query distributor by page param error! request:{}", JSONConverter.toJson(param));
			return result;
		}
		if (logger.isDebugEnabled()) {
			logger.debug("query distributor page sysUser:{},pageModel:{}", JSONConverter.toJson(param),
					JSONConverter.toJson(page));
		}

		QueryResult<QueryCustomerResponse> queryResult = customerQueryService.queryResellerListByPage(param, page);
		result.setData(queryResult);

		if (logger.isDebugEnabled()) {
			logger.debug("query distributor by page result:{}", JSONConverter.toJson(result));
		}
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
	public Result<Long> createDistributor(CreateCustomerRequest distributor) {
		if (logger.isDebugEnabled()) {
			logger.debug("create distributor param:{}", JSONConverter.toJson(distributor));
		}

		Result<Long> result = new Result<>();
		Boolean flag = checkAddDistributor(distributor);
		if (!flag) {
			result.setErrorCode(CustomerExceptionCode.PARAMETER_EMPTY.getCode());
			result.setErrorMsg(CustomerExceptionCode.PARAMETER_EMPTY.getMsg());
			logger.error("create distributor param error! request:{}", JSONConverter.toJson(distributor));
			return result;
		}

		QueryCustomerResponse sysUser = customerUpdateService.queryUserByName(distributor.getLoginName());

		if (sysUser != null) {
			result.setErrorCode(CustomerExceptionCode.LOGINNAME_EXIST.getCode());
			result.setErrorMsg(CustomerExceptionCode.LOGINNAME_EXIST.getMsg());
			logger.warn("create distributor already exist,request param:{}", distributor);
			return result;
		}

		// 生成id
		Long resellerId = createNewCustomerId(distributor);

		Long supplierId = null;
		Long createBy = null;

		if (distributor.getCreateBy() != null) {
			// 如果只有创建人，根据创建人找所属主账号id
			SysUser createByUser = userService.getById(distributor.getCreateBy());

			if (createByUser == null) {
				result.setErrorCode(CustomerExceptionCode.OPERATOR_NOT_EXIST.getCode());
				result.setErrorMsg(CustomerExceptionCode.OPERATOR_NOT_EXIST.getMsg());
				logger.error("creater user not exist,request:{}", JSONConverter.toJson(distributor));
				return result;
			}

			//获取供应商id
			supplierId = getRootId(createByUser);
			createBy = distributor.getCreateBy();
		}

		if (distributor.getRefereeCode() != null) {
			// 如果有推荐码，根据推荐码的销售人员找所属主账号id
			QueryCustomerResponse invitCodeUser = customerQueryService.queryUserByInviteCode(distributor.getRefereeCode());
			if (null == invitCodeUser) {
				throw new CustomerException(CustomerExceptionCode.SALESMAN_NOT_EXIST, "推荐码：推荐码无效");
			}

			if (supplierId != null && invitCodeUser.getSupplierId() != null && !supplierId.equals(invitCodeUser.getSupplierId())){
				CustomerExceptionCode code = CustomerExceptionCode.SALESMAN_SUPPLIER_MISMATCH;
				String templateMessage = code.getTemplateMessage(distributor.getRefereeCode(), createBy, supplierId);
				logger.error(templateMessage);
				throw new CustomerException(code);
			}

			distributor.setRefereeId(invitCodeUser.getId());
			distributor.setBusinessId(invitCodeUser.getId());
			if (supplierId == null) {
				supplierId = invitCodeUser.getSupplierId();
			}
			if (createBy == null){
				createBy = invitCodeUser.getId();
			}
		}

		distributor.setSupplierId(supplierId);
		distributor.setCreateBy(createBy);


		boolean needPasswordInform = distributor.getUserPassword() == null && userConfig.getCustomerCreatePasswordSms();

		// 生成密码
		String initPassword = createNewCustomerPassword(distributor);
		// 创建用户
		customerUpdateService.addReseller(distributor);

		SysUserMicroshop userMicroshop = new SysUserMicroshop();
		userMicroshop.setUserId(resellerId);
		userMicroshop.setAvatar(userConfig.getMicroshopDefaultAvatar());
		userMicroshop.setName(userConfig.getMicroshopDefaultName());
		userMicroshop.setIntro(userConfig.getMicroshopDefaultIntro());
		userMicroshop.setCreateDate(new Date());
		userMicroshopService.insert(userMicroshop);

		// 是否需要发送密码的短信
		if (needPasswordInform) {
			// 发送短信
			sendPasswordSM(distributor, initPassword);
		}

		if (!resellerId.equals(createBy)) {
			//绑定直签分销商
			BindCustomerRequest bindReseller = new BindCustomerRequest();
			bindReseller.setResellerId(resellerId);
			bindReseller.setSupplierId(supplierId);
			bindReseller.setOperateId(createBy);
			Result<Long> bindResult = bindDirectDistributor(bindReseller);
			logger.info("create reseller bind relation,request:{},result:{}", JSONConverter.toJson(bindReseller),
					JSONConverter.toJson(bindResult));
		}

		if (logger.isDebugEnabled()) {
			logger.debug("create distributor result:{}", JSONConverter.toJson(result));
		}

		result.setData(resellerId);
		return result;
	}

	private Long createNewCustomerId(CreateCustomerRequest distributor) {
		Long userId = idGenerater.nextId();
		distributor.setUserId(userId);
		return userId;
	}

	private String createNewCustomerPassword(CreateCustomerRequest distributor) {
		String initPassword;
		if (distributor.getUserPassword() != null) {
			initPassword = distributor.getUserPassword();
		} else {
			initPassword = RandomHelper.mixed(6);
		}
		String yjPassword = PasswordGenerateUtil.generatePassword(distributor.getUserId(), distributor.getLoginName(),
				initPassword);
		distributor.setUserPassword(yjPassword);
		return initPassword;
	}

	private void sendPasswordSM(CreateCustomerRequest distributor, String initPassword) {
		//给用户发送短信
		distributor.setUserPassword(initPassword);
		Boolean sendSmsFlag = customerQueryService.sendSms(distributor);
		logger.info("create distributor success!send message param:{}, result:{}", distributor, sendSmsFlag);
	}

	private Boolean checkAddDistributor(CreateCustomerRequest distributor) {
		Boolean flag = Boolean.TRUE;
		if (distributor == null) {
			return Boolean.FALSE;
		}

		String loginName = null;

		flag: {
			//用户名、联系人、手机号、创建人id,数据来源
			if (distributor.getLoginName() == null || "".equals(loginName = distributor.getLoginName().trim())
					|| loginName.length() < 6) {
				flag = Boolean.FALSE;
				break flag;
			}
			if (distributor.getCorporater() == null || "".equals(distributor.getCorporater().trim())) {
				flag = Boolean.FALSE;
				break flag;
			}
			if (distributor.getCorporaterMobile() == null || "".equals(distributor.getCorporaterMobile().trim())) {
				flag = Boolean.FALSE;
				break flag;
			}
			if (distributor.getUserPassword() != null && distributor.getUserPassword().length() < 6) {
				flag = Boolean.FALSE;
				break flag;
			}
			/*if (distributor.getRefereeCode() != null && !distributor.getRefereeCode().matches("[a-zA-Z0-9]{4}")){
				throw new CustomerException(CustomerExceptionCode.CUSTOMER_BATCH_REFEREE_CODE_NULL, "推荐码：必须是4位的字母或数字");
			}*/
			if (distributor.getRefereeCode() != null){
				String code = distributor.getRefereeCode().trim();
				if (!code.equals("")){
					distributor.setRefereeCode(code);
				} else {
					distributor.setRefereeCode(null);
				}
			}
		}

		return flag;
	}

	@Override
	public Result<ArrayList<CreateCustomerReport>> createDistributor(
			final CreateManyCustomerRequest createManyCustomerRequest) {
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
		} catch (Throwable throwable) {
			RpcCaller.catchThrowable(result, throwable);
		}
		return result;
	}

	private CreateCustomerReport createDistributorOfBatchDoThrowable(CreateCustomerRequest distributor) {
		Result<Long> result = null;

		try {
			result = createDistributorOfBatch(distributor);
		} catch (CustomerException e) {
			result = new Result<>();
			RpcCaller.catchCustomerException(result, e);
		} catch (Throwable throwable) {
			result = new Result<>();
			RpcCaller.catchThrowable(result, throwable);
		}
		if (result != null) {
			CreateCustomerReport createCustomerReport = new CreateCustomerReport();
			createCustomerReport.setLoginName(distributor.getLoginName());
			createCustomerReport.setErrorCode(result.getErrorCode());
			createCustomerReport.setErrorMsg(result.getErrorMsg());
			logger.error(result.getErrorMsg());
			return createCustomerReport;
		}
		return null;
	}

	private Result<Long> createDistributorOfBatch(CreateCustomerRequest distributor) {
		Result<Long> result = createDistributor(distributor);

		if (result != null && result.isOk()) {
			BindCustomerRequest bindUser = new BindCustomerRequest();
			bindUser.setSupplierId(distributor.getSupplierId());
			bindUser.setResellerId(result.getData());
			bindUser.setOperateId(distributor.getCreateBy());
			bindDirectDistributor(bindUser);
			return null;
		}
		return result;
	}

	private SysUser convert(CreateCustomerRequest distributor) {

		SysUser updateUser = new SysUser();
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
		updateUser.setCreateDate(new Date());
		if (distributor.getCreateBy() != null) {
			updateUser.setCreateBy(distributor.getCreateBy().toString());
		}
		return updateUser;
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
				Long supplierId = CustomerUtil.ownerId(updateBy);

				if (oldDistributor.getLastLoginTime() == null) {
					if (!oldDistributor.getCreateBy().equals(distributor.getUpdateBy())) {
						SysUser createBy = userService.getById(Long.valueOf(oldDistributor.getCreateBy()));
						if (createBy.getSupplierId() == updateBy.getSupplierId()) {
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
				Long supplierId = CustomerUtil.ownerId(operator);

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

	public Result<QueryResult<QueryCustomerResponse>> queryAllReferee(Long customerId, String refereeInfo) {
		if (customerId == null || customerId < 0) {
			logger.warn("查询所有推荐人信息参数错误，参数信息customerId:{}", customerId);
			return new Result<>(CustomerExceptionCode.PARAMETER_EMPTY.getCode(),
					CustomerExceptionCode.PARAMETER_EMPTY.getMsg());
		}

		List<SysUser> referees = userService.findUserByRefereeInfo(customerId, refereeInfo, null);
		if (Check.NuNObject(referees)) {
			return new Result<>(new QueryResult<QueryCustomerResponse>(1, 20));
		}
		List<QueryCustomerResponse> customerResponseList = ModelConvert.convertToCustomerResponses(referees);
		QueryResult<QueryCustomerResponse> resule = new QueryResult<>(1, 20);
		resule.setRecords(customerResponseList);
		Result<QueryResult<QueryCustomerResponse>> resultResult = new Result<>(resule);
		return resultResult;
	}

	public Result<QueryResult<QueryCustomerResponse>> queryAvailableReferee(Long customerId, String refereeInfo) {
		if (customerId == null || customerId < 0) {
			logger.warn("查询所有推荐人信息参数错误，参数信息customerId:{}", customerId);
			return new Result<>(CustomerExceptionCode.PARAMETER_EMPTY.getCode(),
					CustomerExceptionCode.PARAMETER_EMPTY.getMsg());
		}

		List<SysUser> referees = userService.findUserByRefereeInfo(customerId, refereeInfo, GlobalParam.FLAG.start());
		if (Check.NuNObject(referees)) {
			return new Result<>(new QueryResult<QueryCustomerResponse>(1, 20));
		}
		List<QueryCustomerResponse> customerResponseList = ModelConvert.convertToCustomerResponses(referees);
		QueryResult<QueryCustomerResponse> resule = new QueryResult<>(1, 20);
		resule.setRecords(customerResponseList);
		Result<QueryResult<QueryCustomerResponse>> resultResult = new Result<>(resule);
		return resultResult;
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
	public Result<Long> bindDirectDistributor(BindCustomerRequest distributor) {
		if (logger.isDebugEnabled()) {
			logger.debug("bind direct distributor request param:{}", JSONConverter.toJson(distributor));
		}
		Result<Long> result = new Result<Long>();
		Boolean flag = checkBindDistributor(distributor);
		if (!flag) {
			result.setErrorCode(CustomerExceptionCode.PARAMETER_EMPTY.getCode());
			result.setErrorMsg(CustomerExceptionCode.PARAMETER_EMPTY.getMsg());
			logger.error("query distributor by name param error!param:{}", JSONConverter.toJson(distributor));
			return result;
		}

		QueryCustomerResponse sysUser = customerUpdateService.queryUserById(distributor.getResellerId());
		if (sysUser == null) {
			logger.warn("query user not exists!param:{}", JSONConverter.toJson(distributor));
			return result;
		}

		SysUser createByUser = userService.getById(distributor.getOperateId());

		if (createByUser == null) {
			result.setErrorCode(CustomerExceptionCode.OPERATOR_NOT_EXIST.getCode());
			result.setErrorMsg(CustomerExceptionCode.OPERATOR_NOT_EXIST.getMsg());
			logger.error("bind direct distributor user not exist,request:{}", JSONConverter.toJson(distributor));
			return result;
		}

		//获取供应商id
		Long supplierId = this.getRootId(createByUser);

		SysUserRelation sysUserRelation = new SysUserRelation();
		sysUserRelation.setUserId(supplierId);
		sysUserRelation.setRelUserId(distributor.getResellerId());
		sysUserRelation.setRelType(UserRelationEnum.SUPPLIER_DIRECT_RESELLER.getId());
		List<SysUserRelation> sysUserRelations = sysUserRelationService.queryUserRelations(sysUserRelation);
		if (sysUserRelations != null && sysUserRelations.size() > 0) {
			SysUserRelation opeUserRelation = sysUserRelations.get(0);
			if (opeUserRelation.getId() != null
					&& (opeUserRelation.getStatus() == null || opeUserRelation.getStatus() != UserRelationStatusEnum.AVAILABLE
							.getStatus())) {
				sysUserRelation.setUpdateBy(distributor.getOperateId());
				sysUserRelation.setStatus(UserRelationStatusEnum.AVAILABLE.getStatus());
				sysUserRelation.setId(opeUserRelation.getId());
				sysUserRelationService.updateUserStatusById(sysUserRelation);
			}
		} else {
			sysUserRelation.setStatus(UserRelationStatusEnum.AVAILABLE.getStatus());
			sysUserRelation.setCreateBy(distributor.getOperateId());
			sysUserRelation.setCreateDate(new Date());
			sysUserRelationService.createNoRepeat(sysUserRelation);
		}
		result.setData(distributor.getResellerId());
		return result;
	}

	private Boolean checkBindDistributor(BindCustomerRequest distributor) {
		Boolean flag = Boolean.TRUE;
		if (distributor == null) {
			return Boolean.FALSE;
		}
		flag: {
			if (distributor.getResellerId() == null) {
				flag = Boolean.FALSE;
				break flag;
			}
			if (distributor.getSupplierId() == null) {
				flag = Boolean.FALSE;
				break flag;
			}
			if (distributor.getOperateId() == null) {
				flag = Boolean.FALSE;
				break flag;
			}
		}

		return flag;
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
		QueryResult<QueryCustomerResponse> queryResult = customerQueryService.queryChannelRelUserPage(requestModel,
				page);
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

		QueryResult<QueryCustomerResponse> queryResult = customerQueryService.queryChannelNotRelUserPage(requestModel,
				page);
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

	private Long getRootId(SysUser createByUser) {
		if (createByUser == null) {
			return null;
		}
		//绑定直签分销商
		Long supplierId = null;
		String isRoot = createByUser.getIsRoot();
		if (UserRootEnum.checkIsRoot(isRoot)) {
			supplierId = createByUser.getId();
		} else {
			supplierId = createByUser.getSupplierId();
		}
		return supplierId;
	}
}
