package com.pzj.core.customer.common.mq;

import com.alibaba.fastjson.JSON;
import com.alibaba.rocketmq.common.message.Message;
import com.pzj.core.customer.profile.mq.CustomerMqMessage;
import com.pzj.core.customer.utils.UserConfig;
import com.pzj.framework.converter.JSONConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2017-4-8.
 */
public abstract class AbstractMqMessageService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerMqMessage.class);

    protected MQUtil mqUtil;
    protected String topic;

    protected abstract void init(UserConfig config);

    protected void sendMsg(String topic, String tag, Object objData){
        if (logger.isInfoEnabled()) {
            logger.info("MQ消息发送开始：topic {} ， tag {}， data {}", topic, tag, JSONConverter.toJson(objData));
        }
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
