package com.pzj.core.customer.commons.mq;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.MQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.client.producer.SendStatus;
import com.alibaba.rocketmq.common.message.Message;

/**
 * Created by Administrator on 2016-12-26.
 */
public class MQUtil {
	private final static Logger logger = LoggerFactory.getLogger(MQUtil.class);

	private DefaultMQProducer producer;
	private String serviceAddress;

	private String productName = "CustomerProduct";
	private int minPoolSize = 1;
	private int maxPoolSize = 10;
	private long keepAliveTime = 300L;
	private final TimeUnit unit = TimeUnit.SECONDS;
	private BlockingQueue<Runnable> workQueue = null;
	private ThreadPoolExecutor threadPool;

	public MQUtil() {

	}

	public MQUtil(String productName, String serviceAddress, int maxPoolSize, int minPoolSize, int keepAliveTime) {
		setProductName(productName);
		setServiceAddress(serviceAddress);
		setMaxPoolSize(maxPoolSize);
		setMinPoolSize(minPoolSize);
		setKeepAliveTime(keepAliveTime);
		init();
	}

	public void init() {
		try {
			initProducer();
			initThreadPool();
		} catch (MQClientException e) {
			logger.error("消息生成者启动失败：" + e.getMessage(), e);
		}
	}

	private static class SendMsgTask implements Runnable {
		private final static Logger logger = LoggerFactory.getLogger(SendMsgTask.class);
		private final MQProducer producer;
		private final Message message;

		private SendMsgTask(MQProducer producer, Message message) {
			this.producer = producer;
			this.message = message;
		}

		@Override
		public void run() {
			try {
				logger.debug("发送消息开始：{}" + message.toString());
				SendResult result = producer.send(message);
				if (result.getSendStatus() != SendStatus.SEND_OK) {
					logger.error("发送消息失败：{}" + result.toString());

				}
			} catch (Throwable throwable) {
				logger.error("发送消息失败：" + throwable.getMessage(), throwable);
			}
		}
	}

	private void initProducer() throws MQClientException {
		producer = new DefaultMQProducer(productName);
		producer.setNamesrvAddr(this.serviceAddress);
		//producer.setInstanceName("rmq-instance");
		producer.start();
	}

	private void initThreadPool() {
		workQueue = new LinkedBlockingDeque<>();
		threadPool = new ThreadPoolExecutor(minPoolSize, maxPoolSize, keepAliveTime, unit, workQueue);
	}

	public void send(Message msg) {
		SendMsgTask task = new SendMsgTask(producer, msg);
		threadPool.execute(task);
	}

	public String getServiceAddress() {
		return serviceAddress;
	}

	public void setServiceAddress(String serviceAddress) {
		this.serviceAddress = serviceAddress;
	}

	public int getMinPoolSize() {
		return minPoolSize;
	}

	public void setMinPoolSize(int minPoolSize) {
		this.minPoolSize = minPoolSize;
	}

	public int getMaxPoolSize() {
		return maxPoolSize;
	}

	public void setMaxPoolSize(int maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}

	public long getKeepAliveTime() {
		return keepAliveTime;
	}

	public void setKeepAliveTime(long keepAliveTime) {
		this.keepAliveTime = keepAliveTime;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
}
