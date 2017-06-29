package com.pzj.core.customer.profile.listener;

import com.pzj.base.common.global.PasswordGenerateUtil;
import com.pzj.core.customer.common.work.Event;
import com.pzj.core.customer.common.work.EventListener;
import com.pzj.core.customer.operator.Modifier;
import com.pzj.core.customer.profile.Profile;
import com.pzj.core.customer.profile.ProfileReadEngine;
import com.pzj.core.customer.profile.ProfileStatus;
import com.pzj.core.customer.profile.event.ProfileChangePasswordEvent;
import com.pzj.core.customer.profile.event.ProfileChangeStatusEvent;
import com.pzj.core.customer.profile.mq.CustomerMqMessage;
import com.pzj.core.customer.profile.mq.ModifyCustomer;
import com.pzj.core.customer.utils.UserConfig;
import com.pzj.core.smp.delivery.IShortMessageService;
import com.pzj.core.smp.delivery.MessageBean;
import com.pzj.core.smp.delivery.MessageHead;
import com.pzj.framework.context.Result;
import com.pzj.framework.converter.JSONConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * Created by Administrator on 2017-6-12.
 */
public class ProfileEventListener implements EventListener {
    private static final Logger logger = LoggerFactory.getLogger(ProfileEventListener.class);

    @Resource
    private CustomerMqMessage customerMqMessage;
    @Resource
    private ProfileReadEngine profileReadEngine;
    @Resource
    private UserConfig userConfig;
    @Resource
    private IShortMessageService shortMessageService;

    @Override
    public void handleEvent(Event event) {
        if (event instanceof ProfileChangeStatusEvent){
            handleProfileChangeStatusEvent((ProfileChangeStatusEvent)event);
        } else if (event instanceof ProfileChangePasswordEvent) {
            handleProfileChangePasswordEvent((ProfileChangePasswordEvent)event);
        }
    }

    private void handleProfileChangeStatusEvent(ProfileChangeStatusEvent event){
        Long profileId = event.getProfileId();
        ProfileStatus oldStatus = event.getOldStatus();
        ProfileStatus newStatus = event.getNewStatus();
        Modifier modifier = event.getModifier();

        ModifyCustomer modifyCustomer = new ModifyCustomer(profileId, oldStatus.getValue(), newStatus.getValue(), modifier.modifyUserId(), modifier.modifyDate());
        customerMqMessage.sendCustomerStateMsg(modifyCustomer);
    }

    private void handleProfileChangePasswordEvent(ProfileChangePasswordEvent event){
        Long profileId = event.getProfileId();
        Long superId = event.getSuperId();
        String newPassword = event.getNewPassword();

        Profile selfProfile = profileReadEngine.queryProfileById(profileId);
        Profile superProfile = selfProfile;
        if (!superId.equals(profileId)) {
            superProfile = profileReadEngine.queryProfileById(superId);
        }

        String name = superProfile.getName();
        if (name == null) {
            name = superProfile.getContacts();
        }

        String message = PasswordGenerateUtil.passwordNoticeMessage(name, selfProfile.username(), newPassword, userConfig.getAppDownload());

        handleProfileChangePasswordEvent_sendSms(selfProfile.getPhoneNum(), message);
    }

    private void handleProfileChangePasswordEvent_sendSms(String phoneNum, String message){
        MessageHead messageHead = new MessageHead("customer:password_inform", "A", 3000L);
        MessageBean messageBean = new MessageBean();
        messageBean.setPhoneNums(Arrays.asList(phoneNum));
        messageBean.setContent(message);

        messageBean.setHead(messageHead);

        Result<Boolean> result = shortMessageService.sendMessage(messageBean);

        if (!result.isOk()) {
            logger.error("密码重新生成后，发送短信失败，参数为 {}，结果为：{}", JSONConverter.toJson(messageBean),  JSONConverter.toJson(result));
        }
    }
}
