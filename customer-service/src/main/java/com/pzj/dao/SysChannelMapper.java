package com.pzj.dao;

import java.util.List;
import java.util.Map;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysChannel;
import com.pzj.base.entity.SysUser;
import org.apache.ibatis.annotations.Param;

@MyBatisDao
public interface SysChannelMapper extends BaseUserMapper<SysChannel> {

    List<SysChannel> findListByObjID(Map<String, Object> params);

    int countByObjID(Map<String, Object> params);

    List<SysChannel> findListByRefID(Map<String, Object> params);

    int countByRefID(Map<String, Object> params);

    List<SysChannel> findNotByProductID(Map<String, Object> params);

    int countNotByProductID(Map<String, Object> params);
    
    int countPageSingleTable(Map<String, Object> params);
    List<SysChannel> queryPageSingleTable(Map<String, Object> params);

    /**
     * 查询渠道
     *
     * 如果指定了user参数，就关联sys_label_relation、sys_user表查询，结果是绑定了条件指定用户的渠道。
     * @param sysChannel
     * @param user
     * @param pageModel
     * @return
     */
    List<SysChannel> selectChannelContainUser(@Param("bParam") SysChannel sysChannel, @Param("user")SysUser user, @Param("pParam")PageModel pageModel,@Param("tmpDelIds") List<Long> tmpDelIds,@Param("tmpAddIds") List<Long> tmpAddIds);

    /**
     * 是 selectChannelContainUser 总数据的统计。
     * @param sysChannel
     * @param user
     * @return
     */
    int countChannelContainUser(@Param("bParam") SysChannel sysChannel, @Param("user")SysUser user,@Param("tmpDelIds") List<Long> tmpDelIds,@Param("tmpAddIds") List<Long> tmpAddIds);

	/**
     * countChannelContainNotUser  总数据统计
     * @param sysChannel
     * @param user
     * @param channelIds
     * @return
     */
    int countChannelContainNotUser(@Param("bParam") SysChannel sysChannel, @Param("user")SysUser user,@Param("channelIds") List<Long> channelIds);

	/**
     * 查询用户关联的渠道，根据已关联的not in 未关联的
     * @param sysChannel
     * @param user
     * @param channelIds
     * @return
     */
    List<SysChannel> queryChannelsUserNotJoin(@Param("bParam") SysChannel sysChannel, @Param("user")SysUser user,@Param("pParam")PageModel pageModel,@Param("channelIds") List<Long> channelIds);
}
