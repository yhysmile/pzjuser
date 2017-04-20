package test;

import com.pzj.base.common.UserServiceContext;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.contacts.entity.Contacts;
import com.pzj.contacts.entity.ContactsParam;
import com.pzj.contacts.service.ContactsService;
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
 * Created by Administrator on 2016-10-13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring.xml")
public class ContactsServiceTest {
    @Autowired
    ContactsService contactsService;

    @Test
    public void createContact_one(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.TRACE);
        userServiceContext.setLogId("2010184128431213");

        Contacts contact = JsonDataUtil.readObjectFromClasspath("/com/pzj/contacts/ContactsService/createContact_one.json",Contacts.class);

        Result<Long> contactId = contactsService.createContacts(contact, userServiceContext);

        assertNotNull(contactId);
    }

    @Test
    public void createContact_list(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        List<Contacts> contacts = JsonDataUtil.readListFromClasspath("/com/pzj/contacts/ContactsService/createContact_list.json",Contacts.class);

        Result<Integer> result = contactsService.createContacts(contacts, userServiceContext);

        assertSame(result, contacts.size());
    }

    @Test
    public void modifyContact_one(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        Contacts contact = JsonDataUtil.readObjectFromClasspath("/com/pzj/contacts/ContactsService/modifyContact_one.json",Contacts.class);

        Result<Integer> result = contactsService.modifyContacts(contact, userServiceContext);

        assertSame(result, 1);
    }

    @Test
    public void modifyContact_list(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        List<Contacts> contacts = JsonDataUtil.readListFromClasspath("/com/pzj/contacts/ContactsService/modifyContact_list.json",Contacts.class);

        Result<Integer> result = contactsService.modifyContacts(contacts, userServiceContext);

        assertSame(result, contacts.size());
    }

    @Test
    public void deleteContact_one(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        Contacts contact = JsonDataUtil.readObjectFromClasspath("/com/pzj/contacts/ContactsService/deleteContact_one.json",Contacts.class);

        Long contactId = contact.getId();

        Result<Integer> result = contactsService.deleteContacts(contactId, userServiceContext);

        assertSame(result, 1);
    }

    @Test
    public void deleteContact_list(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        List<Long> contactIds = JsonDataUtil.readListFromClasspath("/com/pzj/contacts/ContactsService/deleteContact_list.json",Long.class);

        Result<Integer> result = contactsService.deleteContacts(contactIds, userServiceContext);

        assertSame(result, contactIds.size());
    }

    @Test
    public void deleteAndCreateContact(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.TRACE);
        userServiceContext.setLogId("2010184128431213");

        ContactsParam deleteContactParam = JsonDataUtil.readObjectFromClasspath("/com/pzj/contacts/ContactsService/deleteAndCreateContact_delete.json",ContactsParam.class);
        List<Contacts> createContactList = JsonDataUtil.readListFromClasspath("/com/pzj/contacts/ContactsService/deleteAndCreateContact_create.json",Contacts.class);

        Result<Integer> result = contactsService.deleteAndCreateContacts(deleteContactParam, createContactList, userServiceContext);

        assertSame(result, createContactList.size());
    }

    @Test
    public void queryByParam_all(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.TRACE);
        userServiceContext.setLogId("2010184128431213");

        ContactsParam contactParam = JsonDataUtil.readObjectFromClasspath("/com/pzj/contacts/ContactsService/queryByParam_all.json",ContactsParam.class);

        Result<ArrayList<Contacts>> result =  contactsService.queryByParam(contactParam, userServiceContext);

        assertNotNull(result);
        ArrayList<Contacts> resultData = result.getData();
        assertNotNull(resultData);
        assertSame(resultData.size(), 3);
    }

    @Test
    public void queryByParam_page(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        ContactsParam contactParam = JsonDataUtil.readObjectFromClasspath("/com/pzj/contacts/ContactsService/queryByParam_page.json",ContactsParam.class);


        PageModel pageModel = new PageModel(1, 2);

        Result<PageList<Contacts>> result = contactsService.queryByParam(contactParam, pageModel, userServiceContext);

        assertNotNull(result);

        PageList<Contacts> data = result.getData();

        List<Contacts> resultList = data.getResultList();
        assertNotNull(resultList);
        assertSame(resultList.size(), 1);
    }



    @Test
    public void queryDefault(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        ContactsParam contactsParam = JsonDataUtil.readObjectFromClasspath("/com/pzj/contacts/ContactsService/queryDefault.json",ContactsParam.class);

        Result<Contacts> result = contactsService.queryDefault(contactsParam, userServiceContext);

        assertNotNull(result);
        assertNotNull(result.getData());
    }

    @Test
    public void asDefault(){
        UserServiceContext userServiceContext = new UserServiceContext();
        userServiceContext.setLogLevel(Level.INFO);
        userServiceContext.setLogId("2010184128431213");

        Contacts contacts = JsonDataUtil.readObjectFromClasspath("/com/pzj/contacts/ContactsService/asDefault.json",Contacts.class);

        Result<Integer> result = contactsService.asDefault(contacts.getId(), userServiceContext);

        assertNotNull(result);
        assertSame(1, result.getData());

    }

}
