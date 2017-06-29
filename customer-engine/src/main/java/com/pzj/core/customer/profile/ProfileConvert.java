package com.pzj.core.customer.profile;

import com.pzj.core.customer.entitys.ProfileEntity;
import com.pzj.core.customer.operator.Modifier;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-5-16.
 */
public class ProfileConvert {

    public static Profile convertToProfile(ProfileEntity profileEntity) {
        if (profileEntity == null){
            return null;
        }

        Profile profile = new Profile(profileEntity.getId());
        profile.setSuperId(profileEntity.getSuperId());
        profile.setType(ProfileType.valueOf(profileEntity.getType()));
        profile.changeStatusTo(ProfileStatus.valueOf(profileEntity.getStatus()));
        profile.setName(profileEntity.getName());
        profile.setUsername(profileEntity.getUsername());
        profile.setContacts(profileEntity.getContacts());
        profile.setPhoneNum(profileEntity.getPhoneNum());
        profile.setIsRoot(profileEntity.getIsRoot());
        return profile;
    }

    public static List<Profile> convertToProfile(List<ProfileEntity> profileEntitys) {
        if (profileEntitys == null || profileEntitys.isEmpty()){
            return null;
        }

        List<Profile> profiles = new ArrayList<>(profileEntitys.size());
        for (ProfileEntity profileEntity : profileEntitys){
            profiles.add(convertToProfile(profileEntity));
        }
        return profiles;
    }

    public static ProfileEntity convertToProfileEntity(Profile profile, Modifier modifier) {
        if (profile == null){
            return null;
        }

        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setId(profile.id());
        profileEntity.setSuperId(profile.superId());
        if (profile.getType() != null) {
            profileEntity.setType(profile.getType().getValue());
        }
        if (profile.status() != null) {
            profileEntity.setStatus(profile.status().getValue());
        }
        profileEntity.setName(profile.getName());
        profileEntity.setUsername(profile.username());
        profileEntity.setContacts(profile.getContacts());
        profileEntity.setPhoneNum(profile.getPhoneNum());
        profileEntity.setIsRoot(profile.getIsRoot());
        profileEntity.setPassword(profile.password());

        if (modifier != null){
            profileEntity.setModifyUserId(modifier.modifyUserId());
            profileEntity.setModifyDate(modifier.modifyDate());
        }

        return profileEntity;
    }

    public static List<ProfileEntity> convertToProfileEntity(List<Profile> profiles, Modifier modifier) {
        if (profiles == null || profiles.isEmpty()){
            return null;
        }

        List<ProfileEntity> profileEntities = new ArrayList<>(profiles.size());

        for (Profile profile : profiles){
            profileEntities.add(convertToProfileEntity(profile, modifier));
        }

        return profileEntities;
    }
}
