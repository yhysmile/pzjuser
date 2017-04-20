package com.pzj.base.service.sys;

import com.pzj.base.entity.SysTag;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Administrator on 2016-11-7.
 */
public interface IUserTagService {
    /**
     * 关联用户与标签名称
     * @param userId
     * @param tags
     * @param serviceContext
     * @return
     */
    Result<Integer> associateUserTagNames(Long userId, Set<String> tags, ServiceContext serviceContext);

    /**
     * 关系用户与标签对象
     * @param userId
     * @param tags
     * @param serviceContext
     * @return
     */
    Result<Integer> associateUserTagIds(Long userId, Set<Long> tags, ServiceContext serviceContext);

    /**
     * 根据用户ID，查询关联了的标签名称
     * @param userId
     * @param serviceContext
     * @return
     */
    Result<ArrayList<String>> findTagNamesByUserId(Long userId, ServiceContext serviceContext);

    /**
     * 根据用户ID，查询关联了的标签对象
     * @param userId
     * @param serviceContext
     * @return
     */
    Result<ArrayList<SysTag>> findTagsByUserId(Long userId, ServiceContext serviceContext);

}
