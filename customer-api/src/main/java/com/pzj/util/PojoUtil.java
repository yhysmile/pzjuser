package com.pzj.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.pzj.base.common.utils.SubStringUtils;

public class PojoUtil {

    /**
     * 把fromObj对象的属性值传到toObj对象属性名相同的属性值上
     * 
     * @param fromObj
     * @param toObj
     * @throws NoSuchMethodException
     * @throws SecurityException
     */
    public static void copyProperties(Object fromObj, Object toObj)
            throws NoSuchMethodException, SecurityException {

        if (fromObj == null)
            return;
        Field[] fields = fromObj.getClass().getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            String UfieldName = SubStringUtils.captureName(fieldName);
            Method getMethod;
            try {
                getMethod = fromObj.getClass().getMethod("get" + UfieldName,
                        null);
                Object value = getMethod.invoke(fromObj, null);
                if (value != null) {
                    Field userField = toObj.getClass().getDeclaredField(
                            fieldName);
                    if (userField != null) {
                        Method setMethod = toObj.getClass().getMethod(
                                "set" + UfieldName, userField.getType());
                        setMethod.invoke(toObj, value);
                    }
                }

            } catch (Exception e) {
                continue;
            }

        }
    }

    /**
     * 拼接Ids成 IN 查询格式
     * 
     * @param strObj
     * @return
     */
    public static String formatIdsForINQuery(String strObj, String split) {
        if (StringUtils.isBlank(strObj)) {
            return null;
        }
        strObj = strObj.trim();
        strObj = strObj.replaceAll(split, "','");
        strObj = "'" + strObj + "'";
        return strObj;

    }

    /**
     * 将JSON串集合转换成对象集合
     * 
     * @param <E>
     * 
     * @return
     */
    public static <E> List<E> cacheObjToE(List<Object> objList, Class<E> e) {
        if (objList == null || objList.isEmpty()) {
            return null;
        }
        List<E> list = Lists.newArrayList();
        for (Object obj : objList) {
            E bean = JSON.toJavaObject(JSON.parseObject(obj.toString()), e);
            list.add(bean);
        }
        return list;
    }

}
