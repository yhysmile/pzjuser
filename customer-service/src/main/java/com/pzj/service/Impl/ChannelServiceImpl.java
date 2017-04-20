package com.pzj.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.common.global.UserGlobalParam;
import com.pzj.base.common.global.UserGlobalParam.ChannelMapKeyParam;
import com.pzj.base.common.utils.PageBean;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysChannel;
import com.pzj.base.entity.SysLabel;
import com.pzj.base.entity.SysLabelRelationKey;
import com.pzj.base.entity.SysUser;
import com.pzj.base.service.sys.IChannelService;
import com.pzj.base.service.sys.ILabelRelationService;
import com.pzj.base.service.sys.ILabelService;
import com.pzj.base.service.sys.IUserService;
import com.pzj.core.customer.commons.exception.CustomerException;
import com.pzj.core.customer.commons.exception.CustomerExceptionCode;
import com.pzj.core.customer.dao.SysChannelMapper;
import com.pzj.core.customer.utils.UserStatusEnum;
import com.pzj.framework.context.Result;
import com.pzj.framework.converter.JSONConverter;
import com.pzj.framework.entity.QueryResult;
import com.pzj.framework.toolkit.Check;

@Service("channelService")
public class ChannelServiceImpl extends BaseUserServiceImpl<SysChannel, SysChannelMapper> implements IChannelService {

	@Autowired
	private ILabelService channelLabelService;

	@Autowired
	private IUserService userService;

	@Autowired
	private ILabelRelationService labelRelationService;

