package com.pzj.dao;

import java.util.List;
import java.util.Map;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.SysLabel;
import com.pzj.base.entity.SysLabelRelationKey;

@MyBatisDao
public interface SysLabelMapper extends BaseUserMapper<SysLabel> {

    List<SysLabel> findLabelListByObjID(Map<String, Object> params);

    int countLabelByObjID(Map<String, Object> params);

    List<SysLabel> findLabelListByRefID(Map<String, Object> params);

    int countLabelByRefID(Map<String, Object> params);

    List<SysLabel> selectByRelation(SysLabelRelationKey params);
}
