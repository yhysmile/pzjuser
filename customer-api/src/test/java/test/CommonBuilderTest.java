package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.pzj.base.entity.SysOffice;
import com.pzj.department.entity.Department;
import com.pzj.department.entity.DepartmentBuilder;
import com.pzj.department.entity.DepartmentForeachHandle;
import com.pzj.util.ForeachHandle;

public class CommonBuilderTest {

    @Test
    public void test1() {
        DepartmentBuilder builder = new DepartmentBuilder();

        List<SysOffice> entityList = createOfficeList();

        List<Department> result = builder.buildSource(entityList);

        System.out.println(result);
    }

    @Test
    public void test2() {
        DepartmentBuilder builder = new DepartmentBuilder();

        List<SysOffice> entityList = createOfficeList();

        List<Department> result = builder.buildSource(entityList,
                new DepartmentForeachHandle() {

                    @Override
                    public void handle(SysOffice sysOffice,
                            Department department) {
                        System.out.println(sysOffice + "-----" + department);
                    }

                });

        System.out.println(result);
    }

    @Test
    public void test3() {
        DepartmentBuilder builder = new DepartmentBuilder();

        List<SysOffice> entityList = createOfficeList();

        List<Department> result = builder.buildSource(entityList,
                new ForeachHandle<SysOffice, Department>() {

                    @Override
                    public void handle(SysOffice sysOffice,
                            Department department) {
                        System.out.println(sysOffice + "-----" + department);
                    }

                });

        System.out.println(result);
    }

    private List<SysOffice> createOfficeList() {
        List<SysOffice> entityList = new ArrayList<SysOffice>(3);

        {
            SysOffice office = new SysOffice();
            office.setId(1L);
            office.setName("AAA");
            entityList.add(office);
        }
        {
            SysOffice office = new SysOffice();
            office.setId(2L);
            office.setName("BBB");
            entityList.add(office);
        }
        {
            SysOffice office = new SysOffice();
            office.setId(3L);
            office.setName("CCC");
            entityList.add(office);
        }
        return entityList;
    }

}
