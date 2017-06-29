package com.pzj.core.customer.profile.mq;

import com.alibaba.fastjson.JSONObject;
import com.pzj.base.common.global.UserGlobalDict;
import com.pzj.base.entity.SysUser;
import com.pzj.core.customer.common.mq.AbstractMqMessageService;
import com.pzj.core.customer.common.mq.MQUtil;
import com.pzj.core.customer.utils.UserConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 向RocketMQ发送用户相关消息服务
 * Created by Administrator on 2016-12-27.
 */
public class CustomerMqMessage extends AbstractMqMessageService {

	private String tagUserCheck;
	private String tagCustomerState;
	private String tagCreateCustomer;
	private String tagBindDistributor;
	private String tagUnbindDistributor;

	public CustomerMqMessage() {
		super();
	}

	public CustomerMqMessage(MQUtil mqUtil, UserConfig config) {
		super();
		setMqUtil(mqUtil);
		init(config);
	}

	@Override
	protected void init(UserConfig config) {
		setTopic(config.getMqTopic());
		this.tagUserCheck = config.getMqTagUserCheck();
		this.tagCustomerState = config.getConfig("mq.tag.customer.state");
		this.tagCreateCustomer = config.getConfig("mq.tag.customer.create");
		this.tagBindDistributor = config.getConfig("mq.tag.customer.bindDistributor");
		this.tagUnbindDistributor = config.getConfig("mq.tag.customer.unbindDistributor");
	}

	public void sendUserCheckMsg(SysUser user) {
		byte[] msgData = createUserCheckMsgData(user);
		sendMsg(topic, tagUserCheck, msgData);
	}

	private byte[] createUserCheckMsgData(SysUser user) {
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

	public void sendCustomerStateMsg(ModifyCustomer modifyCustomer) {
		sendMsg(topic, tagCustomerState, modifyCustomer);
	}

	public void sendCreateCustomerMsg(CreateCustomer createCustomer) {
		sendMsg(topic, tagCreateCustomer, createCustomer);
	}

	public void sendBindDistributorMsg(BindDistributor bindDistributor) {
		sendMsg(topic, tagBindDistributor, bindDistributor);
	}

	public void sendUnbindDistributorMsg(BindDistributor bindDistributor) {
		sendMsg(topic, tagUnbindDistributor, bindDistributor);
	}
}
