package com.pzj.base.service.sys.cache;

import java.util.List;
import java.util.Map;

import com.pzj.base.common.RedisCacheService;

/**
 * 系统缓存接口
 * @author apple
 *
 */
public interface SysRedisService extends RedisCacheService{

    
    /**
     * 批量存储数据字典,初始化时加载数据
     * @param map
     * @return
     */
    public Boolean addHcode(final Map<String,Map<String,String>> map);
    
    
    /**
     * 通过数据字典类型＋值，查找对象
     * @param dictTypeValue
     * @return
     */
    public String getDictObj(final String dictType,final String value);
    
    
    /**
     * 删除数据字典
     * @param dictType
     * @param value
     * @return
     */
    public Long delDict(final String dictType,final String value);
    
    
    /**
     * put单数据字典到缓存
     * @param dictType
     * @param value
     * @return
     */
    public Long putDict(final String dictType,final String mapKey,final String mapValue);
    
    /**
     * 获取字典类型值的集合
     * @param dictType
     * @return
     */
    public List<Object> dictTypeList(final String dictType);
    
    
}
