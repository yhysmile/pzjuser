package com.pzj.service.Impl;

import java.util.*;

import com.google.common.collect.Multimap;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.collect.HashMultimap;
import com.pzj.base.common.UserServiceException;
import com.pzj.base.common.impl.BaseServiceImpl;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysAddress;
import com.pzj.base.entity.query.SysAddressQueryParam;
import com.pzj.base.service.sys.IAddressService;
import com.pzj.dao.SysAddressMapper;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;

/**
 * Created by Administrator on 2016-10-12.
 */
@Service("iAddressService")
public class AddressServiceImpl extends BaseServiceImpl<SysAddress, SysAddressMapper> implements IAddressService {
    private static final Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);

    private void checkWhenCreate(SysAddress address){
        if (address == null){
            throw new UserServiceException("地址不能为 null");
        }

        if (StringUtils.isBlank(address.getDataSource())){
            throw new UserServiceException("地址的所属平台（dataSource）不能为空");
        }
        if (address.getType() == null){
            throw new UserServiceException("地址的类型（type）不能为空");
        }
        if (address.getSupplierId() == null){
            throw new UserServiceException("地址的所属供应商（supplierId）不能为空");
        }
        if (address.getCreateDate() == null){
            address.setCreateDate(new Date());
        }
        if (address.getIsDefault() == null){
            address.setIsDefault(false);
        }
    }

    private void checkWhenCreate(List<SysAddress> addressList){
        if (CollectionUtils.isEmpty(addressList)){
            throw new UserServiceException("地址集合不能为空");
        }
        for (SysAddress address : addressList){
            checkWhenCreate(address);
        }
    }

    private void checkWhenModify(SysAddress address){
        if (address == null){
            throw new UserServiceException("地址不能为 null");
        }
        if (address.getId() == null){
            throw new UserServiceException("地址的Id不能为空");
        }
        if (address.getSupplierId() == null){
            throw new UserServiceException("地址的SupplierId不能为空");
        }
        if (address.getType() == null){
            throw new UserServiceException("地址的type不能为空");
        }
        if (address.getUpdateDate() == null){
            address.setUpdateDate(new Date());
        }
    }

    private void checkWhenModify(List<SysAddress> addressList){
        if (CollectionUtils.isEmpty(addressList)){
            throw new UserServiceException("地址集合不能为空");
        }
        for (SysAddress address : addressList){
            checkWhenModify(address);
        }
    }
    @Override
    public Result<Long> createAddress(SysAddress address, ServiceContext serviceContext) {

        logger.trace("日志ID：{}；创建地址开始", serviceContext.getLogId());

        checkWhenCreate(address);

        List<SysAddress> nonDefaultAddressList = asDefaultAndExcludeOther(address);
        if (CollectionUtils.isNotEmpty(nonDefaultAddressList)){
            super.updateBatchByPrimaryKey(nonDefaultAddressList);
        }
        Long insert = super.insert(address);

        logger.trace("日志ID：{}；新建地址ID：{}", serviceContext.getLogId(), insert);
        logger.trace("日志ID：{}；创建地址结束", serviceContext.getLogId());

        Result<Long> result = new Result<>();
        result.setData(insert);

        return result;
    }

    @Override
    public Result<Integer> createAddress(List<SysAddress> addressList, ServiceContext serviceContext) {

        logger.trace("日志ID：{}；创建地址开始", serviceContext.getLogId());

        // 校验数据
        checkWhenCreate(addressList);

        // 设置新建的地址为默认地址，以前的地址为非默认地址。
        List<SysAddress> nonDefaultAddressList = asDefaultAndExcludeOther(addressList);
        if (CollectionUtils.isNotEmpty(nonDefaultAddressList)){
            // 更新以前的地址为非默认地址
            super.updateBatchByPrimaryKey(nonDefaultAddressList);
        }
        // 保存新地址。insertResult是影响行数。
        Long insertResult = super.insertBatch(addressList);

        int insert = 0;
        if (insertResult == addressList.size())
            insert = addressList.size();

        logger.trace("日志ID：{}；新建地址数量：{}", serviceContext.getLogId(), insert);
        logger.trace("日志ID：{}；创建地址结束", serviceContext.getLogId());

        Result<Integer> result = new Result<>();
        result.setData(insert);

        return result;
    }

    @Override
    public Result<Integer> modifyAddress(SysAddress address, ServiceContext serviceContext) {
        checkWhenModify(address);

        // 设置新建的地址为默认地址，以前的地址为非默认地址。
        List<SysAddress> nonDefaultAddressList = asDefaultAndExcludeOther(address);
        if (CollectionUtils.isNotEmpty(nonDefaultAddressList)){
            // 更新以前的地址为非默认地址
            super.updateBatchByPrimaryKey(nonDefaultAddressList);
        }

        Integer modify = super.updateByPrimaryKey(address);

        Result<Integer> result = new Result<>();
        result.setData(modify);

        return result;
    }

    @Override
    public Result<Integer> modifyAddress(List<SysAddress> address, ServiceContext serviceContext) {
        checkWhenModify(address);

        // 设置新建的地址为默认地址，以前的地址为非默认地址。
        List<SysAddress> nonDefaultAddressList = asDefaultAndExcludeOther(address);
        if (CollectionUtils.isNotEmpty(nonDefaultAddressList)){
            // 更新以前的地址为非默认地址
            super.updateBatchByPrimaryKey(nonDefaultAddressList);
        }

        Integer modify = super.updateBatchByPrimaryKey(address);

        Result<Integer> result = new Result<>();
        result.setData(modify);

        return result;
    }

    @Override
    public Result<Integer> deleteAddress(Long id, ServiceContext serviceContext) {

        Integer delete = super.delete(id);

        Result<Integer> result = new Result<>();
        result.setData(delete);

        return result;
    }

    @Override
    public Result<Integer> deleteAddress(List<Long> ids, ServiceContext serviceContext) {
        Integer delete = mapper.deleteBatchByPrimaryKey(ids);
        if (delete == 1)
            delete = ids.size();

        Result<Integer> result = new Result<>();
        result.setData(delete);

        return result;
    }

    @Override
    public Result<ArrayList<SysAddress>> queryByParam(SysAddressQueryParam addressQueryParam, ServiceContext serviceContext) {
        List<SysAddress> findResult = super.findListByParams(addressQueryParam);

        Result<ArrayList<SysAddress>> result = new Result<>();
        if (findResult != null){
            result.setData((ArrayList<SysAddress>)findResult);
        }

        return result;
    }

    @Override
    public Result<PageList<SysAddress>> queryByParam(SysAddressQueryParam addressQueryParam, PageModel pageModel, ServiceContext serviceContext) {

        PageList<SysAddress> queryResult = super.queryPageByParamMap(pageModel, addressQueryParam);

        Result<PageList<SysAddress>> result = new Result<>();
        result.setData(queryResult);
        return result;
    }

    @Override
    public Result<SysAddress> queryDefault(SysAddressQueryParam addressQueryParam, ServiceContext serviceContext) {
        Result<SysAddress> result = new Result<>();

        if (addressQueryParam == null){
            return result;
        }
        if (addressQueryParam.getSupplierId() == null){
            return result;
        }
        addressQueryParam.setIsDefault(true);

        List<SysAddress> sysAddressList = super.findListByParams(addressQueryParam);
        if (CollectionUtils.isNotEmpty(sysAddressList)){
            SysAddress address = sysAddressList.get(0);
            result.setData(address);
        }

        return result;
    }

    @Override
    public Result<Integer> asDefault(Long id, ServiceContext serviceContext) {
        Result<Integer> result = new Result<>();
        result.setData(0);

        if (id == null){
            return result;
        }

        SysAddress sysAddressTarget = getById(id);
        if (sysAddressTarget == null || sysAddressTarget.getType() == null){
            return result;
        }

        SysAddress sysAddress1 = new SysAddress();
        sysAddress1.setId(id);
        sysAddress1.setSupplierId(sysAddressTarget.getSupplierId());
        sysAddress1.setType(sysAddressTarget.getType());
        sysAddress1.setIsDefault(true);

        List<SysAddress> nonDefaultAddressList = asDefaultAndExcludeOther(sysAddress1);

        int update = 0;
        if (CollectionUtils.isNotEmpty(nonDefaultAddressList)){
            update = super.updateBatchByPrimaryKey(nonDefaultAddressList);
        }
        update = update + super.updateByPrimaryKey(sysAddress1);

        result.setData(update);

        return result;
    }

    private List<SysAddress> asDefaultAndExcludeOther(SysAddress address){
        Boolean isDefault = address.getIsDefault();
        if (isDefault != null && isDefault)
            return allAddressAsNonDefault(address.getSupplierId(), address.getType());
        return null;
    }

    private List<SysAddress> allAddressAsNonDefault(Long supplierId, Integer type){
        if (type == null)
            throw new UserServiceException("设置所有地址为非默认时，type 不能为 null。");
        if (supplierId == null)
            throw new UserServiceException("设置所有地址为非默认时，supplierId 不能为 null。");

        SysAddressQueryParam addressQueryParam = new SysAddressQueryParam();
        addressQueryParam.setSupplierId(supplierId);
        addressQueryParam.setType(type);
        addressQueryParam.setIsDefault(true);
        List<SysAddress> sysAddressList = super.findListByParams(addressQueryParam);

        List<SysAddress> updateAddressList = asNonDefaultAddress(sysAddressList);

        return updateAddressList;
    }

    /**
     * 将所有地址置为非默认的地址，同时将参数的地址设置为默认地址。
     * @param addressList
     * @return 需要更新保存成为非默认的地址集合
     */
    private List<SysAddress> asDefaultAndExcludeOther(List<SysAddress> addressList){
        if (CollectionUtils.isEmpty(addressList))
            throw new UserServiceException("设置所有地址为非默认时，地址集合不能为空。");

        HashMultimap<Long, Integer> plane = HashMultimap.create();
        for (SysAddress address : addressList){
            if (address == null)
                continue;
            if (address.getType() == null)
                throw new UserServiceException("设置所有地址为非默认时，type 不能为 null。");
            if (address.getSupplierId() == null)
                throw new UserServiceException("设置所有地址为非默认时，supplierId 不能为 null。");

            Boolean isDefault = address.getIsDefault();
            if (plane.containsEntry(address.getSupplierId(), address.getType())){
                address.setIsDefault(false);
            } else if(isDefault != null && isDefault){
                plane.put(address.getSupplierId(), address.getType());
                address.setIsDefault(true);
            }
        }

        return allAddressAsNonDefault(plane);
    }

    /**
     * 将所有地址置为非默认的地址。
     * @param addressList
     * @return 需要更新保存成为非默认的地址集合
     */
    private List<SysAddress> allAddressAsNonDefault(Multimap<Long, Integer> addressList){
        if (addressList.isEmpty()){
            return null;
        }

        List<SysAddressQueryParam> addressQueryParamList = new ArrayList<>(addressList.size());

        Iterator<Map.Entry<Long, Integer>> iterator = addressList.entries().iterator();
        while(iterator.hasNext())
        {
            Map.Entry<Long, Integer> entry = iterator.next();
            SysAddressQueryParam addressQueryParam = new SysAddressQueryParam();
            addressQueryParam.setSupplierId(entry.getKey());
            addressQueryParam.setType(entry.getValue());
            addressQueryParam.setIsDefault(true);
            addressQueryParamList.add(addressQueryParam);
        }

        List<SysAddress> sysAddressList = mapper.queryByManyParam(addressQueryParamList);

        List<SysAddress> nonDefaultAddressList = asNonDefaultAddress(sysAddressList);

        return nonDefaultAddressList;
    }

    /**
     * 获取非默认的地址
     * @param sysAddressList
     * @return
     */
    private List<SysAddress> asNonDefaultAddress(List<SysAddress> sysAddressList){
        List<SysAddress> nonDefaultDataList = null;
        if (CollectionUtils.isNotEmpty(sysAddressList)){
            nonDefaultDataList = new ArrayList<>(sysAddressList.size());
            for (SysAddress sysAddress : sysAddressList){
                SysAddress noDefaultData = new SysAddress();
                noDefaultData.setId(sysAddress.getId());
                noDefaultData.setIsDefault(false);
                nonDefaultDataList.add(noDefaultData);

                if (logger.isTraceEnabled()){
                    noDefaultData.setType(sysAddress.getType());
                    noDefaultData.setSupplierId(sysAddress.getSupplierId());
                }

            }
        }

        if (logger.isTraceEnabled()){
            if (nonDefaultDataList == null){
                logger.trace("转换地址成为非默认的形式：没有任何转换。");
            } else {
                logger.trace("转换地址成为非默认的形式：共 {} 条，详细数据如下：", nonDefaultDataList.size());
                for (SysAddress address : nonDefaultDataList){
                    logger.trace("\tId： {}，Type： {}，SupplierId： {}", address.getId(), address.getType(), address.getSupplierId());
                    address.setSupplierId(null);
                    address.setType(null);
                }
            }
        }

        return nonDefaultDataList;
    }
}
