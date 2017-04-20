package com.pzj.base.service;

import com.pzj.base.common.UserServiceContext;
import com.pzj.base.entity.SysTag;
import com.pzj.base.service.sys.ITagService;
import com.pzj.framework.context.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.event.Level;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.pzj.util.JsonDataUtil;

import javax.annotation.Resource;

import java.util.ArrayList;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by Administrator on 2016-11-8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/spring-context.xml",
        //"classpath:/META-INF/spring/spring-context.xml"
})
public class ITagServiceTest {
    @Resource
    ITagService tagService;

    @Test
    public void createTag(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");


        SysTag sysTag = JsonDataUtil.readOneFromClasspath("/com/pzj/base/service/ITagService/createAddress_one.json",SysTag.class);

        Result<Long> result = tagService.createTag(sysTag, userServiceContext);

        assertNotNull(result);
        assertNotNull(result.getData());
    }


    @Test
    public void findById(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");


        SysTag sysTag = JsonDataUtil.readOneFromClasspath("/com/pzj/base/service/ITagService/findById.json",SysTag.class);

        Result<SysTag> result = tagService.findById(sysTag.getId(), userServiceContext);

        assertNotNull(result);
        assertNotNull(result.getData());
    }


    @Test
    public void findTagNamesByPrefix(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");


        SysTag sysTag = JsonDataUtil.readOneFromClasspath("/com/pzj/base/service/ITagService/findTagNamesByPrefix.json",SysTag.class);

        Result<ArrayList<String>> result = tagService.findTagNamesByPrefix(sysTag.getName(), userServiceContext);

        assertNotNull(result);
        assertNotNull(result.getData());
    }

}
