package com.pzj.core.customer.read;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pzj.core.customer.profile.ChannelResellerQueryParam;
import com.pzj.core.customer.profile.PageEntity;
import com.pzj.core.customer.profile.ResellerEntity;

public interface CustomerReadMapper {

	public List<ResellerEntity> queryResellerBaseInfoList(@Param("reseller") ResellerEntity reseller,
			@Param("page") PageEntity page);

	public Integer countResellerBaseInfoPage(@Param("reseller") ResellerEntity reseller);

	public ResellerEntity queryUserBaseInfoById(Long id);

	public Long judgeUserNameMate(@Param("loginName") String loginName, @Param("mobile") String mobile);

	public List<ResellerEntity> queryUserBaseByInviteCode(String inviteCode);

	public List<ResellerEntity> queryChannelUsers(@Param("channelReseller") ChannelResellerQueryParam channelReseller,
			@Param("page") PageEntity page);

	public Integer countChannelUsers(@Param("channelReseller") ChannelResellerQueryParam channelReseller);

	public List<ResellerEntity> queryRootUsers(@Param("channelReseller") ChannelResellerQueryParam channelReseller,
			@Param("page") PageEntity page);

	public Integer countRootUsers(@Param("channelReseller") ChannelResellerQueryParam channelReseller);

	public List<ResellerEntity> queryChannelRelUsers(
			@Param("channelReseller") ChannelResellerQueryParam channelReseller, @Param("page") PageEntity page);

	public List<Long> countChannelRelUsers(@Param("channelReseller") ChannelResellerQueryParam channelReseller);

	public List<ResellerEntity> queryChannelNotRelUsers(
			@Param("channelReseller") ChannelResellerQueryParam channelReseller, @Param("page") PageEntity page);

	public List<Long> countChannelNotRelUsers(@Param("channelReseller") ChannelResellerQueryParam channelReseller);

	public Integer countResellerSum(@Param("channelReseller") ChannelResellerQueryParam channelReseller);

	public List<ResellerEntity> queryUserIdsByChnnelIds(@Param("list") List<Long> list);

	public List<ResellerEntity> queryCustomerFreeJoin(@Param("reseller") ResellerEntity reseller,
			@Param("page") PageEntity page);

	public Integer countQueryCustomerFreeJoin(@Param("reseller") ResellerEntity reseller);

	int countCustomerLessInfo(@Param("reseller") ResellerEntity param);

	List<ResellerEntity> selectCustomerLessInfo(@Param("reseller") ResellerEntity userParam, @Param("page") PageEntity page);

	public List<ResellerEntity> queryResellerRelMaster(@Param("reseller") ResellerEntity reseller,
			@Param("page") PageEntity page);

	public Integer countResellerRelMaster(@Param("reseller") ResellerEntity reseller);

}
