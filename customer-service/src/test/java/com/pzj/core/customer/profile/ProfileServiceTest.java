package com.pzj.core.customer.profile;

import com.pzj.base.entity.SysUser;
import com.pzj.framework.armyant.anno.OneCase;
import com.pzj.framework.armyant.anno.TestData;
import com.pzj.framework.armyant.junit.spring.ArmyantSpringRunner;
import com.pzj.framework.context.Result;
import com.pzj.framework.converter.JSONConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 2017-2-22.
 * 基础信息test
 */
@RunWith(ArmyantSpringRunner.class)
@ContextConfiguration(locations = {
		"classpath:/spring-local.xml"
})
public class ProfileServiceTest {
	private final Logger logger = LoggerFactory.getLogger(ProfileServiceTest.class);

	@Resource
	private ProfileService profileService;

	@Test
	@OneCase("/com/pzj/core/customer/profile/ProfileService/queryCustomerByLoginName.json")
	public void queryCustomerByLoginName(@TestData String loginName){
		Result<SysUser> result = profileService.queryCustomerByLoginName(loginName);

		assertNotNull(result);
		System.out.println(JSONConverter.toJson(result));
	}

	@Test
	public void passedUser(){
		Result<Boolean> result = profileService.passedUser(null,123456l);
		logger.info("用户审核通过返回结果:{}", JSONConverter.toJson(result));
	}

	@Test
	@OneCase("/com/pzj/core/customer/profile/ProfileService/regenPasswordBeforeFirstLogin.json")
	public void regenPasswordBeforeFirstLogin(@TestData("userId") Long userId,@TestData("operator") Long operator) throws IOException {
		Result<Boolean> result = profileService.regenPasswordBeforeFirstLogin(userId, operator);

		assertNotNull(result);
		assertTrue(result.isOk());
		assertNotNull(result.getData());

		System.out.println(JSONConverter.toJson(result));
		System.in.read();
	}

	@Test
	@OneCase("/com/pzj/core/customer/profile/ProfileService/queryActivateProfileBasicInfoById.json")
	public void queryActivateProfileBasicInfoById(@TestData() Long id){
		Result<ProfileBasicInfo> result = profileService.queryActivateProfileBasicInfoById(id);

		assertNotNull(result);
		assertTrue(result.isOk());
		assertNotNull(result.getData());

		System.out.println(JSONConverter.toJson(result));
	}
}
