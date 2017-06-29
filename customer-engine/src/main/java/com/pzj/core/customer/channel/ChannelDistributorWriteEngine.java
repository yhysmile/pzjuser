package com.pzj.core.customer.channel;


import com.pzj.core.customer.write.ChannelDistributorWriteMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017-6-5.
 */
@Component
public class ChannelDistributorWriteEngine {

    @Resource
    private ChannelDistributorWriteMapper channelDistributorWriteMapper;
    @Resource
    private ChannelWriteEngine channelWriteEngine;

    /**
     * 根据渠道id、分销商id，解绑渠道和分销商
     * @param channelId 渠道id
     * @param distributorId 分销商id
     * @param operatorId 操作人id
     * @return
     */
    public boolean unbindDistributor(Long channelId, Long distributorId, Long operatorId){
        ChannelDistributorEntity channelDistributorEntity = channelDistributorWriteMapper.selectByChannelIdDistributorId(channelId, distributorId);

        boolean result = false;
        if (channelDistributorEntity != null){
            Integer status = channelDistributorEntity.getStatus();

            if (status == null || status.equals(1)){
                ChannelDistributorEntity updateChannelDistributorEntity = new ChannelDistributorEntity();
                updateChannelDistributorEntity.setId(channelDistributorEntity.getId());
                updateChannelDistributorEntity.setStatus(0);
                updateChannelDistributorEntity.setUpdateBy(operatorId);
                updateChannelDistributorEntity.setUpdateDate(new Date());

                channelDistributorWriteMapper.updateChannelDistributor(updateChannelDistributorEntity);

                result = true;
            }
        }
        return result;
    }

    /**
     * 根据主账号id、分销商id，解绑主账号的所有渠道与分销商
     * @param masterId 主账号id
     * @param distributorId 分销商id
     * @param operatorId 操作人id
     * @return
     */
    public boolean unbindDistributorForMasterId(Long masterId, Long distributorId, Long operatorId, Date operatingDate){
        List<ChannelEntity> channelEntities = channelWriteEngine.queryActivateChannelByMasterId(masterId);

        List<ChannelDistributorEntity> updates = null;
        if (channelEntities != null && !channelEntities.isEmpty()){
            updates = new ArrayList<>(channelEntities.size());
            for (ChannelEntity channelEntity : channelEntities){
                ChannelDistributorEntity channelDistributorEntity = new ChannelDistributorEntity();
                channelDistributorEntity.setChannelId(channelEntity.getId());
                channelDistributorEntity.setDistributorId(distributorId);
                channelDistributorEntity.setStatus(0);
                channelDistributorEntity.setUpdateBy(operatorId);
                channelDistributorEntity.setUpdateDate(operatingDate);
                updates.add(channelDistributorEntity);
            }
        }

        boolean result = false;
        if (updates != null){
            channelDistributorWriteMapper.updateChannelDistributorByChannelIdDistributorId(updates);
            result = true;
        }

        return result;
    }
}
