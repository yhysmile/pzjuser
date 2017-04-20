package com.pzj.service.Impl;

import com.pzj.base.common.impl.BaseServiceImpl;
import com.pzj.base.entity.SysTag;
import com.pzj.base.entity.query.SysTagQueryParam;
import com.pzj.base.service.sys.ITagService;
import com.pzj.common.util.StringUtils;
import com.pzj.core.customer.dao.SysTagMapper;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2016-11-8.
 */
@Service("tagService")
public class TagServiceImpl extends BaseServiceImpl<SysTag, SysTagMapper> implements ITagService {
    @Override
    public Result<Long> createTag(SysTag tag, ServiceContext serviceContext) {
        Result<Long> result = new Result<>();
        if (tag == null) {
            result.setErrorCode(-1);
            result.setErrorMsg("标签不能为空");
            return result;
        }
        if (StringUtils.isBlank(tag.getName())) {
            result.setErrorCode(-1);
            result.setErrorMsg("标签名称（name）不能为空");
            return result;
        }

        SysTagQueryParam param = new SysTagQueryParam();
        param.setName(tag.getName());
        List<SysTag> sysTagList = findListByParams(param);
        if (CollectionUtils.isNotEmpty(sysTagList)){
            SysTag sysTag = sysTagList.get(0);
            result.setData(sysTag.getId());
            result.setErrorMsg("标签已经存在");
        } else {
            if (tag.getType() == null)
                tag.setType(1);
            if (tag.getCreateDate() == null)
                tag.setCreateDate(new Date());

            Long tagId = insert(tag);
            result.setData(tagId);
            result.setErrorMsg("标签创建成功");
        }

        return result;
    }

    public Result<Integer> createTag(List<SysTag> tag, ServiceContext serviceContext) {
        Result<Integer> result = new Result<>();

        if (CollectionUtils.isEmpty(tag)) {
            result.setErrorCode(-1);
            result.setErrorMsg("标签集合不能为空");
            return result;
        }

        Long insertBatch = insertBatch(tag);
        if (insertBatch == tag.size()) {
            result.setErrorCode(10000);
            result.setData(tag.size());
        } else {

        }

        return result;
    }

    @Override
    public Result<SysTag> findById(Long id, ServiceContext serviceContext) {
        SysTag sysTag = getById(id);
        Result<SysTag> result = new Result<>();
        result.setData(sysTag);
        return result;
    }

    @Override
    public Result<ArrayList<String>> findTagNamesByPrefix(String namePrefix, ServiceContext serviceContext) {
        Result<ArrayList<String>> result = new Result<>();
        result.setErrorCode(-1);

        if (StringUtils.isBlank(namePrefix)){
            result.setErrorMsg("查询标签的名称前缀参数不能为空！");
            return result;
        }

        SysTagQueryParam param = new SysTagQueryParam();
        param.setName(namePrefix + "%");

        List<SysTag> sysTagList = findListByParams(param);


        if (sysTagList != null){
            ArrayList<String> tagNameList = new ArrayList<>(sysTagList.size());
            for (SysTag sysTag :sysTagList){
                String sysTagName = sysTag.getName();
                if (!tagNameList.contains(sysTagName)){
                    tagNameList.add(sysTagName);
                }
            }
            result.setErrorCode(10000);
            result.setData(tagNameList);
        }

        return result;
    }

    public List<SysTag> findListByParams(SysTagQueryParam queryParam) {
        return super.findListByParams(queryParam);
    }

    public Set<String> existTagNames(Set<String> names){
        return mapper.existTagNames(names);
    }
}
