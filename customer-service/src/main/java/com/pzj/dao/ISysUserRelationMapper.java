/*
 * SysUserRelationMapper.java
 
 * www.piaozhijia.com
 */
package com.pzj.dao;

import java.util.List;
import java.util.Map;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.SysUserRelation;

/**
 * Mapper接口.供应商关系
 * 
 * @author 票之家
 */
@MyBatisDao
public interface ISysUserRelationMapper extends BaseRelationshipMapper<SysUserRelation> {
	List<SysUserRelation> queryAuthByParamMap(Map<String, Object> params);

	List<SysUserRelation> selectRepeat(List<SysUserRelation> params);

	List<SysUserRelation> queryUserRelationByParam(SysUserRelation sysUserRelation);

	void updateUserRelationStatus(SysUserRelation sysUserRelation);
}
