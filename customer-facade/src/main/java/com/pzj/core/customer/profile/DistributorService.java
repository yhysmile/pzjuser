package com.pzj.core.customer.profile;

import java.util.ArrayList;

import com.pzj.core.customer.commons.ChannelResellerQueryModel;
import com.pzj.core.customer.commons.PageBean;
import com.pzj.framework.context.Result;
import com.pzj.framework.entity.QueryResult;

/**
 * Created by Administrator on 2017-2-16.
 */
public interface DistributorService {
	/**
	 * 查询主账号绑定的直签分销商
	 *
	 * @api {dubbo} com.pzj.core.customer.profile.DistributorService#queryDistributorsOfMaster 查询主账号绑定的直签分销商
	 * @apiGroup 分销商信息服务
	 * @apiVersion 1.3.0
	 * @apiDescription
	 *
	 * <p>
	 *     查询供应商绑定的分销商列表，如果指定了推荐人，需要通过推荐人查询。
	 * </p>
	 *
	 * @apiParam (请求参数) {QueryCustomerRequest} param 分销商条件
	 * @apiParam (请求参数) {PageBean} [page] 分页参数
	 *
	 * @apiParam (QueryCustomerRequest) {Long} supplierId 所属供应商id
	 * @apiParam (QueryCustomerRequest) {String} [loginName] 用户名
	 * @apiParam (QueryCustomerRequest) {String} [name] 公司名
	 * @apiParam (QueryCustomerRequest) {String} [supplierNormal] 品牌名
	 * @apiParam (QueryCustomerRequest) {String} [nameOrNormal] 公司名或品牌名
	 * @apiParam (QueryCustomerRequest) {String} [corporater] 联系人名
	 * @apiParam (QueryCustomerRequest) {String} [corporaterMobile] 联系人手机号
	 * @apiParam (QueryCustomerRequest) {String} [province] 省
	 * @apiParam (QueryCustomerRequest) {String} [city] 市
	 * @apiParam (QueryCustomerRequest) {String} [county] 县
	 * @apiParam (QueryCustomerRequest) {String} [address] 地址
	 * @apiParam (QueryCustomerRequest) {Integer=2:旅行社,3:旅行社部门,4:导游,5:商户,8:OTA} [resellerType] 分销商类型
	 * @apiParam (QueryCustomerRequest) {String} [bindDate] 绑定的开始时间
	 * @apiParam (QueryCustomerRequest) {String} [bindDateEnd] 绑定的结束时间
	 * 
	 * @apiParam (PageBean) {Integer} [pageSize] 每页显示条数
	 * @apiParam (PageBean) {Integer} [currentPage] 当前页码号 
	 *
	 * @apiParamExample {json} QueryCustomerRequest参数请求示例
	 * {
	 *     "supplierId" : 478278342345234,
	 *     "nameOrNormal" : "网易",
	 *     "corporater" : "张三",
	 *     "corporaterMobile" : "15510147689",
	 *     "province" : "北京",
	 *     "city" : "北京",
	 *     "county" : "朝阳",
	 *     "address" : "麦子店街",
	 *     "resellerType" : "5",
	 *     "bindDateBegin" : "2017-01-09 10:00:00",
	 *     "bindDateEnd" : "2017-01-20 10:00:00"
	 * }
	 *
	 * @apiSuccess (响应数据) {int} errorCode 错误码
	 * @apiSuccess (响应数据) {String} errorMsg 错误说明
	 * @apiSuccess (响应数据) {QueryResult} queryResult 分页查询分销商集合
	 * 
	 * @apiSuccess (QueryResult) {int} total 数据总数 
	 * @apiSuccess (QueryResult) {int} current_page 当前页 
	 * @apiSuccess (QueryResult) {int} total_page 总页数
	 * @apiSuccess (QueryResult) {int} page_size 每页最大记录数
	 * @apiSuccess (QueryResult) {Long} records 分销商QueryCustomerResponse集合
	 *
	 * @apiSuccess (QueryCustomerResponse) {Long} id 分销商id
	 * @apiSuccess (QueryCustomerResponse) {String} name 分销商名称
	 * @apiSuccess (QueryCustomerResponse) {String} corporater 联系人名
	 * @apiSuccess (QueryCustomerResponse) {String} corporaterMobile 联系人手机号
	 * @apiSuccess (QueryCustomerResponse) {String} province 省
	 * @apiSuccess (QueryCustomerResponse) {String} city 市
	 * @apiSuccess (QueryCustomerResponse) {String} county 县
	 * @apiSuccess (QueryCustomerResponse) {String} address 地址
	 * @apiSuccess (QueryCustomerResponse) {Integer=2:旅行社,3:旅行社部门,4:导游,5:商户,8:OTA} resellerType 分销商类型
	 * @apiSuccess (QueryCustomerResponse) {Date} userRelationCreateDate 绑定关系的时间
	 *
	 * @apiSuccessExample {json} 响应数据示例
	 *
	 * {
	 *     "errorCode" : 10000,
	 *     "errorMsg" : null,
	 *     "data" : {
	 *     		"total": 10000,
	 *     		"current_page":1,
	 *     		"total_page":1000,
	 *     		"page_size":10,
	 *     		"records": [{
	 *         	 "id" : 36346544324325,
	 *         	 "name" : "网易",
	 *         	 "corporater" : "张三",
	 *         	 "corporaterMobile" : "15510147689",
	 *         	 "province" : "北京",
	 *         	 "city" : "北京",
	 *         	 "county" : "朝阳",
	 *         	 "address" : "麦子店街",
	 *         	 "resellerType" : "5",
	 *         	 "userRelationCreateDate" : "2017-01-09 10:00:00"
	 *     		}]
	 * 		}
	 *
	 */
	Result<QueryResult<QueryCustomerResponse>> queryDistributorsOfMaster(QueryCustomerRequest param, PageBean page);

