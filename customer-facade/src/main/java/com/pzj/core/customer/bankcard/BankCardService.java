package com.pzj.core.customer.bankcard;

import com.pzj.framework.context.Result;

/**
 * Created by Administrator on 2017-3-3.
 */
public interface BankCardService {
    /**
     * 根据主账号id，查询微店的银行卡信息
     *
     * @api {dubbo} com.pzj.core.customer.bankcard.BankCardService#queryMicroshopBankCardByOwnerid 查询主账号的银行卡信息
     * @apiGroup 银行卡服务
     * @apiVersion 1.3.0
     * @apiDescription
     * <p>
     *     根据主账号id，查询微店的银行卡信息。
     * </p>
     *
     * @apiParam {Long} ownerId 主账号id
     *
     * @apiParamExample {json} 参数示例
     *
     * {
     *     "id" : 48381023784545
     * }
     *
     * @apiSuccess (响应数据) {int} errorCode 错误码
     * @apiSuccess (响应数据) {String} errorMsg 错误说明
     * @apiSuccess (响应数据) {BankCardDetailResponse} data 银行卡信息。
     *
     * @apiSuccessExample {json} 响应数据示例
     *
     * {
     *     "errorCode" : 10000,
     *     "errorMsg" : null,
     *     "data" : {
     *         "id" : 123,
     *         "ownerId" : 48381023784545,
     *         "accountHolder" : "张三",
     *         "idNum" : "14010919999999",
     *         "bank" : "农行",
     *         "cardNum" : “596432034334”,
     *     }
     * }
     *
     * @apiError (错误码说明) 1 1。
     *
     * @param ownerId
     * @return
     */
    Result<BankCardDetailResponse> queryMicroshopBankCardByOwnerid(Long ownerId);

    /**
     * 创建微店的银行卡信息
     *
     * @api {dubbo} com.pzj.core.customer.bankcard.BankCardService#createMicroshopBankCard 创建微店的银行卡信息
     * @apiGroup 银行卡服务
     * @apiVersion 1.3.0
     * @apiDescription
     * <p>
     *     创建微店的银行卡信息，目前只能创建一份。
     * </p>
     *
     * @apiParam {String} accountHolder 开户人
     * @apiParam {String} idNum 身份证号
     * @apiParam {String} bank 银行名称
     * @apiParam {String} cardNum 银行卡号
     * @apiParam {Integer} dataSource 创建系统
     * @apiParam {Long} operator 创建人id
     *
     * @apiParamExample {json} 参数示例
     *
     * {
     *     "accountHolder" : "张三",
     *     "idNum" : "14010919999999",
     *     "bank" : "农行",
     *     "cardNum" : "596432034334",
     *     "dataSource" : 1,
     *     "id" : 48381023784545
     * }
     *
     * @apiSuccess (响应数据) {int} errorCode 错误码
     * @apiSuccess (响应数据) {String} errorMsg 错误说明
     * @apiSuccess (响应数据) {Long} data 银行卡id。
     *
     * @apiSuccessExample {json} 响应数据示例
     *
     * {
     *     "errorCode" : 10000,
     *     "errorMsg" : null,
     *     "data" : 123
     * }
     *
     * @apiError (错误码说明) 1 1。
     *
     * @param request
     * @return
     */
    Result<Long> createMicroshopBankCard(CreateBankCardRequest request);

    /**
     * 修改微店的银行卡信息
     *
     * @api {dubbo} com.pzj.core.customer.bankcard.BankCardService#modifyMicroshopBankCard 修改微店的银行卡信息
     * @apiGroup 银行卡服务
     * @apiVersion 1.3.0
     * @apiDescription
     * <p>
     *     修改微店的银行卡信息。
     * </p>
     *
     * @apiParam {Long} dataSource 银行卡id
     * @apiParam {String} accountHolder 开户人
     * @apiParam {String} idNum 身份证号
     * @apiParam {String} bank 银行名称
     * @apiParam {String} cardNum 银行卡号
     * @apiParam {Long} operator 创建人id
     *
     * @apiParamExample {json} 参数示例
     *
     * {
     *     "id" : 123,
     *     "accountHolder" : "张三",
     *     "idNum" : "14010919999999",
     *     "bank" : "农行",
     *     "cardNum" : "596432034334",
     *     "id" : 48381023784545
     * }
     *
     * @apiSuccess (响应数据) {int} errorCode 错误码
     * @apiSuccess (响应数据) {String} errorMsg 错误说明
     * @apiSuccess (响应数据) {Boolean=true：成功，false：失败} data 是否修改成功。
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
     * @param request
     * @return
     */
    Result<Boolean> modifyMicroshopBankCard(ModifyBankCardRequest request);
}
