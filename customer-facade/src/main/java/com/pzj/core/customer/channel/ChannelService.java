package com.pzj.core.customer.channel;

import java.util.List;

import com.pzj.base.common.utils.PageModel;
import com.pzj.core.customer.profile.QueryCustomerRequest;
import com.pzj.framework.context.Result;
import com.pzj.framework.entity.QueryResult;

/**
 * Created by Administrator on 2017-2-16.
 */
public interface ChannelService {
	/**
	 * 创建渠道
	 *
	 * @api {dubbo} com.pzj.core.customer.channel.ChannelService#createChannel 创建渠道
	 * @apiGroup 渠道信息服务
	 * @apiVersion 1.3.0
	 * @apiDescription
	 * <p>
	 *     通过操作人id找到主账号信息，新建渠道，设置其主账号为操作人的主账号，名称可重复，渠道类型为直签类型。
	 * </p>
	 *
	 * @apiParam (CreateChannelRequest) {String} name 渠道名称
	 * @apiParam (CreateChannelRequest) {Long} createBy 操作人id
	 * @apiParam (CreateChannelRequest) {String} dataSource 创建渠道的软件平台编号
	 *
	 * @apiParamExample {json} 参数示例
	 *
	 * {
	 *     "name" : "全渠道",
	 *     "createBy" : 48381023784545,
	 *     "dataSource" : 2
	 * }
	 *
	 * @apiSuccess (响应数据) {int} errorCode 错误码
	 * @apiSuccess (响应数据) {String} errorMsg 错误说明
	 * @apiSuccess (响应数据) {Long} data 新渠道的id。
	 *
	 * @apiSuccessExample {json} 响应数据示例
	 *
	 * {
	 *     "errorCode" : 10000,
	 *     "errorMsg" : null,
	 *     "data" : 738472343256453
	 * }
	 *
	 * @apiError (错误码说明) 1 1。
	 *
	 * @return
	 */
	Result<Long> createChannel(CreateChannelRequest channel);

	/**
	 * 修改渠道
	 *
	 * @api {dubbo} com.pzj.core.customer.channel.ChannelService#modifyChannel 修改渠道
	 * @apiGroup 渠道信息服务
	 * @apiVersion 1.3.0
	 * @apiDescription
	 * <p>
	 *     更新指定id的渠道的名称。
	 * </p>
	 *
	 * @apiParam (ModifyChannelRequest) {Long} id 渠道id
	 * @apiParam (ModifyChannelRequest) {String} name 渠道名称
	 * @apiParam (ModifyChannelRequest) {Long} updateBy 操作人id
	 *
	 * @apiParamExample {json} 参数示例
	 *
	 * {
	 *     "id" : 738472343256453,
	 *     "name" : "全渠道新名称",
	 *     "updateBy" : 483810237845459
	 * }
	 *
	 * @apiSuccess (响应数据) {int} errorCode 错误码
	 * @apiSuccess (响应数据) {String} errorMsg 错误说明
	 * @apiSuccess (响应数据) {Boolean} data 修改是否执行成功
	 *
	 * @apiSuccessExample {json} 响应数据示例
	 *
	 * {
	 *     "errorCode" : 10000,
	 *     "errorMsg" : null,
	 *     "data" : true
	 * }
	 *
	 * @apiError (错误码说明) 1 1。
	 *
	 * @param channel
	 * @return
	 */
	Result<Boolean> modifyChannel(ModifyChannelRequest channel);

	/**
	 * 删除渠道
	 *
	 * @api {dubbo} com.pzj.core.customer.channel.ChannelService#modifyChannel 删除渠道
	 * @apiGroup 渠道信息服务
	 * @apiVersion 1.3.0
	 * @apiDescription
	 * <p>
	 *     更新指定id的渠道的状态为删除状态。发送消息。
	 * </p>
	 *
	 * @apiParam {Long} id 渠道id
	 * @apiParam {Long} operator 操作人id
	 *
	 * @apiParamExample {json} 参数示例
	 *
	 * {
	 *     "id" : 738472343256453,
	 *     "updateBy" : 483810237845459
	 * }
	 *
	 * @apiSuccess (响应数据) {int} errorCode 错误码
	 * @apiSuccess (响应数据) {String} errorMsg 错误说明
	 * @apiSuccess (响应数据) {Boolean} data 删除是否执行成功
	 *
	 * @apiSuccessExample {json} 响应数据示例
	 *
	 * {
	 *     "errorCode" : 10000,
	 *     "errorMsg" : null,
	 *     "data" : true
	 * }
	 *
	 * @apiError (错误码说明) 1 1。
	 *
	 * @param id
	 * @param operator 操作人
	 * @return
	 */
	Result<Boolean> deleteChannel(Long id, Long operator);

