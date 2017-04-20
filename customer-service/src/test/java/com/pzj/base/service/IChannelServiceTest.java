package com.pzj.base.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import com.pzj.framework.context.Result;
import com.pzj.framework.entity.QueryResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysChannel;
import com.pzj.base.entity.SysUser;
import com.pzj.base.service.sys.IChannelService;

import com.pzj.framework.armyant.OneTestConfiguration;
import com.pzj.framework.armyant.OneTestConfigurationBuilder;

/**
 * Created by Administrator on 2016-11-21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/spring-context.xml",
        //"classpath:/META-INF/spring/spring-context.xml"
})
public class IChannelServiceTest {
    @Autowired
    IChannelService channelService;

    @Test
    public void queryChannelContainUser(){
        OneTestConfiguration oneTestConfiguration = OneTestConfigurationBuilder.build("/com/pzj/base/service/IChannelServiceTest/queryChannelContainUser.json");

        SysChannel channelParam = (SysChannel)oneTestConfiguration.getTestData("channelParam");
        SysUser distributorParam = (SysUser)oneTestConfiguration.getTestData("distributorParam");
        PageModel pageModel = (PageModel)oneTestConfiguration.getTestData("pageModel");

        Result<QueryResult<SysChannel>> pageListResult = null;//channelService.queryChannelContainUser(channelParam, distributorParam, pageModel,null,null);

        assertNotNull(pageListResult);

        List<SysChannel> resultList = pageListResult.getData().getRecords();
        assertNotNull(resultList);
    }
}
