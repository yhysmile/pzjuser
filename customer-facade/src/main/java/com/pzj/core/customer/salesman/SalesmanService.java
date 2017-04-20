package com.pzj.core.customer.salesman;

import com.pzj.core.customer.profile.QueryCustomerResponse;
import com.pzj.framework.context.Result;
import com.pzj.framework.entity.QueryResult;

/**
 * Created by Administrator on 2017-2-16.
 */
public interface SalesmanService {

	/**
	 * 校验推荐码是否可用
	 *
	 * @api {dubbo} com.pzj.core.customer.profile.ProfileService#verifyRecommendationCode 校验推荐码是否可用
	 * @apiGroup 基础信息服务
	 * @apiVersion 1.3.0
	 * @apiDescription
	 * <p>
	 *     根据推荐码查询销售人员，如果不存在，返回false，如果存在检查其状态，如果为启用，返回ture，否则返回false。
	 * </p>
	 *
	 * @apiParam {String} code 推荐码
	 *
	 * @apiParamExample {json} 参数示例
	 * {
	 *     "code" : "xcvx"
	 * }
	 *
	 * @apiSuccess (响应数据) {int} errorCode 错误码
	 * @apiSuccess (响应数据) {String} errorMsg 错误说明
	 * @apiSuccess (响应数据) {Boolean=true:可用,false=不可用} data 推荐码是否可用
	 *
	 * @apiSuccessExample {json} 响应数据示例
	 *
	 * {
	 *     "errorCode" : 10000,
	 *     "errorMsg" : null,
	 *     "data" : true
	 * }
	 *
	 * @param code
	 * @return
	 */
	Result<Boolean> verifyRecommendationCode(String code);

	/**
	 * 查询主账号的销售人员
	 *
	 * @api {dubbo} com.pzj.core.customer.salesman.SalesmanService#querySalesmansOfMaster 查询主账号的销售人员
	 * @apiGroup 销售人员服务
	 * @apiVersion 1.3.0
	 * @apiDescription
	 * <p>
	 *     查询指定主账号id的销售人员，如有其它可选条件，则进行过滤，分页查询。
	 * </p>
	 *
	 * @apiParam (QuerySalesmanRequest) {Long} [id] 销售人员id
	 * @apiParam (QuerySalesmanRequest) {Long} supplierId 所属主账号id
	 * @apiParam (QuerySalesmanRequest) {String} [corporater] 联系人
	 * @apiParam (QuerySalesmanRequest) {String} [corporaterMobile] 手机号
	 * @apiParam (QuerySalesmanRequest) {String} [invitationCode] 推荐码
	 * @apiParam (QuerySalesmanRequest) {String} [department] 所属单位
	 * @apiParam (QuerySalesmanRequest) {String} [province] 省
	 * @apiParam (QuerySalesmanRequest) {String} [city] 市
	 * @apiParam (QuerySalesmanRequest) {String} [county] 县
	 * @apiParam (QuerySalesmanRequest) {String} [address] 地址
	 * @apiParam (QuerySalesmanRequest) {Date} [createDate] 创建的开始时间
	 * @apiParam (QuerySalesmanRequest) {Date} [createDateEnd] 创建的结束时间
	 *
	 * @apiParamExample {json} 参数示例
	 *
	 * {
	 *     "id" : 36346544324325,
	 *     "supplierId" : 6937854395645366,
	 *     "corporater" : "张三",
	 *     "corporaterMobile" : "15510147689",
	 *     "invitationCode" : "whfw",
	 *     "businessCertificate" : "47456775-f34",
	 *     "department" : "市场",
	 *     "province" : "北京",
	 *     "city" : "北京",
	 *     "county" : "朝阳",
	 *     "address" : "麦子店街",
	 *     "createDate" : "2017-01-09 10:00:00",
	 *     "createDateEnd" : "2017-01-22 23:15:47"
	 * }
	 *
	 * @apiSuccess (响应数据) {int} errorCode 错误码
	 * @apiSuccess (响应数据) {String} errorMsg 错误说明
	 * @apiSuccess (响应数据) {List} data 查询结果，其每一个元素类型为SalesmanSummary
	 *
	 * @apiSuccess (SalesmanSummary) {Long} id 销售人员id
	 * @apiSuccess (SalesmanSummary) {Long} supplierId 所属供应商id
	 * @apiSuccess (SalesmanSummary) {String} corporater 联系人名
	 * @apiSuccess (SalesmanSummary) {String} corporaterMobile 联系人手机号
	 * @apiSuccess (SalesmanSummary) {String} invitationCode 推荐码
	 * @apiSuccess (SalesmanSummary) {String} department 所属单位
	 * @apiSuccess (SalesmanSummary) {String} province 省
	 * @apiSuccess (SalesmanSummary) {String} city 市
	 * @apiSuccess (SalesmanSummary) {String} county 县
	 * @apiSuccess (SalesmanSummary) {String} address 地址
	 * @apiSuccess (SalesmanSummary) {Date} createDate 创建时间
	 *
	 * @apiSuccessExample {json} 响应数据示例
	 *
	 * {
	 *     "errorCode" : 10000,
	 *     "errorMsg" : null,
	 *     "data" : [{
	 *         "id" : 36346544324325,
	 *         "supplierId" : 6937854395645366,
	 *         "corporater" : "张三",
	 *         "corporaterMobile" : "15510147689",
	 *         "invitationCode" : "whfw",
	 *         "businessCertificate" : "47456775-f34",
	 *         "department" : "市场",
	 *         "province" : "北京",
	 *         "city" : "北京",
	 *         "county" : "朝阳",
	 *         "address" : "麦子店街",
	 *         "createDate" : "2017-01-09 10:00:00",
	 *         "createDateEnd" : "2017-01-22 23:15:47"
	 *     }]
	 * }
	 *
	 * @param param
	 * @return
	 */
	Result<QueryResult<SalesmanSummary>> querySalesmansOfMaster(QuerySalesmanRequest param);