	/**
	 * @api {dubbo} com.pzj.core.customer.channel.ChannelService#queryChannelsUserJoin 查询用户已加入的渠道(支持临时生效的渠道查询,此接口可用于渠道列表)
	 * @apiGroup 渠道信息服务
	 * @apiName 查询用户已加入的渠道(此接口可用于渠道列表)
	 * @apiVersion 1.3.0-SNAPSHOT
	 * @apiDescription 查询用户已加入的渠道(此接口可用于渠道列表)
	 *
	 * @apiParam (请求参数) {QueryChannelRequest} channelRequest 渠道查询条件
	 *
	 * @apiParam (QueryChannelRequest) {Long} supplierId 供应商id(查询渠道列表，必填，否则，不填)
	 * @apiParam (QueryChannelRequest) {Long} [id] 渠道编号
	 * @apiParam (QueryChannelRequest) {String} [name] 渠道名称
	 * @apiParam (QueryChannelRequest) {Date} [createDate] 创建时间起
	 * @apiParam (QueryChannelRequest) {Date} [createEndDate] 创建时间止
	 *
	 * @apiParam (请求参数) {QueryCustomerRequest} customerRequest 用户查询条件
	 *
	 * @apiParam (QueryCustomerRequest) {Long} id 用户id(查询已加入渠道，必填，否则，不填)
	 * @apiParam (QueryCustomerRequest) {String} [corporater] 联系人
	 * @apiParam (QueryCustomerRequest) {String} [corporaterMobile] 手机号
	 * @apiParam (QueryCustomerRequest) {String} [name] 公司名称
	 *
	 * @apiParam (请求参数) {PageModel} pageModel 分页信息
	 *
	 * @apiParam (请求参数) {List} tmpDelIds 临时生效的id集合，其中每个元素类型为Long
	 * @apiParam (请求参数) {List} tmpAddIds 临时生效的id集合，其中每个元素类型为Long
	 *
	 * @apiParam (响应数据) {int} errorCode 返回结果码
	 * @apiParam (响应数据) {String} errorMsg 返回结果提示
	 * @apiParam (响应数据) {List} data 渠道信息集合，其中每个元素类型为QueryChannelResponse
	 *
	 * @apiParam (错误码) {CustomerException} 14999 失败
	 *
	 * @apiErrorExample {json} 异常示例
	 * {
	 *    "errorCode" : 14999,
	 *    "errorMsg":"失败"
	 * }
	 */
	Result<QueryResult<QueryChannelResponse>> queryChannelsUserJoin(QueryChannelRequest channelRequest,
			QueryCustomerRequest customerRequest, PageModel pageModel, List<Long> tmpDelIds, List<Long> tmpAddIds);