	/**
	 * 检查用户名和手机号是否匹配
	 *
	 * @api {dubbo} com.pzj.core.customer.profile.DistributorService#checkUserNameMobileMate 检查用户名和手机号是否匹配
	 * @apiGroup 分销商信息服务
	 * @apiVersion 1.3.0
	 * @apiDescription
	 *
	 * <p>
	 *     检查用户名和手机号是否匹配。
	 * </p>
	 *
	 * @apiParam (请求参数) {String} name 分销商名称
	 * @apiParam (请求参数) {String} phone 手机号
	 *
	 * @apiParamExample {String} 请求参数示例
	 * {
	 *     "name" : "张三",
	 *     "phone": "18905673546"
	 * }
	 *
	 * @apiSuccess (响应数据) {int} errorCode 错误码
	 * @apiSuccess (响应数据) {String} errorMsg 错误说明
	 * @apiSuccess (响应数据) {Long} data 用户已经绑定手机号用户id
	 *
	 * @apiSuccessExample {json} 响应数据示例
	 *
	 * {
	 *     "errorCode" : 10000,
	 *     "errorMsg" : null,
	 *     "data" : 123456789
	 * }
	 *
	 */
	Result<Long> checkUserNameMobileMate(String name, String phone);

	/**
	 * 查询渠道包含的分销商
	 *
	 * @api {dubbo} com.pzj.core.customer.profile.DistributorService#queryChannelNotContainDistributors 查询渠道包含的分销商
	 * @apiGroup 分销商信息服务
	 * @apiVersion 1.3.0
	 * @apiDescription
	 *
	 * <p>
	 *     查询渠道包含的分销商。
	 * </p>
	 *
	 * @apiParam (请求参数) {ChannelResellerQueryModel} requestModel 渠道分销商查询模型
	 * @apiParam (请求参数) {PageBean} page 分页参数
	 *
	 * @apiParam (ChannelResellerQueryModel) {Long} channelId 渠道id或主账号id一个不为空
	 * @apiParam (ChannelResellerQueryModel) {String} rootId 主账号id或渠道id一个不为空
	 * @apiParam (ChannelResellerQueryModel) {String} [loginName] 用户名
	 * @apiParam (ChannelResellerQueryModel) {String} [name] 公司名
	 * @apiParam (ChannelResellerQueryModel) {String} [concat] 联系人
	 * @apiParam (ChannelResellerQueryModel) {String} [mobile] 联系人手机号
	 * @apiParam (ChannelResellerQueryModel) {String} [address] 地址区域
	 * @apiParam (ChannelResellerQueryModel) {String=2:旅行社,3:旅行社部门,4:导游,5:商户,8:OTA} [resellerType] 分销商类型
	 * @apiParam (ChannelResellerQueryModel) {String} [bindSDate] 绑定的开始时间
	 * @apiParam (ChannelResellerQueryModel) {String} [bindEDate] 绑定的结束时间
	 * @apiParam (ChannelResellerQueryModel) {String} [province] 省
	 * @apiParam (ChannelResellerQueryModel) {String} [city] 市
	 * @apiParam (ChannelResellerQueryModel) {String} [county] 县
	 * 
	 * @apiParam (PageBean) {Integer} [pageSize] 每页显示条数
	 * @apiParam (PageBean) {Integer} [currentPage] 当前页码号 
	 * 
	 * @apiParamExample {json} 请求参数示例
	 * {
	 *     "channelId" : 5474554235234634765
	 * }
	 *
	 * @apiSuccess (响应数据) {int} errorCode 错误码
	 * @apiSuccess (响应数据) {String} errorMsg 错误说明
	 * @apiSuccess (响应数据) {QueryResult} queryResult 分页查询分销商集合
	 * 
	 * @apiSuccess (QueryResult) {int} total 数据总数 
	 * @apiSuccess (QueryResult) {int} current_page 当前页 
	 * @apiSuccess (QueryResult) {int} total_page 总页数
	 * @apiSuccess (QueryResult) {int} page_size 每页最大记录数
	 * @apiSuccess (QueryResult) {Long} records 分销商SysUser集合
	 *
	 * @apiSuccess (QueryCustomerResponse) {Long} id 分销商id
	 * @apiSuccess (QueryCustomerResponse) {String} name 分销商名称
	 * @apiSuccess (QueryCustomerResponse) {String} corporater 联系人名
	 * @apiSuccess (QueryCustomerResponse) {String} corporaterMobile 联系人手机号
	 * @apiSuccess (QueryCustomerResponse) {String} province 省
	 * @apiSuccess (QueryCustomerResponse) {String} city 市
	 * @apiSuccess (QueryCustomerResponse) {String} county 县
	 * @apiSuccess (QueryCustomerResponse) {String} address 地址
	 * @apiSuccess (QueryCustomerResponse) {String=2:旅行社,3:旅行社部门,4:导游,5:商户,8:OTA} resellerType 分销商类型
	 * @apiSuccess (QueryCustomerResponse) {Date} createDate 绑定关系的时间
	 *
	 * @apiSuccessExample {json} 响应数据示例
	 *
	 * {
	 *     "errorCode" : 10000,
	 *     "errorMsg" : null,
	 *     "data" : {
	 *     		"total": 10000,
	 *     		"current_page":1,
	 *     		"total_page":1000,
	 *     		"page_size":10,
	 *     		"records": [{
	 *         	 "id" : 36346544324325,
	 *         	 "name" : "网易",
	 *         	 "corporater" : "张三",
	 *         	 "corporaterMobile" : "15510147689",
	 *         	 "province" : "北京",
	 *         	 "city" : "北京",
	 *         	 "county" : "朝阳",
	 *         	 "address" : "麦子店街",
	 *         	 "resellerType" : "5",
	 *         	 "createDate" : "2017-01-09 10:00:00"
	 *     		}]
	 * 		}
	 * }
	 * 
	 * 
	 *
	 */
	Result<QueryResult<QueryCustomerResponse>> queryChannelContainDistributors(ChannelResellerQueryModel requestModel, PageBean page);

