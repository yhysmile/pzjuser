package com.pzj.core.customer.visitor;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import com.pzj.common.service.RpcCaller;
import com.pzj.core.customer.commons.PageBean;
import com.pzj.service.Impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.entity.SysUser;
import com.pzj.core.customer.common.exception.CustomerException;
import com.pzj.core.customer.common.exception.CustomerExceptionCode;
import com.pzj.core.customer.profile.CustomerUtil;
import com.pzj.core.customer.entitys.VisitorEntity;
import com.pzj.framework.context.Result;
import com.pzj.framework.converter.JSONConverter;
import com.pzj.framework.entity.QueryResult;

/**
 * Created by Administrator on 2017-2-23.
 */
@Service("visitorServiceImpl")
public class VisitorServiceImpl implements VisitorService {

	private final Logger logger = LoggerFactory.getLogger(VisitorServiceImpl.class);
	@Resource
	private VisitorWriteEngine visitorWriteEngine;
	@Resource(name = "visitorReadEngine")
	private VisitorReadEngine visitorReadEngine;
	@Resource
	private UserServiceImpl userService;

	@Override
	public Result<Long> createVisitor(final CreateVisitorRequest createVisitorRequest) {
		return RpcCaller.call(new RpcCaller<Long>() {
			@Override
			public Long call() {
				checkFroCreateVisitor(createVisitorRequest);

				SysUser operator = userService.getById(createVisitorRequest.getOperator());

				if (operator == null) {
					throw new CustomerException(CustomerExceptionCode.OPERATOR_NOT_EXIST);
				}
				if (!GlobalParam.FLAG.start().equals(operator.getAccountState())) {
					throw new CustomerException(CustomerExceptionCode.OPERATOR_DISABLE);
				}

				Long ownerId = CustomerUtil.masterId(operator);

				VisitorEntity visitorEntity = new VisitorEntity();
				visitorEntity.setName(createVisitorRequest.getName());
				visitorEntity.setPhoneNum(createVisitorRequest.getPhoneNum());
				visitorEntity.setIdNum(createVisitorRequest.getIdNum());
				visitorEntity.setRemark(createVisitorRequest.getRemark());
				visitorEntity.setCreateBy(createVisitorRequest.getOperator());
				visitorEntity.setOwnerId(ownerId);

				visitorWriteEngine.createVisitor(visitorEntity);

				return visitorEntity.getId();
			}
		});
	}

	private void checkFroCreateVisitor(CreateVisitorRequest createVisitorRequest) {
		if (createVisitorRequest == null) {
			throw new CustomerException(CustomerExceptionCode.PARAMETER_EMPTY);
		}
		if (createVisitorRequest.getName() == null) {
			throw new CustomerException(CustomerExceptionCode.VISITOR_NAME_NULL);
		}
		if (createVisitorRequest.getOperator() == null) {
			throw new CustomerException(CustomerExceptionCode.VISITOR_OPERATOR_NULL);
		}
	}

	@Override
	public Result<Boolean> modifyVisitor(final ModifyVisitorRequest modifyVisitorRequest) {
		return RpcCaller.call(new RpcCaller<Boolean>() {
			@Override
			public Boolean call() {
				checkFroModifyVisitor(modifyVisitorRequest);

				VisitorEntity visitorEntity = new VisitorEntity();
				visitorEntity.setId(modifyVisitorRequest.getId());
				visitorEntity.setName(modifyVisitorRequest.getName());
				visitorEntity.setPhoneNum(modifyVisitorRequest.getPhoneNum());
				visitorEntity.setIdNum(modifyVisitorRequest.getIdNum());
				visitorEntity.setRemark(modifyVisitorRequest.getRemark());
				visitorEntity.setUpdateBy(modifyVisitorRequest.getOperator());
				visitorEntity.setUpdateDate(new Date());

				visitorWriteEngine.modifyVisitor(visitorEntity);

				return true;
			}
		});
	}

	private void checkFroModifyVisitor(ModifyVisitorRequest modifyVisitorRequest) {
		if (modifyVisitorRequest == null) {
			throw new CustomerException(CustomerExceptionCode.PARAMETER_EMPTY);
		}
		if (modifyVisitorRequest.getId() == null) {
			throw new CustomerException(CustomerExceptionCode.VISITOR_ID_NULL);
		}
		if (modifyVisitorRequest.getOperator() == null) {
			throw new CustomerException(CustomerExceptionCode.VISITOR_OPERATOR_NULL);
		}
		if (modifyVisitorRequest.getName() == null && modifyVisitorRequest.getIdNum() == null
				&& modifyVisitorRequest.getPhoneNum() == null && modifyVisitorRequest.getRemark() == null) {
			throw new CustomerException(CustomerExceptionCode.VISITOR_NO_UPDATE);
		}
	}

