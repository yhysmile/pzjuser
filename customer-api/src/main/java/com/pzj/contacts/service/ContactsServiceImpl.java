package com.pzj.contacts.service;

import com.pzj.base.common.ServiceException;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysContacts;
import com.pzj.base.entity.query.SysContactsQueryParam;
import com.pzj.base.service.sys.IContactsService;
import com.pzj.contacts.entity.Contacts;
import com.pzj.contacts.entity.ContactsBuilder;
import com.pzj.contacts.entity.ContactsParam;
import com.pzj.contacts.entity.ContactsParamBuilder;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuliqing on 2016-10-12.
 */
@Service
public class ContactsServiceImpl implements ContactsService {
    private static Logger logger = LoggerFactory.getLogger(ContactsServiceImpl.class);

    private final ContactsBuilder contactsBuilder = new ContactsBuilder();

    private final ContactsParamBuilder contactsParamBuilder = new ContactsParamBuilder();

    @Autowired
    private IContactsService contactsService = null;

    @Override
    public Result<Long> createContacts(Contacts contacts, ServiceContext serviceContext) {
        SysContacts sysContacts = null;
        try {
            sysContacts = contactsBuilder.buildNew(contacts);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            return null;
        }

        return contactsService.createContact(sysContacts, serviceContext);
    }

    @Override
    public Result<Integer> createContacts(List<Contacts> contacts, ServiceContext serviceContext) {
        List<SysContacts> sysContactses = null;
        try {
            sysContactses = contactsBuilder.buildNew(contacts);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            return null;
        }

        return contactsService.createContact(sysContactses, serviceContext);
    }

    @Override
    public Result<Integer> modifyContacts(Contacts contacts, ServiceContext serviceContext) {
        SysContacts sysContacts = null;
        try {
            sysContacts = contactsBuilder.buildExisted(contacts);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            return null;
        }

        return contactsService.modifyContact(sysContacts, serviceContext);
    }

    @Override
    public Result<Integer> modifyContacts(List<Contacts> contacts, ServiceContext serviceContext) {
        List<SysContacts> sysContactses = null;
        try {
            sysContactses = contactsBuilder.buildExisted(contacts);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            return null;
        }

        return contactsService.modifyContact(sysContactses, serviceContext);
    }

    @Override
    public Result<Integer> deleteAndCreateContacts(ContactsParam deleteContact, List<Contacts> createContacts, ServiceContext serviceContext) {
        SysContactsQueryParam sysContactQueryParam = contactsParamBuilder.convertTo(deleteContact);

        List<SysContacts> sysContactsList = null;
        try {
            sysContactsList = contactsBuilder.buildNew(createContacts);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            return null;
        }

        return contactsService.deleteAndCreateContact(sysContactQueryParam, sysContactsList, serviceContext);
    }

    @Override
    public Result<Integer> deleteContacts(Long id, ServiceContext serviceContext) {
        return contactsService.deleteContact(id, serviceContext);
    }

    @Override
    public Result<Integer> deleteContacts(List<Long> ids, ServiceContext serviceContext) {
        return contactsService.deleteContact(ids, serviceContext);
    }

    @Override
    public Result<ArrayList<Contacts>> queryByParam(ContactsParam contactQueryParam, ServiceContext serviceContext) {
        SysContactsQueryParam sysContactQueryParam = contactsParamBuilder.convertTo(contactQueryParam);

        Result<ArrayList<SysContacts>> queryResult = contactsService.queryByParam(sysContactQueryParam, serviceContext);

        Result<ArrayList<Contacts>> result = new Result<>();
        if (queryResult != null){
            List<Contacts> contactses = contactsBuilder.buildSource(queryResult.getData());
            if (contactses != null){
                result.setErrorCode(queryResult.getErrorCode());
                result.setErrorMsg(queryResult.getErrorMsg());
                result.setData((ArrayList<Contacts>)contactses);
            }
        }

        return result;
    }

    @Override
    public Result<PageList<Contacts>> queryByParam(ContactsParam contactQueryParam, PageModel pageModel, ServiceContext serviceContext) {
        SysContactsQueryParam sysContactQueryParam = contactsParamBuilder.convertTo(contactQueryParam);

        Result<PageList<SysContacts>> queryResult = contactsService.queryByParam(sysContactQueryParam, pageModel, serviceContext);

        Result<PageList<Contacts>> result = new Result<>();

        if (queryResult != null){
            PageList<SysContacts> data = queryResult.getData();
            if (data != null){
                List<Contacts> contactses = contactsBuilder.buildSource(data.getResultList());
                if (contactses != null){

                    PageList<Contacts> pageResult = new PageList<>();
                    pageResult.setPageBean(data.getPageBean());
                    pageResult.setResultList(contactses);

                    result.setErrorCode(queryResult.getErrorCode());
                    result.setErrorMsg(queryResult.getErrorMsg());
                    result.setData(pageResult);
                }
            }
        }

        return result;
    }

    @Override
    public Result<Contacts> queryDefault(ContactsParam contactQueryParam, ServiceContext serviceContext) {
        Result<Contacts> result = new Result<>();

        SysContactsQueryParam sysContactsQueryParam = contactsParamBuilder.convertTo(contactQueryParam);

        Result<SysContacts> queryResult = contactsService.queryDefault(sysContactsQueryParam, serviceContext);

        if (queryResult != null){
            SysContacts sysContacts = queryResult.getData();
            Contacts address = contactsBuilder.buildSource(sysContacts);

            result.setErrorCode(queryResult.getErrorCode());
            result.setErrorMsg(queryResult.getErrorMsg());
            result.setData(address);
        }

        return result;
    }

    @Override
    public Result<Integer> asDefault(Long id, ServiceContext serviceContext) {
        Result<Integer> result = contactsService.asDefault(id, serviceContext);
        return result;
    }
}
