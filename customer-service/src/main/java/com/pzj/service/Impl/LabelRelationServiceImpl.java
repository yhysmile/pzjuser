package com.pzj.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pzj.framework.toolkit.Check;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.UserGlobalParam;
import com.pzj.base.entity.SysLabelRelationKey;
import com.pzj.base.service.sys.ILabelRelationService;
import com.pzj.dao.SysLabelRelationMapper;

@Service("labelRelationService")
public class LabelRelationServiceImpl extends BaseRelationshipServiceImpl<SysLabelRelationKey, SysLabelRelationMapper>
		implements ILabelRelationService {



	public Map<String, String> getRelationIds(List<SysLabelRelationKey> records, String typeKey, String type) {
		if (records == null || records.isEmpty()) {
			return null;
		}
		StringBuffer objIds = new StringBuffer();
		StringBuffer relIds = new StringBuffer();
		for (SysLabelRelationKey record : records) {
			String objId = record.getObjId();
			String relId = record.getRelId();
			if (StringUtils.isNotBlank(objId) && objIds.indexOf(objId) < 0) {
				objIds.append(objId).append(",");
			}
			if (StringUtils.isNotBlank(relIds) && relIds.indexOf(relId) < 0) {
				relIds.append(relId).append(",");
			}
		}
		Map<String, String> map = new HashMap<String, String>();
		if (StringUtils.isNotBlank(objIds)) {
			map.put(UserGlobalParam.ChannelMapKeyParam.OBJ_MAP_KEY, objIds.substring(0, objIds.length() - 1));
		}
		if (StringUtils.isNotBlank(relIds)) {
			map.put(UserGlobalParam.ChannelMapKeyParam.REF_MAP_KEY, relIds.substring(0, relIds.length() - 1));
		}
		if (StringUtils.isNotBlank(type)) {
			map.put(typeKey, type);
		}

		return map;
	}

	@Override
	public Long delAuthBatch(List<SysLabelRelationKey> records, boolean syncOtherRelation) {
		Long num = 0l;
		try {
			if (records == null || records.isEmpty()) {
				logger.error("方法[LabelRelationService.delAuthBatch],参数records不可以为空");
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
	public Long insertAuthBatch(List<SysLabelRelationKey> records, boolean syncOtherRelation) {
		Long num = 0l;
		String regx = ",";
		try {
			if (records == null || records.isEmpty()) {
				logger.error("方法[LabelRelationService.insertAuthBatch],参数records不可以为空");
				return num;
			}
			Map<String, String> idsMap = getRelationIds(records);
			Map<String, SysLabelRelationKey> havMap = listTMap(findByIds(idsMap), regx);
			List<SysLabelRelationKey> insertList = new ArrayList<SysLabelRelationKey>();
			for (SysLabelRelationKey key : records) {
				String objId = key.getObjId();
				String refId = key.getRelId();
				String type = key.getRelType();
				if (StringUtils.isNotBlank(objId) && StringUtils.isNotBlank(refId) && StringUtils.isNotBlank(type)) {
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
	public String genMapKey(SysLabelRelationKey record, String regx) {
		String key = "";
		if (StringUtils.isBlank(regx)) {
			regx = ",";
		}
		if (record == null) {
			return key;
		}
		String objId = record.getObjId();
		String refId = record.getRelId();
		String refType = record.getRelType();
		if (StringUtils.isBlank(objId) || StringUtils.isBlank(refId) || StringUtils.isBlank(refType)) {
			return key;
		}

		return refType + ":" + objId + regx + refId;
	}

	@Override
	public Map<String, String> getRelationIds(List<SysLabelRelationKey> records) {
		if (records == null || records.isEmpty()) {
			return null;
		}
		StringBuffer objIds = new StringBuffer();
		StringBuffer labelIds = new StringBuffer();
		StringBuilder types = new StringBuilder();
		for (SysLabelRelationKey record : records) {
			String objId = record.getObjId();
			String labelId = record.getRelId();
			String relType = record.getRelType();
			if (StringUtils.isNotBlank(objId) && objIds.indexOf(objId + ",") < 0) {
				objIds.append(objId).append(",");
			}
			if (StringUtils.isNotBlank(labelId) && labelIds.indexOf(labelId + ",") < 0) {
				labelIds.append(labelId).append(",");
			}

			if (StringUtils.isNotBlank(relType) && types.indexOf(relType + ",") < 0){
				types.append("'").append(relType).append("'").append(",");
			}
		}
		Map<String, String> map = new HashMap<String, String>();
		if (StringUtils.isNotBlank(objIds)) {
			map.put(UserGlobalParam.ChannelMapKeyParam.OBJ_MAP_KEY, objIds.substring(0, objIds.length() - 1));
		}
		if (StringUtils.isNotBlank(labelIds)) {
			map.put(UserGlobalParam.ChannelMapKeyParam.REF_MAP_KEY, labelIds.substring(0, labelIds.length() - 1));
		}
		if (StringUtils.isNotBlank(types)) {
			map.put(UserGlobalParam.ChannelMapKeyParam.RELATION_TYPE_KEY, types.substring(0, types.length() - 1));
			map.put("needCompatibleDirectChannel", "false");
		}
		return map;
	}

	@Override
	public List<SysLabelRelationKey> findByRelation(SysLabelRelationKey key) {
		if (null == key) {
			return null;
		}

		return mapper.selectLabelByRelation(key);
	}

	@Override
	public int saveUserTicket(Long objId, List<Long> relIds) {
		return save(objId, relIds, UserGlobalParam.ChannelMapKeyParam.CHANNEL_USER_TICKET_TYPE);
	}

	@Override
	public int save(Long objId, List<Long> relIds, String relType) {
		if (checkRelations(objId, relIds, relType))
			return 0;

		Map<String, String> idsMap = LabelRelationServiceUtil.createIdsMap(objId, relIds, relType);
		List<SysLabelRelationKey> relationList = createRelationList(objId, relIds, relType);

		updateAuthBatch(idsMap, relationList);

		return 1;
	}

	private boolean checkRelations(Long objId, List<Long> relIds, String relType) {
		return null == objId || null == relIds || StringUtils.isBlank(relType);
	}

	@Override
	public List<SysLabelRelationKey> createRelationList(Long objId, List<Long> relIds, String relType) {
		List<SysLabelRelationKey> list = new ArrayList<>(relIds.size());
		String odjIdString = objId.toString();
		for (Long relId : relIds) {
			SysLabelRelationKey relation = new SysLabelRelationKey(odjIdString, relId.toString(), relType);
			list.add(relation);
		}
		return list;
	}

	/**
	 * @author DongChf
	 */
	@Override
	public Long updateAuthBatch(Map<String, String> idsMap, List<SysLabelRelationKey> relationRecords, Long supplieId) {

		Long num = 0l;
		try {
			if (idsMap == null) {
				logger.error("方法[BaseRelationshipService.updateAuthBatch],参数idsMap不可以为空");
				return num;
			}
			if (relationRecords == null) {
				logger.error("方法[BaseRelationshipService.updateAuthBatch],参数relationRecords不可以为null");
				return num;
			}
			if (supplieId == null) {
				logger.error("方法[BaseRelationshipService.updateAuthBatch],参数supplieId不可以为null");
				return num;
			}
			// 1.查询该用户已绑定的渠道 并且渠道类型为"channelUser"
			List<SysLabelRelationKey> findList = findByIds(idsMap);
			if (findList == null || findList.size() == 0) {
				num += insertAuthBatch(relationRecords);
				return num;
			}
			// 根据 supplieId 得到当前用户可以操作的渠道 relBelongMe
			List<SysLabelRelationKey> relBelongMe = new ArrayList<SysLabelRelationKey>();
			for (SysLabelRelationKey key : findList) {
				Long sId = key.getsId();
				if (sId != null && !"".equals(sId)) {
					if (sId.longValue() == supplieId.longValue()) {
						relBelongMe.add(key);
					}
				}
			}
			if (relBelongMe != null && relBelongMe.size() > 0) {
				num += deleteBatchSelective(relBelongMe);
			}
			num += insertAuthBatch(relationRecords);
			return num;
		} catch (NumberFormatException e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@Override
	public Long updateAuthBatchBySupplierIds(Map<String, String> idsMap, List<SysLabelRelationKey> relationRecords,
			List<Long> supplierIds) {
		Long num = 0l;
		try {
			if (idsMap == null) {
				logger.error("方法[ILabelRelationService.updateAuthBatchBySupplierIds],参数idsMap不可以为空");
				return num;
			}
			if (relationRecords == null) {
				logger.error("方法[ILabelRelationService.updateAuthBatchBySupplierIds],参数relationRecords不可以为null");
				return num;
			}
			// 获取 与当前用户集合 旧关系
			List<SysLabelRelationKey> findList = findByIds(idsMap);
			if (findList == null || findList.isEmpty()) {
				num += insertAuthBatch(relationRecords);
				return num;
			}
			// 对比新旧关系列表，找出需要创建的新关系。
			List<SysLabelRelationKey> oldRl = new ArrayList<SysLabelRelationKey>();
			// 创建保存[需要创建的新关系]的列表
			for (SysLabelRelationKey record : findList) {
				if (supplierIds.contains(Long.valueOf(record.getsId()))) {
					oldRl.add(record);
				}
			}
			// 删除可操作的旧关系
			num += deleteBatchSelective(oldRl);
			num += insertAuthBatch(relationRecords);
		} catch (NumberFormatException e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return num;
	}

	@Override
	public List<SysLabelRelationKey> findCURelationByChanneIds(
			List<Long> channelIds) {
		SysLabelRelationKey key = new SysLabelRelationKey();
		key.setQueryObjIds(channelIds);
		key.setRelType(UserGlobalParam.ChannelMapKeyParam.CHANNEL_USER_RELATION_TYPE);
		return findListByParams(key);
	}

	@Override
	public List<SysLabelRelationKey> findByIdListMap(Map<String, Object> idsMap) {
		List<SysLabelRelationKey> lists =  mapper.findByIdListMap(idsMap);
		return lists;
	}

	@Override
	public Integer updateStatusByIds(Integer status, List<Long> ids,Long operId) {
		if(status == null || Check.NuNObject(ids) || ids.size() == 0 || operId == null){
			return 0;
		}
		return mapper.updateStatusByIds(status,ids,operId);
	}
}
