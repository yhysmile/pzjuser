/*
 * SysUserRelationService.java
 
 * www.piaozhijia.com
 */
package com.pzj.service.Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.UserGlobalParam;
import com.pzj.base.common.utils.PageBean;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysUserRelation;
import com.pzj.base.service.sys.ISysUserRelationService;
import com.pzj.core.customer.dao.ISysUserRelationMapper;
import com.pzj.framework.context.Result;

/**
 * service接口实现.供应商关系
 * 
 * @author 票之家
 */
@Service("sysUserRelationService")
public class SysUserRelationServiceImpl extends BaseRelationshipServiceImpl<SysUserRelation, ISysUserRelationMapper>
		implements ISysUserRelationService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Map<String, String> getRelationIds(List<SysUserRelation> records) {
		if (records == null || records.isEmpty()) {
			return null;
		}
		StringBuilder objIds = new StringBuilder();
		StringBuilder relIds = new StringBuilder();
		StringBuilder types = new StringBuilder();
		for (SysUserRelation record : records) {
			Long objId = record.getUserId();
			Long relId = record.getRelUserId();
			String relType = record.getRelType();
			if (objId != null) {
				String objIdString = objId.toString();
				if (objIds.indexOf(objIdString) < 0)
					objIds.append(objIdString).append(",");
			}
			if (relId != null) {
				String relIdString = relId.toString();
				if (relIds.indexOf(relIdString) < 0)
					relIds.append(relIdString).append(",");
			}
			if (StringUtils.isNotBlank(relType)) {
				if (types.indexOf(relType) < 0)
					types.append("'").append(relType).append("'").append(",");
			}
		}
		Map<String, String> map = new HashMap<>();
		if (StringUtils.isNotBlank(objIds)) {
			map.put(UserGlobalParam.UserMapKeyParam.USER_MAP_KEY, objIds.substring(0, objIds.length() - 1));
		}
		if (StringUtils.isNotBlank(relIds)) {
			map.put(UserGlobalParam.ChannelMapKeyParam.REF_MAP_KEY, relIds.substring(0, relIds.length() - 1));
		}
		if (StringUtils.isNotBlank(types)) {
			map.put(UserGlobalParam.UserMapKeyParam.RELT_MAP_KEY, types.substring(0, types.length() - 1));
		}
		return map;
	}

	@Override
	public Long delAuthBatch(List<SysUserRelation> records, boolean syncOtherRelation) {
		Long num = 0l;
		try {
			if (records == null || records.isEmpty()) {
				logger.error("方法[SysUserRelationService.delAuthBatch],参数records不可以为空");
				return num;
			}

			// 删除渠道与标签的关系
			num += deleteBatchSelective(records);

		} catch (NumberFormatException e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return num;
	}

	@Override
	public Long insertAuthBatch(List<SysUserRelation> records, boolean syncOtherRelation) {
		Long num = 0l;
		String regx = ",";
		try {
			if (records == null || records.isEmpty()) {
				logger.error("方法[SysUserRelationService.insertAuthBatch],参数records不可以为空");
				return num;
			}
			Map<String, String> idsMap = getRelationIds(records);
			Map<String, SysUserRelation> havMap = listTMap(findByIds(idsMap), regx);
			List<SysUserRelation> insertList = new ArrayList<SysUserRelation>();
			for (SysUserRelation key : records) {
				Long objId = key.getUserId();
				Long refId = key.getRelUserId();
				String type = key.getRelType();
				if (objId != null && refId != null && StringUtils.isNotBlank(type)) {
					String genKey = genMapKey(key, regx);
					if (!havMap.containsKey(genKey)) {
						insertList.add(key);
						havMap.put(genKey, key);
					}
				}
			}
			if (insertList != null && !insertList.isEmpty()) {
				num += insertBatch(insertList);
			}

		} catch (NumberFormatException e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return num;
	}

	@Override
	public String genMapKey(SysUserRelation record, String regx) {
		String key = "";
		if (StringUtils.isBlank(regx)) {
			regx = ",";
		}
		if (record == null) {
			return key;
		}
		Long objId = record.getUserId();
		Long refId = record.getRelUserId();
		String refType = record.getRelType();
		if (objId == null || refId == null) {
			return null;
		}

		if (StringUtils.isNotBlank(refType)) {
			return refType + ":" + objId + regx + refId;
		} else {
			return objId + regx + refId;
		}
	}

	@Override
	public PageList<SysUserRelation> queryAuthPageByParamMap(PageModel pager, SysUserRelation entity) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pParam", pager);
		params.put("bParam", entity);
		List<SysUserRelation> listBean = mapper.queryAuthByParamMap(params);
		Integer count = mapper.countByParamMap(params);
		PageBean pageObj = new PageBean(Long.valueOf(count.toString()), pager);
		PageList<SysUserRelation> pagelist = new PageList<SysUserRelation>(listBean, pageObj);
		return pagelist;
	}

	@Override
	public Long createNoRepeat(SysUserRelation entity) {

		Long id = null;

		List<SysUserRelation> repeatReleations = mapper.selectRepeat(Arrays.asList(entity));

		if (CollectionUtils.isEmpty(repeatReleations)) {
			id = insert(entity);
		}

		return id;
	}

	@Override
	public Result<Boolean> createBatchNoRepeat(List<SysUserRelation> entityList) {
		Result<Boolean> result = new Result<>(false);
		if (CollectionUtils.isEmpty(entityList)) {
			return result;
		}
		List<SysUserRelation> repeatReleations = mapper.selectRepeat(entityList);

		if (CollectionUtils.isNotEmpty(repeatReleations)) {
			Iterator<SysUserRelation> iterator = entityList.iterator();
			while (iterator.hasNext()) {
				SysUserRelation userRelation = iterator.next();
				for (SysUserRelation repeatRelation : repeatReleations) {
					if (userRelation.getUserId().longValue() == repeatRelation.getUserId().longValue()
							&& userRelation.getRelUserId().longValue() == repeatRelation.getRelUserId().longValue()
							&& userRelation.getRelType().equals(repeatRelation.getRelType())) {
						iterator.remove();
						break;
					}
				}
			}
		}

		if (CollectionUtils.isNotEmpty(entityList)) {
			Long insertBatch = insertBatch(entityList);
			result.setData(insertBatch > 0);
		}
		return result;
	}

	@Override
	public List<SysUserRelation> queryUserRelations(SysUserRelation sysUserRelation) {
		return mapper.queryUserRelationByParam(sysUserRelation);
	}

	@Override
	public void updateUserStatusById(SysUserRelation sysUserRelation) {
		mapper.updateUserRelationStatus(sysUserRelation);
	}
}
