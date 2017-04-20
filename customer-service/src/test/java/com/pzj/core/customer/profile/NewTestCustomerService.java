package com.pzj.core.customer.profile;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pzj.core.customer.commons.ChannelResellerQueryModel;
import com.pzj.framework.armyant.anno.OneCase;
import com.pzj.framework.armyant.anno.TestData;
import com.pzj.framework.context.Result;
import com.pzj.framework.converter.JSONConverter;
import com.pzj.framework.entity.QueryResult;

//@RunWith(ArmyantSpringRunner.class)
public class NewTestCustomerService {

	private final Logger logger = LoggerFactory.getLogger(NewTestCustomerService.class);

	static ApplicationContext context = null;

	@BeforeClass
	public static void setUpClass() {
		context = new ClassPathXmlApplicationContext("applicationContext-test.xml");
		System.out.println(context);
	}

	private DistributorService newUserService;

	@Before
	public void setUp() {
		newUserService = context.getBean(DistributorService.class);
	}

	@Test
	@OneCase("/com/pzj/core/customer/profile/DistributorService/channelNotContainUser.json")
	public void queryChannelNotContainsUsers(@TestData ChannelResellerQueryModel requestModel) {
		//	public void queryChannelNotContainsUsers() {
		//		ChannelResellerQueryModel requestModel = new ChannelResellerQueryModel();
		//		requestModel.setChannelId(3632953674956800L);
		//		requestModel.setRootId(3180074621206529L);
		//		List<Long> tempRemoveResellers = new ArrayList<Long>();
		//		tempRemoveResellers.add(3614900952236032L);
		//		requestModel.setTempRemoveResellers(tempRemoveResellers);
		//		Date date = new Date();
		//		requestModel.setBindSDate(date);
		//		requestModel.setBindEDate(date);
		PageBean page = new PageBean();
		Result<QueryResult<QueryCustomerResponse>> result = newUserService.queryChannelNotContainDistributors(
				requestModel, page);
		logger.info("queryChannelNotContainsUsers result:{}", JSONConverter.toJson(result));
	}
}
