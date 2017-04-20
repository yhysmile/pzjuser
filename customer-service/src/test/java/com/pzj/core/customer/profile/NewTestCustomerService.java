package com.pzj.core.customer.profile;

import java.io.IOException;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;

import com.pzj.framework.armyant.junit.spring.ArmyantSpringRunner;
import com.pzj.framework.context.Result;
import com.pzj.framework.converter.JSONConverter;
import com.pzj.framework.entity.QueryResult;

@RunWith(ArmyantSpringRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/spring-context.xml"
//"classpath:/spring-remote.xml" 
})
public class NewTestCustomerService {

	private final Logger logger = LoggerFactory.getLogger(NewTestCustomerService.class);

	//	static ApplicationContext context = null;
	//
	//	@BeforeClass
	//	public static void setUpClass() {
	//		context = new ClassPathXmlApplicationContext("spring-remote.xml");
	//		System.out.println(context);
	//	}
	//
	@Resource
	private CustomerService customerService;

	//
	//	@Before
	//	public void setUp() {
	//		customerService = context.getBean(CustomerService.class);
	//	}

	//	@Resource
	//	private DistributorService newUserService;
	//	@Resource
	//	private ChannelService newChannelService;
	//	@Resource
	//	private CustomerService customerService;

	//	@Test
	//	public void testQueryChannelUser() {
	//		List<Long> channelIds = new ArrayList<Long>();
	//		channelIds.add(3214733969195008L);
	//		Result<QueryChannelRelationResponse> result = newChannelService.queryChannelRelationByChannelId(channelIds);
	//		logger.info("testQueryChannelUser result:{}", JSONConverter.toJson(result));
	//	}
	//
	//	//	@Test
	//	@OneCase("/com/pzj/core/customer/profile/DistributorService/createDistributor.json")
	//	public void testBindMfSaas(@TestData CreateCustomerRequest param) {
	//		Result<Long> result = newUserService.createDistributor(param);
	//		logger.info("testBindMfSaas result:{}", JSONConverter.toJson(result));
	//	}
	//
	//	//	@Test
	//	@OneCase("/com/pzj/core/customer/profile/DistributorService/channelNotContainUser.json")
	//	public void queryChannelNotContainsUsers(@TestData ChannelResellerQueryModel requestModel) {
	//		//	public void queryChannelNotContainsUsers() {
	//		//		ChannelResellerQueryModel requestModel = new ChannelResellerQueryModel();
	//		//		requestModel.setChannelId(3632953674956800L);
	//		//		requestModel.setRootId(3180074621206529L);
	//		//		List<Long> tempRemoveResellers = new ArrayList<Long>();
	//		//		tempRemoveResellers.add(3614900952236032L);
	//		//		requestModel.setTempRemoveResellers(tempRemoveResellers);
	//		//		Date date = new Date();
	//		//		requestModel.setBindSDate(date);
	//		//		requestModel.setBindEDate(date);
	//		PageBean page = new PageBean();
	//		Result<QueryResult<QueryCustomerResponse>> result = newUserService.queryChannelNotContainDistributors(
	//				requestModel, page);
	//		logger.info("queryChannelNotContainsUsers result:{}", JSONConverter.toJson(result));
	//	}

	@Test
	public void queryMasterOfReseller() throws IOException {
		QueryCustomerRequest param = new QueryCustomerRequest();
		param.setId(2216619736763787L);
		Result<QueryResult<QueryCustomerResponse>> result = customerService.queryMasterCustomerOfDistributor(param,
				null);
		logger.info("queryMasterOfReseller result:{}", JSONConverter.toJson(result));
	}

}
