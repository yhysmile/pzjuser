package com.pzj.tag.service.impl;

import com.pzj.base.common.ServiceException;
import com.pzj.base.entity.SysTag;
import com.pzj.base.service.sys.ITagService;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;
import com.pzj.tag.entity.Tag;
import com.pzj.tag.entity.TagBuilder;
import com.pzj.tag.service.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016-11-7.
 */
@Service
public class TagServiceImpl implements TagService {
    private static Logger logger = LoggerFactory.getLogger(TagServiceImpl.class);


    private TagBuilder tagBuilder = TagBuilder.ATagBuilder;

    @Resource
    private ITagService tagService;

    @Override
    public Result<Long> createTag(Tag tag, ServiceContext serviceContext) {
        try {
            SysTag sysTag = tagBuilder.buildNew(tag);
            if (sysTag == null)
                return new Result<Long>();
            return tagService.createTag(sysTag, serviceContext);

        } catch (ServiceException e) {
            logger.error(e.getErrorReason(), e);
            return new Result<Long>();
        }
    }

    @Override
    public Result<Tag> findById(Long id, ServiceContext serviceContext) {
        Result<SysTag> sysTagResult = tagService.findById(id, serviceContext);

        Result<Tag> result = new Result<>();
        if (sysTagResult != null){
            result.setErrorCode(sysTagResult.getErrorCode());
            result.setErrorMsg(sysTagResult.getErrorMsg());
            SysTag data = sysTagResult.getData();
            if (data != null){
                Tag tag = tagBuilder.buildSource(data);
                result.setData(tag);
            }
        }
        return result;
    }

    @Override
    public Result<ArrayList<String>> findTagNamesByPrefix(String namePrefix, ServiceContext serviceContext) {
        Result<ArrayList<String>> result = tagService.findTagNamesByPrefix(namePrefix, serviceContext);
        return result;
    }

}
