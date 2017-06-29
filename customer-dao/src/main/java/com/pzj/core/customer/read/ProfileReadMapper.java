package com.pzj.core.customer.read;

import com.pzj.core.customer.entitys.ProfileEntity;

import java.util.List;

/**
 * Created by Administrator on 2017-5-16.
 */
public interface ProfileReadMapper {
    ProfileEntity selectProfileById(Long id);

    List<ProfileEntity> selectProfileByIds(List<Long> ids);

    ProfileEntity selectProfileByLoginName(String loginName);
}
