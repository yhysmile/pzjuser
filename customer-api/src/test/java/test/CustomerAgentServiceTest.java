package test;

import org.junit.Test;

import com.pzj.base.common.ServiceException;
import com.pzj.customer.entity.CustomerAgent;
import com.pzj.customer.service.CustomerAgentServiceImpl;

/**
 * Created by Administrator on 2016-3-30.
 */
public class CustomerAgentServiceTest {
    CustomerAgentServiceImpl customerAgentService = new CustomerAgentServiceImpl();

    @Test
    public void saveCustomerAgentTest() throws ServiceException {
        CustomerAgent customerAgent = new CustomerAgent();
        customerAgent.setUserId(1L);
        customerAgent.setAgentId(2L);

        customerAgentService.saveCustomerAgent(customerAgent);
    }

    @Test
    public void deleteCustomerAgentTest() throws ServiceException {
        CustomerAgent customerAgent = new CustomerAgent();
        customerAgent.setUserId(1L);
        customerAgent.setAgentId(2L);

        customerAgentService.deleteCustomerAgent(customerAgent);
    }

    @Test
    public void findAgentByUserId() throws ServiceException {
        Long userId = 1L;
        // Customer customer = customerAgentService.findAgentByUserId(userId);
        // assertNotNull(customer);
        // System.out.println(customer.getId() + "\t" + customer.getName());
    }
}
