package com.pzj.base.service.sys;

import java.util.List;
import java.util.Map;

import com.pzj.base.common.BaseEntity;
import com.pzj.base.common.BaseService;

public interface IBaseRelationshipService<T extends BaseEntity> extends BaseService<T> {

	/**
	 * 根据主键集合串Ids查询关系信息
	 * 
	 * @param idsMap
	 * 
	 */
	public List<T> findByIds(Map<String, String> idsMap);

	public List<T> findByIdList(Map<String, Object> idsMap);

	public Long deleteBatchSelective(List<T> recordList);

	public Long deleteByIds(Map<String, String> idsMap);

	public Long delAuthBatch(List<T> records);

	public Long insertAuthBatch(List<T> records);

    public Long delAuthBatch(List<T> records, boolean syncOtherRelation);

    public Long insertAuthBatch(List<T> records, boolean syncOtherRelation);


	/**
	 * <h3>将关系转换为唯一的字符串形式</h3>
	 * <p>
	 *     关系对旬中必须存在关系双方的id，用分隔符连接成字符串。分隔符为null时，默认为“,”。
	 * 比如分隔符为“,”号，一方id为5，另一方id为8，则转化为“5,8”返回。
	 * </p>
	 * <p>
	 *     由于关系类没有将相同的部分抽象出来，比如获取关系方的id的方法，所以子类需要实现使用
	 * 相应的关系类的方法实现本方法的业务。
	 * </p>
	 * @param record 关系对旬
	 * @param regx 分隔符，默认为“,”
	 * @return
	 */
	public String genMapKey(T record, String regx);

	public Map<String, String> getRelationIds(List<T> records);

	/**
	 * <h3>通用的合并多对多关系</h3>
	 * <p>关系是允许多对多的，合并不同的关系：
	 * <ul>
	 *     <li>如果新关系列表中有数据库中不存在的关系，则创建关系；</li>
	 *     <li>如果新关系列表中有数据库中存在的关系，则不作任何操作；</li>
	 *     <li>如果数据库中有新关系列表中不存在的关系，则删除关系。</li>
	 * </ul>
	 * </p>
	 * @param idsMap
	 * @param relationRecords
	 * @return
	 */
	public Long updateAuthBatch(Map<String, String> idsMap, List<T> relationRecords);
	
    public Long updateAuthBatch(Map<String, String> idsMap, List<T> relationRecords, boolean syncOtherRelation);

	public Long updateAuthBatchByList(Map<String, Object> idsMap, List<T> relationRecords);

    public Long updateAuthBatchByList(Map<String, Object> idsMap, List<T> relationRecords, boolean syncOtherRelation);
}
