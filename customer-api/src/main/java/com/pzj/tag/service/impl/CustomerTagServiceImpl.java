package com.pzj.tag.service.impl;

import com.pzj.base.entity.SysTag;
import com.pzj.base.service.sys.IUserTagService;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;
import com.pzj.framework.toolkit.Check;
import com.pzj.tag.entity.Tag;
import com.pzj.tag.entity.TagBuilder;
import com.pzj.tag.service.CustomerTagService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2016-11-7.
 */
@Service
public class CustomerTagServiceImpl implements CustomerTagService {
    private TagBuilder tagBuilder = TagBuilder.ATagBuilder;

    @Resource
    private IUserTagService userTagService;

    @Override
    public Result<Integer> associateCustomerTagNames(Long customerId, Set<String> tags, ServiceContext serviceContext) {
        Result<Integer> result = userTagService.associateUserTagNames(customerId, tags, serviceContext);
        return result;
    }

    @Override
    public Result<Integer> associateCustomerTagIds(Long customerId, Set<Long> tags, ServiceContext serviceContext) {
        Result<Integer> result = userTagService.associateUserTagIds(customerId, tags, serviceContext);
        return result;
    }

    @Override
    public Result<ArrayList<String>> findTagNamesByCustomerId(Long customerId, ServiceContext serviceContext) {
        Result<ArrayList<String>> result = userTagService.findTagNamesByUserId(customerId, serviceContext);
        return result;
    }

    @Override
    public Result<ArrayList<Tag>> findTagsByCustomerId(Long customerId, ServiceContext serviceContext) {
        Result<ArrayList<SysTag>> sysTagResult = userTagService.findTagsByUserId(customerId, serviceContext);

        Result<ArrayList<Tag>> result = new Result<>();

        if (result != null){
            result.setErrorCode(sysTagResult.getErrorCode());
            result.setErrorMsg(sysTagResult.getErrorMsg());
            ArrayList<Tag> data = result.getData();
            if (!Check.NuNCollections(data)){
                List<Tag> tagList = tagBuilder.buildSource((List) data);
                if (tagList != null)
                    result.setData((ArrayList)tagList);
            }
        }

        return result;
    }
}
