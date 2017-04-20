package test;

import com.pzj.base.common.UserServiceContext;
import com.pzj.framework.context.Result;
import com.pzj.tag.service.TagService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.event.Level;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertSame;

/**
 * Created by Administrator on 2016-11-9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring.xml")
public class TagServiceTest {

    @Resource
    TagService tagService;

    @Test
    public void findTagNamesByPrefix(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        String namePrefix = "Cou";

        Result<ArrayList<String>> result = tagService.findTagNamesByPrefix(namePrefix, userServiceContext);

        assertNotNull(result);

        ArrayList<String> resultList = result.getData();

        assertNotNull(resultList);
        assertSame(resultList.size(), 1);
    }
}
