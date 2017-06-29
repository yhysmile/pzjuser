package com.pzj.core.customer.profile;

import com.pzj.base.entity.SysUser;
import com.pzj.core.customer.common.exception.CustomerExceptionCode;
import com.pzj.core.customer.operator.Modifier;
import com.pzj.framework.context.Result;
import com.pzj.service.Impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by Administrator on 2017-2-17.
 */
@Service("profileService")
public class ProfileServiceImpl implements ProfileService {
	private static final Logger logger = LoggerFactory.getLogger(ProfileService.class);
	@Resource
	private UserServiceImpl userService;
	@Resource
	private ProfileReadEngine profileReadEngine;
	@Resource
	private ProfileWriteEngine profileWriteEngine;

	@Override
	public Result<Boolean> enableCustomer(Long id, Long operator) {
		Modifier modifier = new Modifier(operator);
		boolean enable = profileWriteEngine.enableCustomer(id, modifier);
		return new Result<>(enable);
	}

	@Override
	public Result<Boolean> disableCustomer(final Long id, final Long operator) {
		Modifier modifier = new Modifier(operator);
		boolean disable = profileWriteEngine.disableCustomer(id, modifier);
		return new Result<>(disable);
	}

	@Override
	public Result<SysUser> queryCustomerByLoginName(final String loginName) {
		Profile profile = profileReadEngine.queryProfileByLoginName(loginName);
		if (profile != null && profile.status() == ProfileStatus.Enable){
			SysUser sysUser = ProfileModelConvert.convertToSysUser(profile);
			return new Result<>(sysUser);
		}
		return null;
	}

	@Override
	public Result<Boolean> regenPasswordBeforeFirstLogin(Long profileId, Long operator) {
		Modifier modifier = new Modifier(operator, new Date());
		boolean regen = profileWriteEngine.regenPasswordBeforeFirstLogin(profileId, modifier);
		return new Result<>(regen);
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

	@Override
	public Result<ProfileBasicInfo> queryActivateProfileBasicInfoById(final Long id) {
		Profile profile = profileReadEngine.queryProfileById(id);

		if (profile != null && ProfileStatus.Enable == profile.status()){
			ProfileBasicInfo profileBasicInfo = ProfileModelConvert.convertToProfileBasicInfo(profile);
			return new Result<>(profileBasicInfo);
		}
		return null;
	}
}
