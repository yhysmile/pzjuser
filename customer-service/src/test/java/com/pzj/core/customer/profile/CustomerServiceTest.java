package com.pzj.core.customer.profile;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;

import com.pzj.core.customer.commons.ChannelResellerQueryModel;
import com.pzj.framework.armyant.anno.OneCase;
import com.pzj.framework.armyant.anno.TestData;
import com.pzj.framework.armyant.junit.spring.ArmyantSpringRunner;
import com.pzj.framework.context.Result;
import com.pzj.framework.converter.JSONConverter;
import com.pzj.framework.entity.QueryResult;
import com.pzj.core.customer.commons.PageBean;

@RunWith(ArmyantSpringRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-local.xml"})
public class CustomerServiceTest {
	private final Logger logger = LoggerFactory.getLogger(CustomerServiceTest.class);

	@Resource
	private DistributorService resellerService;
	@Resource
	private CustomerService customerService;

	@Test
	public void testQueryResellerPage() throws ParseException {
		//"nameOrNormal":"打发掉","supplierId":2216619741563734
		//{"bindDateBegin":1488384000000,"bindDateEnd":1488643199000,"supplierId":2216619741564532}
		//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//
		//		Date bindDateBegin = simpleDateFormat.parse("2017-03-03 18:30:39");
		//		Date bindDateEnd = simpleDateFormat.parse("2017-03-03 18:35:39");

		Date bindDateBegin = new Date(1489075200000L);
		Date bindDateEnd = new Date(1489161599000L);
		QueryCustomerRequest param = new QueryCustomerRequest();
		param.setSupplierId(2216619741564532L);
		param.setRefereeId(3673390697676801L);
		//		param.setName("8");
		//		param.setCity("成都市");
		//		param.setProvince("四川省");
		//		param.setProvince("");
		//		param.setBindDateBegin(bindDateBegin);
		//		param.setBindDateEnd(bindDateEnd);

		PageBean page = new PageBean(1, 20);
		//		param.setName("测试");
		//		param.setLoginName("1234567ly");
		Result<QueryResult<QueryCustomerResponse>> result = resellerService.queryDistributorsOfMaster(param, page);
		logger.info("testQueryResellerPage result:{}", JSONConverter.toJson(result));

		if (result.isOk() && result.getData() != null) {
			printResellerBaseInfo(result.getData().getRecords());
		}
	}

	@Test
	@OneCase("/com/pzj/core/customer/profile/DistributorService/createDistributor.json")
	public void testCreateReseller(@TestData CreateCustomerRequest param) {
		Result<Long> result = resellerService.createDistributor(param);
		logger.info("testCreateReseller result:{}", JSONConverter.toJson(result));
	}

	//	@Test
	public void checkUserMobile() {
		String name = "abcdefg";
		String phone = "1239998784";
		Result<Long> result = resellerService.checkUserNameMobileMate(name, phone);
		logger.info("checkUserMobile result:{}", JSONConverter.toJson(result));

		System.out.println("=======================" + JSONConverter.toJson(result));
	}

	@Test
	public void bindDirectReseller() {
		//{"operateId":2216619741564532,"resellerId":3632399036973056,"supplierId":2216619741564532}
		BindCustomerRequest param = new BindCustomerRequest();
		param.setResellerId(3632399036973056L);
		param.setOperateId(3904030217076737L);
		param.setSupplierId(3904030217076737L);
		Result<Long> result = resellerService.bindDirectDistributor(param);

		logger.info("bindDirectReseller result:{}", JSONConverter.toJson(result));
	}

	//	@Test
	@OneCase("/com/pzj/core/customer/profile/DistributorService/channelContainUser.json")
	public void queryChannelContainsUsers(@TestData ChannelResellerQueryModel requestModel) {
		//		ChannelResellerQueryModel requestModel = new ChannelResellerQueryModel();
		//		requestModel.setChannelId(3608336849895424L);
		//		requestModel.setRootId(3180074621206529L);
		//		requestModel.setResellerType(ResellerTypeEnum.TRAVELDEPT.getId().toString());
		//		requestModel.setRootId(3180074621206529L);
		PageBean page = new PageBean();
		Result<QueryResult<QueryCustomerResponse>> result = resellerService.queryChannelContainDistributors(
				requestModel, page);
		logger.info("queryChannelContainsUsers result:{}", JSONConverter.toJson(result));
	}

	@Test
	@OneCase("/com/pzj/core/customer/profile/DistributorService/channelNotContainUser.json")
	public void queryChannelNotContainsUsers(@TestData ChannelResellerQueryModel channelUserParam) {
		//		ChannelResellerQueryModel requestModel = new ChannelResellerQueryModel();
		//		requestModel.setChannelId(3632953674956800L);
		//		requestModel.setRootId(3180074621206529L);
		//		List<Long> tempRemoveResellers = new ArrayList<Long>();
		//		tempRemoveResellers.add(3614900952236032L);
		//		requestModel.setTempRemoveResellers(tempRemoveResellers);
		//		Date date = new Date();
		//		channelUserParam.setBindSDate(date);
		//		channelUserParam.setBindEDate(date);
		PageBean page = new PageBean();
		Result<QueryResult<QueryCustomerResponse>> result = resellerService.queryChannelNotContainDistributors(
				channelUserParam, page);
		logger.info("queryChannelNotContainsUsers result:{}", JSONConverter.toJson(result));
	}

	private void printResellerBaseInfo(List<QueryCustomerResponse> list) {
		if (null != list && list.size() > 0) {
			StringBuffer strBuf = new StringBuffer("[");
			for (QueryCustomerResponse sysUser : list) {
				strBuf.append("\n{");
				strBuf.append("id=" + sysUser.getId()).append("\n");
				strBuf.append("LoginName=" + sysUser.getLoginName()).append("\n");
				strBuf.append("Corporater=" + sysUser.getCorporater()).append("\n");
				strBuf.append("OperChargerMobile=" + sysUser.getCorporaterMobile()).append("\n");
				strBuf.append("Name=" + sysUser.getName()).append("\n");
				strBuf.append("Address=" + sysUser.getAddress()).append("\n");
				strBuf.append("ResellerType=" + sysUser.getResellerType()).append("\n");
				strBuf.append("CreateDate=" + sysUser.getCreateDate()).append("\n");
				strBuf.append("}");
			}
			strBuf.append("]");
			System.out.println("printResellerBaseInfo base info :" + strBuf.toString());
		}

	}

	//	@Test
	//@OneCase("/com/pzj/core/customer/profile/DistributorService/queryDistributorById.json")
	public void queryDistributorDetail() {
		Result<QueryDetailCustomerResponse> result = resellerService.queryDistributorDetail(2216619741563734l);

		assertNotNull(result);
		assertTrue(result.isOk());
		assertNotNull(result.getData());

		System.out.println(JSONConverter.toJson(result));
	}

	//	@Test
	//@OneCase("/com/pzj/core/customer/profile/DistributorService/queryDistributorById.json")
	public void queryDistributorMarketing() {
		Result<CustomerMarketingResponse> result = resellerService.queryDistributorMarketing(3672972781420544L,
				2216619741564532L);

		assertNotNull(result);
		assertTrue(result.isOk());
		assertNotNull(result.getData());

		System.out.println(JSONConverter.toJson(result));
	}

	//	@Test
	@OneCase("/com/pzj/core/customer/profile/DistributorService/modifyDistributorBeforeFirstLogin.json")
	public void modifyDistributorBeforeFirstLogin(@TestData ModifyCustomerRequest distributor) {
		Result<Boolean> result = resellerService.modifyDistributorBeforeFirstLogin(distributor);

		assertNotNull(result);
		assertTrue(result.isOk());
		assertNotNull(result.getData());

		System.out.println(JSONConverter.toJson(result));
	}

	@Test
	@OneCase("/com/pzj/core/customer/profile/DistributorService/modifyCustomer.json")
	public void modifyCustomer(@TestData ModifyCustomerRequest distributor) {
		Result<Boolean> result = resellerService.modifyCustomer(distributor);

		assertNotNull(result);
		assertTrue(result.isOk());
		assertNotNull(result.getData());

		System.out.println(JSONConverter.toJson(result));
	}

	@Test
	@OneCase("/com/pzj/core/customer/profile/DistributorService/createDistributors.json")
	public void createDistributors(@TestData CreateManyCustomerRequest distributors) {
		Result<ArrayList<CreateCustomerReport>> result = resellerService.createDistributor(distributors);

		assertNotNull(result);
		System.out.println(JSONConverter.toJson(result));
		assertTrue(result.isOk());

	}


	@Test
	@OneCase("/com/pzj/core/customer/profile/DistributorService/createDistributors2.json")
	public void createDistributors2(@TestData CreateCustomerRequest distributors) {
		Result<Long> result = resellerService.createDistributor(distributors);

		assertNotNull(result);
		System.out.println(JSONConverter.toJson(result));
		assertTrue(result.isOk());

	}

	//	@Test
	public void queryCustomerFreeJoin() {
		QueryCustomerRequest request = new QueryCustomerRequest();
		List<Long> userIds = new ArrayList<Long>();
		userIds.add(2216619736563715l);
		userIds.add(2216619736563718l);
		request.setUserIds(userIds);
		PageBean pageBean = new PageBean();
		Result<QueryResult<QueryCustomerResponse>> result = customerService.queryCustomerFreeJoin(request, pageBean, 2);
		logger.info("查询用户返回{}", JSONConverter.toJson(result));
	}

	@Test
	@OneCase("/com/pzj/core/customer/profile/CustomerService/queryCustomerLessInfo.json")
	public void queryCustomerLessInfo(@TestData("param") QueryCustomerLessInfoRequest param, @TestData("page") PageBean page){
		Result<QueryResult<QueryCustomerLessInfoResponse>> result = customerService.queryCustomerLessInfo(param, page);

		assertNotNull(result);
		System.out.println(JSONConverter.toJson(result));
		assertTrue(result.isOk());
	}
}
