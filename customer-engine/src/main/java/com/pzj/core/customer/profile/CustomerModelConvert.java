package com.pzj.core.customer.profile;

import com.pzj.core.customer.entitys.CustomerEntity;
import com.pzj.core.customer.entitys.CustomerQuery;
import com.pzj.core.customer.utils.UserRelationEnum;
import com.pzj.core.customer.utils.UserRootEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-4-12.
 */
public class CustomerModelConvert {

    public static CustomerQuery convertToResellerQuery(QueryCustomerLessInfoRequest param) {
        if (param == null) {
            return null;
        }

        CustomerQuery customerEntity = new CustomerQuery();
        boolean hasParam = false;

        if (param.getName() != null && param.getName().trim() != ""){
            customerEntity.setName("%"+ param.getName() + "%");
            hasParam = true;
        }
        List<Long> ids = param.getIds();
        if (ids != null && !ids.isEmpty()) {
            customerEntity.setUserIds(ids);
            hasParam = true;
        }

        if (hasParam) {
            return customerEntity;
        }

        return null;
    }

    public static List<QueryCustomerLessInfoResponse> convertToQueryCustomerLessInfoResponse(List<CustomerEntity> resellerEntities) {
        if (resellerEntities == null){
            return null;
        }
        List<QueryCustomerLessInfoResponse> list = new ArrayList<>(resellerEntities.size());

        for (CustomerEntity customerEntity : resellerEntities) {
            if (customerEntity != null) {
                list.add(convertToQueryCustomerLessInfoResponse(customerEntity));
            }
        }

        return list;
    }

    public static QueryCustomerLessInfoResponse convertToQueryCustomerLessInfoResponse(CustomerEntity customerEntity) {
        if (customerEntity == null) {
            return null;
        }
        QueryCustomerLessInfoResponse response = new QueryCustomerLessInfoResponse();
        response.setId(customerEntity.getId());
        response.setName(customerEntity.getName());
        response.setCorporater(customerEntity.getCorporater());
        return response;
    }

    public static CustomerQuery convertToCustomerQuery(QueryCustomerRequest param) {
        if (param == null) {
            return null;
        }
        CustomerQuery customerQuery = new CustomerQuery();
        customerQuery.setLoginName(param.getLoginName());
        customerQuery.setSupplierId(param.getSupplierId());
        customerQuery.setCorporater(param.getCorporater());
        customerQuery.setCorporaterMobile(param.getCorporaterMobile());
        customerQuery.setName(param.getName());
        customerQuery.setAddress(param.getAddress());
        customerQuery.setUserRelType(UserRelationEnum.SUPPLIER_DIRECT_RESELLER.getId());
        customerQuery.setIsRoot(UserRootEnum.ROOT_USER.getKey());
        if (param.getResellerType() != null) {
            customerQuery.setResellerType(param.getResellerType().toString());
        }
        customerQuery.setRefereeId(param.getRefereeId());
        customerQuery.setCreateDate(param.getCreateDate());
        customerQuery.setBindDateBegin(param.getBindDateBegin());
        customerQuery.setBindDateEnd(param.getBindDateEnd());
        customerQuery.setProvince(param.getProvince());
        customerQuery.setCity(param.getCity());
        customerQuery.setCounty(param.getCounty());
        customerQuery.setQueryType(param.getQuerType());
        customerQuery.setUserIds(param.getUserIds());
        customerQuery.setId(param.getId());
        customerQuery.setNameOrCorporaterOrMobile(param.getNameOrCorporaterOrMobile());
        return customerQuery;
    }

    public static ArrayList<QueryCustomerResponse> convertToQueryCustomerResponse(List<CustomerEntity> resellers) {
        if (resellers == null || resellers.size() == 0) {
            return null;
        }
        ArrayList<QueryCustomerResponse> queryCustomerResponses = new ArrayList<>(resellers.size());
        for (CustomerEntity reseller : resellers) {
            queryCustomerResponses.add(convertToQueryCustomerResponse(reseller));
        }
        return queryCustomerResponses;
    }

    public static QueryCustomerResponse convertToQueryCustomerResponse(CustomerEntity reseller) {
        if (reseller == null) {
            return null;
        }
        QueryCustomerResponse queryCustomerResponse = new QueryCustomerResponse();
        queryCustomerResponse.setId(reseller.getId());
        queryCustomerResponse.setLoginName(reseller.getLoginName());
        queryCustomerResponse.setSupplierId(reseller.getSupplierId());
        queryCustomerResponse.setCorporater(reseller.getCorporater());
        queryCustomerResponse.setCorporaterMobile(reseller.getCorporaterMobile());
        queryCustomerResponse.setName(reseller.getName());
        queryCustomerResponse.setAddress(reseller.getAddress());
        queryCustomerResponse.setResellerType(reseller.getResellerType() == null ? null
                : Integer.parseInt(reseller.getResellerType()));
        queryCustomerResponse.setCreateDate(reseller.getCreateDate());
        queryCustomerResponse.setProvince(reseller.getProvince());
        queryCustomerResponse.setCity(reseller.getCity());
        queryCustomerResponse.setCounty(reseller.getCounty());
        queryCustomerResponse.setIsRoot(reseller.getIsRoot());

        if (reseller.getName() == null || reseller.getName().trim().length() == 0) {
            queryCustomerResponse.setName(reseller.getCorporater());
        }
        return queryCustomerResponse;
    }
}
