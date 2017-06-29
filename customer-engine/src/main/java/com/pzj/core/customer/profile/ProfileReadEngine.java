package com.pzj.core.customer.profile;

import com.pzj.core.customer.entitys.ProfileEntity;
import com.pzj.core.customer.read.ProfileReadMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017-5-16.
 */
@Component
public class ProfileReadEngine {
    @Resource
    private ProfileReadMapper profileReadMapper;

    public Profile queryProfileById(Long id){
        if (id == null){
            return null;
        }
        ProfileEntity profileEntity = profileReadMapper.selectProfileById(id);
        return ProfileConvert.convertToProfile(profileEntity);
    }

    public List<Profile> queryProfileByIds(List<Long> ids){
        if (CollectionUtils.isEmpty(ids)){
            return null;
        }

        List<ProfileEntity> profileEntity = profileReadMapper.selectProfileByIds(ids);
        return ProfileConvert.convertToProfile(profileEntity);
    }

    /**
     * 根据登录名查询Profile
     * @param loginName
     * @return
     */
    public Profile queryProfileByLoginName(String loginName) {
        if (loginName == null){
            return null;
        }
        ProfileEntity profileEntity = profileReadMapper.selectProfileByLoginName(loginName);
        return ProfileConvert.convertToProfile(profileEntity);
    }
}