	@Override
	public Long addChannelAndAuth(SysChannel channel, List<SysLabel> channelLabelList) {
		Long channelId = 0l;

		try {
			if (channel == null) {
				logger.error("方法[ChannelService.addChannelAndAuth],参数channel不可以为空");
				return channelId;
			}
			// 新建或更新渠道
			insertOrUpdate(channel);

			channelId = channel.getId();

			if (channelId > 0) {
				// 添加渠道及渠道标签关系
				saveChannelAndChannelLabel(channel, channelLabelList, false);
			}
		} catch (NumberFormatException e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return channelId;
	}

	@Override
	public Long saveChannelAndChannelLabel(SysChannel bean, List<SysLabel> records, boolean isNeedUpdate) {

		Long num = 0l;
		try {
			if (bean == null) {
				logger.error("方法[ChannelService.saveChannelAndAuth],参数channel不可以为空");
				return num;
			}
			if (bean.getId() == null || bean.getId() < 1) {
				logger.error("方法[ChannelService.saveChannelAndAuth],参数channel的id属性不可以为空");
				return num;
			}
			if (records == null || records.isEmpty()) {
				logger.error("方法[ChannelService.saveChannelAndAuth],参数records不可以为空");
				return num;
			}
			// 更新用户
			if (isNeedUpdate) {
				num += updateByPrimaryKey(bean);
			}

			// 新建或更新角色
			num += channelLabelService.insertOrUpdateBatch(records);

			String objId = String.valueOf(bean.getId());
			// 更新渠道及渠道标签关系
			List<SysLabelRelationKey> relationList = new ArrayList<SysLabelRelationKey>();
			for (SysLabel ref : records) {
				Long refId = ref.getId();
				if (ref == null || ref.getId() == null || ref.getId() < 1) {
					continue;
				}
				SysLabelRelationKey key = new SysLabelRelationKey();
				key.setObjId(objId);
				key.setRelId(String.valueOf(refId));
				key.setRelType(ChannelMapKeyParam.CHANNEL_LABEL_RELATION_TYPE);
				relationList.add(key);

			}

			List<SysChannel> list = new ArrayList<SysChannel>();
			list.add(bean);

			Map<String, Object> searchMap = new HashMap<String, Object>();
			searchMap.put(ChannelMapKeyParam.OBJ_MAP_KEY, getIdList(list));
			searchMap.put(ChannelMapKeyParam.RELATION_TYPE_KEY, ChannelMapKeyParam.CHANNEL_LABEL_RELATION_TYPE);
			num += labelRelationService.updateAuthBatchByList(searchMap, relationList);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return num;
	}

	@Override
	public Integer saveChannelAndUser(SysChannel bean, List<SysUser> records, boolean isNeedUpdate) {
		int num = 0;
		try {
			if (bean == null) {
				logger.error("方法[ChannelService.saveChannelAndUser],参数channel不可以为空");
				return num;
			}
			if (bean.getId() == null || bean.getId() < 1) {
				logger.error("方法[ChannelService.saveChannelAndUser],参数channel的id属性不可以为空");
				return num;
			}
			if (records == null || records.isEmpty()) {
				logger.error("方法[ChannelService.saveChannelAndUser],参数records不可以为空");
				return num;
			}
			// 更新用户
			if (isNeedUpdate) {
				num += updateByPrimaryKey(bean);

				// 新建或更新用户
				num += userService.insertOrUpdateBatch(records);
			}

			String objId = String.valueOf(bean.getId());
			// 更新渠道及渠道分销商关系
			List<SysLabelRelationKey> relationList = new ArrayList<SysLabelRelationKey>();
			for (SysUser ref : records) {
				Long refId = ref.getId();
				if (ref == null || ref.getId() == null || ref.getId() < 1) {
					continue;
				}
				SysLabelRelationKey key = new SysLabelRelationKey();
				key.setObjId(objId);
				key.setRelId(String.valueOf(refId));
				key.setRelType(ChannelMapKeyParam.CHANNEL_USER_RELATION_TYPE);
				relationList.add(key);

			}

			List<SysChannel> list = new ArrayList<SysChannel>();
			list.add(bean);

			Map<String, Object> searchMap = new HashMap<String, Object>();
			searchMap.put(ChannelMapKeyParam.OBJ_MAP_KEY, getIdList(list));
			searchMap.put(ChannelMapKeyParam.RELATION_TYPE_KEY, ChannelMapKeyParam.CHANNEL_USER_RELATION_TYPE);
			num += labelRelationService.updateAuthBatchByList(searchMap, relationList);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return num;
	}

	@Override
	public PageList<SysChannel> queryPageByObjId(PageModel pager, SysChannel record, Long objId, String refType) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pParam", pager);
		params.put("bParam", record);
		params.put("idParam", objId);
		params.put(ChannelMapKeyParam.RELATION_TYPE_KEY, refType);
		List<SysChannel> listBean = mapper.findListByObjID(params);
		Integer count = mapper.countByParamMap(params);
		PageBean pageObj = new PageBean(Long.valueOf(count.toString()), pager);
		PageList<SysChannel> pagelist = null;
		pagelist = new PageList<SysChannel>(listBean, pageObj);
		return pagelist;
	}

	@Override
	public PageList<SysChannel> queryPageByRefId(PageModel pager, SysChannel record, Long refId, String refType) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pParam", pager);
		params.put("bParam", record);
		params.put("idParam", refId);
		params.put(ChannelMapKeyParam.RELATION_TYPE_KEY, refType);

		CompatibleDirectChannelHelper.compatibleDirectChannelUserParamForObject(params);

        List<SysChannel> listBean = null;
        Integer count = mapper.countByRefID(params);
        if (count != null && count > 0 ){
            listBean = mapper.findListByRefID(params);
        }
        PageBean pageObj = new PageBean(Long.valueOf(count.toString()), pager);
        PageList<SysChannel> pagelist = null;
        pagelist = new PageList<>(listBean, pageObj);
        return pagelist;
    }

	@Override
	public PageList<SysChannel> queryPageNotByProductId(PageModel pager, SysChannel record, Long productId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pParam", pager);
		params.put("bParam", record);
		params.put("idParam", productId);
		params.put("strategyChannel", ChannelMapKeyParam.STRATEGY_CHANNEL_RELATION_TYPE);
		params.put("strategyProduct", ChannelMapKeyParam.STRATEGY_PROCUDT_RELATION_TYPE);
		List<SysChannel> listBean = mapper.findNotByProductID(params);
		Integer count = mapper.countNotByProductID(params);
		PageBean pageObj = new PageBean(Long.valueOf(count.toString()), pager);
		PageList<SysChannel> pagelist = null;
		pagelist = new PageList<SysChannel>(listBean, pageObj);
		return pagelist;
	}

	@Override
	public PageList<SysChannel> queryPageBySupplierId(PageModel pager, Long supplierId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pParam", pager);
		params.put("bParam", supplierId);
		//简单的根据供应商ID查询渠道信息
		Integer count = mapper.countPageSingleTable(params);
		List<SysChannel> listBean = mapper.queryPageSingleTable(params);
		PageBean pageObj = new PageBean(Long.valueOf(count.toString()), pager);
		PageList<SysChannel> pagelist = null;
		pagelist = new PageList<SysChannel>(listBean, pageObj);
		return pagelist;
	}

	@Override
	public List<SysChannel> queryPageByUserId(PageModel pager, SysChannel param, Long userId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pParam", pager);
		params.put("bParam", param);
		params.put("idParam", userId);
		params.put(ChannelMapKeyParam.RELATION_TYPE_KEY, ChannelMapKeyParam.CHANNEL_USER_RELATION_TYPE);
		List<SysChannel> listBean = mapper.findListByRefID(params);
		return listBean;
	}

	@Override
	public List<SysChannel> findValidChannelsByIds(List<Long> channelIds) {
		List<SysChannel> result = new ArrayList<SysChannel>();
		if (CollectionUtils.isEmpty(channelIds)) {
			return result;
		}
		SysChannel queryParam = new SysChannel();
		queryParam.setDelFlag(GlobalParam.FLAG.start().toString());
		queryParam.setQueryIds(channelIds);
		List<SysChannel> list = findListByParams(queryParam);
		if (CollectionUtils.isNotEmpty(list)) {
			return list;
		}
		return result;
	}

	@Override
	public Result<QueryResult<SysChannel>> queryChannelContainUser(SysChannel channelParam, SysUser distributorParam,
			PageModel pageModel, List<Long> tmpDelIds, List<Long> tmpAddIds) {
		//此处分2步处理，第一步 根据渠道参数和用户id查询用户所有的渠道
		QueryResult<SysChannel> queryResult = new QueryResult<>(pageModel == null ? 1 : pageModel.getPageNo(),
				pageModel == null ? 20 : pageModel.getPageSize());
		SysUser paramUser = new SysUser();
		paramUser.setId(distributorParam.getId());
		List<SysChannel> channelList = mapper.selectChannelContainUser(channelParam, paramUser, null);

		//用户已关联的渠道id集合
		List<Long> channelIds = new ArrayList<>();
		for (SysChannel sysCh : channelList) {
			channelIds.add(sysCh.getId());
		}

		//第二步，根据用户参数 包含联系人，包含公司名称，包含用户手机，查询渠道信息，取第一步的交集

		//在结果集中操作临时生效的
		if (!Check.NuNObject(tmpAddIds)) {
			channelIds.addAll(tmpAddIds);
		}
		if (!Check.NuNObject(tmpDelIds)) {
			channelIds.removeAll(tmpDelIds);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("用户:{},已关联的渠道id集合:{}", distributorParam.getId(), JSONConverter.toJson(channelIds));
		}

		if (Check.NuNObject(channelIds) || channelIds.size() == 0) {
			return new Result<>(queryResult);
		}

		channelParam.setQueryIds(channelIds);
		distributorParam.setId(null);
		int count = mapper.countChannelContainUser(channelParam, distributorParam);
		if (count == 0) {
			return new Result<>(queryResult);
		}
		channelList = mapper.selectChannelContainUser(channelParam, distributorParam, pageModel);
		queryResult.setRecords(channelList);
		queryResult.setTotal(count);
		Result<QueryResult<SysChannel>> resultResult = new Result<>(queryResult);
		return resultResult;
	}

	/**
	 *
	 * @param objectId  如果是渠道管理用户，此处是渠道id，如果是用户管理渠道，此处是用户id
	 * @param addObjectIds 如上
	 * @param delObjectIds 如上
	 * @param operId 操作人id
	 * @param supplierId 供应商id
	 * @param operType 管理类型。渠道管理多个用户的关系，还是用户管理多个渠道的关系
	 * @return
	 */
	public Result<Boolean> modifyChannelUserOwned(Long objectId, List<Long> addObjectIds, List<Long> delObjectIds,
			Long operId, Long supplierId, String operType) {
		//第一步，先获取到新增的关系，有哪些是已存在的，并且将删除的状态改为可用，可用状态的不变。

		boolean channelUser = UserGlobalParam.ChannelMapKeyParam.DIRECT_CHANNEL_USER_TYPE.equals(operType);
		try {
			if (!Check.NuNObject(addObjectIds) && addObjectIds.size() != 0) {
				List<SysLabelRelationKey> relationKeys = getLabelRelations(objectId, addObjectIds, channelUser);
				//已经存在的关系，用于从add集合中remove掉
				List<Long> existObjIds = new ArrayList<>();
				//已经存在的主键id，用于批量修改
				List<Long> existIds = new ArrayList<>();
				if (!Check.NuNObject(relationKeys) && relationKeys.size() != 0) {
					for (SysLabelRelationKey sysLabel : relationKeys) {
						//如果状态为空。或者为禁用。需要加入批量修改的集合中
						if (Check.NuNObject(sysLabel.getStatus()) || sysLabel.getStatus() == 0) {
							existIds.add(sysLabel.getId());
						}
						if (channelUser) {
							existObjIds.add(Long.valueOf(sysLabel.getRelId()));
						} else {
							existObjIds.add(Long.valueOf(sysLabel.getObjId()));
						}
					}
				}

				//这里需要做如下操作
				//1.将禁用的关系改为启用
				if (existIds.size() != 0) {
					Integer updateResult = labelRelationService.updateStatusByIds(UserStatusEnum.AVAILABLE.getStatus(),
							existIds, operId);
					if (updateResult != existIds.size()) {
						throw new CustomerException(CustomerExceptionCode.MODIFY_LABEL_ERROR);
					}
				}

				//2.将已存在的关系从新增集合中去除，并且将剩下的新增
				addObjectIds.removeAll(existObjIds);
				if (addObjectIds.size() != 0) {
					List<SysLabelRelationKey> insertLabels = packagedIntoRelationKeyList(objectId, addObjectIds,
							supplierId, operId, operType);
					Long insertBatch = labelRelationService.insertBatch(insertLabels);
					if (insertBatch != addObjectIds.size()) {
						throw new CustomerException(CustomerExceptionCode.MODIFY_LABEL_ERROR);
					}
				}
			}

			//将删除的关系修改为删除
			if (!Check.NuNObject(delObjectIds)) {
				List<SysLabelRelationKey> delRelationKeys = getLabelRelations(objectId, delObjectIds, channelUser);
				List<Long> delIds = new ArrayList<>();
				for (SysLabelRelationKey delSys : delRelationKeys) {
					delIds.add(delSys.getId());
				}
				Integer updateResult = labelRelationService.updateStatusByIds(UserStatusEnum.DISABLE.getStatus(),
						delIds, operId);
				if (updateResult != delRelationKeys.size()) {
					throw new CustomerException(CustomerExceptionCode.MODIFY_LABEL_ERROR);
				}
			}
		} catch (Exception e) {
			logger.error(
					"管理渠道用户关联关系出错,objectId is " + objectId + "addObjectIds is +" + JSONConverter.toJson(addObjectIds)
							+ "delObjectIds\n is " + JSONConverter.toJson(delObjectIds) + "operId is " + operId
							+ "supplierId is " + supplierId + "operType is " + operType, e);
			throw new CustomerException(CustomerExceptionCode.MODIFY_LABEL_ERROR);
		}
		return new Result<>(true);
	}

	private List<SysLabelRelationKey> getLabelRelations(Long objectId, List<Long> addObjectIds, boolean channelUser) {
		Map<String, Object> idsMap = new HashMap<>();
		List<Long> objIds = new ArrayList<>();
		objIds.add(objectId);
		if (channelUser) {
			idsMap.put(UserGlobalParam.ChannelMapKeyParam.OBJ_MAP_KEY, objIds);
			idsMap.put(UserGlobalParam.ChannelMapKeyParam.REF_MAP_KEY, addObjectIds);
		} else {
			idsMap.put(UserGlobalParam.ChannelMapKeyParam.OBJ_MAP_KEY, addObjectIds);
			idsMap.put(UserGlobalParam.ChannelMapKeyParam.REF_MAP_KEY, objIds);
		}
		idsMap.put(UserGlobalParam.ChannelMapKeyParam.RELATION_TYPE_KEY, ChannelMapKeyParam.DIRECT_CHANNEL_USER_TYPE);
		List<SysLabelRelationKey> relationKeys = labelRelationService.findByIdListMap(idsMap);
		return relationKeys;
	}

	/**
	 * 封装渠道与用户关系
	 * @param objectId
	 * @param objectIds
	 * @param supplierId
	 * @param operId
	 * @param operType
	 * @return
	 */
	private List<SysLabelRelationKey> packagedIntoRelationKeyList(Long objectId, List<Long> objectIds, Long supplierId,
			Long operId, String operType) {

		boolean channelUser = UserGlobalParam.ChannelMapKeyParam.DIRECT_CHANNEL_USER_TYPE.equals(operType);
		List<SysLabelRelationKey> sysLabelRelationKeyList = new ArrayList<>(objectIds.size());
		String objIdStr = objectId.toString();
		for (Long oid : objectIds) {
			if (oid == null) {
				continue;
			}
			SysLabelRelationKey sysLabelRelationKey = new SysLabelRelationKey();
			if (channelUser) {
				sysLabelRelationKey.setObjId(objIdStr);
				sysLabelRelationKey.setRelId(oid.toString());
			} else {
				sysLabelRelationKey.setObjId(oid.toString());
				sysLabelRelationKey.setRelId(objIdStr);
			}

			sysLabelRelationKey.setsId(supplierId);
			sysLabelRelationKey.setRelType(UserGlobalParam.ChannelMapKeyParam.DIRECT_CHANNEL_USER_TYPE);
			sysLabelRelationKey.setCreateBy(operId);

			sysLabelRelationKeyList.add(sysLabelRelationKey);
		}
		return sysLabelRelationKeyList;
	}
}
