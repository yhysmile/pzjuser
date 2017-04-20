package com.pzj.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pzj.base.common.BaseEntity;
import com.pzj.base.common.impl.BaseServiceImpl;
import com.pzj.base.common.utils.PageBean;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.service.sys.IBaseUserService;
import com.pzj.dao.BaseUserMapper;

public abstract class BaseUserServiceImpl<T extends BaseEntity, E extends BaseUserMapper<T>>
		extends BaseServiceImpl<T, E> implements IBaseUserService<T> {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 通过Id集合获取对象集合
	 */
	public List<T> findByIds(Map<String, String> idsMap) {
		List<T> list = null;
		try {
			list = mapper.findByIdsMap(idsMap);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}

		return list;
	}

	/**
	 * 根据主键集合列表查询实体列表
	 * 
	 * @param idsMap
	 * 
	 * @return 主键集合
	 * 
	 */
	public List<T> findByIdList(Map<String, Object> idsMap) {
		List<T> list = null;
		try {
			list = mapper.findByIdList(idsMap);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}

		return list;
	}

	public Long insertOrUpdateBatch(List<T> records) {
		List<T> insertList = new ArrayList<T>();
		List<T> updateList = new ArrayList<T>();
		Long num = 0l;
		try {
			if (records == null || records.isEmpty()) {
				logger.error("方法[BaseUserService.insertOrUpdateBatch],参数records不可以为空");
				return num;
			}
			for (T record : records) {
				Long id = record.getId();
				if (id == null || id < 1) {
					insertList.add(record);
				} else {
					updateList.add(record);
				}
			}
			if (insertList != null && !insertList.isEmpty()) {
				logger.debug("id 为空，批量执行新增");

				if (idGenerater != null){
					for (T entity : records)
						entity.setId(idGenerater.nextId());
				}
				num += mapper.insertBatch(insertList);
			}
			if (updateList != null && !updateList.isEmpty()) {
				logger.debug("id 不为空，批量执行更新");
				num += mapper.updateBatchByPrimaryKey(updateList);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}

		return num;
	}

	public String getIds(List<T> records) {
		if (records == null || records.isEmpty()) {
			return "";
		}
		StringBuffer buff = new StringBuffer();
		for (T record : records) {
			Long id = record.getId();
			if (id != null && (buff.indexOf(id + ",") < 0)) {
				buff.append(id).append(",");
			}

		}
		return buff.substring(0, buff.length() - 1);
	}

	public List<Long> getIdList(List<T> records) {
		if (records == null || records.isEmpty()) {
			return null;
		}
		List<Long> list = new ArrayList<Long>();
		StringBuffer buff = new StringBuffer();
		for (T record : records) {
			Long id = record.getId();
			if (id != null && (buff.indexOf(id + ",") < 0)) {
				buff.append(id).append(",");
				list.add(id);
			}

		}
		return list;
	}

	public PageList<T> queryPageByParamMap(PageModel pager, T entity, String sql) {
		if (pager == null) {
			String msg = "参数page不可以为空";
			logger.error(msg);
			return null;
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pParam", pager);
		params.put("bParam", entity);
		params.put("sql", sql);

		List<T> listBean = mapper.queryByParamMap(params);
		Integer count = mapper.countByParamMap(params);

		PageBean pageObj = new PageBean(Long.valueOf(count.toString()), pager);
		PageList<T> pagelist = null;
		pagelist = new PageList<T>(listBean, pageObj);
		return pagelist;

	}

	/**
	 * 将实体map转为list
	 * 
	 */
	public List<T> map2Alllist(Map<String, List<T>> records) {
		if (records == null || records.isEmpty()) {
			return null;
		}
		List<T> returnList = new ArrayList<T>();
		StringBuffer buff = new StringBuffer();
		for (Entry<String, List<T>> record : records.entrySet()) {
			List<T> list = record.getValue();
			if (list == null || list.isEmpty()) {
				continue;
			}
			for (T entity : list) {
				Long id = entity.getId();
				if (buff.indexOf(id + ",") < 0) {
					returnList.add(entity);
					buff.append(id).append(",");
				}
			}

		}
		return returnList;
	}

	
}