	/**
	 * 根据id查询销售人员
	 *
	 * @api {dubbo} com.pzj.core.customer.salesman.SalesmanService#querySalesmanById 根据id查询销售人员
	 * @apiGroup 销售人员服务
	 * @apiVersion 1.3.0
	 * @apiDescription
	 * <p>
	 *     根据销售人员id精确查询销售人员详细信息。
	 * </p>
	 *
	 * @apiParam {Long} id 销售人员id
	 *
	 * @apiParamExample {json} 参数示例
	 *
	 * {
	 *     "id" : 36346544324325
	 * }
	 *
	 * @apiSuccess (响应数据) {int} errorCode 错误码
	 * @apiSuccess (响应数据) {String} errorMsg 错误说明
	 * @apiSuccess (响应数据) {SalesmanDetail} data 查询结果，销售人员信息
	 *
	 * @apiSuccess (SalesmanDetail) {Long} id 销售人员id
	 * @apiSuccess (SalesmanDetail) {Long} supplierId 所属供应商id
	 * @apiSuccess (SalesmanDetail) {String} name 销售人名称
	 * @apiSuccess (SalesmanDetail) {String} corporater 联系人名
	 * @apiSuccess (SalesmanDetail) {String} corporaterMobile 联系人手机号
	 * @apiSuccess (SalesmanDetail) {String} invitationCode 推荐码
	 * @apiSuccess (SalesmanDetail) {String} department 所属单位
	 * @apiSuccess (SalesmanDetail) {String} province 省
	 * @apiSuccess (SalesmanDetail) {String} city 市
	 * @apiSuccess (SalesmanDetail) {String} county 县
	 * @apiSuccess (SalesmanDetail) {String} address 地址
	 * @apiSuccess (SalesmanDetail) {Date} createDate 创建时间
	 *
	 * @apiSuccessExample {json} 响应数据示例
	 *
	 * {
	 *     "errorCode" : 10000,
	 *     "errorMsg" : null,
	 *     "data" : {
	 *         "id" : 36346544324325,
	 *         "supplierId" : 6937854395645366,
	 *         "name" : "张三",
	 *         "corporater" : "张三",
	 *         "corporaterMobile" : "15510147689",
	 *         "invitationCode" : "whfw",
	 *         "businessCertificate" : "47456775-f34",
	 *         "department" : "市场",
	 *         "province" : "北京",
	 *         "city" : "北京",
	 *         "county" : "朝阳",
	 *         "address" : "麦子店街",
	 *         "createDate" : "2017-01-09 10:00:00",
	 *         "createDateEnd" : "2017-01-22 23:15:47"
	 *     }
	 * }
	 *
	 * @param id
	 * @return
	 */
	Result<SalesmanDetail> querySalesmanById(Long id);

