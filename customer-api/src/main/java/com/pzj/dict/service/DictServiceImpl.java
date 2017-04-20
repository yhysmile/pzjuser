package com.pzj.dict.service;

import java.util.List;
import java.util.Map;

import com.pzj.base.common.global.KeyParam;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.pzj.base.common.global.GlobalDict;
import com.pzj.base.common.global.UserGlobalDict.ChannelGlobalDict;
import com.pzj.base.entity.SysDict;
import com.pzj.base.service.sys.IDictService;
import com.pzj.base.service.sys.cache.SysRedisService;
import com.pzj.base.service.sys.cache.UserRedisService;
import com.pzj.dict.entity.Dict;
import com.pzj.util.PojoUtil;

@Service
public class DictServiceImpl implements DictService {

    // 创建日志对象
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IDictService idictService;

    @Autowired
    private UserRedisService userRedisService = null;

    @Autowired
    private SysRedisService sysRedisService = null;

    /**
     * 创建数据字典
     * 
     * @param dict
     *            数据字典实体
     */
    public Long createDict(Dict dict) throws Exception {
        if (dict == null)
            return 0l;
        SysDict sysDict = Dict.createNewSysDict(dict);
        Long id = idictService.insert(sysDict);
        dict.setId(id);

        // 放入缓存
        String dictJson = JSONObject.toJSONString(dict);
        sysRedisService.putDict(dict.getType(), dict.getValue(), dictJson);

        return id;
    }

    /**
     * 编辑保存数据字典
     * 
     * @param dict
     *            数据字典实体
     */
    public Long saveDict(Dict dict) throws Exception {
        if (dict == null)
            return 0l;
        if (dict.getId() == null)
            return 0l;
        SysDict sysDict = Dict.createNewSysDict(dict);
        Long num = idictService.insertOrUpdate(sysDict);

        // 放入缓存
        sysDict = idictService.getById(num);

        if (null != sysDict) {
            dict = Dict.sysDict2Dict(sysDict);
            String dictJson = JSONObject.toJSONString(dict);
            sysRedisService.putDict(dict.getType(), dict.getValue(), dictJson);
        }

        return num;
    }

    public Long createChannelDict(Dict dict) throws Exception {
        Long id = 0l;
        if (dict == null)
            return 0l;

        String dictModel = dict.getType();
        if (StringUtils.isBlank(dictModel))
            return 0l;

        if (ChannelGlobalDict.channelTypeKey().equals(
                dictModel + GlobalDict.INCR)) {
            if (sysRedisService.get(ChannelGlobalDict.channelTypeKey()) == null) {
                sysRedisService.put(ChannelGlobalDict.channelTypeKey(), "1000",
                        0l);
            }
            Long value = userRedisService.incr(ChannelGlobalDict
                    .channelTypeKey());
            dict.setValue(String.valueOf(value));
            SysDict sysDict = Dict.createNewSysDict(dict);
            id = idictService.insert(sysDict);
            dict.setId(id);

            // 放入缓存
            String dictJson = JSONObject.toJSONString(dict);
            sysRedisService.putDict(dict.getType(), dict.getValue(), dictJson);
        }

        return id;

    }

    public boolean modifyChannelDict(Dict dict) throws Exception {
        if (dict == null) {
            return false;
        }

        if (dict.getId() == null){
            Object dictValue = sysRedisService.getMapCache(ChannelGlobalDict.ChannelTypeDPT(), dict.getValue());

            if (dictValue == null && dictValue instanceof String)
                return false;

            String dictJson = (String)dictValue;
            Dict dictCache = JSON.parseObject(dictJson, Dict.class);

            if (dictCache == null || dictCache.getId() == null)
                return false;

            dict.setId(dictCache.getId());
        }

        dict.setType(ChannelGlobalDict.ChannelTypeDPT());
        SysDict sysDict = Dict.changeTSysDict(dict);
        idictService.updateByPrimaryKey(sysDict);

        sysDict = idictService.getById(sysDict.getId());
        dict = Dict.sysDict2Dict(sysDict);
        // 放入缓存
        String dictJson = JSONObject.toJSONString(dict);
        sysRedisService.putDict(dict.getType(), dict.getValue(), dictJson);

        return true;
    }

