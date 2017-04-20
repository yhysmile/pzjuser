package com.pzj.base.service.sys;

import java.util.List;

import com.pzj.base.entity.SysUserOfficeKey;

/**
 * 权限接口
 * 
 * @author huxiaona
 * @email huxiaona@mftour.cn
 * @date 2015-9-11 上午11:13:01
 */
public interface IUserAuthOfficeService extends
        IBaseRelationshipService<SysUserOfficeKey> {

    public Long deleteBatchByPrimaryKey(List<SysUserOfficeKey> recordList);
}
