package com.pzj.base.service;

import com.pzj.base.common.UserServiceContext;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysContacts;
import com.pzj.base.entity.query.SysContactsQueryParam;
import com.pzj.base.service.sys.IContactsService;
import com.pzj.framework.context.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.event.Level;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.pzj.util.JsonDataUtil;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertSame;

/**
 * Created by wuliqing on 2016-10-12.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/spring-context.xml",
        //"classpath:/META-INF/spring/spring-context.xml"
})
public class IContactsServiceTest {
    @Resource
    IContactsService contactsService;

    @Test
    public void createContact_one(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        SysContacts contact = JsonDataUtil.readOneFromClasspath("/com/pzj/base/service/IContactsService/createContact_one.json",SysContacts.class);

        Result<Long> result = contactsService.createContact(contact, userServiceContext);

        assertNotNull(result);
        assertNotNull(result.getData());
    }

    @Test
    public void createContact_list(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        List<SysContacts> contacts = JsonDataUtil.readListFromClasspath("/com/pzj/base/service/IContactsService/createContact_list.json",SysContacts.class);

        Result<Integer> result = contactsService.createContact(contacts, userServiceContext);

        assertNotNull(result);
        assertSame(contacts.size(), result.getData());
    }

    @Test
    public void modifyContact_one(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        SysContacts contact = JsonDataUtil.readOneFromClasspath("/com/pzj/base/service/IContactsService/modifyContact_one.json",SysContacts.class);

        Result<Integer> result = contactsService.modifyContact(contact, userServiceContext);

        assertNotNull(result);
        assertSame(1, result.getData());
    }

    @Test
    public void modifyContact_list(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        List<SysContacts> contacts = JsonDataUtil.readListFromClasspath("/com/pzj/base/service/IContactsService/modifyContact_list.json",SysContacts.class);

        Result<Integer> result = contactsService.modifyContact(contacts, userServiceContext);

        assertNotNull(result);
        assertSame(contacts.size(), result.getData());
    }

    @Test
    public void deleteContact_one(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        SysContacts contact = JsonDataUtil.readOneFromClasspath("/com/pzj/base/service/IContactsService/deleteContact_one.json",SysContacts.class);

        Long contactId = contact.getId();

        Result<Integer> result = contactsService.deleteContact(contactId, userServiceContext);

        assertNotNull(result);
        assertSame(1, result.getData());
    }

    @Test
    public void deleteContact_list(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        List<Long> contactIds = JsonDataUtil.readListFromClasspath("/com/pzj/base/service/IContactsService/deleteContact_list.json",Long.class);

        Result<Integer> result = contactsService.deleteContact(contactIds, userServiceContext);

        assertNotNull(result);
        assertSame(contactIds.size(), result.getData());
    }

    @Test
    public void deleteAndCreateContact(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.TRACE);
        userServiceContext.setLogId("2010184128431213");

        SysContactsQueryParam deleteContactParam = JsonDataUtil.readOneFromClasspath("/com/pzj/base/service/IContactsService/deleteAndCreateContact_delete.json",SysContactsQueryParam.class);
        List<SysContacts> createContactList = JsonDataUtil.readListFromClasspath("/com/pzj/base/service/IContactsService/deleteAndCreateContact_create.json",SysContacts.class);

        Result<Integer> result = contactsService.deleteAndCreateContact(deleteContactParam, createContactList, userServiceContext);

        assertNotNull(result);
        assertSame(createContactList.size(), result.getData());
    }

    @Test
    public void queryByParam_all(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.TRACE);
        userServiceContext.setLogId("2010184128431213");

        SysContactsQueryParam contactParam = JsonDataUtil.readOneFromClasspath("/com/pzj/base/service/IContactsService/queryByParam_all.json",SysContactsQueryParam.class);

        Result<ArrayList<SysContacts>> result = contactsService.queryByParam(contactParam, userServiceContext);

        assertNotNull(result);

        ArrayList<SysContacts> data = result.getData();
        assertNotNull(data);
        assertSame(3, data.size());
    }

    @Test
    public void queryByParam_page(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        SysContactsQueryParam contactParam = JsonDataUtil.readOneFromClasspath("/com/pzj/base/service/IContactsService/queryByParam_page.json",SysContactsQueryParam.class);


        PageModel pageModel = new PageModel(2, 2);

        Result<PageList<SysContacts>> result = contactsService.queryByParam(contactParam, pageModel, userServiceContext);

        assertNotNull(result);

        PageList<SysContacts> data = result.getData();

        List<SysContacts> resultList = data.getResultList();
        assertNotNull(resultList);
        assertSame(resultList.size(), 1);
    }

    @Test
    public void queryDefault(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        SysContactsQueryParam contactParam = JsonDataUtil.readOneFromClasspath("/com/pzj/base/service/IContactsService/queryDefault.json",SysContactsQueryParam.class);

        Result<SysContacts> result = contactsService.queryDefault(contactParam, userServiceContext);

        assertNotNull(result);
        assertNotNull(result.getData());
    }

    @Test
    public void asDefault(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        SysContacts address = JsonDataUtil.readOneFromClasspath("/com/pzj/base/service/IContactsService/asDefault.json",SysContacts.class);

        Result<Integer> result = contactsService.asDefault(address.getId(), userServiceContext);

        assertNotNull(result);
        assertSame(2, result.getData());

    }
}
