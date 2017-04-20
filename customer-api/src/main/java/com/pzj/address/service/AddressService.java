package com.pzj.address.service;

import com.pzj.address.entity.Address;
import com.pzj.address.entity.AddressParam;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-10-18.
 */
public interface AddressService {
    /**
     * 创建单个地址
     * @param Address 地址
     * @param serviceContext 服务上下文
     * @return 地址ID
     */
    Result<Long> createAddress(Address Address, ServiceContext serviceContext);

    /**
     * 创建多个地址
     * @param Address 地址集合
     * @param serviceContext 服务上下文
     * @return 创建数量
     */
    Result<Integer> createAddress(List<Address> Address, ServiceContext serviceContext);

    /**
     * 修改单个地址
     * @param Address 地址集合
     * @param serviceContext 服务上下文
     * @return 修改数量
     */
    Result<Integer> modifyAddress(Address Address, ServiceContext serviceContext);

    /**
     * 修改多个地址
     * @param Address 地址集合
     * @param serviceContext 服务上下文
     * @return 修改数量
     */
    Result<Integer> modifyAddress(List<Address> Address, ServiceContext serviceContext);

    /**
     * 删除单个地址
     * @param id 地址ID
     * @param serviceContext 服务上下文
     * @return 删除数量
     */
    Result<Integer> deleteAddress(Long id, ServiceContext serviceContext);

    /**
     * 删除多个地址
     * @param ids 地址ID集合
     * @param serviceContext 服务上下文
     * @return 删除数量
     */
    Result<Integer> deleteAddress(List<Long> ids, ServiceContext serviceContext);

    /**
     * 根据条件查询地址
     * @param AddressQueryParam 地址查询参数
     * @return 地址集合
     */
    Result<ArrayList<Address>> queryByParam(AddressParam AddressQueryParam, ServiceContext serviceContext);

    /**
     * 根据条件查询地址，分页查询
     * @param AddressQueryParam 地址查询参数
     * @param pageModel 分页参数
     * @param serviceContext 服务上下文
     * @return 分页结果集
     */
    Result<PageList<Address>> queryByParam(AddressParam AddressQueryParam, PageModel pageModel, ServiceContext serviceContext);

    /**
     * 根据条件查询默认地址
     * @param AddressQueryParam 地址查询参数
     * @return 地址集合
     */
    Result<Address> queryDefault(AddressParam AddressQueryParam, ServiceContext serviceContext);


    /**
     * 设置为默认地址
     *
     * 同一个供应商（Address.supplierId相同）的地址中，将其中一个设置为默认。
     * @param id 地址ID
     * @param serviceContext 服务上下文
     * @return 执行数量
     */
    Result<Integer> asDefault(Long id, ServiceContext serviceContext);
}
