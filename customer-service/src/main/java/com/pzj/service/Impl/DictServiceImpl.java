package com.pzj.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pzj.base.common.impl.BaseServiceImpl;
import com.pzj.base.entity.SysDict;
import com.pzj.base.service.sys.IDictService;
import com.pzj.dao.SysDictMapper;

/**
 * 字典表实现类
 * @author apple
 *
 */
@Service("dictService")
public class DictServiceImpl extends BaseServiceImpl<SysDict, SysDictMapper>
        implements IDictService {

    /**
     * 查询字典集合实现方法
     */
    @Override
    public List<SysDict> getDictList(SysDict dict) {
        List<SysDict> dictList=mapper.selectAllObj(dict);
        return dictList;
    }
    
    

}
