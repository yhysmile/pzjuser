package com.pzj.core.customer.write;

import com.pzj.core.customer.profile.VisitorEntity;

import java.util.List;

/**
 * Created by Administrator on 2017-2-23.
 */
public interface VisitorWriteMapper {

    VisitorEntity selectById(Long id);

    int insert(VisitorEntity visitorEntity);

    int insertBatch(List<VisitorEntity> visitorEntity);

    int update(VisitorEntity visitorEntity);

    int updateBatch(List<VisitorEntity> visitorEntity);

}
