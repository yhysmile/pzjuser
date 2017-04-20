package com.pzj.core.customer.visitor;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;

import com.pzj.core.customer.commons.PageBean;
import com.pzj.framework.armyant.anno.OneCase;
import com.pzj.framework.armyant.anno.TestData;
import com.pzj.framework.armyant.junit.spring.ArmyantSpringRunner;
import com.pzj.framework.context.Result;
import com.pzj.framework.converter.JSONConverter;
import com.pzj.framework.entity.QueryResult;

/**
 * Created by Administrator on 2017-2-24.
 */
@RunWith(ArmyantSpringRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/spring-context.xml" })
public class VisitorServiceTest {
	private final Logger logger = LoggerFactory.getLogger(VisitorServiceTest.class);
	@Resource
	VisitorService visitorService;

	@Test
	@OneCase("/com/pzj/core/customer/profile/VisitorService/queryVisitor.json")
	public void queryVisitorByPage(@TestData QueryVisitorRequest queryVisitorRequest, PageBean page) {
		Result<QueryResult<QueryVisitorSummaryResponse>> result = visitorService.queryVisitorSummaryByPage(
				queryVisitorRequest, page);
		logger.info("queryVisitorByPage result :{}", JSONConverter.toJson(result));
		assertNotNull(result);

	}

	@Test
	public void queryVisitorByNameMobile() {
		String nameMobile = "789";
		Result<ArrayList<QueryVisitorSummaryResponse>> result = visitorService.queryVisitorSummaryByNameMobile(
				nameMobile, 0l);

	}

	//	@Test
	public void queryVisitorDetail() {
		Long id = 3593655469735936L;
		Result<QueryVisitorDetailResponse> result = visitorService.queryVisitorDetailById(id);

	}

	//	@Test
	@OneCase("/com/pzj/core/customer/visitor/VisitorService/createVisitor.json")
	public void createVisitor(@TestData CreateVisitorRequest createVisitorRequest) {
		Result<Long> result = visitorService.createVisitor(createVisitorRequest);

		assertNotNull(result);
		assertTrue(result.isOk());
		assertNotNull(result.getData());
	}

	//	@Test
	@OneCase("/com/pzj/core/customer/visitor/VisitorService/modifyVisitor.json")
	public void modifyVisitor(@TestData ModifyVisitorRequest modifyVisitorRequest) {
		Result<Boolean> result = visitorService.modifyVisitor(modifyVisitorRequest);

		assertNotNull(result);
		assertTrue(result.isOk());
		assertTrue(result.getData());
	}

	//	@Test
	@OneCase("/com/pzj/core/customer/visitor/VisitorService/deleteVisitor.json")
	public void deleteVisitor(@TestData("visitorId") Long visitorId, @TestData("operator") Long operator) {
		Result<Boolean> result = visitorService.deleteVisitor(visitorId, operator);

		assertNotNull(result);
		assertTrue(result.isOk());
		assertTrue(result.getData());
	}
}
