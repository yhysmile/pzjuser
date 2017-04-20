package com.pzj.address.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pzj.address.entity.Address;
import com.pzj.address.entity.AddressBuilder;
import com.pzj.address.entity.AddressParam;
import com.pzj.address.entity.AddressParamBuilder;
import com.pzj.base.common.ServiceException;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysAddress;
import com.pzj.base.entity.query.SysAddressQueryParam;
import com.pzj.base.service.sys.IAddressService;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;

/**
 * Created by wuliqing on 2016-10-18.
 */
@Service
public class AddressServiceImpl implements AddressService {
    private static final AddressBuilder addressBuilder = AddressBuilder.AAddressBuilder;
    private static final AddressParamBuilder addressParamBuilder = AddressParamBuilder.AAddressParamBuilder;

    private static Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);

    @Resource
    private IAddressService addressService;

    @Override
    public Result<Long> createAddress(Address address, ServiceContext serviceContext) {
        SysAddress sysAddress = null;
        try {
            sysAddress = addressBuilder.buildNew(address);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            return null;
        }

        return addressService.createAddress(sysAddress, serviceContext);
    }

    @Override
    public Result<Integer> createAddress(List<Address> addressList, ServiceContext serviceContext) {
        List<SysAddress> sysAddressList = null;
        try {
            sysAddressList = addressBuilder.buildNew(addressList);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            return null;
        }

        return addressService.createAddress(sysAddressList, serviceContext);
    }

    @Override
    public Result<Integer> modifyAddress(Address address, ServiceContext serviceContext) {
        SysAddress sysAddress = null;
        try {
            sysAddress = addressBuilder.buildExisted(address);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            return null;
        }

        return addressService.modifyAddress(sysAddress, serviceContext);
    }

    @Override
    public Result<Integer> modifyAddress(List<Address> addressList, ServiceContext serviceContext) {
        List<SysAddress> sysAddressList = null;
        try {
            sysAddressList = addressBuilder.buildExisted(addressList);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            return null;
        }

        return addressService.modifyAddress(sysAddressList, serviceContext);
    }

    @Override
    public Result<Integer> deleteAddress(Long id, ServiceContext serviceContext) {
        return addressService.deleteAddress(id, serviceContext);
    }

    @Override
    public Result<Integer> deleteAddress(List<Long> ids, ServiceContext serviceContext) {
        return addressService.deleteAddress(ids, serviceContext);
    }

    @Override
    public Result<ArrayList<Address>> queryByParam(AddressParam addressQueryParam, ServiceContext serviceContext) {
        SysAddressQueryParam sysAddressQueryParam = addressParamBuilder.convertTo(addressQueryParam);

        Result<ArrayList<SysAddress>> queryResult = addressService.queryByParam(sysAddressQueryParam, serviceContext);

        Result<ArrayList<Address>> result = new Result<>();
        if (queryResult != null){
            List<Address> addressesList = addressBuilder.buildSource(queryResult.getData());
            if (addressesList != null){
                result.setErrorCode(queryResult.getErrorCode());
                result.setErrorMsg(queryResult.getErrorMsg());
                result.setData((ArrayList<Address>)addressesList);
            }
        }

        return result;
    }

    @Override
    public Result<PageList<Address>> queryByParam(AddressParam addressQueryParam, PageModel pageModel, ServiceContext serviceContext) {
        SysAddressQueryParam sysAddressQueryParam = addressParamBuilder.convertTo(addressQueryParam);

        Result<PageList<SysAddress>> queryResult = addressService.queryByParam(sysAddressQueryParam, pageModel, serviceContext);

        Result<PageList<Address>> result = new Result<>();

        if (queryResult != null){
            PageList<SysAddress> data = queryResult.getData();
            if (data != null){
                List<Address> addressesList = addressBuilder.buildSource(data.getResultList());
                if (addressesList != null){

                    PageList<Address> pageResult = new PageList<>();
                    pageResult.setPageBean(data.getPageBean());
                    pageResult.setResultList(addressesList);

                    result.setErrorCode(queryResult.getErrorCode());
                    result.setErrorMsg(queryResult.getErrorMsg());
                    result.setData(pageResult);
                }
            }
        }

        return result;
    }

    @Override
    public Result<Address> queryDefault(AddressParam addressQueryParam, ServiceContext serviceContext) {
        Result<Address> result = new Result<>();
        
        SysAddressQueryParam sysAddressQueryParam = addressParamBuilder.convertTo(addressQueryParam);

        Result<SysAddress> queryResult = addressService.queryDefault(sysAddressQueryParam, serviceContext);

        if (queryResult != null){
            SysAddress sysAddress = queryResult.getData();
            Address address = addressBuilder.buildSource(sysAddress);

            result.setErrorCode(queryResult.getErrorCode());
            result.setErrorMsg(queryResult.getErrorMsg());
            result.setData(address);
        }

        return result;
    }

    @Override
    public Result<Integer> asDefault(Long id, ServiceContext serviceContext) {
        Result<Integer> result = addressService.asDefault(id, serviceContext);
        return result;
    }
}
