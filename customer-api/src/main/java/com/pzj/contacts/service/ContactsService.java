package com.pzj.contacts.service;

import java.util.ArrayList;
import java.util.List;

import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysContacts;
import com.pzj.contacts.entity.Contacts;
import com.pzj.contacts.entity.ContactsParam;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;

/**
 * Created by Administrator on 2016-10-12.
 */
public interface ContactsService {
    /**
     * 创建单个联系人
     * @param contacts 联系人
     * @param serviceContext 服务上下文
     * @return 联系人ID
     */
    Result<Long> createContacts(Contacts contacts, ServiceContext serviceContext);

    /**
     * 创建多个联系人
     * @param contacts 联系人集合
     * @param serviceContext 服务上下文
     * @return 创建数量
     */
    Result<Integer> createContacts(List<Contacts> contacts, ServiceContext serviceContext);

    /**
     * 修改单个联系人
     * @param contacts 联系人集合
     * @param serviceContext 服务上下文
     * @return 修改数量
     */
    Result<Integer> modifyContacts(Contacts contacts, ServiceContext serviceContext);

    /**
     * 修改多个联系人
     * @param contacts 联系人集合
     * @param serviceContext 服务上下文
     * @return 修改数量
     */
    Result<Integer> modifyContacts(List<Contacts> contacts, ServiceContext serviceContext);

    /**
     * 删除一些联系人，再创建一些联系人。
     *
     * @param deleteContact 需要删除的联系人
     * @param createContacts 需要创建的联系人
     * @param serviceContext
     * @return
     */
    Result<Integer> deleteAndCreateContacts(ContactsParam deleteContact, List<Contacts> createContacts, ServiceContext serviceContext);

    /**
     * 删除单个联系人
     * @param id 联系人ID
     * @param serviceContext 服务上下文
     * @return 删除数量
     */
    Result<Integer> deleteContacts(Long id, ServiceContext serviceContext);

    /**
     * 删除多个联系人
     * @param ids 联系人ID集合
     * @param serviceContext 服务上下文
     * @return 删除数量
     */
    Result<Integer> deleteContacts(List<Long> ids, ServiceContext serviceContext);

    /**
     * 根据条件查询联系人
     * @param contactQueryParam 联系人查询参数
     * @return 联系人集合
     */
    Result<ArrayList<Contacts>> queryByParam(ContactsParam contactQueryParam, ServiceContext serviceContext);

    /**
     * 根据条件查询联系人，分页查询
     * @param contactQueryParam 联系人查询参数
     * @param pageModel 分页参数
     * @param serviceContext 服务上下文
     * @return 分页结果集
     */
    Result<PageList<Contacts>> queryByParam(ContactsParam contactQueryParam, PageModel pageModel, ServiceContext serviceContext);

    /**
     * 根据条件查询默认联系人
     * @param contactQueryParam 联系人查询参数
     * @return 联系人集合
     */
    Result<Contacts> queryDefault(ContactsParam contactQueryParam, ServiceContext serviceContext);


    /**
     * 设置为默认联系人
     *
     * 同一个供应商（Contacts.supplierId相同）的联系人中，将其中一个设置为默认。
     * @param id 联系人ID
     * @param serviceContext 服务上下文
     * @return 执行数量
     */
    Result<Integer> asDefault(Long id, ServiceContext serviceContext);
}
