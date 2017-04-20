package com.pzj.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.pzj.core.customer.commons.exception.CustomerException;
import com.pzj.core.customer.profile.CustomerUtil;
import com.pzj.framework.toolkit.RandomHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.common.global.UserGlobalDict;
import com.pzj.base.common.utils.PageBean;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysUser;
import com.pzj.core.customer.commons.exception.CustomerExceptionCode;
import com.pzj.core.customer.profile.QueryCustomerResponse;
import com.pzj.core.customer.salesman.CreateSalesmanRequest;
import com.pzj.core.customer.salesman.ModifySalesmanRequest;
import com.pzj.core.customer.salesman.QuerySalesmanRequest;
import com.pzj.core.customer.salesman.SalesmanDetail;
import com.pzj.core.customer.salesman.SalesmanService;
import com.pzj.core.customer.salesman.SalesmanSummary;
import com.pzj.core.customer.utils.ModelConvert;
import com.pzj.framework.context.Result;
import com.pzj.framework.entity.QueryResult;
import com.pzj.framework.toolkit.Check;

/**
 * Created by Administrator on 2017-2-26.
 */
@Service("salesmanServiceImpl")
public class SalesmanServiceImpl implements SalesmanService {
	private static final Logger logger = LoggerFactory.getLogger(SalesmanServiceImpl.class);
	@Resource
	private UserServiceImpl userService;

	@Override
	public Result<Boolean> verifyRecommendationCode(final String code) {
		return RpcCaller.call(new RpcCaller<Boolean>() {
			@Override
			public Boolean call() {
				if (code == null){
					throw new CustomerException(CustomerExceptionCode.PARAMETER_EMPTY);
				}
				SysUser userParam = new SysUser();
				userParam.setInvitationCode(code);
				List<SysUser> userList = userService.findListByParams(userParam);
				if (userList != null && userList.size() == 1) {
					SysUser user = userList.get(0);
					if (user.getAccountState() == GlobalParam.FLAG.start()
							&& user.getCheckStatus() == UserGlobalDict.passStatus()) {
						return true;
					}
					/*else {
						return false;
						//throw  new CustomerException(CustomerExceptionCode.SALESMAN_DISABLE);
					}*/
				}
				/*else {
					throw new CustomerException(CustomerExceptionCode.SALESMAN_NOT_EXIST);
				}*/
				return false;
			}
		});
	}

	@Override
	public Result<QueryResult<SalesmanSummary>> querySalesmansOfMaster(final QuerySalesmanRequest param) {
		return RpcCaller.call(new RpcCaller<QueryResult<SalesmanSummary>>() {
			@Override
			public QueryResult<SalesmanSummary> call() {
				final PageModel page = new PageModel(1, 20);
				if (param.getPageIndex() > 1) {
					page.setPageNo(param.getPageIndex());
				}
				if (param.getPageSize() > 0) {
					page.setPageSize(param.getPageSize());
				}

				SysUser userParam = new SysUser();

				userParam.setId(param.getId());
				if (param.getCorporater() != null) {
					userParam.setCorporater("%" + param.getCorporater() + "%");
				}
				if (param.getCorporaterMobile() != null) {
					userParam.setCorporaterMobile("%" + param.getCorporaterMobile() + "%");
				}
				userParam.setInvitationCode(param.getInvitationCode());
				if (param.getDepartment() != null) {
					userParam.setDepartment("%" + param.getDepartment() + "%");
				}
				userParam.setCity(param.getCity());
				userParam.setCounty(param.getCounty());
				userParam.setProvince(param.getProvince());
				userParam.setSupplierId(param.getSupplierId());
				userParam.setCreateDate(param.getCreateDate());
				userParam.setUserType(UserGlobalDict.salespersonType());
				userParam.setAccountState(GlobalParam.FLAG.start());

				PageList<SysUser> userList = userService.queryPageByParamMap(page, userParam);

				if (userList != null && userList.getResultList() != null) {
					PageBean pageBean = userList.getPageBean();
					int currentPage = pageBean.getCurrentPage();
					int pageSize = pageBean.getPageSize();
					int total = Integer.valueOf(String.valueOf(pageBean.getTotalCount()));

					QueryResult<SalesmanSummary> queryResult = new QueryResult<>(currentPage, pageSize);
					queryResult.setTotal(total);

					List<SysUser> resultList = userList.getResultList();
					if (resultList != null && resultList.size() > 0) {
						List<SalesmanSummary> salesmanSummaries = new ArrayList<>(resultList.size());
						for (SysUser user : resultList) {
							SalesmanSummary result = new SalesmanSummary();
							result.setId(user.getId());
							result.setCorporater(user.getCorporater());
							result.setCorporaterMobile(user.getCorporaterMobile());
							result.setInvitationCode(user.getInvitationCode());
							result.setDepartment(user.getDepartment());
							result.setCity(user.getCity());
							result.setCounty(user.getCounty());
							result.setProvince(user.getProvince());
							result.setSupplierId(user.getSupplierId());
							result.setCreateDate(user.getCreateDate());
							salesmanSummaries.add(result);
						}
						queryResult.setRecords(salesmanSummaries);
					}

					return queryResult;
				}

				return null;
			}
		});
	}

	@Override
	public Result<SalesmanDetail> querySalesmanById(final Long id) {
		return RpcCaller.call(new RpcCaller<SalesmanDetail>() {

			@Override
			public SalesmanDetail call() {
				SysUser user = userService.getById(id);

				if (user != null && UserGlobalDict.salespersonType().equals(user.getUserType())) {
					SalesmanDetail result = new SalesmanDetail();
					result.setId(user.getId());
					result.setCorporater(user.getCorporater());
					result.setCorporaterMobile(user.getCorporaterMobile());
					result.setInvitationCode(user.getInvitationCode());
					result.setDepartment(user.getDepartment());
					result.setCity(user.getCity());
					result.setCounty(user.getCounty());
					result.setProvince(user.getProvince());
					result.setSupplierId(user.getSupplierId());
					result.setCreateDate(user.getCreateDate());
					result.setAddress(user.getAddress());
					return result;
				}

				return null;
			}
		});
	}

