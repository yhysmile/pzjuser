package com.pzj.base.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.pzj.framework.converter.JSONConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pzj.base.entity.SysUserMicroshop;
import com.pzj.base.service.sys.IUserMicroshopService;
import com.pzj.framework.context.Result;

import com.pzj.framework.armyant.OneTestConfiguration;
import com.pzj.framework.armyant.OneTestConfigurationBuilder;

/**
 * Created by Administrator on 2016-12-27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/spring-local.xml"
})
public class IUserMicroshopServiceTest {
    @Autowired
    IUserMicroshopService userMicroshopService;

    @Test
    public void findListByParams(){
        OneTestConfiguration oneTestConfiguration = OneTestConfigurationBuilder.build("/com/pzj/base/service/IUserMicroshopService/findByUserId.json");

        Long userId = (Long) oneTestConfiguration.getTestData();

        Result<SysUserMicroshop> result = userMicroshopService.findByUserId(userId);

        assertNotNull(result);
        System.out.println(JSONConverter.toJson(result));
    }

    @Test
    public void modifyMicroshop(){
        OneTestConfiguration oneTestConfiguration = OneTestConfigurationBuilder.build("/com/pzj/base/service/IUserMicroshopService/modifyMicroshop.json");

        SysUserMicroshop userMicroshop = (SysUserMicroshop) oneTestConfiguration.getTestData();
        Result<Boolean> result = userMicroshopService.modifyMicroshop(userMicroshop);
        assertNotNull(result);
        assertTrue(result.getData());
    }

}
