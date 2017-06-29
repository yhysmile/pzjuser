package com.pzj.core.customer.entitys;

public class PageEntity implements java.io.Serializable {

	private static final long serialVersionUID = -3525317729516447798L;
	private Integer currentPage;

	private Integer pageSize;

	private Integer startIndex;

	private String orderByClause;

	private final int defaultPage = 1;
	private final int defaultPageSize = 20;

	public PageEntity() {
		this.currentPage = defaultPage;
		this.pageSize = defaultPageSize;
		setSartIndex();
	}

	public PageEntity(Integer currentPage, Integer pageSize) {
		setCurrentPage(currentPage);
		setPageSize(pageSize);
		setSartIndex();
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage <= 0 ? defaultPage : currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize <= 0 ? defaultPageSize : pageSize;
	}

	public int getStartIndex() {
		if (this.currentPage != null && this.pageSize != null) {
			this.startIndex = (this.currentPage - 1) * this.pageSize;
		}
		return startIndex;
	}

	private void setSartIndex() {
		if (this.currentPage != null && this.pageSize != null) {
			this.startIndex = (this.currentPage - 1) * this.pageSize;
		} else {
			this.startIndex = 0;
		}
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

}
