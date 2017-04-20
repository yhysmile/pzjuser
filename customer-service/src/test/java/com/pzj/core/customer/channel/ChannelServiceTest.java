package com.pzj.core.customer.channel;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;

import com.pzj.base.common.utils.PageModel;
import com.pzj.core.customer.profile.QueryCustomerRequest;
import com.pzj.framework.armyant.anno.OneCase;
import com.pzj.framework.armyant.anno.TestData;
import com.pzj.framework.armyant.junit.spring.ArmyantSpringRunner;
import com.pzj.framework.context.Result;
import com.pzj.framework.converter.JSONConverter;
import com.pzj.framework.entity.QueryResult;

/**
 * Created by Administrator on 2017-2-22.
 * 渠道相关test
 */
@RunWith(ArmyantSpringRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/spring-context.xml" })
public class ChannelServiceTest {
	private final Logger logger = LoggerFactory.getLogger(ChannelServiceTest.class);

	@Resource
	private ChannelService newChannelService;

	//@Test
	public void queryChannelDetailByChannelId() {
		Result<QueryChannelResponse> sysChannelResult = newChannelService
				.queryChannelDetailByChannelId(2216619736563714l);
		logger.info("测试查询渠道详情返回结果:{}", JSONConverter.toJson(sysChannelResult));
	}

	@Test
	public void queryChannelsUserJoin() {
		//渠道查询参数
		QueryChannelRequest channelRequest = new QueryChannelRequest();
		//channelRequest.setId(2216619736763766l);
		//channelRequest.setName("zz");
		channelRequest.setSupplierId(3180074621206529l);
		//用户查询参数
		QueryCustomerRequest customerRequest = new QueryCustomerRequest();
		//customerRequest.setId(2216619736763736l);
		//customerRequest.setName("王导游");
		//分页查询参数
		PageModel pageModel = new PageModel(1, 20);
		//临时删除的渠道
		List<Long> tmpDelIds = new ArrayList<>();
		//tmpDelIds.add(2216619736563713l);
		//临时加入的渠道
		List<Long> tmpAddIds = new ArrayList<>();
		//tmpAddIds.add(2216619736563717l);
		Result<QueryResult<QueryChannelResponse>> queryResultResult = newChannelService.queryChannelsUserJoin(
				channelRequest, null, pageModel, tmpDelIds, tmpAddIds);
		logger.info("查询用户已关联的渠道返回结果:{}", JSONConverter.toJson(queryResultResult));
	}


	@Test
	@OneCase("/com/pzj/core/customer/channel/ChannelService/queryChannelsUserJoin.json")
	public void queryChannelsUserJoin2(@TestData("channelRequest") QueryChannelRequest channelRequest,
									   @TestData("customerRequest") QueryCustomerRequest customerRequest,
									   @TestData("pageModel")PageModel pageModel,
									   @TestData("tmpDelIds") List<Long> tmpDelIds,
									   @TestData("tmpAddIds") List<Long> tmpAddIds) {

		Result<QueryResult<QueryChannelResponse>> result = newChannelService.queryChannelsUserJoin(
				channelRequest, customerRequest, pageModel, tmpDelIds, tmpAddIds);

		assertNotNull(result);
		assertTrue(result.isOk());
		assertNotNull(result.getData());

		System.out.println(JSONConverter.toJson(result));
	}

	@Test
	@OneCase("/com/pzj/core/customer/channel/ChannelService/queryChannelsUserNotJoin.json")
	public void queryChannelsUserNotJoin(@TestData("channelRequest") QueryChannelRequest channelRequest,
										 @TestData("customerRequest") QueryCustomerRequest customerRequest,
										 @TestData("pageModel") PageModel pageModel,
										 @TestData("tmpDelIds") List<Long> tmpDelIds,
										 @TestData("tmpAddIds") List<Long> tmpAddIds) {

		Result<QueryResult<QueryChannelResponse>> result = newChannelService.queryChannelsUserNotJoin(
				channelRequest, customerRequest, pageModel, tmpAddIds,tmpDelIds);

		assertNotNull(result);
		assertTrue(result.isOk());
		assertNotNull(result.getData());

		System.out.println(JSONConverter.toJson(result));
	}

	//@Test
	public void modifyChannelOwnedUser() {
		List<Long> addIds = new ArrayList<>();
		//addIds.add(111123l);
		//addIds.add(111456l);
		//addIds.add(111000l);
		//addIds.add(111777l);

		List<Long> delIds = new ArrayList<>();
		delIds.add(111123l);
		delIds.add(111456l);

		Result<Boolean> result = newChannelService.modifyChannelOwnedUser(9999999l, addIds, null, 2216619736563713l);
		logger.info("管理渠道用户关联关系返回结果:{}", JSONConverter.toJson(result));
	}

	@Test
	public void modifyUserOwnedChannel() {
		List<Long> addIds = new ArrayList<>();
		//addIds.add(111123l);
		//addIds.add(111456l);
		//addIds.add(111000l);
		//addIds.add(111777l);

		List<Long> delIds = new ArrayList<>();
		delIds.add(9999999l);

		Result<Boolean> result = newChannelService.modifyChannelOwnedUser(null, addIds, null, 2216619736563713l);
		logger.info("管理渠道用户关联关系返回结果:{}", JSONConverter.toJson(result));
	}

	@Test
	@OneCase("/com/pzj/core/customer/channel/ChannelService/createChannel.json")
	public void test(@TestData CreateChannelRequest createChannelRequest) {
		Result<Long> result = newChannelService.createChannel(createChannelRequest);

		assertNotNull(result);
		assertTrue(result.isOk());
		assertNotNull(result.getData());

		System.out.println(JSONConverter.toJson(result));
	}

	@Test
	@OneCase("/com/pzj/core/customer/channel/ChannelService/modifyChannel.json")
	public void modifyChannel(@TestData ModifyChannelRequest modifyChannelRequest) {
		Result<Boolean> result = newChannelService.modifyChannel(modifyChannelRequest);

		assertNotNull(result);
		assertTrue(result.isOk());
		assertTrue(result.getData());

		System.out.println(JSONConverter.toJson(result));
	}

	//@Test
	@OneCase("/com/pzj/core/customer/channel/ChannelService/deleteChannel.json")
	public void deleteChannel(@TestData("id") Long id, @TestData("operator") Long operator) {

		Result<Boolean> result = newChannelService.deleteChannel(id, operator);

		assertNotNull(result);
		assertTrue(result.isOk());
		assertTrue(result.getData());

		System.out.println(JSONConverter.toJson(result));
	}

}
