package com.pzj.base.service.sys;

import java.util.List;
import java.util.Map;

import com.pzj.base.entity.SysLabelRelationKey;

public interface ILabelRelationService extends IBaseRelationshipService<SysLabelRelationKey> {
    /**
     *
     * @param key
     * @return
     */
    List<SysLabelRelationKey> findByRelation(SysLabelRelationKey key);

    /**
     * 保存用户与售票点关系
     * @param objId
     * @param relIds
     * @return
     */
    int saveUserTicket(Long objId, List<Long> relIds);

    /**
     * 将对象ID与引用对象ID保存关系
     *
     * @param objId 对象ID
     * @param relIds 引用对象ID集合
     * @param relType 关系类型
     * @return
     */
    int save(Long objId, List<Long> relIds, String relType);

    /**
     * 创建关系集合
     * @param objId
     * @param relIds
     * @param relType
     * @return
     */
    List<SysLabelRelationKey> createRelationList(Long objId, List<Long> relIds, String relType);
    /**
     * @author DongChf
     * 根据供应商的ID来维护对应的用户与渠道的关系
     */
    Long updateAuthBatch(Map<String, String> idsMap, List<SysLabelRelationKey> relationRecords ,Long supplieId);
    /**
     * @author DongChf
     * 根据供应商的ID 批量 维护对应的用户与渠道的关系
     */
    Long updateAuthBatchBySupplierIds(Map<String, String> idsMap, List<SysLabelRelationKey> relationRecords, List<Long> supplierIds);

    /**
     * 根据渠道id获取用户渠道关系集合
     * @param channelIds
     * @return
     */
    List<SysLabelRelationKey> findCURelationByChanneIds(List<Long> channelIds);

	/**
     * 根据渠道ids、用户ids、rel_type 进行查询，
     * @param idsMap
     * @return
     */
    List<SysLabelRelationKey> findByIdListMap(Map<String, Object> idsMap);

    Integer updateStatusByIds(Integer status,List<Long> ids,Long updateBy);




}