	/**
	 * 查询渠道未包含的分销商
	 *
	 * @api {dubbo} com.pzj.core.customer.profile.DistributorService#queryChannelNotContainDistributors 查询渠道未包含的分销商
	 * @apiGroup 分销商信息服务
	 * @apiVersion 1.3.0
	 * @apiDescription
	 *
	 * <p>
	 *     查询渠道未包含的分销商。
	 * </p>
	 *
	 * @apiParam (请求参数) {ChannelResellerQueryModel} requestModel 渠道分销商查询模型
	 * @apiParam (请求参数) {PageBean} page 分页参数
	 * 
	 * @apiParam (ChannelResellerQueryModel) {String} rootId 主账号id
	 * @apiParam (ChannelResellerQueryModel) {Long} [channelId] 渠道id
	 * @apiParam (ChannelResellerQueryModel) {String} [loginName] 用户名
	 * @apiParam (ChannelResellerQueryModel) {String} [name] 公司名
	 * @apiParam (ChannelResellerQueryModel) {String} [concat] 联系人
	 * @apiParam (ChannelResellerQueryModel) {String} [mobile] 联系人手机号
	 * @apiParam (ChannelResellerQueryModel) {String} [address] 地址区域
	 * @apiParam (ChannelResellerQueryModel) {String=2:旅行社,3:旅行社部门,4:导游,5:商户,8:OTA} [resellerType] 分销商类型
	 * @apiParam (ChannelResellerQueryModel) {String} [bindSDate] 绑定的开始时间
	 * @apiParam (ChannelResellerQueryModel) {String} [bindEDate] 绑定的结束时间
	 * @apiParam (ChannelResellerQueryModel) {String} [province] 省
	 * @apiParam (ChannelResellerQueryModel) {String} [city] 市
	 * @apiParam (ChannelResellerQueryModel) {String} [county] 县
	 * 
	 * @apiParam (PageBean) {Integer} [pageSize] 每页显示条数
	 * @apiParam (PageBean) {Integer} [currentPage] 当前页码号 
	 *
	 * @apiParamExample {json} 请求参数示例
	 * {
	 *     "rootId" : 36346544324325
	 * }
	 *
	 * @apiSuccess (响应数据) {int} errorCode 错误码
	 * @apiSuccess (响应数据) {String} errorMsg 错误说明
	 * @apiSuccess (响应数据) {QueryResult} queryResult 分页查询分销商集合
	 * 
	 * @apiSuccess (QueryResult) {int} total 数据总数 
	 * @apiSuccess (QueryResult) {int} current_page 当前页 
	 * @apiSuccess (QueryResult) {int} total_page 总页数
	 * @apiSuccess (QueryResult) {int} page_size 每页最大记录数
	 * @apiSuccess (QueryResult) {Long} records 分销商SysUser集合
	 *
	 * @apiSuccess (QueryCustomerResponse) {Long} id 分销商id
	 * @apiSuccess (QueryCustomerResponse) {String} name 分销商名称
	 * @apiSuccess (QueryCustomerResponse) {String} corporater 联系人名
	 * @apiSuccess (QueryCustomerResponse) {String} corporaterMobile 联系人手机号
	 * @apiSuccess (QueryCustomerResponse) {String} province 省
	 * @apiSuccess (QueryCustomerResponse) {String} city 市
	 * @apiSuccess (QueryCustomerResponse) {String} county 县
	 * @apiSuccess (QueryCustomerResponse) {String} address 地址
	 * @apiSuccess (QueryCustomerResponse) {Integer=2:旅行社,3:旅行社部门,4:导游,5:商户,8:OTA} resellerType 分销商类型
	 * @apiSuccess (QueryCustomerResponse) {Date} userRelationCreateDate 绑定关系的时间
	 *
	 * @apiSuccessExample {json} 响应数据示例
	 *
	 * {
	 *     "errorCode" : 10000,
	 *     "errorMsg" : null,
	 *     "data" : {
	 *     		"total": 10000,
	 *     		"current_page":1,
	 *     		"total_page":1000,
	 *     		"page_size":10,
	 *     		"records": [{
	 *         	 "id" : 36346544324325,
	 *         	 "name" : "网易",
	 *         	 "corporater" : "张三",
	 *         	 "corporaterMobile" : "15510147689",
	 *         	 "province" : "北京",
	 *         	 "city" : "北京",
	 *         	 "county" : "朝阳",
	 *         	 "address" : "麦子店街",
	 *         	 "resellerType" : "5",
	 *         	 "userRelationCreateDate" : "2017-01-09 10:00:00"
	 *     		}]
	 * 		}
	 * }
	 *
	 */
	Result<QueryResult<QueryCustomerResponse>> queryChannelNotContainDistributors(
			ChannelResellerQueryModel requestModel, PageBean page);

