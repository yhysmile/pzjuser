package com.pzj.core.customer.channel;

import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.entity.SysChannel;
import com.pzj.base.entity.SysUser;
import com.pzj.core.customer.channel.mq.ChannelMqMessage;
import com.pzj.core.customer.channel.mq.DirectChannelUser;
import com.pzj.core.customer.channel.mq.ModifyChannel;
import com.pzj.core.customer.channel.mq.Relation;
import com.pzj.core.customer.dao.SysUserMapper;
import com.pzj.core.customer.profile.CustomerUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017-4-11.
 */
@Component
public class ChannelMessageEngine {
    @Resource
    private SysUserMapper userMapper;

    @Resource
    private ChannelMqMessage channelMqMessage;


    public void sendChannelStatusChange(Long channelId, Integer oldState, Integer newState, Long operatorId) {
        ModifyChannel modifyChannel = new ModifyChannel(channelId, oldState, GlobalParam.FLAG.del(), operatorId, new Date());
        channelMqMessage.sendChannelStateMsg(modifyChannel);
    }

    public void sendChannelStatusChange(SysChannel newChannel, SysChannel oldChannel) {
        if (newChannel.getDelFlag() == null){
            return;
        }
        if (oldChannel.getDelFlag() != null && !newChannel.getDelFlag().equals(oldChannel.getDelFlag())){
            ModifyChannel modifyChannel = new ModifyChannel();
            modifyChannel.setChannelId(newChannel.getId());
            modifyChannel.setNewStaus(Integer.valueOf(newChannel.getDelFlag()));
            modifyChannel.setOldStatus(Integer.valueOf(oldChannel.getDelFlag()));
            modifyChannel.setOperatorId(Long.valueOf(newChannel.getUpdateBy()));
            modifyChannel.setOperatingDate(newChannel.getUpdateDate());

            channelMqMessage.sendChannelStateMsg(modifyChannel);
        }
    }

    public void sendMsg1(Long channelId, List<Long> addCustomerIds, List<Long> delCustomerIds, Long operatorId){
        List<Relation> addRelations = null;
        List<Relation> delRelations = null;
        if (addCustomerIds != null && !addCustomerIds.isEmpty()) {
            addRelations = channelCustomerRelationses(channelId, addCustomerIds);
        }
        if (delCustomerIds != null && !delCustomerIds.isEmpty()) {
            delRelations = channelCustomerRelationses(channelId, delCustomerIds);
        }
        sendChannelUserRelationMsg(addRelations, delRelations, operatorId);
    }

    private List<Relation> channelCustomerRelationses(Long channelId, List<Long> customerIds){
        List<Relation> relations = new ArrayList<>(customerIds.size());
        for (Long customerId : customerIds){
            Relation relation = createRelations(customerId, channelId);
            relations.add(relation);
        }
        return relations;
    }

    private Relation createRelations(Long customerId, Long channelId) {
        Relation relation = new Relation();
        relation.setCustomerId(customerId);
        relation.setChannelId(channelId);
        return relation;
    }

    private void sendChannelUserRelationMsg(List<Relation> addRelations, List<Relation> delRelations, Long operatorId){
        if (addRelations == null && delRelations == null){
            return;
        }

        Date currentDate = new Date();

        SysUser operator = userMapper.selectByPrimaryKey(operatorId);
        Long ownerId = CustomerUtil.masterId(operator);

        DirectChannelUser addCustomerMsg = createDirectChannelUser(operatorId, currentDate, ownerId, addRelations);
        DirectChannelUser delCustomerMsg = createDirectChannelUser(operatorId, currentDate, ownerId, delRelations);

        channelMqMessage.sendAddCustomerMsg(addCustomerMsg);
        channelMqMessage.sendDelCustomerMsg(delCustomerMsg);
    }


    private DirectChannelUser createDirectChannelUser(Long operId, Date currentDate, Long ownerId, List<Relation> relations) {
        if (relations == null){
            return null;
        }

        DirectChannelUser addCustomerMsg = new DirectChannelUser();
        addCustomerMsg.setOperatingDate(currentDate);
        addCustomerMsg.setOperatorId(operId);
        addCustomerMsg.setSupplierId(ownerId);
        addCustomerMsg.setRelations(relations);
        return addCustomerMsg;
    }

    public void sendMsg2(Long customer, List<Long> addChannelIds, List<Long> delChannelIds, Long operatorId){
        List<Relation> addRelations = null;
        List<Relation> delRelations = null;
        if (addChannelIds != null && !addChannelIds.isEmpty()) {
            addRelations = customerChannelRelations(addChannelIds, customer);
        }
        if (delChannelIds != null && !delChannelIds.isEmpty()) {
            delRelations = customerChannelRelations(delChannelIds, customer);
        }
        sendChannelUserRelationMsg(addRelations, delRelations, operatorId);
    }

    private List<Relation> customerChannelRelations(List<Long> channelIds, Long customerId){
        List<Relation> relations = new ArrayList<>(channelIds.size());
        for (Long channelId : channelIds){
            Relation relation = createRelations(customerId, channelId);
            relations.add(relation);
        }
        return relations;
    }
}
