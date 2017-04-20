package com.pzj.core.customer.channel.mq;

import com.pzj.core.customer.commons.mq.AbstractMqMessageService;
import com.pzj.core.customer.commons.mq.MQUtil;
import com.pzj.core.customer.utils.UserConfig;

/**
 * 向RocketMQ发送渠道相关消息服务
 * Created by Administrator on 2016-12-27.
 */
public class ChannelMqMessage extends AbstractMqMessageService{
	private String tagAddCustomer;
	private String tagDelCustomer;
	private String tagChannelState;

	public ChannelMqMessage() {
		super();
	}

	public ChannelMqMessage(MQUtil mqUtil, UserConfig config) {
		super();
		setMqUtil(mqUtil);
		init(config);
	}

	@Override
	protected void init(UserConfig config) {
		setTopic(config.getConfig("mq.topic.channel"));
		this.tagAddCustomer = config.getConfig("mq.tag.channel.addCustomer");
		this.tagDelCustomer = config.getConfig("mq.tag.channel.delCustomer");
		this.tagChannelState = config.getConfig("mq.tag.channel.state");
	}

	public void sendAddCustomerMsg(DirectChannelUser directChannelUser) {
		sendMsg(topic, tagAddCustomer, directChannelUser);
	}

	public void sendDelCustomerMsg(DirectChannelUser directChannelUser) {
		sendMsg(topic, tagDelCustomer, directChannelUser);
	}

	public void sendChannelStateMsg(ModifyChannel modifyChannel) {
		sendMsg(topic, tagChannelState, modifyChannel);
	}

}
