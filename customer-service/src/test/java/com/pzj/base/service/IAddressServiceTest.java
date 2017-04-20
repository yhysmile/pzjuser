package com.pzj.base.service;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.event.Level;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pzj.base.common.UserServiceContext;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysAddress;
import com.pzj.base.entity.query.SysAddressQueryParam;
import com.pzj.base.service.sys.IAddressService;
import com.pzj.framework.context.Result;
import com.pzj.util.JsonDataUtil;

/**
 * Created by wuliqing on 2016-10-12.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/spring-context.xml",
        //"classpath:/META-INF/spring/spring-context.xml"
})
public class IAddressServiceTest {
    @Resource
    IAddressService addressService;

    @Test
    public void createAddress_one(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        SysAddress address = JsonDataUtil.readOneFromClasspath("/com/pzj/base/service/IAddressService/createAddress_one.json",SysAddress.class);

        Result<Long> result = addressService.createAddress(address, userServiceContext);

        assertNotNull(result);
        assertNotNull(result.getData());
    }

    @Test
    public void createAddress_list(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.TRACE);
        userServiceContext.setLogId("2010184128431213");

        List<SysAddress> addressList = JsonDataUtil.readListFromClasspath("/com/pzj/base/service/IAddressService/createAddress_list.json",SysAddress.class);

        Result<Integer> result = addressService.createAddress(addressList, userServiceContext);

        assertNotNull(result);
        assertSame(addressList.size(), result.getData());
    }

    @Test
    public void modifyAddress_one(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        SysAddress address = JsonDataUtil.readOneFromClasspath("/com/pzj/base/service/IAddressService/modifyAddress_one.json",SysAddress.class);

        Result<Integer> result = addressService.modifyAddress(address, userServiceContext);

        assertNotNull(result);
        assertSame(1, result.getData());
    }

    @Test
    public void modifyAddress_list(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.TRACE);
        userServiceContext.setLogId("2010184128431213");

        List<SysAddress> addressList = JsonDataUtil.readListFromClasspath("/com/pzj/base/service/IAddressService/modifyAddress_list.json",SysAddress.class);

        Result<Integer> result = addressService.modifyAddress(addressList, userServiceContext);

        assertNotNull(result);
        assertSame(addressList.size(), result.getData());
    }

    @Test
    public void deleteAddress_one(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        SysAddress address = JsonDataUtil.readOneFromClasspath("/com/pzj/base/service/IAddressService/deleteAddress_one.json",SysAddress.class);

        Long contactId = address.getId();

        Result<Integer> result = addressService.deleteAddress(contactId, userServiceContext);

        assertNotNull(result);
        assertSame(1, result.getData());
    }

    @Test
    public void deleteAddress_list(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        List<Long> contactIds = JsonDataUtil.readListFromClasspath("/com/pzj/base/service/IAddressService/deleteAddress_list.json",Long.class);

        Result<Integer> result = addressService.deleteAddress(contactIds, userServiceContext);

        assertNotNull(result);
        assertSame(contactIds.size(), result.getData());
    }

    @Test
    public void queryByParam_all(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.TRACE);
        userServiceContext.setLogId("2010184128431213");

        SysAddressQueryParam addressParam = JsonDataUtil.readOneFromClasspath("/com/pzj/base/service/IAddressService/queryByParam_all.json",SysAddressQueryParam.class);

        Result<ArrayList<SysAddress>> result = addressService.queryByParam(addressParam, userServiceContext);

        assertNotNull(result);

        ArrayList<SysAddress> data = result.getData();
        assertNotNull(data);
        assertSame(3, data.size());
    }

    @Test
    public void queryByParam_page(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        SysAddressQueryParam addressParam = JsonDataUtil.readOneFromClasspath("/com/pzj/base/service/IAddressService/queryByParam_page.json",SysAddressQueryParam.class);


        PageModel pageModel = new PageModel(1, 2);

        Result<PageList<SysAddress>> result = addressService.queryByParam(addressParam, pageModel, userServiceContext);

        assertNotNull(result);

        PageList<SysAddress> data = result.getData();

        List<SysAddress> resultList = data.getResultList();
        assertNotNull(resultList);
        assertSame(1, resultList.size());
    }

    @Test
    public void queryDefault(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        SysAddressQueryParam addressParam = JsonDataUtil.readOneFromClasspath("/com/pzj/base/service/IAddressService/queryDefault.json",SysAddressQueryParam.class);

        Result<SysAddress> result = addressService.queryDefault(addressParam, userServiceContext);

        assertNotNull(result);
        assertNotNull(result.getData());
    }

    @Test
    public void asDefault(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        SysAddress address = JsonDataUtil.readOneFromClasspath("/com/pzj/base/service/IAddressService/asDefault.json",SysAddress.class);

        Result<Integer> result = addressService.asDefault(address.getId(), userServiceContext);

        assertNotNull(result);
        assertSame(1, result.getData());

    }
}
