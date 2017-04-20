package com.pzj.service.Impl.mq;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.rocketmq.common.message.Message;
import com.pzj.base.common.global.UserGlobalDict;
import com.pzj.base.entity.SysUser;
import com.pzj.common.util.MQUtil;
import com.pzj.core.customer.utils.UserConfig;

/**
 * 向RocketMQ发送消息服务
 * Created by Administrator on 2016-12-27.
 */
public class MqMessageService {
	private MQUtil mqUtil;
	private String topic;
	private String tagUserCheck;

	public MqMessageService() {
		super();
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public MqMessageService(MQUtil mqUtil, UserConfig config) {
		super();
		setMqUtil(mqUtil);
		setTopic(config.getMqTopic());
		setTagUserCheck(config.getMqTagUserCheck());
	}

	public void sendUserCheckMsg(SysUser user) {
		byte[] msgData = createMsgData(user);
		Message msg = new Message(topic, tagUserCheck, msgData);
		mqUtil.send(msg);
	}

	private byte[] createMsgData(SysUser user) {
		JSONObject json = new JSONObject();
		json.put("id", user.getId());
		json.put("checkType", user.getCheckType());
		json.put("checkTime", user.getCheckDate());
		json.put("checkStatus", user.getCheckStatus());
		if (UserGlobalDict.passStatus().equals(user.getCheckStatus())) {
			json.put("reason", "符合规范");
		} else {
			json.put("reason", user.getReasonRejection());
		}
		return json.toJSONString().getBytes();
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

	public String getTagUserCheck() {
		return tagUserCheck;
	}

	public void setTagUserCheck(String tagUserCheck) {
		this.tagUserCheck = tagUserCheck;
	}
}
