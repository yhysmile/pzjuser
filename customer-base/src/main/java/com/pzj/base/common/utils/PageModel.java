package com.pzj.base.common.utils;

import java.io.Serializable;

import com.pzj.base.common.global.GlobalParam;

/**
 * 分页信息记录实体
 * 
 * 类名称：PageBean 类描述:
 * 
 * @version
 * 
 */
public class PageModel implements Serializable {

	private static final long serialVersionUID = 3987115680525820105L;

	private Integer startIndex = 0;

	private Integer pageSize = 10;

	private String orderByClause;

	private Integer pageNo = 1;
	
	public PageModel(){
		
	}

	/**
	 * 只做排序，不分页
	 * @param orderByClause
	 */
	public PageModel(String orderByClause){
		this.orderByClause = orderByClause;
	}
   

	public PageModel(Integer pageNo, Integer pageSize) {
		if (pageNo == null || pageNo < 1) {
			pageNo = GlobalParam.Page.pageNo();
		}
		if (pageSize == null || pageSize < 1) {
			pageSize = GlobalParam.Page.pageSize();
		}
		this.pageNo = pageNo;
		this.startIndex = (this.pageNo - 1) * pageSize;
		this.pageSize = pageSize;
	}

	public PageModel(Integer pageNo, Integer pageSize, String orderBy) {
		if (pageNo == null || pageNo < 1) {
			pageNo = GlobalParam.Page.pageNo();
		}
		if (pageSize == null || pageSize < 1) {
			pageSize = GlobalParam.Page.pageSize();
		}
		this.pageSize = pageSize;
		this.pageNo = pageNo;
		this.orderByClause = orderBy;
		startIndex = (this.pageNo - 1) * pageSize;
	}

	private void setStartIndex(Integer startIndex) {
		if (startIndex == null || startIndex < 0) {
			startIndex = GlobalParam.Page.pageNo();
		}
		this.startIndex = startIndex;
	}

	public Integer getStartIndex() {
		if (pageNo != null && pageSize != null) {
			startIndex = (this.pageNo - 1) * pageSize;
		}
		return startIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		if (pageSize == null || pageSize < 1) {
			pageSize = GlobalParam.Page.pageSize();
		}
		this.pageSize = pageSize;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	private void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		if (pageNo < 1) {
			pageNo = GlobalParam.Page.pageNo();
		}
		this.pageNo = pageNo;
	}
}
