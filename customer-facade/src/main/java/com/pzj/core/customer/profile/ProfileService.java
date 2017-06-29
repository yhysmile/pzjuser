package com.pzj.core.customer.profile;

import com.pzj.base.entity.SysUser;
import com.pzj.framework.context.Result;

/**
 * Created by Administrator on 2017-2-16.
 */
public interface ProfileService {

	/**
	 * 启用用户
	 *
	 * @api {dubbo} com.pzj.core.customer.profile.ProfileService#enableCustomer 启用用户
	 * @apiGroup 基础信息服务
	 * @apiVersion 1.3.0
	 * @apiDescription
	 * <p>
	 *     根据销售人员id查找其信息，如果是禁用状态，更新其状态为启用。
	 * </p>
	 *
	 * @apiParam {Long} id 用户id
	 * @apiParam {Long} operator 操作人id
	 *
	 * @apiParamExample {json} 参数示例
	 * {
	 *     "id" : 46893782423453t6,
	 *     "operator" : 5496734502345345
	 * }
	 *
	 * @apiSuccess (响应数据) {int} errorCode 错误码
	 * @apiSuccess (响应数据) {String} errorMsg 错误说明
	 * @apiSuccess (响应数据) {Boolean=true:成功,false=失败} data 启用结果
	 *
	 * @apiSuccessExample {json} 响应数据示例
	 *
	 * {
	 *     "errorCode" : 10000,
	 *     "errorMsg" : null,
	 *     "data" : true
	 * }
	 *
	 *
	 * @param id
	 * @param operator
     * @return
     */
	Result<Boolean> enableCustomer(Long id, Long operator);

	/**
	 * 禁用用户
	 *
	 * @api {dubbo} com.pzj.core.customer.profile.ProfileService#disableCustomer 禁用用户
	 * @apiGroup 基础信息服务
	 * @apiVersion 1.3.0
	 * @apiDescription
	 * <p>
	 *     根据销售人员id查找其信息，如果是启用状态，更新其状态为禁用。
	 * </p>
	 *
	 * @apiParam {Long} id 用户id
	 * @apiParam {Long} operator 操作人id
	 *
	 * @apiParamExample {json} 参数示例
	 * {
	 *     "id" : 46893782423453t6,
	 *     "operator" : 5496734502345345
	 * }
	 *
	 * @apiSuccess (响应数据) {int} errorCode 错误码
	 * @apiSuccess (响应数据) {String} errorMsg 错误说明
	 * @apiSuccess (响应数据) {Boolean=true:成功,false=失败} data 禁用结果
	 *
	 * @apiSuccessExample {json} 响应数据示例
	 *
	 * {
	 *     "errorCode" : 10000,
	 *     "errorMsg" : null,
	 *     "data" : true
	 * }
	 *
	 * @param id
	 * @param operator
     * @return
     */
	Result<Boolean> disableCustomer(Long id, Long operator);

	/**
	 * 根据登录名查询用户基本（少量）信息
	 * @param loginName
	 * @return
	 */
	Result<SysUser> queryCustomerByLoginName(String loginName);

	/**
	 * 重新生成6位密码并发送短信
	 *
	 * @api {dubbo} com.pzj.core.customer.profile.ProfileService#regenPasswordBeforeFirstLogin 重新生成6位密码并发送短信
	 * @apiGroup 基础信息服务
	 * @apiVersion 1.3.0
	 * @apiDescription
	 * <p>
	 *     检查用户是否已经登录过系统，如果还没有登录过一次，则重新生成6位随机数字的密码，并将密码发送给联系人。登录过一次之后就不生成。
	 * </p>
	 *
	 * @apiParam {Long} userId 用户id
	 * @apiParam {Long} operator 操作人id
	 *
	 * @apiParamExample {json} 参数示例
	 * {
	 *     "userId" : 46893782423453t6,
	 *     "operator" : 5496734502345345
	 * }
	 *
	 * @apiSuccess (响应数据) {int} errorCode 错误码
	 * @apiSuccess (响应数据) {String} errorMsg 错误说明
	 * @apiSuccess (响应数据) {Boolean=true:成功,false=失败} data 重置结果
	 *
	 * @apiSuccessExample {json} 响应数据示例
	 *
	 * {
	 *     "errorCode" : 10000,
	 *     "errorMsg" : null,
	 *     "data" : true
	 * }
	 *
	 * @param userId
	 * @return
	 */
	Result<Boolean> regenPasswordBeforeFirstLogin(Long userId, Long operator);

	/**
	 * @api {dubbo} com.pzj.core.customer.profile.ProfileService#passedUser 用户审核通过
	 * @apiGroup 基础信息服务
	 * @apiName 用户审核通过
	 * @apiVersion 1.3.0-SNAPSHOT
	 * @apiDescription 将未审核用户置为审核通过
	 *
	 * @apiParam (请求参数) {Long} customerId 审核用户id
	 * @apiParam (请求参数) {Long} operId 操作人id
	 *
	 * @apiParamExample 请求参数示例
	 *	{
	 *   "customerId": "12345678"
	 * }
	 *
	 * @apiParam (响应数据) {int} errorCode 返回结果码
	 * @apiParam (响应数据) {String} errorMsg 返回结果提示
	 * @apiParam (响应数据) {boolean} data 返回审核结果 true or false
	 *
	 * @apiParam (错误码) {CustomerException} 14999 失败
	 *
	 * @apiErrorExample {json} 异常示例
	 * {
	 *    "errorCode" : 14999,
	 *    "errorMsg":"失败"
	 * }
	 */
	Result<Boolean> passedUser(Long customerId,Long operId);

	/**
	 * 根据用户id，查询正常状态的用户基体信息
	 * @param id
	 * @return
     */
	Result<ProfileBasicInfo> queryActivateProfileBasicInfoById(Long id);
}
