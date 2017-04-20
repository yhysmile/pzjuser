package test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.pzj.base.common.utils.PageList;
import com.pzj.customer.entity.CustomerRelation;
import com.pzj.customer.service.CustomerRelationService;
import com.pzj.customer.service.CustomerRelationServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring.xml")
public class CustomerRelationTest {
    @Autowired
    CustomerRelationService service = null;

    @Test
    public void queryPageByParamMap() throws Exception {


        CustomerRelation relation = new CustomerRelation();
        relation.setRelUserId(2216619746563733L);
        relation.setRelType("5");


        PageList<CustomerRelation> list = service.queryPageByParamMap(null,
                relation);

        if (list != null && !list.isEmpty()) {
            for (CustomerRelation bean : list.getResultList()) {
                System.out.println(bean.toString());
            }
        }
        assertNotNull(list);
    }

    @Test
    public void unbundingSupplierAndDirctSingDistributors(){
        service.unbundingSupplierAndDirctSingDistributors(2216619736563790L, 2216619736563714L);
    }

}
