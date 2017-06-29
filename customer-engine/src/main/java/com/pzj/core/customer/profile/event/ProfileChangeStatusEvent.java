package com.pzj.core.customer.profile.event;

import com.pzj.core.customer.common.work.support.AbstractEvent;
import com.pzj.core.customer.operator.Modifier;
import com.pzj.core.customer.profile.ProfileStatus;

/**
 * Created by Administrator on 2017-6-12.
 */
public class ProfileChangeStatusEvent extends AbstractEvent {
    private Long profileId;
    private ProfileStatus oldStatus;
    private ProfileStatus newStatus;
    private Modifier modifier;

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public ProfileStatus getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(ProfileStatus oldStatus) {
        this.oldStatus = oldStatus;
    }

    public ProfileStatus getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(ProfileStatus newStatus) {
        this.newStatus = newStatus;
    }

    public Modifier getModifier() {
        return modifier;
    }

    public void setModifier(Modifier modifier) {
        this.modifier = modifier;
    }
}
