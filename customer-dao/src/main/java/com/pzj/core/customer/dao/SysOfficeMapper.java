package com.pzj.core.customer.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.SysOffice;
import com.pzj.base.entity.SysRole;

@MyBatisDao
public interface SysOfficeMapper extends BaseUserMapper<SysOffice> {

	List<SysOffice> findByPidsMap(Map<String, String> map);

    /**
	 * 根据部门及岗位的信息查询 部门及相应岗位的信息（其中用户的的信息为null）
	 * 
	 * @param office
	 *            部门相关信息 
	 * @param role
	 * 			      岗位相关信息
	 * @return 符合条件的部门 含有岗位属性
	 */
	List<SysOffice> findByOfficeAndRole(@Param(value = "office") SysOffice office, @Param(value = "role")SysRole role);
}