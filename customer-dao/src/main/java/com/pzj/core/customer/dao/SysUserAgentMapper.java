package com.pzj.core.customer.dao;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.SysUser;
import com.pzj.base.entity.SysUserAgent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatisDao
public interface SysUserAgentMapper extends BaseRelationshipMapper<SysUserAgent> {
    /**
     * 查询代理商信息
     * <p/>
     * 可根据SysUserAgent中的userId或agentId查询代理人信息。
     * 可根据主用户信息作为条件查询代理人信息。
     * @param usag
     * @param masterUser
     * @return
     */
    List<SysUser> selectAgentByParams(@Param("usag") SysUserAgent usag, @Param("user") SysUser masterUser);

    /**
     * 查询主用户信息
     * <p/>
     * 可根据SysUserAgent中的userId或agentId查询主用户信息。
     * 可根据主用户信息作为条件查询主用户信息。
     * @param usag
     * @param masterUser
     * @return
     */
    List<SysUser> selectUserByParams(@Param("usag") SysUserAgent usag, @Param("user") SysUser masterUser);
}