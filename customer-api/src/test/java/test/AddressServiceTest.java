package test;

import com.pzj.address.entity.Address;
import com.pzj.address.entity.AddressParam;
import com.pzj.address.service.AddressService;
import com.pzj.base.common.UserServiceContext;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.framework.context.Result;
import com.pzj.util.JsonDataUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertSame;

/**
 * Created by Administrator on 2016-10-18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring.xml")
public class AddressServiceTest {
    @Autowired
    AddressService addressService;

    @Test
    public void createAddress_one(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        Address address = JsonDataUtil.readObjectFromClasspath("/com/pzj/address/AddressService/createAddress_one.json",Address.class);

        Result<Long> addressId = addressService.createAddress(address, userServiceContext);

        assertNotNull(addressId);
    }

    @Test
    public void createAddress_list(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        List<Address> Address = JsonDataUtil.readListFromClasspath("/com/pzj/address/AddressService/createAddress_list.json",Address.class);

        Result<Integer> result = addressService.createAddress(Address, userServiceContext);

        assertSame(result.getData(), Address.size());
    }

    @Test
    public void modifyAddress_one(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        Address address = JsonDataUtil.readObjectFromClasspath("/com/pzj/address/AddressService/modifyAddress_one.json",Address.class);

        Result<Integer> result = addressService.modifyAddress(address, userServiceContext);

        assertSame(result, 1);
    }

    @Test
    public void modifyAddress_list(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        List<Address> Address = JsonDataUtil.readListFromClasspath("/com/pzj/address/AddressService/modifyAddress_list.json",Address.class);

        Result<Integer> result = addressService.modifyAddress(Address, userServiceContext);

        assertSame(result, Address.size());
    }

    @Test
    public void deleteAddress_one(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        Address address = JsonDataUtil.readObjectFromClasspath("/com/pzj/address/AddressService/deleteAddress_one.json",Address.class);

        Long addressId = address.getId();

        Result<Integer> result = addressService.deleteAddress(addressId, userServiceContext);

        assertSame(result, 1);
    }

    @Test
    public void deleteAddress_list(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        List<Long> addressIds = JsonDataUtil.readListFromClasspath("/com/pzj/address/AddressService/deleteAddress_list.json",Long.class);

        Result<Integer> result = addressService.deleteAddress(addressIds, userServiceContext);

        assertSame(result, addressIds.size());
    }

    @Test
    public void queryByParam_all(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.TRACE);
        userServiceContext.setLogId("2010184128431213");

        AddressParam addressParam = JsonDataUtil.readObjectFromClasspath("/com/pzj/address/AddressService/queryByParam_all.json",AddressParam.class);

        Result<ArrayList<Address>> result = addressService.queryByParam(addressParam, userServiceContext);

        assertNotNull(result);

        ArrayList<Address> data = result.getData();
        assertNotNull(data);
        assertSame(data.size(), 3);
    }

    @Test
    public void queryByParam_page(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        AddressParam addressParam = JsonDataUtil.readObjectFromClasspath("/com/pzj/address/AddressService/queryByParam_page.json",AddressParam.class);


        PageModel pageModel = new PageModel(1, 2);

        Result<PageList<Address>> result = addressService.queryByParam(addressParam, pageModel, userServiceContext);

        assertNotNull(result);

        PageList<Address> data = result.getData();

        List<Address> resultList = data.getResultList();
        assertNotNull(resultList);
        assertSame(resultList.size(), 1);
    }

    @Test
    public void queryDefault(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        AddressParam addressParam = JsonDataUtil.readObjectFromClasspath("/com/pzj/address/AddressService/queryDefault.json",AddressParam.class);

        Result<Address> result = addressService.queryDefault(addressParam, userServiceContext);

        assertNotNull(result);
        assertNotNull(result.getData());
    }

    @Test
    public void asDefault(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        Address address = JsonDataUtil.readObjectFromClasspath("/com/pzj/address/AddressService/asDefault.json",Address.class);

        Result<Integer> result = addressService.asDefault(address.getId(), userServiceContext);

        assertNotNull(result);
        assertSame(1, result.getData());

    }
}
