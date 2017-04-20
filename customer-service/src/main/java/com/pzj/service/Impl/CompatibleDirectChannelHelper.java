package com.pzj.service.Impl;

import com.pzj.base.common.global.UserGlobalParam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-3-1.
 */
public class CompatibleDirectChannelHelper {

    public static List<String> channelRealtionTyps = Arrays.asList("channelUser","directChannelUser");
    public static String channelRealtionTypsString = "\"channelUser\",\"directChannelUser\"";
    public static String channelRealtionTypsString2 = "\"channelUser\"";

    /**
     * 查询用户与直签渠道关系，兼容直签和分销类型
     * @param param
     * @return
     */
    public static void compatibleDirectChannelUserParamForString(Map<String, String> param){
        if (param != null){
            String needCompatibleDirectChannel = param.get("needCompatibleDirectChannel");
            String type = param.get(UserGlobalParam.ChannelMapKeyParam.RELATION_TYPE_KEY);
            if (needCompatibleDirectChannel == null || "ture".equals(needCompatibleDirectChannel)){
                if (type != null && UserGlobalParam.ChannelMapKeyParam.CHANNEL_USER_RELATION_TYPE.equals(type)){
                    param.put(UserGlobalParam.ChannelMapKeyParam.RELATION_TYPE_KEY, channelRealtionTypsString);
                }
            } else {
                if (type != null && UserGlobalParam.ChannelMapKeyParam.CHANNEL_USER_RELATION_TYPE.equals(type)){
                    param.put(UserGlobalParam.ChannelMapKeyParam.RELATION_TYPE_KEY, channelRealtionTypsString2);
                }
            }
        }
    }

    public static void compatibleDirectChannelUserParamForObject(Map<String, Object> param){
        if (param != null){
            Object type = param.get(UserGlobalParam.ChannelMapKeyParam.RELATION_TYPE_KEY);
            if (type != null && UserGlobalParam.ChannelMapKeyParam.CHANNEL_USER_RELATION_TYPE.equals(type)){
                param.put(UserGlobalParam.ChannelMapKeyParam.RELATION_TYPE_KEY, channelRealtionTypsString);
            }
        }
    }
}
