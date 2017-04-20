package com.pzj.core.customer.utils;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pzj.base.entity.SysChannel;
import com.pzj.base.entity.SysUser;
import com.pzj.core.customer.channel.QueryChannelRequest;
import com.pzj.core.customer.channel.QueryChannelResponse;
import com.pzj.core.customer.profile.CreateCustomerRequest;
import com.pzj.core.customer.profile.QueryCustomerResponse;
import com.pzj.framework.toolkit.Check;

/**
 * Created by Administrator on 2017-2-16.
 * 模型转换
 */
public class ModelConvert {
	private static final Logger logger = LoggerFactory.getLogger(ModelConvert.class);

	public static SysUser convertToSysUser(CreateCustomerRequest createRequest) {
		if (Check.NuNObject(createRequest)) {
			return new SysUser();
		}
		SysUser sysUser = new SysUser(createRequest.getLoginName(), createRequest.getName(),
				createRequest.getSupplierNormal(), createRequest.getIdentifyType(),
				createRequest.getCorporaterMobile(), createRequest.getCorporater(),
				createRequest.getCorporaterCredentials(), createRequest.getBusinessCertificate(),
				createRequest.getBusinessLicense(), createRequest.getGuideCertificate(), createRequest.getAddress(),
				createRequest.getOperChargerPhone(), createRequest.getOperChargerFax(),
				createRequest.getOperChargerEmail(), createRequest.getCreateBy().toString(),
				createRequest.getRefereeId(), createRequest.getBusinessId(), createRequest.getRefereeCode(),
				createRequest.getProvince(), createRequest.getCity(), createRequest.getCounty(), createRequest
						.getResellerType().toString());

		return sysUser;
	}

	/**
	 * SysUser转换返回模型
	 * @param sysUser
	 * @return
	 */
	public static QueryCustomerResponse convertToCustomerResponse(SysUser sysUser) {
		if (Check.NuNObject(sysUser)) {
			return new QueryCustomerResponse();
		}
		QueryCustomerResponse customerResponse = new QueryCustomerResponse(sysUser.getId(), sysUser.getLoginName(),
				sysUser.getName(), sysUser.getCorporaterMobile(), sysUser.getCorporater(), sysUser.getProvince(),
				sysUser.getCity(), sysUser.getCounty(), Check.NuNStrStrict(sysUser.getResellerType()) ? null
						: Integer.valueOf(sysUser.getResellerType()), sysUser.getAddress(),
				sysUser.getUserRelationCreateDate(), sysUser.getSupplierId());
		return customerResponse;
	}

	public static SysChannel convertSysChannel(QueryChannelRequest channelRequest) {
		if (Check.NuNObject(channelRequest)) {
			return new SysChannel();
		}
		SysChannel sysChannel = new SysChannel(channelRequest.getSupplierId(), channelRequest.getId(),
				channelRequest.getName(), channelRequest.getCreateDate(), channelRequest.getCreateEndDate(),
				channelRequest.getDelFlag() == null ? 1 : channelRequest.getDelFlag());
		return sysChannel;
	}

	public static List<QueryCustomerResponse> convertToCustomerResponses(List<SysUser> sysUsers) {
		List<QueryCustomerResponse> cList = new ArrayList<QueryCustomerResponse>();
		if (Check.NuNObject(sysUsers)) {
			return cList;
		}
		for (SysUser sysU : sysUsers) {
			cList.add(convertToCustomerResponse(sysU));
		}
		return cList;
	}

}
