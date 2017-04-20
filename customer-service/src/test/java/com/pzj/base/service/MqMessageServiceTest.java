package com.pzj.base.service;

import java.util.List;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.pzj.core.customer.profile.mq.CustomerMqMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pzj.base.entity.SysUser;

import com.pzj.framework.armyant.OneTestConfiguration;
import com.pzj.framework.armyant.OneTestConfigurationBuilder;
/**
 * Created by Administrator on 2016-12-27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/META-INF/spring/spring-context.xml",
})
public class MqMessageServiceTest {
    @Autowired
    CustomerMqMessage customerMqMessage;

    @Test
    public void sendUserCheckMsg() throws Exception {
        OneTestConfiguration oneTestConfiguration = OneTestConfigurationBuilder.build("/com/pzj/base/service/ShortMessageService/sendUserCheckMsg.json");

        List<SysUser> sysUsers = (List<SysUser>)oneTestConfiguration.getTestData();

        for (SysUser user : sysUsers) {
            System.out.println("\r=====================================================");
            customerMqMessage.sendUserCheckMsg(user);
        }
        //System.in.read();
    }

}
