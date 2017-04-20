package com.pzj.core.customer.commons.mq;

import com.alibaba.fastjson.JSON;
import com.alibaba.rocketmq.common.message.Message;
import com.pzj.core.customer.utils.UserConfig;

/**
 * Created by Administrator on 2017-4-8.
 */
public abstract class AbstractMqMessageService {
    protected MQUtil mqUtil;
    protected String topic;

    protected abstract void init(UserConfig config);

    protected void sendMsg(String topic, String tag, Object objData){
        if (objData == null){
            return;
        }
        byte[] msgData = JSON.toJSONString(objData).getBytes();
        sendMsg(topic, tag, msgData);
    }

    protected void sendMsg(String topic, String tag, byte[] msgData){
        if (topic == null){
            return;
        }
        if (tag == null){
            return;
        }
        if (msgData == null){
            return;
        }
        Message msg = new Message(topic, tag, msgData);
        mqUtil.send(msg);
    }

    public MQUtil getMqUtil() {
        return mqUtil;
    }

    public void setMqUtil(MQUtil mqUtil) {
        this.mqUtil = mqUtil;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
