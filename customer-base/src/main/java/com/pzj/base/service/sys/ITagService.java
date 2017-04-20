package com.pzj.base.service.sys;

import com.pzj.base.entity.SysTag;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-11-7.
 */
public interface ITagService {
    /**
     * 创建标签
     * @param tag
     * @param serviceContext
     * @return
     */
    Result<Long> createTag(SysTag tag, ServiceContext serviceContext);

    /**
     * 根据ID查询标签
     * @param id
     * @param serviceContext
     * @return
     */
    Result<SysTag> findById(Long id, ServiceContext serviceContext);

    /**
     * 根据名称前缀查询标签
     * @param namePrefix
     * @param serviceContext
     * @return
     */
    Result<ArrayList<String>> findTagNamesByPrefix(String namePrefix, ServiceContext serviceContext);
}
