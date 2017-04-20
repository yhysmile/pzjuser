package com.pzj.core.customer.visitor;

import java.util.ArrayList;

import com.pzj.core.customer.commons.PageBean;
import com.pzj.framework.context.Result;
import com.pzj.framework.entity.QueryResult;

/**
 * 客户服务
 * Created by Administrator on 2017-2-23.
 */
public interface VisitorService {
    /**
     * 创建客户者
     *
     * @api {dubbo} com.pzj.core.customer.visitor.VisitorService#createVisitor 创建客户者
     * @apiGroup 客户模块
     * @apiVersion 1.3.0
     * @apiDescription
     *
     * <p>
     *     创建客户
     * </p>
     *
     * @apiParam (CreateVisitorRequest) {String} name 客户名称
     * @apiParam (CreateVisitorRequest) {String} [remark] 备注
     * @apiParam (CreateVisitorRequest) {String} [phoneNum] 手机号
     * @apiParam (CreateVisitorRequest) {String} [idNum] 身份证号
     * @apiParam (CreateVisitorRequest) {Long} operator 操作id
     *
     * @apiParamExample {json} 请求参数示例
     *
     * {
     *     "name" : "张三",
     *     "remark" : "张三简介",
     *     "phoneNum" : "15510147689",
     *     "idNum" : "476575856345345435",
     *     "operator" : 574574523455474623
     * }
     *
     * @apiSuccess (响应数据) {int} errorCode 错误码
     * @apiSuccess (响应数据) {String} errorMsg 错误说明
     * @apiSuccess (响应数据) {Long} data 新客户的id
     *
     * @apiSuccessExample {json} 响应数据示例
     *
     * {
     *     "errorCode" : 10000,
     *     "errorMsg" : null,
     *     "data" : 574574523455474623
     * }
     *
     * @param createVisitorRequest
     * @return
     */
    Result<Long> createVisitor(CreateVisitorRequest createVisitorRequest);

    /**
     * 修改客户
     *
     * @api {dubbo} com.pzj.core.customer.visitor.VisitorService#modifyVisitor 修改客户
     * @apiGroup 客户模块
     * @apiVersion 1.3.0
     * @apiDescription
     *
     * <p>
     *     通过id更新客户信息
     * </p>
     *
     * @apiParam (ModifyVisitorRequest) {Long} id 客户id
     * @apiParam (ModifyVisitorRequest) {String} [name] 客户名称
     * @apiParam (ModifyVisitorRequest) {String} [remark] 备注
     * @apiParam (ModifyVisitorRequest) {String} [phoneNum] 手机号
     * @apiParam (ModifyVisitorRequest) {String} [idNum] 身份证号
     * @apiParam (ModifyVisitorRequest) {Long} operator 操作id
     *
     * @apiParamExample {json} 请求参数示例
     *
     * {
     *     "id" : 574574523455474623,
     *     "name" : "张三",
     *     "remark" : "张三简介",
     *     "phoneNum" : "15510147689",
     *     "idNum" : "476575856345345435",
     *     "operator" : 574574523455474623
     * }
     *
     * @apiSuccess (响应数据) {int} errorCode 错误码
     * @apiSuccess (响应数据) {String} errorMsg 错误说明
     * @apiSuccess (响应数据) {Boolean=true：成功,false：失败} data 修改是否成功
     *     *
     * @apiSuccessExample {json} 响应数据示例
     *
     * {
     *     "errorCode" : 10000,
     *     "errorMsg" : null,
     *     "data" : ture
     * }
     *
     * @param modifyVisitorRequest
     * @return
     */
    Result<Boolean> modifyVisitor(ModifyVisitorRequest modifyVisitorRequest);

    /**
     * 删除客户
     *
     * @api {dubbo} com.pzj.core.customer.visitor.VisitorService#deleteVisitor 删除客户
     * @apiGroup 客户模块
     * @apiVersion 1.3.0
     * @apiDescription
     *
     * <p>
     *     通过id更新客户信息，将其状态改为删除状态。
     * </p>
     *
     * @apiParam (ModifyVisitorRequest) {Long} visitorId 客户id
     * @apiParam (ModifyVisitorRequest) {Long} operator 操作id
     *
     * @apiParamExample {json} 请求参数示例
     *
     * {
     *     "id" : 574574523455474623,
     *     "operator" : 574574523455474623
     * }
     *
     * @apiSuccess (响应数据) {int} errorCode 错误码
     * @apiSuccess (响应数据) {String} errorMsg 错误说明
     * @apiSuccess (响应数据) {Boolean=true：成功,false：失败} data 删除是否成功
     *     *
     * @apiSuccessExample {json} 响应数据示例
     *
     * {
     *     "errorCode" : 10000,
     *     "errorMsg" : null,
     *     "data" : ture
     * }
     * @param visitorId
     * @param operator
     * @return
     */
    Result<Boolean> deleteVisitor(Long visitorId, Long operator);