	/**
	 * 查询分销商详细信息
	 *
	 * @api {dubbo} com.pzj.core.customer.profile.DistributorService#queryDistributorDetail 查询分销商详细信息
	 * @apiGroup 查询分销商详细信息
	 * @apiVersion 1.3.0
	 * @apiDescription
	 *
	 * <p>
	 *    查询分销商详细信息。
	 * </p>
	 *
	 * @apiParam (param) {Long} resellerId 分销商id
	 *
	 * @apiParamExample {json} 参数示例
	 * {
	 *     "resellerId" : 478278342345234
	 * }
	 *
	 * @apiSuccess (响应数据) {int} errorCode 错误码
	 * @apiSuccess (响应数据) {String} errorMsg 错误说明
	 * @apiSuccess (响应数据) {QueryDetailCustomerResponse} data 分销商信息
	 *
	 * @apiSuccess (QueryDetailCustomerResponse) {Long} id 分销商id
	 * @apiSuccess (QueryDetailCustomerResponse) {String} loginName 用户名
	 * @apiSuccess (QueryDetailCustomerResponse) {String} name 分销商名称
	 * @apiSuccess (QueryDetailCustomerResponse) {String} supplierNormal 品牌名称
	 * @apiSuccess (QueryDetailCustomerResponse) {String=p:个人,q:企业} identifyType=p 身份类型
	 * @apiSuccess (QueryDetailCustomerResponse) {String} corporater 联系人名
	 * @apiSuccess (QueryDetailCustomerResponse) {String} corporaterMobile 联系人手机号
	 * @apiSuccess (QueryDetailCustomerResponse) {String} corporaterCredentials 证件号（身份证号）
	 * @apiSuccess (QueryDetailCustomerResponse) {String} businessCertificate 经营许可证
	 * @apiSuccess (QueryDetailCustomerResponse) {String} businessLicense 经营资质
	 * @apiSuccess (QueryDetailCustomerResponse) {String} guideCertificate 导游证
	 * @apiSuccess (QueryDetailCustomerResponse) {String} businessQualification 相关资质
	 * @apiSuccess (QueryDetailCustomerResponse) {String} province 省
	 * @apiSuccess (QueryDetailCustomerResponse) {String} city 市
	 * @apiSuccess (QueryDetailCustomerResponse) {String} county 县
	 * @apiSuccess (QueryDetailCustomerResponse) {String} address 地址
	 * @apiSuccess (QueryDetailCustomerResponse) {String} operChargerPhone 座机号码
	 * @apiSuccess (QueryDetailCustomerResponse) {String} operChargerFax 传真号码
	 * @apiSuccess (QueryDetailCustomerResponse) {String} operChargerEmail 电子邮箱
	 * @apiSuccess (QueryDetailCustomerResponse) {String=2:旅行社,3:旅行社部门,4:导游,5:商户,8:OTA} resellerType 分销商类型
	 * @apiSuccess (QueryDetailCustomerResponse) {Date} userRelationCreateDate 绑定关系的时间
	 * @apiSuccess (QueryDetailCustomerResponse) {Date} lastLoginTime 最后登录时间
	 *
	 * @apiSuccessExample {json} 响应数据示例
	 *
	 * {
	 *     "errorCode" : 10000,
	 *     "errorMsg" : null,
	 *     "data" : {
	 *         	 "id" : 36346544324325,
	 *         	 "loginName" : "用户名",
	 *         	 "name" : "网易",
	 *         	 "supplierNormal" : "网易",
	 *         	 "identifyType" : "p",
	 *         	 "corporater" : "张三",
	 *         	 "corporaterMobile" : "15510147689",
	 *         	 "corporaterCredentials" : "F3zv-342-f34",
	 *         	 "businessCertificate" : "47456775-f34",
	 *         	 "businessLicense" : "46w34532534523234,6478y32844565462",
	 *         	 "guideCertificate" : "46w34532534523234,6478y32844565462",
	 *         	 "province" : "北京",
	 *         	 "city" : "北京",
	 *         	 "county" : "朝阳",
	 *         	 "address" : "麦子店街",
	 *         	 "operChargerPhone" : "400-8800-8800",
	 *         	 "operChargerFax" : "0553-5965828",
	 *         	 "operChargerEmail" : "af3143@163.com",
	 *         	 "resellerType" : "5",
	 *         	 "userRelationCreateDate" : "2017-01-09 10:00:00"
	 *         	 "lastLoginTime" : "2017-01-22 23:15:47"
	 *     }
	 * }
	 */
	Result<QueryDetailCustomerResponse> queryDistributorDetail(Long resellerId);

