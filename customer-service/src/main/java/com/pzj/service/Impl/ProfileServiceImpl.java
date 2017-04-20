package com.pzj.service.Impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.pzj.core.customer.common.exception.CustomerException;
import com.pzj.framework.converter.JSONConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.common.global.PasswordGenerateUtil;
import com.pzj.base.common.global.UserGlobalDict;
import com.pzj.base.entity.SysUser;
import com.pzj.core.customer.common.exception.CustomerExceptionCode;
import com.pzj.core.customer.profile.ProfileService;
import com.pzj.core.customer.utils.UserConfig;
import com.pzj.core.smp.delivery.IShortMessageService;
import com.pzj.core.smp.delivery.MessageBean;
import com.pzj.core.smp.delivery.MessageHead;
import com.pzj.framework.context.Result;

/**
 * Created by Administrator on 2017-2-17.
 */
@Service("prfileService")
public class ProfileServiceImpl implements ProfileService {
	private static final Logger logger = LoggerFactory.getLogger(ProfileService.class);
	@Resource
	private UserServiceImpl userService;

	@Resource(name = "userConfig")
	private UserConfig userConfig;

	@Resource
	private IShortMessageService shortMessageService;

	@Override
	public Result<Boolean> enableCustomer(final Long id, final Long operator) {
		return RpcCaller.call(new RpcCaller<Boolean>() {

			@Override
			public Boolean call() {
				return modifyCustomerAccoutState(id, operator, GlobalParam.FLAG.off(), GlobalParam.FLAG.start());
			}
		});
	}

	private Boolean modifyCustomerAccoutState(Long id, Long operator, Integer state1, Integer state2) {
		SysUser sysUser = userService.getById(id);
		if (sysUser == null || sysUser.getAccountState() != state1) {
			return false;
		}

		SysUser user = new SysUser();
		user.setId(id);
		user.setAccountState(state2);

		Integer update = userService.updateByPrimaryKey(user);
		if (update == 1)
			return true;

		return false;
	}

	@Override
	public Result<Boolean> disableCustomer(final Long id, final Long operator) {
		return RpcCaller.call(new RpcCaller<Boolean>() {

			@Override
			public Boolean call() {
				return modifyCustomerAccoutState(id, operator, GlobalParam.FLAG.start(), GlobalParam.FLAG.off());
			}
		});
	}

	@Override
	public Result<SysUser> queryCustomerByLoginName(final String loginName) {
		return RpcCaller.call(new RpcCaller<SysUser>() {
			@Override
			public SysUser call() {
				SysUser userParam = new SysUser();
				userParam.setLoginName(loginName);
				List<SysUser> userList = userService.findListByParams(userParam);
				if (userList != null && userList.size() == 1) {
					SysUser user = userList.get(0);
					return user;
				}
				return null;
			}
		});
	}

	@Override
	public Result<Boolean> regenPasswordBeforeFirstLogin(final Long userId, final Long operator) {
		return RpcCaller.call(new RpcCaller<Boolean>() {

			@Override
			public Boolean call() {
				SysUser sysUser = userService.getById(userId);
				if (sysUser.getLastLoginTime() != null) {
					return false;
				}

				String password = PasswordGenerateUtil.generate6BitPassword();
				String passwordMd5 = PasswordGenerateUtil.generatePassword(userId, sysUser.getLoginName(), password);

				SysUser updatePasswdUser = new SysUser();
				updatePasswdUser.setId(sysUser.getId());
				updatePasswdUser.setLoginPasswd(passwordMd5);
				updatePasswdUser.setUpdateBy(operator.toString());
				updatePasswdUser.setUpdateDate(new Date());

				Integer update = userService.updateByPrimaryKey(updatePasswdUser);
				if (update == 1) {
					SysUser supplier = sysUser;
					if (!sysUser.getId().equals(sysUser.getSupplierId())) {
						supplier = userService.getById(sysUser.getSupplierId());
					}

					String name = supplier.getName();
					if (name == null) {
						name = supplier.getCorporater();
					}

					String message = PasswordGenerateUtil.passwordNoticeMessage(name, sysUser.getLoginName(), password,
							userConfig.getAppDownload());

					sendPasswordToSM(sysUser.getCorporaterMobile(), message);

					return true;
				}

				return false;
			}
		});
	}

	/**
	 * 给手机号发送短信
	 */
	private void sendPasswordToSM(String phoneNum, String message) {
		MessageHead messageHead = new MessageHead("customer:password_inform", "A", 3000L);

		MessageBean messageBean = new MessageBean();
		messageBean.setPhoneNums(Arrays.asList(phoneNum));
		messageBean.setContent(message);

		messageBean.setHead(messageHead);

		Result<Boolean> result = shortMessageService.sendMessage(messageBean);

		if (!result.isOk()){
			logger.error("密码重新生成时，短信改善失败：{}", JSONConverter.toJson(result));
		}
	}

	@Override
	public Result<Boolean> passedUser(Long customerId, Long operId) {

		if (customerId == null || customerId < 1 || operId == null || operId < 1) {
			logger.error("参数为空,customerId: {}", customerId);
			Result<Boolean> booleanResult = new Result<>(CustomerExceptionCode.PARAMETER_EMPTY.getCode(),
					CustomerExceptionCode.PARAMETER_EMPTY.getMsg());
			booleanResult.setData(false);
			return booleanResult;
		}
		return userService.checkUserPass(customerId, operId);
	}
}
