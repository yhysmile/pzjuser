package test;

import com.pzj.base.entity.SysUserMicroshop;
import com.pzj.base.service.sys.IUserMicroshopService;
import com.pzj.framework.context.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Administrator on 2016-12-28.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring.xml")
public class MicroshopServiceTest {
    @Autowired
    IUserMicroshopService iuserMicroshopService;

    @Test
    public void test(){
        Result<SysUserMicroshop> result = iuserMicroshopService.findByUserId(2216619741564110L);
        assertNotNull(result);

        SysUserMicroshop data = result.getData();
        assertNotNull(data);

        System.out.println(data.getName());
    }
}
