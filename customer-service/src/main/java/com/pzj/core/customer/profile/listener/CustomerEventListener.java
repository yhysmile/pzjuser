package com.pzj.core.customer.profile.listener;

import com.pzj.core.customer.common.work.Event;
import com.pzj.core.customer.common.work.EventListener;
import com.pzj.core.customer.profile.event.UnbindDirectDistributorEvent;
import com.pzj.core.customer.profile.mq.BindDistributor;
import com.pzj.core.customer.profile.mq.CustomerMqMessage;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Administrator on 2017-6-6.
 */
public class CustomerEventListener implements EventListener {
    @Resource
    private CustomerMqMessage customerMqMessage;

    @Override
    public void handleEvent(Event event) {
        if (event instanceof UnbindDirectDistributorEvent){
            handleUnbindDirectDistributorEvent((UnbindDirectDistributorEvent)event);
        }
    }

    private void handleUnbindDirectDistributorEvent(UnbindDirectDistributorEvent event) {
        Long supplierId = event.getSupplierId();
        Long distributorId = event.getDistributorId();
        Long operatorId = event.getOperatorId();
        Date operatingDate = event.getOperatingDate();

        BindDistributor bindDistributor = new BindDistributor();
        bindDistributor.setSupplierId(supplierId);
        bindDistributor.setCustomerIds(Arrays.asList(distributorId));
        bindDistributor.setOperatorId(operatorId);
        bindDistributor.setOperatingDate(operatingDate);

        customerMqMessage.sendUnbindDistributorMsg(bindDistributor);
    }

    public void setCustomerMqMessage(CustomerMqMessage customerMqMessage) {
        this.customerMqMessage = customerMqMessage;
    }
}
