package com.pzj.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class KeyValueVo implements Serializable {
    private String key;
    private String value;
    
    public KeyValueVo(){}
    
    public KeyValueVo(String key, String value){
    	this.key = key;
    	this.value = value;
    }
    
    

    /**
     * 获取key
     * 
     * @return key key
     */
    public String getKey() {
        return key;
    }

    /**
     * 设置key
     * 
     * @param key
     *            key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * 获取value
     * 
     * @return value value
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置value
     * 
     * @param value
     *            value
     */
    public void setValue(String value) {
        this.value = value;
    }

    public static String getString(List<KeyValueVo> list) {
        if (list == null || list.isEmpty())
            return null;
        StringBuffer rules = new StringBuffer();
        for (KeyValueVo vo : list) {
            if (StringUtils.isBlank(vo.getKey()))
                continue;
            if (StringUtils.isBlank(vo.getValue()))
                continue;
            rules.append(vo.getKey()).append("#").append(vo.getValue()).append(",");
        }
        String str = rules.toString();
        if (!str.isEmpty()) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    public static String getString(KeyValueVo vo) {
        if (vo == null || StringUtils.isBlank(vo.getKey()) || StringUtils.isBlank(vo.getValue())) {
            return null;
        }
        return vo.getKey() + "#" + vo.getValue();
    }

    public static List<KeyValueVo> getList(String str) {
        if (StringUtils.isBlank(str))
            return null;
        List<KeyValueVo> list = new ArrayList<KeyValueVo>();
        String[] rules = str.split(",");
        for (String s : rules) {
            String[] vo = s.split("#");
            if (vo != null && vo.length == 2) {
                KeyValueVo key = new KeyValueVo();
                key.setKey(vo[0]);
                key.setValue(vo[1]);
                list.add(key);
            }

        }
        return list;
    }

}
