package test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pzj.base.entity.SysOfficeRoleKey;
import com.pzj.base.service.sys.IOfficeRoleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring.xml")
public class OfficeRoelServiceTest {

    @Autowired
    private IOfficeRoleService service = null;

    
    @Test
    public void insert() {
        
        SysOfficeRoleKey key = new SysOfficeRoleKey();
        key.setId(1L);
        key.setRoleId("2");
        key.setOfficeId("3"); 
        
        service.insert(key);
    }
    
    @Test
    public void insertBatch() {
        
        List<SysOfficeRoleKey> records = new ArrayList<SysOfficeRoleKey>();
        
        {
            SysOfficeRoleKey key = new SysOfficeRoleKey();
            key.setId(1L);
            key.setRoleId("2");
            key.setOfficeId("3");
            records.add(key);
        }
        
        {
            SysOfficeRoleKey key = new SysOfficeRoleKey();
            key.setId(2L);
            key.setRoleId("67");
            key.setOfficeId("67");
            records.add(key);
        }
        
        {
            SysOfficeRoleKey key = new SysOfficeRoleKey();
            key.setId(3L);
            key.setRoleId("31");
            key.setOfficeId("53");
            records.add(key);
        }
        
        
        service.insertBatch(records);
    }
    
    @Test
    public void insertOrUpdate() {
        SysOfficeRoleKey key = new SysOfficeRoleKey();
        //key.setId(2L);
        key.setRoleId("22222");
        key.setOfficeId("33333"); 
        
        service.insertOrUpdate(key);
    }
}
