package com.pzj.core.customer.microshop;

import com.pzj.framework.context.Result;

/**
 * Created by Administrator on 2017-6-8.
 */
public interface MicroshopService {
    /**
     * 修改用户微店信息
     * @param microshopId 微店id
     * @param microshopContent 微店内容
     * @param modifierId 修改人id
     * @return
     *
     * @api {dubbo} com.pzj.core.customer.microshop.MicroshopService#modifyMicroshop 修改用户微店信息
     * @apiGroup 微店信息服务
     * @apiVersion 1.5.0
     * @apiDescription
     * 修改用户微店信息
     * @apiParam (参数) {Long} microshopId 微店id
     * @apiParam (参数) {MicroshopContent} microshopContent 微店内容
     * @apiParam (参数) {Long} modifierId 修改人id
     *
     * @apiParam (MicroshopContent) {String} name 微店名称
     * @apiParam (MicroshopContent) {String} intro 微店简介
     * @apiParam (MicroshopContent) {String} avatar 微店头像
     * @apiParam (MicroshopContent) {String} phoneNun 电话号码
     *
     * @apiParamExample {json} 参数示例
     * {
     *     	  "microshopId":2216619736563718,
     *     	  "microshopContent": {
     *     	      	  "name": "test",
     *     	      	  "intro": "18581359701",
     *     	      	  "avatar" : "123456",
     *     	      	  "phoneNun": "18581359701"
     *     	  },
     *     	  "modifierId":1,
     * }
     *
     */
    Result<Boolean> modifyMicroshop(Long microshopId, MicroshopContent microshopContent, Long modifierId);

    /**
     * 创建默认的微店信息
     * 此接口暂时只给平台创建SaaS账号时用。
     * @param masterId
     * @param defaultPhoneNum
     * @param creatorId
     * @return
     */
    Result<Boolean> createDefaultMicroshopt(Long masterId, String defaultPhoneNum, Long creatorId);

    /**
     * 根据主账号id查询用户微信微店信息
     * @param masterId 主账号id
     * @return
     *
     * @api {dubbo} com.pzj.core.customer.microshop.MicroshopService#queryMicroshopByMasterId 根据主账号id查询用户微信微店信息
     * @apiGroup 微店信息服务
     * @apiVersion 1.5.0
     * @apiDescription
     * 目前一个主账号只对应一个微店
     * @apiParam {Long} masterId 主账号id
     *
     * @apiSuccess (响应数据) {int} errorCode 错误码
     * @apiSuccess (响应数据) {String} errorMsg 错误说明
     * @apiSuccess (响应数据) {MicroshopInfo} data 微店信息
     *
     * @apiSuccess (MicroshopInfo) {Long} id 微店id
     * @apiSuccess (MicroshopInfo) {Long} masterId 主账号id
     * @apiSuccess (MicroshopInfo) {String} name 微店名称
     * @apiSuccess (MicroshopInfo) {String} intro 微店简介
     * @apiSuccess (MicroshopInfo) {String} avatar 微店头像
     * @apiSuccess (MicroshopInfo) {String} phoneNun 电话号码
     */
    Result<MicroshopInfo> queryMicroshopByMasterId(Long masterId);
}
