/*
 * SysUserRelationService.java
 
 * www.piaozhijia.com
 */
package com.pzj.base.service.sys;

import java.util.List;

import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysUserRelation;
import com.pzj.framework.context.Result;

/**
 * @Description:service接口.供应商关系
 * @author: 票之家
 */
// public interface ISysUserRelationService extends
// BaseService<SysUserRelation,ISysUserRelationMapper>{
// }
public interface ISysUserRelationService extends IBaseRelationshipService<SysUserRelation> {
	PageList<SysUserRelation> queryAuthPageByParamMap(PageModel pager, SysUserRelation entity);

	Long createNoRepeat(SysUserRelation entity);

	Result<Boolean> createBatchNoRepeat(List<SysUserRelation> entityList);

	List<SysUserRelation> queryUserRelations(SysUserRelation sysUserRelation);

	void updateUserStatusById(SysUserRelation sysUserRelation);
}