	/**
	 * 查询分销商和营销详细信息
	 *
	 * @api {dubbo} com.pzj.core.customer.profile.DistributorService#queryDistributorDetail 查询分销商和营销详细信息
	 * @apiGroup 查询分销商和营销详细信息
	 * @apiVersion 1.3.0
	 * @apiDescription
	 *
	 * <p>
	 *    查询分销商详细信息。
	 * </p>
	 *
	 * @apiParam (param) {Long} resellerId 分销商id
	 * @apiParam (param) {Long} rootId 主账号id
	 *
	 * @apiParamExample {json} 请求示例
	 * {
	 *     "resellerId" : 478278342345234,
	 *     "rootId" : 123456789
	 * }
	 *
	 * @apiSuccess (响应数据) {int} errorCode 错误码
	 * @apiSuccess (响应数据) {String} errorMsg 错误说明
	 * @apiSuccess (响应数据) {QueryDetailCustomerResponse} data 分销商信息
	 *
	 * @apiSuccess (CustomerMarketingResponse) {Long} id 分销商id
	* @apiSuccess (CustomerMarketingResponse) {String} loginName 用户名
	* @apiSuccess (CustomerMarketingResponse) {String} name 分销商名称
	* @apiSuccess (CustomerMarketingResponse) {String} supplierNormal 品牌名称
	* @apiSuccess (CustomerMarketingResponse) {String=p:个人,q:企业} identifyType=p 身份类型
	* @apiSuccess (CustomerMarketingResponse) {String} corporater 联系人名
	* @apiSuccess (CustomerMarketingResponse) {String} corporaterMobile 联系人手机号
	* @apiSuccess (CustomerMarketingResponse) {String} corporaterCredentials 证件号（身份证号）
	* @apiSuccess (CustomerMarketingResponse) {String} businessCertificate 经营许可证
	* @apiSuccess (CustomerMarketingResponse) {String} businessLicense 经营资质
	* @apiSuccess (CustomerMarketingResponse) {String} guideCertificate 导游证
	* @apiSuccess (CustomerMarketingResponse) {String} businessQualification 相关资质
	* @apiSuccess (CustomerMarketingResponse) {String} province 省
	* @apiSuccess (CustomerMarketingResponse) {String} city 市
	* @apiSuccess (CustomerMarketingResponse) {String} county 县
	* @apiSuccess (CustomerMarketingResponse) {String} address 地址
	* @apiSuccess (CustomerMarketingResponse) {String} operChargerPhone 座机号码
	* @apiSuccess (CustomerMarketingResponse) {String} operChargerFax 传真号码
	* @apiSuccess (CustomerMarketingResponse) {String} operChargerEmail 电子邮箱
	* @apiSuccess (CustomerMarketingResponse) {String=2:旅行社,3:旅行社部门,4:导游,5:商户,8:OTA} resellerType 分销商类型
	* @apiSuccess (CustomerMarketingResponse) {Date} userRelationCreateDate 绑定关系的时间
	* @apiSuccess (CustomerMarketingResponse) {Date} lastLoginTime 最后登录时间
	 *
	 * @apiSuccessExample {json} 响应数据示例
	 *
	 * {
	 *     "errorCode" : 10000,
	 *     "errorMsg" : null,
	 *     "data" : {
	 *         	 "id" : 36346544324325,
	 *         	 "loginName" : "用户名",
	 *         	 "name" : "网易",
	 *         	 "supplierNormal" : "网易",
	 *         	 "identifyType" : "p",
	 *         	 "corporater" : "张三",
	 *         	 "corporaterMobile" : "15510147689",
	 *         	 "corporaterCredentials" : "F3zv-342-f34",
	 *         	 "businessCertificate" : "47456775-f34",
	 *         	 "businessLicense" : "46w34532534523234,6478y32844565462",
	 *         	 "guideCertificate" : "46w34532534523234,6478y32844565462",
	 *         	 "province" : "北京",
	 *         	 "city" : "北京",
	 *         	 "county" : "朝阳",
	 *         	 "address" : "麦子店街",
	 *         	 "operChargerPhone" : "400-8800-8800",
	 *         	 "operChargerFax" : "0553-5965828",
	 *         	 "operChargerEmail" : "af3143@163.com",
	 *         	 "resellerType" : "5",
	 *         	 "userRelationCreateDate" : "2017-01-09 10:00:00"
	 *         	 "lastLoginTime" : "2017-01-22 23:15:47"
	 *         	 "refereeId":12,
	 *           "businessId":12,
	 *           "refereeName":"推荐人",
	 *           "businessName":"商务负责人"
	 *     }
	 * }
	 */
	Result<CustomerMarketingResponse> queryDistributorMarketing(Long resellerId, Long rootId);

	/**
	 * 创建分销商
	 *
	 * @api {dubbo} com.pzj.core.customer.profile.DistributorService#createDistributor 创建分销商
	 * @apiGroup 分销商信息服务
	 * @apiVersion 1.3.0
	 * @apiDescription
	 * <p>
	 *     根据输入的参数创建新用户，随机生成6位数字密码，用户状态默认为待审核、启用的。只要求用户名不重复，且验证几个必输项。公司名和身份证号不做唯一判断。
	 *     默认为个人、商户。商务负责人默认为推荐人。通过操作人id找到主账号信息，将新用户的所属供应商设置为刚才的主账号。创建成功后，将密码发送短信给手机号。如果用户名已存在，则跳过。
	 *     失败时要记录原因并返回。如果有推荐人id，优先推荐人id，否则使用推荐码。
	 * </p>
	 *
	 * @apiParam (请求参数) {CreateCustomerRequest} distributor 分销商对象
	 *
	 * @apiParam (CreateCustomerRequest) {String} loginName 用户名
	 * @apiParam (CreateCustomerRequest) {String} corporater 联系人名
	 * @apiParam (CreateCustomerRequest) {String} corporaterMobile 联系人手机号
	 * @apiParam (CreateCustomerRequest) {Long} createBy 操作人id
	 * @apiParam (CreateCustomerRequest) {String} userSource 用户来源
	 * @apiParam (CreateCustomerRequest) {String} [name] 分销商名称
	 * @apiParam (CreateCustomerRequest) {String} [supplierNormal] 品牌名称
	 * @apiParam (CreateCustomerRequest) {String=p:个人,q:企业} [identifyType=p] 身份类型
	 * @apiParam (CreateCustomerRequest) {String} [corporaterCredentials] 证件号（营业执照号、身份证号）
	 * @apiParam (CreateCustomerRequest) {String} [businessCertificate] 经营许可证
	 * @apiParam (CreateCustomerRequest) {String} [businessLicense] 经营资质
	 * @apiParam (CreateCustomerRequest) {String} [guideCertificate] 导游证
	 * @apiParam (CreateCustomerRequest) {String} [province] 省
	 * @apiParam (CreateCustomerRequest) {String} [city] 市
	 * @apiParam (CreateCustomerRequest) {String} [county] 县
	 * @apiParam (CreateCustomerRequest) {String} [address] 地址
	 * @apiParam (CreateCustomerRequest) {String} [operChargerPhone 座机号码
	 * @apiParam (CreateCustomerRequest) {String} [operChargerFax] 传真号码
	 * @apiParam (CreateCustomerRequest) {String} [operChargerEmail] 电子邮箱
	 * @apiParam (CreateCustomerRequest) {String=2:旅行社,3:旅行社部门,4:导游,5:商户,8:OTA} [resellerType=5] 分销商类型
	 * @apiParam (CreateCustomerRequest) {Long} [refereeId] 推荐人id
	 * @apiParam (CreateCustomerRequest) {Long} [businessId] 商务负责人id
	 * @apiParam (CreateCustomerRequest) {Long} [refereeCode] 推荐码
	 *
	 * @apiParamExample {json} 参数示例
	 *
	 * {
	 *     "loginName" : "用户名",
	 *     "name" : "网易",
	 *     "supplierNormal" : "网易",
	 *     "identifyType" : "p",
	 *     "corporater" : "张三",
	 *     "corporaterMobile" : "15510147689",
	 *     "corporaterCredentials" : "F3zv-342-f34",
	 *     "businessCertificate" : "47456775-f34",
	 *     "businessLicense" : "46w34532534523234,6478y32844565462",
	 *     "guideCertificate" : "46w34532534523234,6478y32844565462",
	 *     "province" : "北京",
	 *     "city" : "北京",
	 *     "county" : "朝阳",
	 *     "address" : "麦子店街",
	 *     "operChargerPhone" : "400-8800-8800",
	 *     "operChargerFax" : "0553-5965828",
	 *     "operChargerEmail" : "af3143@163.com",
	 *     "resellerType" : "5",
	 *     "createBy" : 5474554235234634765,
	 *     "refereeId" : 7437623472378942465,
	 *     "businessId" : 7437623472378942465,
	 *     "refereeCode" : "zxve"
	 * }
	 *
	 *
	 * @apiSuccess (响应数据) {int} errorCode 错误码
	 * @apiSuccess (响应数据) {String} errorMsg 错误说明
	 * @apiSuccess (响应数据) {Long} data 返回创建的分销商id
	 *
	 * @apiSuccessExample {json} 响应数据示例
	 *
	 * {
	 *     "errorCode" : 10000,
	 *     "errorMsg" : null,
	 *     "data" : 5474554235234634765
	 * }
	 */
	Result<Long> createDistributor(CreateCustomerRequest distributor);

