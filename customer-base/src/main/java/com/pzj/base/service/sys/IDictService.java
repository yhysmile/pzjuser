package com.pzj.base.service.sys;

import java.util.List;

import com.pzj.base.common.BaseService;
import com.pzj.base.entity.SysDict;

/**
 * 字典信息接口
 * 
 * @author apple
 * 
 */
public interface IDictService extends BaseService<SysDict> {
    
    /**
     * 返回字典集合
     * @param dict
     * @return
     */
    public List<SysDict> getDictList(SysDict dict);
    
    
}
