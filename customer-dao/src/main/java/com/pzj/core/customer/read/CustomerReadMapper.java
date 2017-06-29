package com.pzj.core.customer.read;

import java.util.List;

import com.pzj.core.customer.entitys.CustomerQuery;
import org.apache.ibatis.annotations.Param;

import com.pzj.core.customer.entitys.ChannelResellerQueryParam;
import com.pzj.core.customer.entitys.PageEntity;
import com.pzj.core.customer.entitys.CustomerEntity;

public interface CustomerReadMapper {

	List<CustomerEntity> selectResellerBaseInfoList(@Param("reseller") CustomerQuery reseller,
													@Param("page") PageEntity page);

	int countResellerBaseInfoPage(@Param("reseller") CustomerQuery reseller);

	CustomerEntity selectUserBaseInfoById(Long id);

	Long judgeUserNameMate(@Param("loginName") String loginName, @Param("mobile") String mobile);

	List<CustomerEntity> selectUserBaseByInviteCode(String inviteCode);

	List<CustomerEntity> selectChannelUsers(@Param("channelReseller") ChannelResellerQueryParam channelReseller,
											@Param("page") PageEntity page);

	int countChannelUsers(@Param("channelReseller") ChannelResellerQueryParam channelReseller);

	List<CustomerEntity> selectRootUsers(@Param("channelReseller") ChannelResellerQueryParam channelReseller,
										 @Param("page") PageEntity page);

	int countRootUsers(@Param("channelReseller") ChannelResellerQueryParam channelReseller);

	List<CustomerEntity> selectChannelRelUsers(@Param("channelReseller") ChannelResellerQueryParam channelReseller,
											   @Param("page") PageEntity page);

	List<Long> countChannelRelUsers(@Param("channelReseller") ChannelResellerQueryParam channelReseller);

	List<CustomerEntity> selectChannelNotRelUsers(@Param("channelReseller") ChannelResellerQueryParam channelReseller,
												  @Param("page") PageEntity page);

	List<Long> countChannelNotRelUsers(@Param("channelReseller") ChannelResellerQueryParam channelReseller);

	Integer countResellerSum(@Param("channelReseller") ChannelResellerQueryParam channelReseller);
	List<CustomerEntity> selectCustomerFreeJoin(@Param("reseller") CustomerQuery reseller,
												@Param("page") PageEntity page);

	int countQueryCustomerFreeJoin(@Param("reseller") CustomerQuery reseller);

	int countCustomerLessInfo(@Param("reseller") CustomerQuery param);

	List<CustomerEntity> selectCustomerLessInfo(@Param("reseller") CustomerQuery userParam,
												@Param("page") PageEntity page);

	List<CustomerEntity> selectResellerRelMaster(@Param("reseller") CustomerQuery reseller,
												 @Param("page") PageEntity page);

	int countResellerRelMaster(@Param("reseller") CustomerQuery reseller);

}
