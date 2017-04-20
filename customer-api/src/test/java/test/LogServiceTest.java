package test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pzj.base.common.utils.PageList;
import com.pzj.base.entity.SysLog;
import com.pzj.base.service.sys.ILogService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring.xml")
public class LogServiceTest {
    @Autowired
    private ILogService logService = null;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void insert() {
        SysLog entity = new SysLog();
        entity.setCreateBy("fffffffffffff");
        entity.setCreateId(1L);
        entity.setCreateDate(new Date());
        entity.setParams("params...");
        entity.setPosition("psoition...");
        entity.setException("exception...");
        entity.setMethod("metho");
        entity.setTelephone("telephone");
        entity.setClient("client");
        
        Long id = logService.insert(entity);
        
        assertNotNull(id);
    }
    

    @Test
    public void updateByPrimaryKey() {
        Long id = 3L;
        
        SysLog entity = new SysLog();
        entity.setId(id);
        entity.setCreateBy("xxxxx");
        entity.setCreateId(1L);
        entity.setCreateDate(new Date());
        entity.setParams("params...");
        entity.setPosition("psoition...");
        entity.setException("exception...");
        entity.setMethod("metho");
        entity.setTelephone("telephone");
        entity.setClient("client");
        
        Integer num = logService.updateByPrimaryKey(entity);
        
        assertNotNull(num);
    }
    


    @Test
    public void delete() {
        Long id = 3L;

        logService.delete(id);


        SysLog log = logService.getById(id);
        
        assertNull(log);
    }


    @Test
    public void getById() {
        Long id = 3L;
        
        SysLog log = logService.getById(id);
        
        assertNotNull(log);
    }

    @Test
    public void findListByParams() {
        Long id = 3L;
        
        SysLog entity = new SysLog();
        entity.setId(id);
        
        List<SysLog> result = logService.findListByParams(entity);
        
        assertNotNull(result);
        assertEquals(result.size(), 1);
    }
    

    @Test
    public void queryPageByParamMap() {
        
        PageList<SysLog> result = logService.queryPageByParamMap(null, null);
        
        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(result.getResultList().size(), 1);
    }

}
