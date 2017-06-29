package com.pzj.core.customer.write;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.core.customer.channel.ChannelDistributorEntity;
import com.pzj.core.customer.channel.ChannelDistributorQuery;

/**
 * Created by Administrator on 2017-4-14.
 */
@MyBatisDao
public interface ChannelDistributorWriteMapper {
	List<ChannelDistributorEntity> selectByChannelId(Long channelId);

	List<ChannelDistributorEntity> selectByCustomerId(Long customerId);

	List<ChannelDistributorEntity> selectByChannelIds(List<Long> channelIds);

	List<ChannelDistributorEntity> selectByCustomerIds(List<Long> customerIds);

	List<ChannelDistributorEntity> selectByChannelIdDistributorIds(List<ChannelDistributorQuery> params);

	/**
	 * 查询渠道用户关系。根据渠道id和分销商id，最多只查到一条。
	 * @param channelId
	 * @param distributorId
	 * @return
	 */
	ChannelDistributorEntity selectByChannelIdDistributorId(@Param("channelId") Long channelId,
			@Param("distributorId") Long distributorId);

	/**
	 * 更新渠道用户关系。根据关系id，单个更新。
	 * @param updateChannelDistributorEntity
	 * @return
	 */
	int updateChannelDistributor(ChannelDistributorEntity updateChannelDistributorEntity);

	/**
	 * 更新渠道用户关系。根据渠道id、分销商id，批量更新。
	 * @param updates
	 * @return
	 */
	int updateChannelDistributorByChannelIdDistributorId(List<ChannelDistributorEntity> updates);
}
