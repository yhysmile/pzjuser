package com.pzj.core.customer.common.mq;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.alibaba.rocketmq.common.protocol.heartbeat.MessageModel;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017-4-8.
 */
public class MqConsumerTest {

    @Test
    public void customerConsumer() throws MQClientException, IOException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("43535");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.setNamesrvAddr("10.0.6.26:9876");
        consumer.setInstanceName("bdfbdfbdf");
        consumer.setMessageModel(MessageModel.BROADCASTING);

        consumer.subscribe("customer", "*");

        consumer.registerMessageListener(new MessageListenerConcurrently() {

            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                            ConsumeConcurrentlyContext context) {
                for (MessageExt msg : msgs){
                    System.out.println("收到消息，主题为 " + msg.getTopic() + " ， Tag 为 " + msg.getTags());
                    System.out.println(Thread.currentThread().getName() + " Receive New Messages: " + new String(msg.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        consumer.start();

        System.out.println("Consumer Started.");

        System.in.read();
    }
}
