package com.pzj.core.customer.profile;

import com.pzj.framework.armyant.anno.OneCase;
import com.pzj.framework.armyant.anno.TestData;
import com.pzj.framework.armyant.junit.spring.ArmyantSpringRunner;
import com.pzj.framework.context.Result;
import com.pzj.framework.converter.JSONConverter;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 2017-2-22.
 * 基础信息test
 */
@RunWith(ArmyantSpringRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/spring-context.xml"
})
public class ProfileServiceTest {
	private final Logger logger = LoggerFactory.getLogger(ProfileServiceTest.class);

	@Resource
	private ProfileService  prfileService;


	@Test
	public void passedUser(){
		Result<Boolean> result = prfileService.passedUser(null,123456l);
		logger.info("用户审核通过返回结果:{}", JSONConverter.toJson(result));
	}

	@Test
	@OneCase("/com/pzj/core/customer/profile/ProfileService/regenPasswordBeforeFirstLogin.json")
	public void regenPasswordBeforeFirstLogin(@TestData("userId") Long userId,@TestData("operator") Long operator){
		Result<Boolean> result = prfileService.regenPasswordBeforeFirstLogin(userId, operator);

		assertNotNull(result);
		assertTrue(result.isOk());
		assertNotNull(result.getData());

		System.out.println(JSONConverter.toJson(result));
	}
}
