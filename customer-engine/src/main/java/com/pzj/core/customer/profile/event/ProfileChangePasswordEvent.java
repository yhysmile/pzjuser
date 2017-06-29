package com.pzj.core.customer.profile.event;

import com.pzj.core.customer.common.work.support.AbstractEvent;
import com.pzj.core.customer.operator.Modifier;

/**
 * Created by Administrator on 2017-6-12.
 */
public class ProfileChangePasswordEvent extends AbstractEvent {
    private Long profileId;

    private Long superId;

    private Modifier modifier;

    private String newPassword;

    private Boolean isRoot;

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public Modifier getModifier() {
        return modifier;
    }

    public void setModifier(Modifier modifier) {
        this.modifier = modifier;
    }

    public Long getSuperId() {
        return superId;
    }

    public void setSuperId(Long superId) {
        this.superId = superId;
    }

    public Boolean getIsRoot() {
        return isRoot;
    }

    public void setIsRoot(Boolean root) {
        isRoot = root;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
