package com.pzj.core.customer.write;

import com.pzj.core.customer.profile.ResellerEntity;
import org.apache.ibatis.annotations.Param;

public interface CustomerWriteMapper {
	ResellerEntity selectById(@Param("id") Long id);
	Long insertDistributor(ResellerEntity reseller);

	ResellerEntity queryUserByName(String loginName);

	ResellerEntity queryUserBaseInfoById(Long id);
}
