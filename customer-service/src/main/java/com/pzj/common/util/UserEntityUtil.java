package com.pzj.common.util;

import java.util.ArrayList;
import java.util.List;

import com.pzj.base.common.BaseEntity;

public class UserEntityUtil {

    public static <T extends BaseEntity> List<Long> getEntityIdList(List<T> entityList) {
        if (entityList == null) {
            return null;
        }
        List<Long> returnList = new ArrayList<Long>();
        for (T t : entityList) {
            Long id = t.getId();
            if (id == null) {
                continue;
            }
            returnList.add(id);
        }
        return returnList;
    }

}
