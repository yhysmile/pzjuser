package test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.pzj.base.common.utils.PageList;
import com.pzj.log.entity.OperatorLog;
import com.pzj.log.service.OperatorLogService;
import com.pzj.log.service.OperatorLogServiceImpl;

public class OperatorLogServiceImplTest {
    static OperatorLogService operatorLogService = new OperatorLogServiceImpl();

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findOperatorLogByParams1() throws Exception {
        OperatorLog operatorLog = new OperatorLog();
        operatorLog.setCreateBy("ff");
        
        PageList<OperatorLog> result = operatorLogService.findOperatorLogByParams(1, 10, operatorLog);
        
        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(result.getResultList().size(), 3);
    }
    
    @Test
    public void findOperatorLogByParams2() throws Exception {
        OperatorLog operatorLog = new OperatorLog();
        operatorLog.setCreateBy("qq");
        
        PageList<OperatorLog> result = operatorLogService.findOperatorLogByParams(1, 10, operatorLog);
        
        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(result.getResultList().size(), 1);
    }
    
    @Test
    public void findOperatorLogByParams3() throws Exception {
                
        PageList<OperatorLog> result = operatorLogService.findOperatorLogByParams(1, 10, null);
        
        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(result.getResultList().size(), 4);
    }
    
    @Test
    public void findOperatorLogByParams4() throws Exception {
        OperatorLog operatorLog = new OperatorLog();
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date startDate = format.parse("2015-11-12 15:20:33");
        Date endDate = format.parse("2015-11-12 15:43:25");
        
        operatorLog.setCreateDate(startDate);
        operatorLog.setCreateDateEnd(endDate);
        
        PageList<OperatorLog> result = operatorLogService.findOperatorLogByParams(1, 10, operatorLog);
        
        assertNotNull(result);
        assertNotNull(result.getResultList());
        assertEquals(result.getResultList().size(), 2);
    }
}
