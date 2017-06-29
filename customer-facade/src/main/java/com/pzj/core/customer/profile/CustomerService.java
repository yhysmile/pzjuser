package com.pzj.core.customer.profile;

import com.pzj.framework.context.Result;
import com.pzj.framework.entity.QueryResult;
import com.pzj.core.customer.commons.PageBean;

/**
 * Created by Administrator on 2017-3-29.
 */
public interface CustomerService {
	/**
	 * 根据分销商根据关联的主用户（SaaS用户）
	 * @param param
	 * @param page
	 * @return
	 */
	Result<QueryResult<QueryCustomerResponse>> queryMasterCustomerOfDistributor(QueryCustomerRequest param,
			PageBean page);

	/**
	 * 根据一些简单的参数查询用户最少的信息
	 * @param param
	 * @param page
	 * @return
	 */
	Result<QueryResult<QueryCustomerLessInfoResponse>> queryCustomerLessInfo(QueryCustomerLessInfoRequest param,
			PageBean page);

	/**
	 * @api {dubbo} com.pzj.core.customer.channel.CustomerService#queryCustomerFreeJoin 根据查询类型筛选用户信息
	 * @apiGroup 分销商信息服务
	 * @apiName 根据查询类型筛选用户信息
	 * @apiVersion 1.3.0-SNAPSHOT
	 * @apiDescription 根据查询类型筛选用户信息
	 *
	 * @apiParam (请求参数) {QueryCustomerRequest} customerRequest 用户查询条件
	 * @apiParam (请求参数) {Integer} operType 查询类型  GlobalParam.QueryType 
	 * 
	 * @apiParam (QueryCustomerRequest) {String} [corporater] 联系人
	 * @apiParam (QueryCustomerRequest) {String} [corporaterMobile] 手机号
	 * @apiParam (QueryCustomerRequest) {String} [name] 公司名称
	 * 
	 * @apiParam (响应数据) {int} errorCode 返回结果码
	 * @apiParam (响应数据) {String} errorMsg 返回结果提示
	 * @apiParam (响应数据) {QueryCustomerResponse} data 渠道信息
	 *
	 *@apiSuccessExample {json} 成功响应数据
	 *{
	 *	 "errorCode": 10000,
	 *	 "errorMsg": "ok",
	 *	 "data": {
	 *			 	{
	 *			 	 "loginName":"123456"
	 *				 "corporater": "渠道1",
	 *				 "corporaterMobile":"2017-2-27",
	 *				 "name":"公司名称",
	 *			     "address":"河北省秦皇岛市山海关区老龙头路",
	 *               "resellerType":2(//分销商类型 2:旅行社, 3:旅行社部门, 4:导游, 5:商户, 8:OTA)
	 *	 		}
	 * 		}
	 *}
	 * @apiParam (错误码) {CustomerException} 14999 失败
	 *
	 * @apiErrorExample {json} 异常示例
	 * {
	 *    "errorCode" : 14999,
	 *    "errorMsg":"失败"
	 * }
	 */
	Result<QueryResult<QueryCustomerResponse>> queryCustomerFreeJoin(QueryCustomerRequest customerRequest,
			PageBean pageBean, Integer operType);

	Result<Long> createSaasCustomer(CreateSaasCustomerRequest createSaasCustomerRequest);
}