	/**
	 * @api {dubbo} com.pzj.core.customer.channel.ChannelService#queryChannelsUserNotJoin 查询用户未加入的渠道(支持临时生效的渠道查询)
	 * @apiGroup 渠道信息服务
	 * @apiName 查询用户未加入的渠道
	 * @apiVersion 1.3.0-SNAPSHOT
	 * @apiDescription 查询用户未加入的渠道
	 *
	 * @apiParam (请求参数) {QueryChannelRequest} channelRequest 渠道查询条件
	 *
	 * @apiParam (QueryChannelRequest) {Long} supplierId 供应商id(查询渠道列表，必填，否则，不填)
	 * @apiParam (QueryChannelRequest) {Long} [id] 渠道编号
	 * @apiParam (QueryChannelRequest) {String} [name] 渠道名称 
	 * @apiParam (QueryChannelRequest) {Date} [createDate] 创建时间起
	 * @apiParam (QueryChannelRequest) {Date} [createEndDate] 创建时间止
	 *
	 * @apiParam (请求参数) {QueryCustomerRequest} customerRequest 用户查询条件
	 *
	 * @apiParam (QueryCustomerRequest) {Long} id 用户id(查询已加入渠道，必填，否则，不填)
	 * @apiParam (QueryCustomerRequest) {String} [corporater] 联系人
	 * @apiParam (QueryCustomerRequest) {String} [corporaterMobile] 手机号
	 * @apiParam (QueryCustomerRequest) {String} [name] 公司名称
	 *
	 * @apiParam (请求参数) {PageModel} pageModel 分页信息
	 *
	 * @apiParam (请求参数) {List} tmpAddIds 临时生效的id集合，其中每个元素类型为Long
	 * @apiParam (请求参数) {List} tmpDelIds 临时生效的id集合，其中每个元素类型为Long
	 *
	 * @apiParam (响应数据) {int} errorCode 返回结果码
	 * @apiParam (响应数据) {String} errorMsg 返回结果提示
	 * @apiParam (响应数据) {List} data 渠道信息集合，其中每个元素类型为QueryChannelResponse
	 *
	 * @apiParam (错误码) {CustomerException} 14999 失败
	 *
	 * @apiErrorExample {json} 异常示例
	 * {
	 *    "errorCode" : 14999,
	 *    "errorMsg":"失败"
	 * }
	 */
	Result<QueryResult<QueryChannelResponse>> queryChannelsUserNotJoin(QueryChannelRequest channelRequest,
			QueryCustomerRequest customerRequest, PageModel pageModel, List<Long> tmpAddIds, List<Long> tmpDelIds);

	/**
	 * @api {dubbo} com.pzj.core.customer.channel.ChannelService#modifyUserOwnedChannel 用户新增和删除多个渠道
	 * @apiGroup 渠道信息服务
	 * @apiName 用户新增和删除多个渠道
	 * @apiVersion 1.3.0-SNAPSHOT
	 * @apiDescription 用户新增和删除多个渠道
	 *
	 * @apiParam (请求参数) {Long} customerId 用户id
	 * @apiParam (请求参数) {List} addChannelIds 新增的渠道id集合，其中每个元素类型为Long
	 * @apiParam (请求参数) {List} delChannelIds 删除的渠道id集合，其中每个元素类型为Long
	 * @apiParam (请求参数) {Long} operId 操作人id
	 *
	 * @apiParam (响应数据) {int} errorCode 返回结果码
	 * @apiParam (响应数据) {String} errorMsg 返回结果提示
	 * @apiParam (响应数据) {boolean} data 返回操作结果
	 *
	 * @apiSuccessExample {json} 成功响应数据
	 * {
	 *	 "errorCode": 10000,
	 *	 "errorMsg": "ok",
	 *	 "data": true
	 * }
	 * @apiParam (错误码) {CustomerException} 14999 失败
	 *
	 * @apiErrorExample {json} 异常示例
	 * {
	 *    "errorCode" : 14999,
	 *    "errorMsg":"失败"
	 * }
	 */
	Result<Boolean> modifyUserOwnedChannel(Long customerId, List<Long> addChannelIds, List<Long> delChannelIds,
			Long operId);

	/**
	 * @api {dubbo} com.pzj.core.customer.channel.ChannelService#modifyChannelOwnedUser 渠道新增和删除多个用户
	 * @apiGroup 渠道信息服务
	 * @apiName 渠道新增和删除多个用户
	 * @apiVersion 1.3.0-SNAPSHOT
	 * @apiDescription 渠道新增和删除多个用户
	 *
	 * @apiParam (请求参数) {Long} channelId 渠道id
	 * @apiParam (请求参数) {List} addCustomerIds 新增的用户id集合，其中每个元素类型为Long
	 * @apiParam (请求参数) {List} delCustomerIds 删除的用户id集合，其中每个元素类型为Long
	 * @apiParam (请求参数) {Long} operId 操作人id
	 *
	 * @apiParam (响应数据) {int} errorCode 返回结果码
	 * @apiParam (响应数据) {String} errorMsg 返回结果提示
	 * @apiParam (响应数据) {boolean} data 返回操作结果
	 *
	 *@apiSuccessExample {json} 成功响应数据
	 *{
	 *	 "errorCode": 10000,
	 *	 "errorMsg": "ok",
	 *	 "data": true
	 *}
	 * @apiParam (错误码) {CustomerException} 14999 失败
	 *
	 * @apiErrorExample {json} 异常示例
	 * {
	 *    "errorCode" : 14999,
	 *    "errorMsg":"失败"
	 * }
	 */
	Result<Boolean> modifyChannelOwnedUser(Long channelId, List<Long> addCustomerIds, List<Long> delCustomerIds,
			Long operId);

