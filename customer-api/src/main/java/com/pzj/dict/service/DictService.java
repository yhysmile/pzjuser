package com.pzj.dict.service;

import java.util.List;

import com.pzj.dict.entity.Dict;

/**
 * 系统日志接口
 * 
 * @author huxn
 * @mail huxiaona@mftour.cn
 * @date 2015-11-24 下午17:05：23
 * 
 */
public interface DictService {

    /**
     * 初始化字典表
     * 
     * @return
     */
    public Boolean inItDict() throws Exception;

    /**
     * 创建数据字典
     * 
     * @param dict
     *            数据字典实体
     */
    Long createDict(Dict dict) throws Exception;

    /**
     * 创建渠道类型数据字典
     * 
     */
    Long createChannelDict(Dict dict) throws Exception;

    boolean modifyChannelDict(Dict dict) throws Exception;

    /**
     * 编辑保存数据字典
     * 
     * @param dict
     *            数据字典实体
     */
    Long saveDict(Dict dict) throws Exception;

    /**
     * 按照类型获取对应的集合
     */
    public List<Dict> getListByType(String type) throws Exception;

    /**
     * 根据条件查询字典
     * @param param
     * @return
     * @throws Exception
     */
    List<Dict> getListByParams(Dict param) throws Exception;

    /**
     * 根据类型和字典值获取对应的详情
     * 
     * @param val
     *            字典值
     * @param type
     *            字典类型
     * @return
     */
    public Dict getByVal(String val, String type) throws Exception;

}