    /**
     * 分页查询客户列表
     *
     * @api {dubbo} com.pzj.core.customer.visitor.VisitorService#queryVisitorSummaryByPage 分页查询客户列表
     * @apiGroup 客户模块
     * @apiVersion 1.3.0
     * @apiDescription
     *
     * <p>
     *     分页查询客户列表。
     * </p>
     *
     * @apiParam (请求参数) {Long} ownerId 拥有者id，所属主账号id
     * @apiParam (请求参数) {Long} [currentPage] 当前页码
     * @apiParam (请求参数) {Long} [pageSize] 每页显示条数
     *
     * @apiParamExample {json} 请求参数示例
     * {
     * 	   "ownerId": 44523423t635324534,
     * 	   "currentPage" : 1,
     * 	   "pageSize" : 20
     * }
     *
     * @apiSuccess (响应数据) {int} errorCode 错误码
     * @apiSuccess (响应数据) {String} errorMsg 错误说明
     * @apiSuccess (响应数据) {QueryResult} queryResult 分页查询分销商集合
     *
     * @apiSuccess (QueryResult) {int} total 数据总数
     * @apiSuccess (QueryResult) {int} current_page 当前页
     * @apiSuccess (QueryResult) {int} total_page 总页数
     * @apiSuccess (QueryResult) {int} page_size
     * @apiSuccess (QueryResult) {Long} records 分销商SysUser集合
     *
     * @apiSuccess (QueryVisitorSummaryResponse) {Long} id 主键id
     * @apiSuccess (QueryVisitorSummaryResponse) {String} name 客户名称
     * @apiSuccess (QueryVisitorSummaryResponse) {String} remark 备注
     * @apiSuccess (QueryVisitorSummaryResponse) {String} phoneNum 手机号
     * @apiSuccess (QueryVisitorSummaryResponse) {String} idNum 身份证号
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
     *         	 "name" : "张三",
     *         	 "remark" : "张三简介",
     *         	 "phoneNum" : "15510147689",
     *         	 "idNum" : "476575856345345435"
     *     		}]
     * 		}
     * }
     *
     */
    Result<QueryResult<QueryVisitorSummaryResponse>> queryVisitorSummaryByPage(QueryVisitorRequest queryVisitorRequest, PageBean page);

    /**
     * 通过id查询客户详情
     *
     * @api {dubbo} com.pzj.core.customer.visitor.VisitorService#queryVisitorDetailById 通过id查询客户详情
     * @apiGroup 客户模块
     * @apiVersion 1.3.0
     * @apiDescription
     *
     * <p>
     *     通过id查询客户详情。
     * </p>
     *
     * @apiParam (请求参数) {Long} id 客户id
     *
     * @apiParamExample {json} 请求参数示例
     * {
     * 	   "id" : 1
     * }
     *
     * @apiSuccess (响应数据) {int} errorCode 错误码
     * @apiSuccess (响应数据) {String} errorMsg 错误说明
     * @apiSuccess (响应数据) {QueryVisitorDetailResponse} data 客户详情
     *
     * @apiSuccess (QueryVisitorDetailResponse) {Long} id 主键id
     * @apiSuccess (QueryVisitorDetailResponse) {String} name 客户名称
     * @apiSuccess (QueryVisitorDetailResponse) {String} remark 备注
     * @apiSuccess (QueryVisitorDetailResponse) {String} phoneNum 手机号
     * @apiSuccess (QueryVisitorDetailResponse) {String} idNum 身份证号
     *
     * @apiSuccessExample {json} 响应数据示例
     *
     * {
     *     "errorCode" : 10000,
     *     "errorMsg" : null,
     *     "data" : {
     *         	 "id" : 1,
     *         	 "rootId" : 36346544324325,
     *         	 "name" : "张三",
     *         	 "remark" : "张三简介",
     *         	 "phoneNum" : "15510147689",
     *         	 "idNum" : "35647458768568423"
     * 		}
     * }
     *
     */
    Result<QueryVisitorDetailResponse> queryVisitorDetailById(Long id);

    /**
     * 通过客户名称或者手机号查找客户列表
     *
     * @api {dubbo} com.pzj.core.customer.visitor.VisitorService#queryVisitorSummaryByNameMobile 通过客户名称或者手机号查找客户列表
     * @apiGroup 客户模块
     * @apiVersion 1.3.0
     * @apiDescription
     *
     * <p>
     *     通过客户名称或者手机号查找客户列表。
     * </p>
     *
     * @apiParam (请求参数) {String} nameMobile 客户名称或手机号
     * @apiParam (请求参数) {Long} supplierId 供应商id
     *
     *
     * @apiParamExample {json} 请求参数示例
     * {
     * 	   "nameMobile" : "张"
     * }
     *
     * @apiSuccess (响应数据) {int} errorCode 错误码
     * @apiSuccess (响应数据) {String} errorMsg 错误说明
     * @apiSuccess (响应数据) {ArrayList} data ClientModel客户集合
     *
     * @apiSuccess (QueryVisitorSummaryResponse) {Long} id 主键id
     * @apiSuccess (QueryVisitorSummaryResponse) {String} name 客户名称
     * @apiSuccess (QueryVisitorSummaryResponse) {String} remark 备注
     * @apiSuccess (QueryVisitorSummaryResponse) {String} phoneNum 手机号
     * @apiSuccess (QueryVisitorSummaryResponse) {String} idNum 身份证号
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
     *         	    "id" : 1,
     *         	    "rootId" : 36346544324325,
     *         	    "name" : "张三",
     *         	    "remark" : "张三简介",
     *         	    "phoneNum" : "15510147689",
     *         	    "idNum" : "35647458768568423"
     *     		}]
     * 		}
     * }
     *
     */
    Result<ArrayList<QueryVisitorSummaryResponse>> queryVisitorSummaryByNameMobile(String nameMobile, Long supplierId);
}