	@Override
	public Result<Long> createSalesman(final CreateSalesmanRequest salesman) {
		return RpcCaller.call(new RpcCaller<Long>() {

			@Override
			public Long call() {
				if (salesman == null){
					throw new CustomerException(CustomerExceptionCode.PARAMETER_EMPTY);
				}
				if (salesman.getCorporater() == null){
					throw new CustomerException(CustomerExceptionCode.SALESMAN_NULL_NAME);
				}
				if (salesman.getCorporaterMobile() == null){
					throw new CustomerException(CustomerExceptionCode.SALESMAN_NULL_PHONE);
				}
				if (salesman.getCreateBy() == null){
					throw new CustomerException(CustomerExceptionCode.OPERATOR_ID_NULL);
				}

				SysUser operator = userService.getById(salesman.getCreateBy());
				if (operator == null){
					throw new CustomerException(CustomerExceptionCode.OPERATOR_NOT_EXIST);
				}
				if (!GlobalParam.FLAG.start().equals(operator.getAccountState())){
					throw new CustomerException(CustomerExceptionCode.OPERATOR_DISABLE);
				}

				Long supplierId = CustomerUtil.ownerId(operator);
				String invitationCode = buildInvitationCode();

				SysUser createSalesman = new SysUser();
				createSalesman.setUserType(UserGlobalDict.salespersonType());
				createSalesman.setCorporater(salesman.getCorporater());
				createSalesman.setCorporaterMobile(salesman.getCorporaterMobile());
				createSalesman.setName(salesman.getCorporater());
				createSalesman.setDepartment(salesman.getDepartment());
				createSalesman.setCreateBy(String.valueOf(salesman.getCreateBy()));
				createSalesman.setCreateDate(new Date());
				createSalesman.setCheckStatus(UserGlobalDict.passStatus());
				createSalesman.setCheckType(UserGlobalDict.UserCheckType.NOT_CHECK);
				createSalesman.setAccountState(GlobalParam.FLAG.start());
				createSalesman.setInvitationCode(invitationCode);
				createSalesman.setProvince(salesman.getProvince());
				createSalesman.setCity(salesman.getCity());
				createSalesman.setCounty(salesman.getCounty());
				createSalesman.setAddress(salesman.getAddress());
				createSalesman.setSupplierId(supplierId);
				createSalesman.setUserSource(operator.getUserSource());
				createSalesman.setIsRoot("0");

				Long insertId = userService.insert(createSalesman);

				return insertId;
			}
		});
	}

	/**
	 * 创建一个可用的推荐码，验证是否通用
	 * @return
	 */
	private String buildInvitationCode() {
		while (true) {
			String invitationCode = RandomHelper.mixed(4);
			SysUser chekcInvitationCode = new SysUser();
			chekcInvitationCode.setInvitationCode(invitationCode);

			int checkResult = userService.countByParams(chekcInvitationCode);
			if (checkResult == 0)
				return invitationCode;
		}
	}

	@Override
	public Result<Boolean> modifySalesman(final ModifySalesmanRequest salesman) {
		return RpcCaller.call(new RpcCaller<Boolean>() {

			@Override
			public Boolean call() {
				if (salesman == null){
					throw new CustomerException(CustomerExceptionCode.PARAMETER_EMPTY);
				}
				if (salesman.getId() == null){
					throw new CustomerException(CustomerExceptionCode.SALESMAN_ID_NULL);
				}
				if (salesman.getUpdateBy() == null){
					throw new CustomerException(CustomerExceptionCode.OPERATOR_ID_NULL);
				}

				SysUser updateUser = new SysUser();

				SysUser oldSalesman = userService.getById(salesman.getId());
				if (GlobalParam.FLAG.del().equals(oldSalesman.getAccountState())){
					throw new CustomerException(CustomerExceptionCode.SALESMAN_DELETED);
				}
				if (!GlobalParam.FLAG.start().equals(oldSalesman.getAccountState())){
					throw new CustomerException(CustomerExceptionCode.SALESMAN_DISABLE);
				}
				SysUser operator = userService.getById(salesman.getUpdateBy());
				if (operator == null){
					throw new CustomerException(CustomerExceptionCode.OPERATOR_NOT_EXIST);
				}
				if (!GlobalParam.FLAG.start().equals(operator.getAccountState())){
					throw new CustomerException(CustomerExceptionCode.OPERATOR_DISABLE);
				}
				if (!operator.getSupplierId().equals(oldSalesman.getSupplierId())){
					throw new CustomerException(CustomerExceptionCode.OPERATOR_SUPPLIER_MISMATCH);
				}

				updateUser.setId(salesman.getId());
				updateUser.setUpdateBy(String.valueOf(salesman.getUpdateBy()));
				updateUser.setUpdateDate(new Date());
				updateUser.setName(salesman.getCorporater());
				updateUser.setCorporater(salesman.getCorporater());
				updateUser.setCorporaterMobile(salesman.getCorporaterMobile());
				updateUser.setDepartment(salesman.getDepartment());
				updateUser.setProvince(salesman.getProvince());
				updateUser.setCity(salesman.getCity());
				updateUser.setCounty(salesman.getCounty());
				updateUser.setAddress(salesman.getAddress());

				Integer update = userService.updateByPrimaryKey(updateUser);

				return update > 0;
			}
		});
	}

	@Override
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

	@Override
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
}
