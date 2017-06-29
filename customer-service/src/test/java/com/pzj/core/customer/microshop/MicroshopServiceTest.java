package com.pzj.core.customer.microshop;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import com.pzj.framework.armyant.anno.OneCase;
import com.pzj.framework.armyant.anno.TestData;
import com.pzj.framework.armyant.junit.spring.ArmyantSpringRunner;
import com.pzj.framework.context.Result;
import com.pzj.framework.converter.JSONConverter;

@RunWith(ArmyantSpringRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-local.xml" })
public class MicroshopServiceTest {
	@Resource
	private MicroshopService microshopService;

	@Test
	@OneCase("/com/pzj/core/customer/microshop/MicroshopService/modifyMicroshop.json")
	public void modifyMicroshop(@TestData("microshopId") Long microshopId,
			@TestData("microshopContent") MicroshopContent microshopContent, @TestData("modifierId") Long modifierId)
			throws IOException {
		Result<Boolean> result = microshopService.modifyMicroshop(microshopId, microshopContent, modifierId);

		assertNotNull(result);
		System.out.println(JSONConverter.toJson(result));
		assertTrue(result.isOk());

		System.in.read();
	}

	@Test
	@OneCase("/com/pzj/core/customer/microshop/MicroshopService/createDefaultMicroshopt.json")
	public void createDefaultMicroshopt(@TestData("masterId") Long masterId,
								@TestData("defaultPhoneNum") String defaultPhoneNum,
								@TestData("creatorId") Long creatorId)
			throws IOException {
		Result<Boolean> result = microshopService.createDefaultMicroshopt(masterId, defaultPhoneNum, creatorId);

		assertNotNull(result);
		System.out.println(JSONConverter.toJson(result));
		assertTrue(result.isOk());

		System.in.read();
	}

	@Test
	@OneCase("/com/pzj/core/customer/microshop/MicroshopService/queryMicroshopByMasterId.json")
	public void queryMicroshopByMasterId(@TestData Long masterId){
		Result<MicroshopInfo> result = microshopService.queryMicroshopByMasterId(masterId);
		assertNotNull(result);
		System.out.println(JSONConverter.toJson(result));
		assertTrue(result.isOk());
	}
}