	/**
	 * 批量创建分销商
	 *
	 * @api {dubbo} com.pzj.core.customer.profile.DistributorService#createDistributor 批量创建分销商
	 * @apiGroup 分销商信息服务
	 * @apiVersion 1.3.0
	 * @apiDescription
	 * <p>
	 *     根据输入的参数创建新用户，随机生成6位数字密码，用户状态默认为待审核、启用的。只要求用户名不重复，且验证几个必输项。公司名和身份证号不做唯一判断。默认为个人、商户。商务负责人默认为推荐人。通过操作人id找到主账号信息，将新用户的所属供应商设置为刚才的主账号。创建成功后，将密码发送短信给手机号。如果用户名已存在，则跳过。一个用户创建失败不会导致其它用户创建失败，失败时要记录原因并返回。如果有推荐人id，优先推荐人id，否则使用推荐码。
	 * </p>
	 *
	 * @apiParam {List} distributors 分销商集合，其中每个元素类型为SysUser
	 *
	 * @apiParam (SysUser) {String} loginName 用户名
	 * @apiParam (SysUser) {String} corporater 联系人名
	 * @apiParam (SysUser) {String} corporaterMobile 联系人手机号
	 * @apiParam (SysUser) {String} [name] 分销商名称
	 * @apiParam (SysUser) {String} [supplierNormal] 品牌名称
	 * @apiParam (SysUser) {String=p:个人,q:企业} [identifyType=p] 身份类型
	 * @apiParam (SysUser) {String} [corporaterCredentials] 证件号（营业执照号、身份证号）
	 * @apiParam (SysUser) {String} [businessCertificate] 经营许可证
	 * @apiParam (SysUser) {String} [businessLicense] 经营资质
	 * @apiParam (SysUser) {String} [guideCertificate] 导游证
	 * @apiParam (SysUser) {String} [province] 省
	 * @apiParam (SysUser) {String} [city] 市
	 * @apiParam (SysUser) {String} [county] 县
	 * @apiParam (SysUser) {String} [address] 地址
	 * @apiParam (SysUser) {String} [operChargerPhone 座机号码
	 * @apiParam (SysUser) {String} [operChargerFax] 传真号码
	 * @apiParam (SysUser) {String} [operChargerEmail] 电子邮箱
	 * @apiParam (SysUser) {String=2:旅行社,3:旅行社部门,4:导游,5:商户,8:OTA} [resellerType=5] 分销商类型
	 * @apiParam (SysUser) {Long} createBy 操作人id
	 * @apiParam (SysUser) {Long} [refereeId] 推荐人id
	 * @apiParam (SysUser) {Long} [businessId] 商务负责人id
	 * @apiParam (SysUser) {Long} [refereeCode] 推荐码
	 *
	 * @apiParamExample {json} 参数示例
	 *
	 * [{
	 *     "loginName" : "用户名",
	 *     "name" : "网易",
	 *     "supplierNormal" : "网易",
	 *     "identifyType" : "p",
	 *     "corporater" : "张三",
	 *     "corporaterMobile" : "15510147689",
	 *     "corporaterCredentials" : "F3zv-342-f34",
	 *     "businessCertificate" : "47456775-f34",
	 *     "businessLicense" : "46w34532534523234,6478y32844565462",
	 *     "guideCertificate" : "46w34532534523234,6478y32844565462",
	 *     "province" : "北京",
	 *     "city" : "北京",
	 *     "county" : "朝阳",
	 *     "address" : "麦子店街",
	 *     "operChargerPhone" : "400-8800-8800",
	 *     "operChargerFax" : "0553-5965828",
	 *     "operChargerEmail" : "af3143@163.com",
	 *     "resellerType" : "5",
	 *     "createBy" : 5474554235234634765,
	 *     "refereeId" : 7437623472378942465,
	 *     "businessId" : 7437623472378942465,
	 *     "refereeCode" : "zxve"
	 * }]
	 *
	 * @apiSuccess (响应数据) {int} errorCode 错误码
	 * @apiSuccess (响应数据) {String} errorMsg 错误说明
	 * @apiSuccess (响应数据) {List} data 批量创建结果，其中每个元素类型为Report
	 *
	 * @apiSuccess (CreateManyCustomerRequest) {Long} operator 操作人id
	 * @apiSuccess (CreateManyCustomerRequest) {List} createCustomerRequests 创建用户的参数
	 *
	 * @apiSuccess (CreateCustomerReport) {String} loginName 创建时的用户名
	 * @apiSuccess (CreateCustomerReport) {int} paramIndex 传入参数时索引位置
	 * @apiSuccess (CreateCustomerReport) {int} errorCode 错误码
	 * @apiSuccess (CreateCustomerReport) {String} errorMsg 错误说明
	 *
	 * @apiSuccessExample {json} 响应数据示例
	 *
	 * {
	 *     "errorCode" : 10000,
	 *     "errorMsg" : null,
	 *     "data" : [{
	 *         "loginName" : "用户名",
	 *         "loginName" : 0,
	 *         "errorCode" : 532345,
	 *         "errorMsg" : "用户名不只能是英文或数字"
	 *     }]
	 * }
	 *
	 * @param distributors
	 * @return
	 */
	Result<ArrayList<CreateCustomerReport>> createDistributor(CreateManyCustomerRequest distributors);

