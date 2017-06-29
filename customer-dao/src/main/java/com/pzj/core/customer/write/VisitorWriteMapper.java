package com.pzj.core.customer.write;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.core.customer.entitys.VisitorEntity;

import java.util.List;

/**
 * Created by Administrator on 2017-2-23.
 */
@MyBatisDao
public interface VisitorWriteMapper {

    VisitorEntity selectById(Long id);

    int insert(VisitorEntity visitorEntity);

    int insertBatch(List<VisitorEntity> visitorEntity);

    int update(VisitorEntity visitorEntity);

    int updateBatch(List<VisitorEntity> visitorEntity);

}