	/**
	 * 新建销售人员
	 *
	 * @api {dubbo} com.pzj.core.customer.salesman.SalesmanService#createSalesman 新建销售人员
	 * @apiGroup 销售人员服务
	 * @apiVersion 1.3.0
	 * @apiDescription
	 * <p>
	 *     通过操作人id找到主账号信息，新建销售人员，设置其属于主账号，生成4位随机字符串的推荐码，需要检查推荐码是否已存在，创建时间为当前时间，状态默认为启用审核通过的。
	 * </p>
	 *
	 * @apiParam (CreateSalesmanRequest) {String} corporater 联系人名
	 * @apiParam (CreateSalesmanRequest) {String} corporaterMobile 手机号
	 * @apiParam (CreateSalesmanRequest) {String} createBy 操作人id
	 * @apiParam (CreateSalesmanRequest) {String} [department] 所属单位
	 *
	 * @apiParamExample {json} 参数示例
	 *
	 * {
	 *     "corporater" : "张三",
	 *     "corporaterMobile" : "15510147689",
	 *     "createBy" : 934789456456456,
	 *     "department" : "市场"
	 * }
	 *
	 * @apiSuccess (响应数据) {int} errorCode 错误码
	 * @apiSuccess (响应数据) {String} errorMsg 错误说明
	 * @apiSuccess (响应数据) {Long} data 销售人员的id
	 *
	 * @apiSuccessExample {json} 响应数据示例
	 *
	 * {
	 *     "errorCode" : 10000,
	 *     "errorMsg" : null,
	 *     "data" : 36346544324325
	 * }
	 *
	 * @param salesman
	 * @return
	 */
	Result<Long> createSalesman(CreateSalesmanRequest salesman);

	/**
	 * 修改销售人员
	 *
	 * @api {dubbo} com.pzj.core.customer.salesman.SalesmanService#modifySalesman 修改销售人员
	 * @apiGroup 销售人员服务
	 * @apiVersion 1.3.0
	 * @apiDescription
	 * <p>
	 *     根据销售人员id更新其信息
	 * </p>
	 *
	 * @apiParam (ModifySalesmanRequest) {Long} id 销售人员id
	 * @apiParam (ModifySalesmanRequest) {String} [corporater] 联系人名
	 * @apiParam (ModifySalesmanRequest) {String} [corporaterMobile] 手机号
	 * @apiParam (ModifySalesmanRequest) {String} [department] 所属单位
	 * @apiParam (ModifySalesmanRequest) {String} updateBy 操作人id
	 *
	 * @apiParamExample {json} 参数示例
	 *
	 * {
	 *     "id" : 36346544324325,
	 *     "corporater" : "张三",
	 *     "corporaterMobile" : "15510147689",
	 *     "department" : "市场",
	 *     "updateBy" : 934789456456456
	 * }
	 *
	 * @apiSuccess (响应数据) {int} errorCode 错误码
	 * @apiSuccess (响应数据) {String} errorMsg 错误说明
	 * @apiSuccess (响应数据) {Boolean=true:成功,false:失败} data 修改结果
	 *
	 * @apiSuccessExample {json} 响应数据示例
	 *
	 * {
	 *     "errorCode" : 10000,
	 *     "errorMsg" : null,
	 *     "data" : true
	 * }
	 * @param salesman
	 * @return
	 */
	Result<Boolean> modifySalesman(ModifySalesmanRequest salesman);

