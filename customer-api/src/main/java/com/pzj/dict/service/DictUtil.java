package com.pzj.dict.service;

import java.util.LinkedList;
import java.util.List;

import com.pzj.dict.entity.Dict;
import org.springframework.stereotype.Component;

public class DictUtil {

    /**
     * 排序 sort从小到大
     * 
     */
    public static List<Dict> compareDict(List<Dict> dictList) {
        List<Dict> returnDict = new LinkedList<Dict>();
        if (dictList == null || dictList.isEmpty()) {
            return null;
        }
        for (Dict dict : dictList) {
            Long value = null;
            if(dict.getSort() == null){
                value = dict.getId();
            }else{
                value = Long.valueOf(dict.getSort());
            }
            if (returnDict.isEmpty()) {
                returnDict.add(dict);
            } else {
                boolean hasAdd = false;
                for (int i = 0; i < returnDict.size(); i++) {
                    Dict vo = returnDict.get(i);
                    Long compareValue = null;
                    if(vo.getSort() == null){
                        compareValue = vo.getId();
                    }else{
                        compareValue = Long.valueOf(vo.getSort());
                    }
                    if ( value< compareValue) {
                        returnDict.add(i, dict);
                        hasAdd = true;
                        break;
                    }
                }
                if(!hasAdd){
                    returnDict.add(dict);
                }
            }
        }
        
        return returnDict;
    }

}
