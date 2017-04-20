package com.pzj.core.customer.dao;

import java.util.List;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.SysLabelRelationKey;
import org.apache.ibatis.annotations.Param;

@MyBatisDao
public interface SysLabelRelationMapper extends BaseRelationshipMapper<SysLabelRelationKey> {
	/**
	 * <h3>查询标签与其它数据的关联关系，并查询标签信息</h3>
	 * <p>
	 * 参数中需要指定objId和relType，根据这两个属性查询，返回标签关联关系的集合，每个关系对象的labels中有标签信息。
	 * </p>
	 * 
	 * @param key
	 */
	public List<SysLabelRelationKey> selectLabelByRelation(SysLabelRelationKey key);

	Integer updateStatusByIds(@Param(value = "status")Integer status,@Param(value = "ids")List<Long> ids,@Param(value = "updateBy") Long updateBy);
}
