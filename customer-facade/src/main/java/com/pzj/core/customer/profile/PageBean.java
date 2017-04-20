package com.pzj.core.customer.profile;

public class PageBean implements java.io.Serializable {

	private static final long serialVersionUID = -4295306588332976397L;

	private Integer currentPage;

	private Integer pageSize;

	private Integer startIndex;

	private final int defaultPage = 1;
	private final int defaultPageSize = 20;

	public PageBean() {
		this.currentPage = defaultPage;
		this.pageSize = defaultPageSize;
		setSartIndex();
	}

	public PageBean(Integer currentPage, Integer pageSize) {
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
}
