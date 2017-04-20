package com.pzj.common;

import java.util.ArrayList;
import java.util.List;

import com.pzj.base.common.BaseVO;

public abstract class BaseVoUtil {

    /**
     * 校验对象重复
     * 
     * @return
     */
    public static <T extends BaseVO> List<T> checkBeanRepetition(List<T> beans) {
        if (beans == null || beans.isEmpty()) {
            return null;
        }
        StringBuffer buff = new StringBuffer();
        List<T> checkdList = new ArrayList<T>();
        for (T bean : beans) {
            Long id = bean.getId();
            if (id == null || buff.indexOf(id + ",") > -1) {
                continue;
            }
            checkdList.add(bean);
        }
        return checkdList;

    }

    /**
     * 获取对象的Id集合
     */
    public static <T extends BaseVO> List<Long> getBeanIdList(List<T> beans) {
        if (beans == null || beans.isEmpty()) {
            return null;
        }
        StringBuffer buff = new StringBuffer();
        List<Long> idList = new ArrayList<Long>();
        for (T bean : beans) {
            Long id = bean.getId();
            if (id == null || buff.indexOf(id + ",") > -1) {
                continue;
            }
            idList.add(id);
        }
        return idList;
    }
}