	/**
	 * 修改分销商信息
	 *
	 * @api {dubbo} com.pzj.core.smp.delivery.DistributorService#modifyDistributorBeforeFirstLogin 修改分销商信息
	 * @apiGroup 分销商信息服务
	 * @apiVersion 1.3.0
	 * @apiDescription
	 *
	 * <p>
	 *     判断用户是否已经登录，如没还没登录过一次，则通过用户id直接更新信息。用户名不可修改。推荐人、商务负责人、品牌名称可以在任何时候修改。其它字段在用户第一次登录前可编辑，之后不可编辑；自主注册的用户信息不可编辑；关联的用户信息不可编辑。
	 * </p>
	 *
	 * @apiParam (ModifyCustomerRequest) {Long} id 分销商id
	 * @apiParam (ModifyCustomerRequest) {String} [name] 分销商名称
	 * @apiParam (ModifyCustomerRequest) {String} [supplierNormal] 品牌名称
	 * @apiParam (ModifyCustomerRequest) {String=p:个人,q:企业} [identifyType=p] 身份类型
	 * @apiParam (ModifyCustomerRequest) {String} corporater 联系人名
	 * @apiParam (ModifyCustomerRequest) {String} corporaterMobile 联系人手机号
	 * @apiParam (ModifyCustomerRequest) {String} [corporaterCredentials] 证件号（营业执照号、身份证号）
	 * @apiParam (ModifyCustomerRequest) {String} [businessCertificate] 经营许可证
	 * @apiParam (ModifyCustomerRequest) {String} [businessLicense] 经营资质
	 * @apiParam (ModifyCustomerRequest) {String} [guideCertificate] 导游证
	 * @apiParam (ModifyCustomerRequest) {String} [province] 省
	 * @apiParam (ModifyCustomerRequest) {String} [city] 市
	 * @apiParam (ModifyCustomerRequest) {String} [county] 县
	 * @apiParam (ModifyCustomerRequest) {String} [address] 地址
	 * @apiParam (ModifyCustomerRequest) {String} [operChargerPhone 座机号码
	 * @apiParam (ModifyCustomerRequest) {String} [operChargerFax] 传真号码
	 * @apiParam (ModifyCustomerRequest) {String} [operChargerEmail] 电子邮箱
	 * @apiParam (ModifyCustomerRequest) {String=2:旅行社,3:旅行社部门,4:导游,5:商户,8:OTA} [resellerType] 分销商类型
	 * @apiParam (ModifyCustomerRequest) {Long} updateBy 操作人id
	 * @apiParam (ModifyCustomerRequest) {Long} [refereeId] 推荐人id
	 * @apiParam (ModifyCustomerRequest) {Long} [businessId] 商务负责人id
	 *
	 * @apiParamExample {json} 参数示例
	 *
	 * {
	 *     "id" : 36346544324325,
	 *     "loginName" : "用户名",
	 *     "name" : "网易",
	 *     "supplierNormal" : "网易",
	 *     "identifyType" : "p",
	 *     "corporater" : "张三",
	 *     "corporaterMobile" : "15510147689",
	 *     "corporaterCredentials" : "F3zv-342-f34",
	 *     "businessCertificate" : "47456775-f34",
	 *     "businessLicense" : "46w34532534523234,6478y32844565462",
	 *     "guideCertificate" : "46w34532534523234,6478y32844565462",
	 *     "province" : "北京",
	 *     "city" : "北京",
	 *     "county" : "朝阳",
	 *     "address" : "麦子店街",
	 *     "operChargerPhone" : "400-8800-8800",
	 *     "operChargerFax" : "0553-5965828",
	 *     "operChargerEmail" : "af3143@163.com",
	 *     "resellerType" : "5",
	 *     "createBy" : 5474554235234634765,
	 *     "refereeId" : 7437623472378942465,
	 *     "businessId" : 7437623472378942465
	 * }
	 *
	 * @apiSuccess (响应数据) {int} errorCode 错误码
	 * @apiSuccess (响应数据) {String} errorMsg 错误说明
	 * @apiSuccess (响应数据) {Boolean=true:成功,false:失败} data 修改分销商是否成功
	 *
	 * @apiSuccessExample {json} 响应数据示例
	 *
	 * {
	 *     "errorCode" : 10000,
	 *     "errorMsg" : null,
	 *     "data" : true
	 * }
	 *
	 */
	Result<Boolean> modifyDistributorBeforeFirstLogin(ModifyCustomerRequest distributor);

