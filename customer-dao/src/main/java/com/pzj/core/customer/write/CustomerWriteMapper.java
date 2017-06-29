package com.pzj.core.customer.write;

import org.apache.ibatis.annotations.Param;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.core.customer.entitys.CustomerEntity;

@MyBatisDao
public interface CustomerWriteMapper {
	CustomerEntity selectById(@Param("id") Long id);

	Long insertDistributor(CustomerEntity reseller);

	CustomerEntity selectUserBaseInfoById(Long id);

	CustomerEntity selectUserByName(String loginName);

	CustomerEntity selectUserBaseByInviteCode(String inviteCode);
}
