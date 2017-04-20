package com.pzj.base.common;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RedisCacheService  {
    
   
    /**
     * 获取value缓存数据
     * @param key
     * @return
     */
    public Object get(Object key);

   
    /**
     * 
     * @param key
     * @param value
     * @param liveTime,过期时间0为无过期时间
     * @return
     */
    public Long put(Object key, Object value,long liveTime);
    
    
    /**
     * 删除缓存
     * @param key
     */
    public Long delKey(Object key);
     
    /**
     * 存入hash－cache
     * @return
     */
    public Long putMapCache(String key,Map<String,String> map,long liveTime);
    
    
    /**
     * 读取hash－cache
     * @return
     */
    public Object getMapCache(String key,String mapkey);

    
    /**
     * 删除缓存hash－cache
     * @param key
     * @param val
     * @return
     */
    public Long delHashCache(String key,String... mapkey);
    
    
   /**
    * 获取map中key集合
    * @param key
    * @return
    */
    public Set<Object> getHashMapkeys(String key);
    
    
    /**
     * 通过key，hashkeys获取所有value
     * @param key
     * @param keys
     * @return
     */
    public List<Object> getHashMapkeys(String key,Set<Object> keys);
    
    
    /**
     * 计数器
     * @return
     */
    public Long incr(String key);
    
}
