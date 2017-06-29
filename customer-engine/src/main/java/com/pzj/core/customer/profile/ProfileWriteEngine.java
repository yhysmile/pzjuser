package com.pzj.core.customer.profile;

import com.pzj.base.common.global.PasswordGenerateUtil;
import com.pzj.core.customer.common.exception.CustomerException;
import com.pzj.core.customer.common.exception.CustomerExceptionCode;
import com.pzj.core.customer.common.work.support.ThreadUnitOfWork;
import com.pzj.core.customer.entitys.ProfileEntity;
import com.pzj.core.customer.operator.Modifier;
import com.pzj.core.customer.profile.event.ProfileChangePasswordEvent;
import com.pzj.core.customer.profile.event.ProfileChangeStatusEvent;
import com.pzj.core.customer.write.ProfileWriteMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017-5-16.
 */
@Component
public class ProfileWriteEngine {
    @Resource
    private ProfileWriteMapper profileWriteMapper;

    /**
     * 根据id查询Profile
     * @param id
     * @return
     */
    public Profile findProfileById(Long id){
        if (id == null){
            return null;
        }
        ProfileEntity profileEntity = profileWriteMapper.selectProfileById(id);
        return ProfileConvert.convertToProfile(profileEntity);
    }

    public List<Profile> findProfileByIds(List<Long> ids){
        if (CollectionUtils.isEmpty(ids)){
            return null;
        }
        List<ProfileEntity> profileEntity = profileWriteMapper.selectProfileByIds(ids);
        return ProfileConvert.convertToProfile(profileEntity);
    }

    /**
     * 内容使用，更新Profile
     * @param profile
     * @return
     */
    private int modifyProfile(Profile profile, Modifier modifier){
        if (profile == null || modifier == null){
            return 0;
        }

        ProfileEntity profileEntity = ProfileConvert.convertToProfileEntity(profile, modifier);
        return profileWriteMapper.updateProfile(profileEntity);
    }

    public boolean enableCustomer(Long id, Modifier modifier){
        return modifyCustomerAccountState(id, modifier.modifyUserId(), ProfileStatus.Enable);
    }

    public boolean disableCustomer(Long id, Modifier modifier){
        return modifyCustomerAccountState(id, modifier.modifyUserId(), ProfileStatus.Disable);
    }

    private boolean modifyCustomerAccountState(Long id, Long operator, ProfileStatus newState) {
        if (id == null){
            throw new CustomerException(CustomerExceptionCode.PROFILE_NULL_ID);
        }
        if (operator == null){
            throw new CustomerException(CustomerExceptionCode.OPERATOR_ID_NULL);
        }
        if (newState == null){
            throw new CustomerException(CustomerExceptionCode.STATUS_NULL);
        }

        Profile profile = findProfileById(id);

        if (profile == null){
            throw new CustomerException(CustomerExceptionCode.PROFILE_NOT_EXIST);
        }

        if (profile.status().equals(newState)) {
            return false;
        }

        Profile modifyProfile = new Profile(profile.id());
        modifyProfile.changeStatusTo(newState);

        Modifier modifier = new Modifier(operator);

        int modify = modifyProfile(modifyProfile, modifier);

        if (modify == 1){
            ProfileChangeStatusEvent event = new ProfileChangeStatusEvent();
            event.setProfileId(id);
            event.setOldStatus(profile.status());
            event.setNewStatus(modifyProfile.status());
            event.setModifier(modifier);

            ThreadUnitOfWork unitOfWork = ThreadUnitOfWork.getOrCreateThreadUnitOfWork();
            unitOfWork.addEvent(event);

            return true;
        }

        return false;
    }

    private boolean doModifyProfile(Profile profile, Modifier modifier){
        if (profile == null){
            return false;
        }
        ProfileEntity profileEntity = ProfileConvert.convertToProfileEntity(profile, modifier);
        int update = profileWriteMapper.updateProfile(profileEntity);
        return update == 1;
    }

    public boolean regenPasswordBeforeFirstLogin(Long profileId, Modifier modifier){
        Profile profile = findProfileById(profileId);

        if (profile.lastLoginDate() != null) {
            return false;
        }

        String password = PasswordGenerateUtil.generate6BitPassword();
        String passwordMd5 = PasswordGenerateUtil.generatePassword(profileId, profile.username(), password);

        Profile modifyProfile = new Profile(profile.id());
        modifyProfile.changePassword(passwordMd5);

        boolean modify = doModifyProfile(modifyProfile, modifier);

        if (modify){
            ProfileChangePasswordEvent event = new ProfileChangePasswordEvent();
            event.setProfileId(profile.id());
            event.setSuperId(profile.superId());
            event.setIsRoot(profile.getIsRoot());
            event.setNewPassword(password);
            event.setModifier(modifier);

            ThreadUnitOfWork unitOfWork = ThreadUnitOfWork.getOrCreateThreadUnitOfWork();
            unitOfWork.addEvent(event);
            return true;
        }
        return false;
    }
}
