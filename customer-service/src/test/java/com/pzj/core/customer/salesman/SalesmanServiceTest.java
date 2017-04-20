package com.pzj.core.customer.salesman;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;

import com.pzj.core.customer.profile.QueryCustomerResponse;
import com.pzj.framework.armyant.anno.OneCase;
import com.pzj.framework.armyant.anno.TestData;
import com.pzj.framework.armyant.junit.spring.ArmyantSpringRunner;
import com.pzj.framework.context.Result;
import com.pzj.framework.converter.JSONConverter;
import com.pzj.framework.entity.QueryResult;

/**
 * Created by Administrator on 2017-2-22.
 * 销售人员test
 */
@RunWith(ArmyantSpringRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/spring-context.xml" })
public class SalesmanServiceTest {
	@Resource
	private SalesmanService salesmanService;

	private final Logger logger = LoggerFactory.getLogger(SalesmanServiceTest.class);

	@Test
	public void queryAllReferee() {
		Result<QueryResult<QueryCustomerResponse>> resultResult = salesmanService.queryAllReferee(123456789l, "uj");
		logger.info("查询所有销售人员返回结果:{}", JSONConverter.toJson(resultResult));
	}

	@Test
	public void queryAvailableReferee() {
		Result<QueryResult<QueryCustomerResponse>> resultResult = salesmanService.queryAvailableReferee(123456789l,
				"销售");
		logger.info("查询可用状态销售人员返回结果:{}", JSONConverter.toJson(resultResult));
	}

	@Test
	@OneCase("/com/pzj/core/customer/salesman/SalesmanService/querySalesmansOfMaster.json")
	public void querySalesmansOfMaster(@TestData QuerySalesmanRequest param) {
		Result<QueryResult<SalesmanSummary>> result = salesmanService.querySalesmansOfMaster(param);

		assertNotNull(result);
		assertTrue(result.isOk());
		assertNotNull(result.getData());

		System.out.println(JSONConverter.toJson(result));
	}

	@Test
	@OneCase("/com/pzj/core/customer/salesman/SalesmanService/querySalesmanById.json")
	public void querySalesmanById(@TestData Long id) {
		if (id == null) {
			id = 3604243568656384L;
		}
		Result<SalesmanDetail> result = salesmanService.querySalesmanById(id);

		assertNotNull(result);
		assertTrue(result.isOk());
		assertNotNull(result.getData());

		System.out.println(JSONConverter.toJson(result));
	}

	@Test
	@OneCase("/com/pzj/core/customer/salesman/SalesmanService/createSalesman.json")
	public void createSalesman(@TestData CreateSalesmanRequest createSalesmanRequest) {
		Result<Long> result = salesmanService.createSalesman(createSalesmanRequest);
		assertNotNull(result);
		assertTrue(result.isOk());
		assertNotNull(result.getData());
		System.out.println(result.getData());
	}

	@Test
	@OneCase("/com/pzj/core/customer/salesman/SalesmanService/modifySalesman.json")
	public void modifySalesman(@TestData ModifySalesmanRequest modifySalesmanRequest) {
		Result<Boolean> result = salesmanService.modifySalesman(modifySalesmanRequest);
		assertNotNull(result);
		assertTrue(result.isOk());
		assertNotNull(result.getData());
	}
}