	/**
	 * @api {dubbo} com.pzj.core.customer.channel.ChannelService#queryChannelDetailByChannelId 根据渠道id查询渠道详情
	 * @apiGroup 渠道信息服务
	 * @apiName 根据渠道id查询渠道详情
	 * @apiVersion 1.3.0-SNAPSHOT
	 * @apiDescription 根据渠道id查询渠道详情
	 *
	 * @apiParam (请求参数) {Long} channelId 渠道id
	 *
	 * @apiParam (响应数据) {int} errorCode 返回结果码
	 * @apiParam (响应数据) {String} errorMsg 返回结果提示
	 * @apiParam (响应数据) {QueryChannelResponse} data 渠道详细信息
	 *
	 *@apiSuccessExample {json} 成功响应数据
	 *{
	 *	 "errorCode": 10000,
	 *	 "errorMsg": "ok",
	 *	 "data": {
	 *			 	{
	 *			 	 "id":"123456"
	 *				 "name": "渠道1",
	 *				 "createDate":"2017-2-27"
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
	Result<QueryChannelResponse> queryChannelDetailByChannelId(Long channelId);

	/**
	 * 根据渠道id，根据每个渠道关联的用户id。
	 * @param channelIds
	 * @return
	 */
	Result<QueryChannelRelationResponse> queryChannelRelationByChannelId(List<Long> channelIds);

	/**
	 * @api {dubbo} com.pzj.core.customer.channel.ChannelService#queryChannelFreeJoin 根据查询类型筛选渠道信息
	 * @apiGroup 渠道信息服务
	 * @apiName 根据查询类型筛选渠道信息
	 * @apiVersion 1.3.0-SNAPSHOT
	 * @apiDescription 根据查询类型筛选渠道信息
	 *
	 * @apiParam (请求参数) {QueryChannelRequest} channelRequest 渠道查询条件
	 * @apiParam (请求参数) {QueryCustomerRequest} customerRequest 用户查询条件
	 * @apiParam (请求参数) {Integer} operType 查询类型  GlobalParam.QueryType 
	 *
	 * @apiParam (QueryChannelRequest) {Long} [id] 渠道编号
	 * @apiParam (QueryChannelRequest) {String} [name] 渠道名称 
	 * @apiParam (QueryChannelRequest) {Date} [createDate] 创建时间起
	 * @apiParam (QueryChannelRequest) {Date} [createEndDate] 创建时间止
	 * @apiParam (QueryChannelRequest) {Long} childIds 渠道id集合
	 * 
	 * @apiParam (QueryCustomerRequest) {String} [corporater] 联系人
	 * @apiParam (QueryCustomerRequest) {String} [corporaterMobile] 手机号
	 * @apiParam (QueryCustomerRequest) {String} [name] 公司名称
	 * 
	 * @apiParam (响应数据) {int} errorCode 返回结果码
	 * @apiParam (响应数据) {String} errorMsg 返回结果提示
	 * @apiParam (响应数据) {QueryChannelResponse} data 渠道信息
	 *
	 *@apiSuccessExample {json} 成功响应数据
	 *{
	 *	 "errorCode": 10000,
	 *	 "errorMsg": "ok",
	 *	 "data": {
	 *			 	{
	 *			 	 "id":"123456"
	 *				 "name": "渠道1",
	 *				 "createDate":"2017-2-27",
	 *				 "userIds":,
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
	Result<QueryResult<QueryChannelResponse>> queryChannelFreeJoin(QueryChannelRequest channelRequest,
			QueryCustomerRequest customerRequest, PageModel pageModel, Integer operType);

}
