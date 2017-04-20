package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.pzj.base.common.utils.PageList;
import com.pzj.customer.entity.CustomerRelation;
import com.pzj.customer.service.CustomerRelationService;
import com.pzj.customer.service.CustomerRelationServiceImpl;

public class CustomerRelTest {
    CustomerRelationService service = new CustomerRelationServiceImpl();

    @Test
    public void testCreate() {
        List<Long> idList = new ArrayList<Long>();

        idList.add(2L);
        idList.add(3L);
        idList.add(4L);
        idList.add(5L);
        idList.add(6L);

        service.insertBatch(1L, idList, "1");
    }

    @Test
    public void testDelete() {
        List<Long> idList = new ArrayList<Long>();

        idList.add(2L);
        idList.add(3L);
        idList.add(4L);
        idList.add(5L);
        idList.add(6L);

        service.deleteBatch(1L, idList, "1");
    }

    @Test
    public void testQuery() throws Exception {

        PageList<CustomerRelation> pageList = service.queryPageByParamMap(null,
                new CustomerRelation());

        System.out.println(pageList.getResultList());
    }
}
