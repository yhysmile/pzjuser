package com.pzj.base.common.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.pzj.base.common.BaseEntity;
import com.pzj.base.common.BaseMapper;
import com.pzj.base.common.BaseService;
import com.pzj.base.common.utils.PageBean;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.framework.idgen.IDGenerater;

public abstract class BaseServiceImpl<T extends BaseEntity, E extends BaseMapper<T>> implements BaseService<T> {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected E mapper;

	@Autowired(required = false)
	protected IDGenerater idGenerater;

	@Override
	public Long insert(T entity) {
		if (entity == null) {
			String msg = "操作数据对象不可以为空";
			logger.error(msg);
			return null;
		}

		if (idGenerater != null) {
			entity.setId(idGenerater.nextId());
		}

		logger.debug("插入对象：{}", entity);
		mapper.insert(entity);
		return entity.getId();
	}

	@Override
	public Integer updateByPrimaryKey(T entity) {
		Integer num = 0;
		if (entity == null || entity.getId() == null) {
			String msg = "操作数据不可以为空";
			logger.error(msg);
			return num;
		}
		logger.info("更新对象：{}", entity);

		//        Boolean isNeedUpdateNull = entity.getIsNeedUpdateNull();
		//        if (isNeedUpdateNull != null && isNeedUpdateNull.booleanValue()) {
		//            num = mapper.updateAllByPrimaryKey(entity);
		//        } else {
		//            num = mapper.updateByPrimaryKey(entity);
		//        }
		num = mapper.updateByPrimaryKey(entity);
		return num;
	}

	@Override
	public Long insertOrUpdate(T entity) {
		if (entity == null) {
			String msg = "操作数据对象不可以为空";
			logger.error(msg);
			return null;
		}
		if (entity.getId() != null) {
			logger.debug("id 不为空，执行更新");
			this.updateByPrimaryKey(entity);
		} else {
			logger.debug("id 为空，执行插入");

			if (idGenerater != null) {
				entity.setId(idGenerater.nextId());
			}
			this.insert(entity);
		}
		return entity.getId();
	}

	@Override
	public Integer delete(Long id) {
		if (id == null) {
			String msg = "id不可以为空";
			logger.error(msg);
			return null;
		}
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public T getById(Long id) {
		if (id == null) {
			String msg = "id不可以为空";
			logger.error(msg);
			return null;
		}
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public PageList<T> queryPageByParamMap(PageModel pager, T entity) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pParam", pager);
		params.put("bParam", entity);
		List<T> listBean = mapper.queryByParamMap(params);
		Integer count = mapper.countByParamMap(params);
		PageBean pageObj = new PageBean(Long.valueOf(count.toString()), pager);
		PageList<T> pagelist = null;
		pagelist = new PageList<T>(listBean, pageObj);
		return pagelist;
	}

	@Override
	public List<T> findListByParams(T entity) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bParam", entity);
		List<T> listBean = mapper.queryByParamMap(params);
		return listBean;
	}

	@Override
	public Long insertBatch(List<T> entityList) {
		if (entityList == null || entityList.isEmpty()) {
			String msg = "操作数据集合不可以为空";
			logger.error(msg);
			return null;
		}
		logger.debug("批量插入对象：{} 条", entityList.size());

		if (idGenerater != null) {
			for (T entity : entityList) {
				entity.setId(idGenerater.nextId());
			}
		}
		Long insertBatch = mapper.insertBatch(entityList);
		BigDecimal de = new BigDecimal(insertBatch);
		return de.longValue();
	}

	@Override
	public Integer updateBatchByPrimaryKey(List<T> entityList) {
		if (entityList == null || entityList.isEmpty()) {
			String msg = "操作数据集合不可以为空";
			logger.error(msg);
			return null;
		}
		logger.debug("批量更新对象：{} 条", entityList.size());
		Integer update = mapper.updateBatchByPrimaryKey(entityList);
		if (update == 1)
			return entityList.size();
		return update;
	}

	@Override
	public Long insertOrUpdateBatch(List<T> entityList) {
		Long num = 0l;
		try {
			if (entityList == null || entityList.isEmpty()) {
				String msg = "操作数据集合不可以为空";
				logger.error(msg);
				return num;
			}
			List<T> insertList = new ArrayList<T>();
			List<T> updateList = new ArrayList<T>();
			for (T pr : entityList) {
				Long id = pr.getId();
				if (id == null) {
					insertList.add(pr);
				} else {
					updateList.add(pr);
				}
			}
			if (!insertList.isEmpty()) {
				num += insertBatch(insertList);
				logger.debug("批量插入对象：{} 条", insertList.size());
			}
			if (!updateList.isEmpty()) {
				num += updateBatchByPrimaryKey(updateList);
				logger.debug("批量更新对象：{} 条", updateList.size());
			}
			return num;

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			throw e;
		}

	}

	/**
	 * 将实体集合转换为以主键为key的map集合
	 * 
	 * @param entityList
	 * @return
	 */
	@Override
	public Map<String, T> listTMap(List<T> entityList, String regx) {
		if (entityList == null) {
			String msg = "操作数据集合不可以为空";
			logger.error(msg);
			return null;
		}

		Map<String, T> map = new HashMap<String, T>();
		for (T record : entityList) {
			Long id = record.getId();
			String key = "";
			if (id != null) {
				key = String.valueOf(id);
			}

			if (StringUtils.isNotBlank(key) && !map.containsKey(record)) {
				map.put(key, record);
			}
		}
		return map;
	}

	public IDGenerater getIdGenerater() {
		return idGenerater;
	}

	public void setIdGenerater(IDGenerater idGenerater) {
		this.idGenerater = idGenerater;
	}
}