	/**
	 * 修改用户信息
	 *
	 * @api {dubbo} com.pzj.core.smp.delivery.DistributorService#modifyCustomer 修改用户信息
	 * @apiGroup 分销商信息服务
	 * @apiVersion 1.3.0
	 * @apiDescription
	 *
	 * <p>
	 *
	 * </p>
	 *
	 * @apiParam (ModifyCustomerRequest) {Long} id 分销商id
	 * @apiParam (ModifyCustomerRequest) {String} [name] 分销商名称
	 * @apiParam (ModifyCustomerRequest) {String} [supplierNormal] 品牌名称
	 * @apiParam (ModifyCustomerRequest) {String=p:个人,q:企业} [identifyType=p] 身份类型
	 * @apiParam (ModifyCustomerRequest) {String} corporater 联系人名
	 * @apiParam (ModifyCustomerRequest) {String} corporaterMobile 联系人手机号
	 * @apiParam (ModifyCustomerRequest) {String} [corporaterCredentials] 证件号（营业执照号、身份证号）
	 * @apiParam (ModifyCustomerRequest) {String} [businessCertificate] 经营许可证
	 * @apiParam (ModifyCustomerRequest) {String} [businessLicense] 经营资质
	 * @apiParam (ModifyCustomerRequest) {String} [guideCertificate] 导游证
	 * @apiParam (ModifyCustomerRequest) {String} [province] 省
	 * @apiParam (ModifyCustomerRequest) {String} [city] 市
	 * @apiParam (ModifyCustomerRequest) {String} [county] 县
	 * @apiParam (ModifyCustomerRequest) {String} [address] 地址
	 * @apiParam (ModifyCustomerRequest) {String} [operChargerPhone 座机号码
	 * @apiParam (ModifyCustomerRequest) {String} [operChargerFax] 传真号码
	 * @apiParam (ModifyCustomerRequest) {String} [operChargerEmail] 电子邮箱
	 * @apiParam (ModifyCustomerRequest) {String=2:旅行社,3:旅行社部门,4:导游,5:商户,8:OTA} [resellerType] 分销商类型
	 * @apiParam (ModifyCustomerRequest) {Long} updateBy 操作人id
	 * @apiParam (ModifyCustomerRequest) {Long} [refereeId] 推荐人id
	 * @apiParam (ModifyCustomerRequest) {Long} [businessId] 商务负责人id
	 *
	 * @apiParamExample {json} 参数示例
	 *
	 * {
	 *     "id" : 36346544324325,
	 *     "loginName" : "用户名",
	 *     "name" : "网易",
	 *     "supplierNormal" : "网易",
	 *     "identifyType" : "p",
	 *     "corporater" : "张三",
	 *     "corporaterMobile" : "15510147689",
	 *     "corporaterCredentials" : "F3zv-342-f34",
	 *     "businessCertificate" : "47456775-f34",
	 *     "businessLicense" : "46w34532534523234,6478y32844565462",
	 *     "guideCertificate" : "46w34532534523234,6478y32844565462",
	 *     "province" : "北京",
	 *     "city" : "北京",
	 *     "county" : "朝阳",
	 *     "address" : "麦子店街",
	 *     "operChargerPhone" : "400-8800-8800",
	 *     "operChargerFax" : "0553-5965828",
	 *     "operChargerEmail" : "af3143@163.com",
	 *     "resellerType" : "5",
	 *     "createBy" : 5474554235234634765,
	 *     "refereeId" : 7437623472378942465,
	 *     "businessId" : 7437623472378942465
	 * }
	 *
	 * @apiSuccess (响应数据) {int} errorCode 错误码
	 * @apiSuccess (响应数据) {String} errorMsg 错误说明
	 * @apiSuccess (响应数据) {Boolean=true:成功,false:失败} data 修改分销商是否成功
	 *
	 * @apiSuccessExample {json} 响应数据示例
	 *
	 * {
	 *     "errorCode" : 10000,
	 *     "errorMsg" : null,
	 *     "data" : true
	 * }
	 *
	 */
	Result<Boolean> modifyCustomer(ModifyCustomerRequest distributor);

	/**
	 * 绑定直签分销商
	 *
	 * @api {dubbo} com.pzj.core.customer.profile.DistributorService#bindDirectDistributor 绑定直签分销商
	 * @apiGroup 分销商信息服务
	 * @apiVersion 1.3.0
	 * @apiDescription
	 *
	 * <p>
	 *    绑定直签分销商
	 * </p>
	 *
	 * @apiParam (BindCustomerRequest) {Long} resellerId 被绑定分销商id
	 * @apiParam (BindCustomerRequest) {Long} supplierId 主账号id
	 * @apiParam (BindCustomerRequest) {Long} operateId 操作人id
	 * 
	 *
	 * @apiParamExample {json} 请求示例
	 *
	 * {
	 *     "resellerId" : 36346544324325,
	 *     "supplierId" : 7437623472378942465,
	 *     "operateId" : 5474554235234634765
	 * }
	 * 
	 * @apiSuccess (响应数据) {int} errorCode 错误码
	 * @apiSuccess (响应数据) {String} errorMsg 错误说明
	 * @apiSuccess (响应数据) {Long} data 被绑定分销商id
	 *
	 *
	 * @apiSuccessExample {json} 响应数据示例
	 *
	 * {
	 *     "errorCode" : 10000,
	 *     "errorMsg" : null,
	 *     "data" : 36346544324325
	 * }
	 */
	Result<Long> bindDirectDistributor(BindCustomerRequest distributor);

	/**
	 * 解绑直签分销商
	 * @param distributor
	 * @return
	 */
	Result<Boolean> unbindDirectDistributor(BindCustomerRequest distributor);
}
