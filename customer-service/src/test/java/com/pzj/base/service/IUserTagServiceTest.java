package com.pzj.base.service;

import com.pzj.base.common.UserServiceContext;
import com.pzj.base.entity.SysTag;
import com.pzj.base.service.sys.IUserTagService;
import com.pzj.framework.context.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.event.Level;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.pzj.util.JsonDataUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Set;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by Administrator on 2016-11-8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/spring-context.xml",
        //"classpath:/META-INF/spring/spring-context.xml"
})
public class IUserTagServiceTest {
    @Resource
    IUserTagService userTagService;

    @Test
    public void associateUserTagNames(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        Long userId = 123L;

        Set<String> tagNames = JsonDataUtil.readSetFromClasspath("/com/pzj/base/service/IUserTagService/associateUserTagNames.json",String.class);

        Result<Integer> result = userTagService.associateUserTagNames(userId, tagNames, userServiceContext);

        assertNotNull(result);
        assertNotNull(result.getData());
    }

    @Test
    public void associateUserTagIds(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        Long userId = 123L;

        Set<Long> tagIds = JsonDataUtil.readSetFromClasspath("/com/pzj/base/service/IUserTagService/associateUserTagIds.json",Long.class);

        Result<Integer> result = userTagService.associateUserTagIds(userId, tagIds, userServiceContext);

        assertNotNull(result);
        assertNotNull(result.getData());
    }

    @Test
    public void findTagNamesByUserId(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        Long userId = 2216619741564388L;

        Result<ArrayList<String>> result = userTagService.findTagNamesByUserId(userId, userServiceContext);

        assertNotNull(result);
        assertNotNull(result.getData());
    }

    @Test
    public void findTagsByUserId(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        Long userId = 123L;

        Result<ArrayList<SysTag>> result = userTagService.findTagsByUserId(userId, userServiceContext);

        assertNotNull(result);
        assertNotNull(result.getData());
    }
}
