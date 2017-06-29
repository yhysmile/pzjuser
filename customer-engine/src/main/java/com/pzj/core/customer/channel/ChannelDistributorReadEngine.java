package com.pzj.core.customer.channel;

import com.pzj.core.customer.common.exception.CustomerException;
import com.pzj.core.customer.common.exception.CustomerExceptionCode;
import com.pzj.core.customer.read.ChannelDistributorReadMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-5-4.
 */
@Component
public class ChannelDistributorReadEngine {
    @Resource
    private ChannelDistributorReadMapper channelDistributorReadMapper;


    public QueryChannelRelationResponse queryChannelCustomerByChannelIds(List<Long> list) {
        if (list == null || list.isEmpty()) {
            throw new CustomerException(CustomerExceptionCode.PARAMETER_EMPTY);
        }

        List<ChannelDistributorEntity> channelCustomers = channelDistributorReadMapper.selectByChannelIds(list);
        if (channelCustomers == null || channelCustomers.isEmpty()){
            return null;
        }

        Map<Long, List<Long>> channelCustomerMap = new HashMap<>(list.size());
        for (ChannelDistributorEntity relation : channelCustomers) {
            Long channelId = relation.getChannelId();

            List<Long> customerIds = channelCustomerMap.get(channelId);

            if (customerIds == null){
                customerIds = new ArrayList<>();
                channelCustomerMap.put(channelId, customerIds);
            }

            customerIds.add(relation.getDistributorId());
        }

        QueryChannelRelationResponse response = new QueryChannelRelationResponse();
        response.setChannelRelations(channelCustomerMap);

        return response;
    }

    public QueryChannelRelationResponse queryChannelCustomerByDistributorIds(List<Long> list) {
        if (list == null || list.isEmpty()) {
            throw new CustomerException(CustomerExceptionCode.PARAMETER_EMPTY);
        }

        List<ChannelDistributorEntity> channelCustomers = channelDistributorReadMapper.selectByDiDistributorIds(list);
        if (channelCustomers == null || channelCustomers.isEmpty()){
            return null;
        }


        Map<Long, List<Long>> channelCustomerMap = new HashMap<>(list.size());
        for (ChannelDistributorEntity relation : channelCustomers) {
            Long customerId = relation.getDistributorId();

            List<Long> channelIds = channelCustomerMap.get(customerId);

            if (channelIds == null){
                channelIds = new ArrayList<>();
                channelCustomerMap.put(customerId, channelIds);
            }

            channelIds.add(relation.getChannelId());
        }

        QueryChannelRelationResponse response = new QueryChannelRelationResponse();
        response.setChannelRelations(channelCustomerMap);

        return response;
    }
}
