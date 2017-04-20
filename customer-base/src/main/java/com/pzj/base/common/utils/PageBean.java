package com.pzj.base.common.utils;

import java.io.Serializable;

/**
 * 分页信息记录实体
 * 
 * 类名称：PageBean 类描述:
 * 
 * @version
 * 
 */
public class PageBean implements Serializable {

	private static final long serialVersionUID = -1853714859883796507L;

	public PageBean() {
	}

	public PageBean(long totalCount, PageModel pager) {
		if (pager != null && pager.getPageSize() != null) {
			setPageSize(pager.getPageSize());
		}
		setTotalCount(totalCount);
		if (pager != null && pager.getStartIndex() != null) {
			setStartIndex(pager.getStartIndex());
		}
	}

	public final static int PAGESIZE = 10;

	/** the number of records in one page */
	private int pageSize = PAGESIZE;

	/** 分页索引的数组 */
	private int[] indexs;

	/** 当前分页索引 */
	private int startIndex;

	/** 总结果数 */
	private long totalCount;

	/** 当前页码 */
	private int currentPage;

	private int[] pages;

	/** 是否有上一页 */
	private boolean hasPreviousPage;

	/** 是否有下一页 */
	private boolean hasNextPage;

	/** 最后一页页码 */
	private int lastIndex;

	public static int getPAGESIZE() {
		return PAGESIZE;
	}

	public int[] getIndexs() {
		return indexs;
	}

	public void setIndexs(int[] indexs) {
		this.indexs = indexs;
	}

	public int getNextIndex() {
		// System.out.println("in getNextIndex");
		int nextIndex = getStartIndex() + pageSize;
		if (nextIndex >= totalCount)
			return getStartIndex();
		else
			return nextIndex;

	}

	private void setNextIndex(int nextIndex) {
	}

	public int getPageSize() {
		return pageSize;
	}

	private void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPreviousIndex() {
		// System.out.println("in getPreviousIndex");
		int previousIndex = getStartIndex() - pageSize;
		if (previousIndex < 0)
			return 0;
		else
			return previousIndex;
	}

	private void setPreviousIndex(int previousIndex) {
	}

	public int getStartIndex() {
		// System.out.println("public int getStartIndex()"+startIndex);
		return startIndex;
	}

	private void setStartIndex(long startIndex) {

		if (totalCount <= 0)
			this.startIndex = 0;
		else if (startIndex >= totalCount)
			this.startIndex = indexs[indexs.length - 1];
		else if (startIndex < 0)
			this.startIndex = 0;
		else {
			this.startIndex = indexs[(int) (startIndex / pageSize)];
		}
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {

		if (totalCount > 0) {

			this.totalCount = totalCount;

			int count = (int) (totalCount / pageSize);
			if (totalCount % pageSize > 0)
				count++;
			indexs = new int[count];

			for (int i = 0; i < count; i++) {
				indexs[i] = pageSize * i;
			}
			this.setLastIndex(indexs[indexs.length - 1]);
		} else {
			this.totalCount = 0;
			indexs = new int[0];
			this.setLastIndex(0);
		}
	}

	public int[] getPages() {
		pages = new int[getIndexs().length];
		for (int i = 0; i < pages.length; i++) {
			pages[i] = i + 1;
		}
		return pages;
	}

	private void setPages(int[] pages) {
		this.pages = pages;
	}

	public int getCurrentPage() {
		for (int i = 0; i < getIndexs().length; i++) {
			if (getStartIndex() == getIndexs()[i]) {
				setCurrentPage(i + 1);
			}
		}
		return currentPage;
	}

	private void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getLastIndex() {
		return lastIndex;
	}

	private void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	private boolean hasNextPage() {
		if (getCurrentPage() == getPages().length) {
			setHasNextPage(false);
		} else {
			setHasNextPage(true);
		}
		return hasNextPage;
	}

	public boolean getHasNextPage() {
		if (getCurrentPage() == getPages().length) {
			setHasNextPage(false);
		} else {
			setHasNextPage(true);
		}
		return hasNextPage;
	}

	private void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	private boolean hasPreviousPage() {
		if (getCurrentPage() == 1) {
			setHasPreviousPage(false);
		} else {
			setHasPreviousPage(true);
		}
		return hasPreviousPage;
	}

	public boolean getHasPreviousPage() {
		if (getCurrentPage() == 0 || getCurrentPage() == 1) {
			setHasPreviousPage(false);
		} else {
			setHasPreviousPage(true);
		}
		return hasPreviousPage;
	}

	private void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	@Override
	public String toString() {
		StringBuilder buff = new StringBuilder();
		String sf = "[ ";
		for (int s : getIndexs()) {
			sf = sf + s + " ";
		}
		sf = sf + "]";

		String spg = "[";
		for (int j : getPages()) {
			spg = spg + j + " ";
		}
		spg = spg + "]";
		buff.append("当前Page对象信息如下").append("\n").append("分页索引的数组：" + sf)
				.append("\n").append("当前分页索引:" + this.getStartIndex())
				.append("\n").append("总结果数：" + this.getTotalCount())
				.append("\n").append("下一页索引:" + this.getNextIndex())
				.append("\n").append("上一页索引:" + this.getPreviousIndex())
				.append("\n").append("当前页码数：" + this.getCurrentPage())
				.append("\n").append("每页显示：" + this.getPageSize()).append("\n")
				.append("页码列表：" + spg);
		return buff.toString();
	}

}
