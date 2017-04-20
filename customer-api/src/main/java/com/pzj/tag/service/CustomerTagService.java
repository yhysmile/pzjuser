package com.pzj.tag.service;

import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;
import com.pzj.tag.entity.Tag;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Administrator on 2016-11-7.
 */
public interface CustomerTagService {
    /**
     * 关联用户与标签名称
     *
     * @param customerId
     * @param tags
     * @param serviceContext
     * @return
     */
    Result<Integer> associateCustomerTagNames(Long customerId, Set<String> tags, ServiceContext serviceContext);

    /**
     * 关系用户与标签对象
     * @param customerId
     * @param tags
     * @param serviceContext
     * @return
     */
    Result<Integer> associateCustomerTagIds(Long customerId, Set<Long> tags, ServiceContext serviceContext);

    /**
     * 根据用户ID，查询关联了的标签名称
     * @param customerId
     * @param serviceContext
     * @return
     */
    Result<ArrayList<String>> findTagNamesByCustomerId(Long customerId, ServiceContext serviceContext);

    /**
     * 根据用户ID，查询关联了的标签对象
     * @param customerId
     * @param serviceContext
     * @return
     */
    Result<ArrayList<Tag>> findTagsByCustomerId(Long customerId, ServiceContext serviceContext);
}
