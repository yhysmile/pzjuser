package com.pzj.core.customer.write;

import org.apache.ibatis.annotations.Param;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.core.customer.profile.ResellerEntity;

@MyBatisDao
public interface CustomerWriteMapper {
	ResellerEntity selectById(@Param("id") Long id);

	Long insertDistributor(ResellerEntity reseller);

	ResellerEntity queryUserBaseInfoById(Long id);

	ResellerEntity queryUserByName(String loginName);

	ResellerEntity queryUserBaseByInviteCode(String inviteCode);
}
