package com.pzj.base.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pzj.base.entity.SysUser;
import com.pzj.service.Impl.mq.MqMessageService;

import com.pzj.framework.armyant.OneTestConfiguration;
import com.pzj.framework.armyant.OneTestConfigurationBuilder;
/**
 * Created by Administrator on 2016-12-27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/spring-context.xml",
})
public class MqMessageServiceTest {
    @Autowired
    MqMessageService mqMessageService;

    @Test
    public void sendUserCheckMsg() throws Exception {
        OneTestConfiguration oneTestConfiguration = OneTestConfigurationBuilder.build("/com/pzj/base/service/ShortMessageService/sendUserCheckMsg.json");

        List<SysUser> sysUsers = (List<SysUser>)oneTestConfiguration.getTestData();

        for (SysUser user : sysUsers) {
            System.out.println("\r=====================================================");
            mqMessageService.sendUserCheckMsg(user);
        }
        System.in.read();
    }

}
