package com.pzj.core.customer.utils;

import java.util.List;

import com.pzj.base.common.utils.PageModel;
import com.pzj.core.customer.commons.PageBean;
import com.pzj.core.customer.profile.PageEntity;
import com.pzj.framework.entity.QueryResult;

/**
 * Created by Administrator on 2017-4-10.
 */
public class QueryUtil {
	public static <T> QueryResult<T> result(PageModel pageModel, int count, List<T> channelResponses) {
		int no = 1;
		int size = 0;

		if (pageModel != null){
			no = pageModel.getPageNo();
			size = pageModel.getPageSize();
		}

		QueryResult<T> queryResult = new QueryResult<>(no, size);
		queryResult.setRecords(channelResponses);
		queryResult.setTotal(count);
		return queryResult;
	}

	public static <T> QueryResult<T> result(PageBean pageBean, int count, List<T> channelResponses) {
		int no = 1;
		int size = 0;

		if (pageBean != null){
			no = pageBean.getCurrentPage();
			size = pageBean.getPageSize();
		}

		QueryResult<T> queryResult = new QueryResult<>(no, size);
		queryResult.setRecords(channelResponses);
		queryResult.setTotal(count);
		return queryResult;
	}

	public static PageBean defaultPageBean(PageBean pageBean){
		if (pageBean == null){
			return new PageBean(1, 10);
		}
		return new PageBean(pageBean.getCurrentPage(), pageBean.getPageSize());
	}

	public static PageEntity convertToPageEntity(PageBean pageBean){
		return new PageEntity(pageBean.getCurrentPage(), pageBean.getPageSize());
	}
}
