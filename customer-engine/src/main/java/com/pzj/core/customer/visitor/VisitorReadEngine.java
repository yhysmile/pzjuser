package com.pzj.core.customer.visitor;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.pzj.core.customer.profile.PageBean;
import com.pzj.core.customer.profile.PageEntity;
import com.pzj.core.customer.profile.VisitorEntity;
import com.pzj.core.customer.read.VisitorReadMapper;
import com.pzj.framework.entity.QueryResult;

/**
 * Created by Administrator on 2017-2-23.
 */
@Component("visitorReadEngine")
public class VisitorReadEngine {
	@Resource
	private VisitorReadMapper visitorReadMapper;

	public QueryResult<QueryVisitorSummaryResponse> queryVisitorPage(QueryVisitorRequest visitorRequest, PageBean page) {
		if (page == null) {
			page = new PageBean();
		}

		QueryResult<QueryVisitorSummaryResponse> queryResult = new QueryResult<QueryVisitorSummaryResponse>(
				page.getCurrentPage(), page.getPageSize());

		VisitorEntity visitorEntity = convertRequest(visitorRequest);
		PageEntity pageEntity = new PageEntity(page.getCurrentPage(), page.getPageSize());
		List<VisitorEntity> visitorEntitys = visitorReadMapper.queryVisitorPage(visitorEntity, pageEntity);
		List<QueryVisitorSummaryResponse> visitorResponse = convertResponse(visitorEntitys);
		if (visitorResponse == null) {
			return queryResult;
		}
		Integer count = visitorReadMapper.countVisitorPage(visitorEntity, pageEntity);

		queryResult.setRecords(visitorResponse);
		queryResult.setTotal(count);
		return queryResult;
	}

	public QueryVisitorDetailResponse queryVisitorDetail(Long id) {
		VisitorEntity visitorEntity = visitorReadMapper.queryVisitorDetailById(id);

		return convertVisitorDetail(visitorEntity);
	}

	public ArrayList<QueryVisitorSummaryResponse> queryVisitorByNameMobile(String nameOrMobile) {
		List<VisitorEntity> visitorEntitys = visitorReadMapper.queryVisitorByNameMobile(nameOrMobile);

		return convertResponse(visitorEntitys);
	}

	private VisitorEntity convertRequest(QueryVisitorRequest visitorRequest) {
		if (visitorRequest == null) {
			return null;
		}
		VisitorEntity visitorEntity = new VisitorEntity();
		visitorEntity.setOwnerId(visitorRequest.getOwnerId());
		visitorEntity.setIdNum(visitorRequest.getIdNum());
		visitorEntity.setName(visitorRequest.getName());
		visitorEntity.setPhoneNum(visitorRequest.getPhoneNum());
		return visitorEntity;
	}

	private ArrayList<QueryVisitorSummaryResponse> convertResponse(List<VisitorEntity> visitorEntitys) {
		if (visitorEntitys == null || visitorEntitys.size() == 0) {
			return null;
		}
		ArrayList<QueryVisitorSummaryResponse> visitorResponses = new ArrayList<>();
		for (VisitorEntity visitorEntity : visitorEntitys) {
			visitorResponses.add(convertVisitor(visitorEntity));
		}
		return visitorResponses;
	}

	private QueryVisitorSummaryResponse convertVisitor(VisitorEntity visitorEntity) {
		if (visitorEntity == null) {
			return null;
		}
		QueryVisitorSummaryResponse visitorResponse = new QueryVisitorSummaryResponse();
		visitorResponse.setId(visitorEntity.getId());
		visitorResponse.setIdNum(visitorEntity.getIdNum());
		visitorResponse.setName(visitorEntity.getName());
		visitorResponse.setOperator(visitorEntity.getOwnerId());
		visitorResponse.setRemark(visitorEntity.getRemark());
		visitorResponse.setPhoneNum(visitorEntity.getPhoneNum());
		return visitorResponse;
	}

	private QueryVisitorDetailResponse convertVisitorDetail(VisitorEntity visitorEntity) {
		if (visitorEntity == null) {
			return null;
		}
		QueryVisitorDetailResponse visitorDetail = new QueryVisitorDetailResponse();
		visitorDetail.setId(visitorEntity.getId());
		visitorDetail.setIdNum(visitorEntity.getIdNum());
		visitorDetail.setName(visitorEntity.getName());
		visitorDetail.setOperator(visitorEntity.getOwnerId());
		visitorDetail.setRemark(visitorEntity.getRemark());
		visitorDetail.setPhoneNum(visitorEntity.getPhoneNum());
		visitorDetail.setStatus(visitorEntity.getStatus());
		visitorDetail.setCreateBy(visitorEntity.getCreateBy());
		visitorDetail.setCreateDate(visitorEntity.getCreateDate());
		visitorDetail.setUpdateBy(visitorEntity.getUpdateBy());
		visitorDetail.setUpdateDate(visitorEntity.getUpdateDate());
		return visitorDetail;
	}
}
