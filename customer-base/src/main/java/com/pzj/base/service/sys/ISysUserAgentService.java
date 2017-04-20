package com.pzj.base.service.sys;

import com.pzj.base.entity.SysUser;
import com.pzj.base.entity.SysUserAgent;

import java.util.List;

/**
 * 用户与代理人关系
 * 
 * @author dongchunfu
 * @email dongchunfu@mftour.cn
 * @date 2016-3-30 上午10:08:01
 */
public interface ISysUserAgentService extends
        IBaseRelationshipService<SysUserAgent> {

    /**
     * 保存用户与代理人关系
     * <p/>
     * 相应地会删除旧关系。
     * @param userAgentList
     */
    void saveUserAgent(List<SysUserAgent> userAgentList);

    /**
     * 查询代理商信息
     * <p/>
     * 可根据SysUserAgent中的userId或agentId查询代理人信息。
     * 可根据主用户信息作为条件查询代理人信息。
     * @param usag
     * @param masterUser
     * @return
     */
    List<SysUser> findAgentByParams(SysUserAgent usag, SysUser masterUser);
}
