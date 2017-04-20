package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.pzj.label.entity.LabelVo;
import com.pzj.label.service.LabelService;
import com.pzj.label.service.impl.LabelServiceimpl;

public class labelTest {

    private LabelService labelService = new LabelServiceimpl();

    @Test
    public void findByCustomer() throws Exception {
        Long customerId = 38L;
        
        List<LabelVo> result = labelService.findByCustomer(customerId);
        
        assertNotNull(result);
        assertEquals(result.size(), 1);
        
    }
}