	@Override
	public Result<Boolean> deleteVisitor(final Long visitorId, final Long operator) {
		return RpcCaller.call(new RpcCaller<Boolean>() {
			@Override
			public Boolean call() {
				checkFroDeleteVisitor(visitorId, operator);

				visitorWriteEngine.deleteVisitor(visitorId, operator);

				return true;
			}
		});
	}

	@Override
	public Result<QueryResult<QueryVisitorSummaryResponse>> queryVisitorSummaryByPage(
			QueryVisitorRequest queryVisitorRequest, PageBean page) {
		Result<QueryResult<QueryVisitorSummaryResponse>> result = new Result<QueryResult<QueryVisitorSummaryResponse>>();
		if (queryVisitorRequest == null || queryVisitorRequest.getOwnerId() == null) {
			result.setErrorCode(CustomerExceptionCode.PARAMETER_EMPTY.getCode());
			result.setErrorMsg(CustomerExceptionCode.PARAMETER_EMPTY.getMsg());
			logger.error("query visitor by page param error! request:{},page:{}",
					JSONConverter.toJson(queryVisitorRequest), JSONConverter.toJson(page));
			return result;
		}
		if (logger.isDebugEnabled()) {
			logger.debug("query visitor by page,param:{},page:{}", JSONConverter.toJson(queryVisitorRequest),
					JSONConverter.toJson(page));
		}
		QueryResult<QueryVisitorSummaryResponse> queryResult = visitorReadEngine.queryVisitorPage(queryVisitorRequest,
				page);
		result.setData(queryResult);
		if (logger.isDebugEnabled()) {
			logger.debug("query visitor by page,result:{}", JSONConverter.toJson(result));
		}
		return result;
	}

	@Override
	public Result<QueryVisitorDetailResponse> queryVisitorDetailById(Long id) {
		Result<QueryVisitorDetailResponse> result = new Result<QueryVisitorDetailResponse>();
		if (null == id || id <= 0) {
			result.setErrorCode(CustomerExceptionCode.PARAMETER_EMPTY.getCode());
			result.setErrorMsg(CustomerExceptionCode.PARAMETER_EMPTY.getMsg());
			logger.error("query visitor detail param error! request:{}", id);
			return result;
		}
		if (logger.isDebugEnabled()) {
			logger.debug("query visitor detail,param:{}", id);
		}

		QueryVisitorDetailResponse visitorResponse = visitorReadEngine.queryVisitorDetail(id);
		result.setData(visitorResponse);
		if (logger.isDebugEnabled()) {
			logger.debug("query visitor detail,result:{}", JSONConverter.toJson(result));
		}
		return result;
	}

	@Override
	public Result<ArrayList<QueryVisitorSummaryResponse>> queryVisitorSummaryByNameMobile(String nameMobile,
			Long supplierId) {
		Result<ArrayList<QueryVisitorSummaryResponse>> result = new Result<ArrayList<QueryVisitorSummaryResponse>>();
		if (null == nameMobile || null == supplierId || "".equals(nameMobile.trim())) {
			result.setErrorCode(CustomerExceptionCode.PARAMETER_EMPTY.getCode());
			result.setErrorMsg(CustomerExceptionCode.PARAMETER_EMPTY.getMsg());
			logger.error("query visitor by nameOrMobile param error! request:{}", nameMobile);
			return result;
		}
		if (logger.isDebugEnabled()) {
			logger.debug("query visitor by nameOrMobile,param:{}", nameMobile);
		}

		ArrayList<QueryVisitorSummaryResponse> visitors = visitorReadEngine.queryVisitorByNameMobile(nameMobile,
				supplierId);
		result.setData(visitors);
		if (logger.isDebugEnabled()) {
			logger.debug("query visitor by nameOrMobile,result:{}", JSONConverter.toJson(result));
		}
		return result;
	}

	private void checkFroDeleteVisitor(Long visitorId, Long operator) {
		if (visitorId == null) {
			throw new CustomerException(CustomerExceptionCode.VISITOR_ID_NULL);
		}
		if (operator == null) {
			throw new CustomerException(CustomerExceptionCode.VISITOR_OPERATOR_NULL);
		}
	}
}