    @Override
    public Boolean inItDict() throws Exception {

        Map<String, List<SysDict>> map = Maps.newHashMap();
        Map<String, Map<String, String>> mapCache = Maps.newHashMap();

        List<SysDict> dictList = idictService.getDictList(null);// 获取字典表集合
        if (!dictList.isEmpty() && dictList.size() > 0) {
            SysDict dictType = new SysDict();
            for (SysDict dict : dictList) {
                dictType.setType(dict.getType());
                List<SysDict> list = idictService.getDictList(dictType);
                if (!map.containsKey(dict.getType())) {
                    map.put(dict.getType(), list);
                }
            }

            // 二次处理map结构
            if (!map.isEmpty()) {

                Map<String, String> hashValueMap = null;
                for (Map.Entry<String, List<SysDict>> entity : map.entrySet()) {
                    hashValueMap = Maps.newHashMap();
                    for (SysDict dict : entity.getValue()) {
                        String dictJson = JSONObject.toJSONString(dict);
                        hashValueMap.put(dict.getValue(), dictJson);
                    }
                    mapCache.put(entity.getKey(), hashValueMap);
                }
            }

        }
        return sysRedisService.addHcode(mapCache);
    }

    /**
     * 根据数据字典类型获取数据字典列表
     * 
     * @param type
     *            数据字典类型
     * @throws Exception
     */
    public List<Dict> getListByType(String type) throws Exception {
        List<Dict> list = null;
        if (StringUtils.isBlank(type)) {
            return list;
        }
        List<Object> dictJsonList = sysRedisService.dictTypeList(type);
        if (dictJsonList != null && !dictJsonList.isEmpty()) {
            list = PojoUtil.cacheObjToE(dictJsonList, Dict.class);
        } else {
            SysDict entity = new SysDict();
            entity.setType(type);
            List<SysDict> sysList = idictService.findListByParams(entity);
            if (sysList == null || sysList.isEmpty()) {
                return list;
            }
            list = Dict.sList2CList(sysList);

            // 数据字典放入缓存
            Map<String, Map<String, String>> mapCache = Maps.newHashMap();
            Map<String, String> hashValueMap = Maps.newHashMap();
            for (SysDict dict : sysList) {
                String dictJson = JSONObject.toJSONString(dict);
                hashValueMap.put(dict.getValue(), dictJson);

            }
            mapCache.put(type, hashValueMap);
            sysRedisService.addHcode(mapCache);
        }
        // 对数据字典进行排序
        if (list != null) {
            list = DictUtil.compareDict(list);
        }

        return list;
    }

    @Override
    public List<Dict> getListByParams(Dict param) throws Exception {
        if (null == param)
            return null;

        SysDict entity = Dict.changeTSysDict(param);
        List<SysDict> sysList = idictService.findListByParams(entity);
        if (sysList != null && !sysList.isEmpty()) {
            List<Dict> list = Dict.sList2CList(sysList);
            return list;
        }

        return null;
    }

    /**
     * 根据数据字典类型和数据字典值，获取数据字典
     * 
     * @throws Exception
     * 
     */
    public Dict getByVal(String val, String type) throws Exception {
        Dict dict = null;
        if (StringUtils.isBlank(val) || StringUtils.isBlank(type)) {
            return dict;
        }
        String dictJson = sysRedisService.getDictObj(type, val);
        if (dictJson != null) {
            dict = JSON.toJavaObject(JSON.parseObject(dictJson), Dict.class);
        } else {
            SysDict sysBean = new SysDict();
            sysBean.setType(type);
            sysBean.setValue(val);
            List<SysDict> dictList = idictService.findListByParams(sysBean);
            if (dictList != null && !dictList.isEmpty()) {
                dict = Dict.sysDict2Dict(dictList.get(0));

                // 放入缓存
                String json = JSONObject.toJSONString(dict);
                sysRedisService.putDict(dict.getType(), dict.getValue(), json);

            }
        }
        return dict;
    }
}
