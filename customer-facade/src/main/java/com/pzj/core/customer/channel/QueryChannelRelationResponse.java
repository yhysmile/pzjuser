package com.pzj.core.customer.channel;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-3-29.
 */
public class QueryChannelRelationResponse implements Serializable {

	private static final long serialVersionUID = 7511853817879898911L;
	/**
	 * Key：渠道ID
	 * Value：用户ID集合
	 */
	private Map<Long, List<Long>> channelRelations;

	public Map<Long, List<Long>> getChannelRelations() {
		return channelRelations;
	}

	public void setChannelRelations(Map<Long, List<Long>> channelRelations) {
		this.channelRelations = channelRelations;
	}
}
