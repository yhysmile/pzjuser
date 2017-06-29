package com.pzj.core.customer.write;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.core.customer.entitys.ProfileEntity;

import java.util.List;

/**
 * Created by Administrator on 2017-5-16.
 */
@MyBatisDao
public interface ProfileWriteMapper {
    ProfileEntity selectProfileById(Long id);

    List<ProfileEntity> selectProfileByIds(List<Long> ids);

    int updateProfile(ProfileEntity profileEntity);
}
