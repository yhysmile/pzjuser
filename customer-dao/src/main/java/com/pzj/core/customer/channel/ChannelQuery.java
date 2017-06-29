package com.pzj.core.customer.channel;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017-4-14.
 */
public class ChannelQuery extends ChannelEntity {
	/**  */
	private static final long serialVersionUID = -6660275605349559133L;

	private List<Long> ids;

	private Date createDateBegin;

	private Date createDateEnd;

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

	public Date getCreateDateBegin() {
		return createDateBegin;
	}

	public void setCreateDateBegin(Date createDateBegin) {
		this.createDateBegin = createDateBegin;
	}

	public Date getCreateDateEnd() {
		return createDateEnd;
	}

	public void setCreateDateEnd(Date createDateEnd) {
		this.createDateEnd = createDateEnd;
	}
}
