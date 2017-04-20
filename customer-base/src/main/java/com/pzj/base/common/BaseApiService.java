package com.pzj.base.common;

import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;

public interface BaseApiService<V extends BaseVO> {

	/**
	 * 创建，返回对象主键
	 * 
	 * @param vo
	 * @return
	 */
	Long create(V vo) throws Exception;

	/**
	 * 更新，返回影响记录条数
	 * 
	 * @param vo
	 * @return
	 */
	 Integer update(V vo) throws Exception;

	/**
	 * 逻辑删除数据
	 * 
	 * @param id
	 * @return 返回影响记录条数
	 */
	// public int changeStatus(V vo) throws Exception;

	/**
	 * 通过id获取对象
	 * 
	 * @param id
	 * @return 返回对象
	 */
	V getById(Long id) throws Exception;

	/**
	 * 分页查询
	 * 
	 * @param pager
	 *            分页、排序对象
	 * 
	 * @param vo
	 *            查询条件
	 * @return 返回PageList<V>队形
	 */
	PageList<V> queryPageByParamMap(PageModel pager, V vo) throws Exception;

}