	/**
	 * @api {dubbo} com.pzj.core.customer.salesman.SalesmanService#queryAllReferee 根据名称、手机号、推荐码查询所有状态的推荐人信息
	 * @apiGroup 营销信息服务
	 * @apiName 根据名称、手机号、推荐码查询所以状态的推荐人信息
	 * @apiVersion 1.3.0-SNAPSHOT
	 * @apiDescription 根据名称、手机号、推荐码查询所以状态的推荐人信息
	 *
	 * @apiParam (请求参数) {Long} customerId 用户id
	 * @apiParam (请求参数) {String} refereeInfo 推荐人关键信息
	 *
	 * @apiParamExample 请求参数示例
	 *	{
	 *  "customerId": "12345678",
	 *	"refereeInfo": "13520"
	 * }
	 *
	 * @apiParam (响应数据) {int} errorCode 返回结果码
	 * @apiParam (响应数据) {String} errorMsg 返回结果提示
	 * @apiParam (响应数据) {List} data 匹配到的所有推荐人信息集合，其中每个元素类型为SysUser
	 *
	 *@apiSuccessExample {json} 成功响应数据
	 *{
	 *	 "errorCode": 10000,
	 *	 "errorMsg": "ok",
	 *	 "allTotal":"111"
	 *	 "data": {
	 *			 	{
	 *				 "supplierId": 123456,
	 *				 "invitationCode": "asqs",
	 *				 "name": "销售周",
	 *				 "corporaterMobile": "135********"
	 *	 		}
	 * 		}
	 *}
	 *
	 * @apiParam (错误码) {CustomerException} 14999 失败
	 *
	 * @apiErrorExample {json} 异常示例
	 * {
	 *    "errorCode" : 14999,
	 *    "errorMsg":"失败"
	 * }
	 */
	Result<QueryResult<QueryCustomerResponse>> queryAllReferee(Long customerId, String refereeInfo);

	/**
	 * @api {dubbo} com.pzj.core.customer.salesman.SalesmanService#queryAvailableReferee 根据名称、手机号、推荐码查询可用状态的推荐人信息
	 * @apiGroup 营销信息服务
	 * @apiName 根据名称、手机号、推荐码查询可用状态的推荐人信息
	 * @apiVersion 1.3.0-SNAPSHOT
	 * @apiDescription 根据名称、手机号、推荐码查询可用状态的推荐人信息
	 *
	 * @apiParam (请求参数) {Long} customerId 用户id
	 * @apiParam (请求参数) {String} refereeInfo 推荐人关键信息
	 *
	 * @apiParamExample 请求参数示例
	 *	{
	 *  "customerId": "12345678",
	 *	"refereeInfo": "13520"
	 * }
	 *
	 * @apiParam (响应数据) {int} errorCode 返回结果码
	 * @apiParam (响应数据) {String} errorMsg 返回结果提示
	 * @apiParam (响应数据) {List} data 匹配到的所有推荐人信息集合，其中每个元素类型为SysUser
	 *
	 *@apiSuccessExample {json} 成功响应数据
	 *{
	 *	 "errorCode": 10000,
	 *	 "errorMsg": "ok",
	 *	 "allTotal":"111"
	 *	 "data": {
	 *			 	{
	 *				 "supplierId": 123456,
	 *				 "invitationCode": "asqs",
	 *				 "name": "销售周",
	 *				 "corporaterMobile": "135********"
	 *	 		}
	 * 		}
	 *}
	 *
	 * @apiParam (错误码) {CustomerException} 14999 失败
	 *
	 * @apiErrorExample {json} 异常示例
	 * {
	 *    "errorCode" : 14999,
	 *    "errorMsg":"失败"
	 * }
	 */
	Result<QueryResult<QueryCustomerResponse>> queryAvailableReferee(Long customerId, String refereeInfo);
}
