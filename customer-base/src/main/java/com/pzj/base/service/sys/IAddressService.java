package com.pzj.base.service.sys;

import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysAddress;
import com.pzj.base.entity.query.SysAddressQueryParam;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;

import java.util.ArrayList;
import java.util.List;

/**
 * 地址服务接口
 * Created by wuliqing on 2016-10-11.
 */
public interface IAddressService {
    /**
     * 创建单个地址
     * @param address 地址
     * @param serviceContext 服务上下文
     * @return 地址ID
     */
    Result<Long> createAddress(SysAddress address, ServiceContext serviceContext);

    /**
     * 创建多个地址
     * @param addressList 地址集合
     * @param serviceContext 服务上下文
     * @return 创建数量
     */
    Result<Integer> createAddress(List<SysAddress> addressList, ServiceContext serviceContext);

    /**
     * 修改单个地址
     * @param address 地址集合
     * @param serviceContext 服务上下文
     * @return 修改数量
     */
    Result<Integer> modifyAddress(SysAddress address, ServiceContext serviceContext);

    /**
     * 修改多个地址
     * @param addressList 地址集合
     * @param serviceContext 服务上下文
     * @return 修改数量
     */
    Result<Integer> modifyAddress(List<SysAddress> addressList, ServiceContext serviceContext);

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
     * @param addressQueryParam 地址查询参数
     * @return 地址集合
     */
    Result<ArrayList<SysAddress>> queryByParam(SysAddressQueryParam addressQueryParam, ServiceContext serviceContext);

    /**
     * 根据条件查询地址，分页查询
     * @param addressQueryParam 地址查询参数
     * @param pageModel 分页参数
     * @param serviceContext 服务上下文
     * @return 分页结果集
     */
    Result<PageList<SysAddress>> queryByParam(SysAddressQueryParam addressQueryParam, PageModel pageModel, ServiceContext serviceContext);

    /**
     * 根据条件查询默认地址
     * @param addressQueryParam 地址查询参数
     * @return 地址集合
     */
    Result<SysAddress> queryDefault(SysAddressQueryParam addressQueryParam, ServiceContext serviceContext);

    /**
     * 设置为默认地址
     *
     * 同一个供应商（addresss.supplierId相同）的地址中，将其中一个设置为默认。
     * @param id 地址ID
     * @param serviceContext 服务上下文
     * @return 执行数量
     */
    Result<Integer> asDefault(Long id, ServiceContext serviceContext);
}