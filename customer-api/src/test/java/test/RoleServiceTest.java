package test;

import com.pzj.base.common.utils.PageList;
import com.pzj.department.entity.Department;
import com.pzj.menu.entity.Menu;
import com.pzj.role.entity.Role;
import com.pzj.role.service.RoleService;
import com.pzj.role.service.RoleServiceImpl;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoleServiceTest extends TestCase {
    @Test
    public void test() throws Exception {
        RoleServiceImpl service = new RoleServiceImpl();

        Department department = new Department();
        department.setId(2215520224936074L);
        department.setSupplierId(1L);
        department.setParentId(null);

        List<Role> result = service.findByDempartment(department);
        assertNotNull(result);
    }

}
