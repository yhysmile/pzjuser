package com.pzj.service.Impl;

import com.pzj.base.common.global.UserGlobalParam;
import com.pzj.base.entity.SysTag;
import com.pzj.base.entity.SysUserTag;
import com.pzj.base.entity.query.SysTagQueryParam;
import com.pzj.base.service.sys.IUserTagService;
import com.pzj.dao.SysUserTagMapper;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by Administrator on 2016-11-8.
 */
@Service("userTagService")
public class UserTagServiceImpl  extends
        BaseRelationshipServiceImpl<SysUserTag, SysUserTagMapper>
        implements IUserTagService{

    @Resource(name = "tagService")
    private TagServiceImpl tagService;

    @Override
    public Long delAuthBatch(List<SysUserTag> records, boolean syncOtherRelation) {
        Long num = 0l;
        try {
            if (records == null || records.isEmpty())
                return num;

            num = deleteBatchSelective(records);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
        return num;
    }

    @Override
    public Long insertAuthBatch(List<SysUserTag> records, boolean syncOtherRelation) {
        Long num = 0l;
        try {
            if (records == null || records.isEmpty())
                return num;

            num = insertBatch(records);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
        return num;
    }

    @Override
    public String genMapKey(SysUserTag record, String regx) {
        String key = "";
        if (StringUtils.isBlank(regx)) {
            regx = ",";
        }
        if (record == null) {
            return key;
        }
        Long tagId = record.getTagId();
        Long userId = record.getUserId();

        if (tagId == null || userId == null) {
            return key;
        }

        return userId + regx + tagId;
    }

    @Override
    public Map<String, String> getRelationIds(List<SysUserTag> records) {
        if (records == null || records.isEmpty()) {
            return null;
        }
        StringBuffer userIds = new StringBuffer();
        StringBuffer menuIds = new StringBuffer();
        for (SysUserTag record : records) {
            userIds.append(record.getUserId()).append(",");
            menuIds.append(record.getTagId()).append(",");
        }
        Map<String, String> map = new HashMap<>();
        if (StringUtils.isNotBlank(userIds)) {
            map.put(UserGlobalParam.UserMapKeyParam.USER_MAP_KEY, userIds.substring(0, userIds.length() - 1));
        }
        if (StringUtils.isNotBlank(menuIds)) {
            map.put(UserGlobalParam.UserMapKeyParam.TAG_MAP_KEY, menuIds.substring(0, menuIds.length() - 1));
        }

        return map;
    }

    @Override
    public Result<Integer> associateUserTagNames(Long userId, Set<String> tags, ServiceContext serviceContext) {
        Result<Integer> result = new Result<>();

        List<SysTag> sysTagList = null;
        if (tags == null || !tags.isEmpty()) {
            SysTagQueryParam queryParam = new SysTagQueryParam();
            queryParam.setNames(tags);

            sysTagList = tagService.findListByParams(queryParam);
        }

        if (sysTagList != null && !sysTagList.isEmpty()){
            for (SysTag sysTag : sysTagList){
                tags.remove(sysTag.getName());
            }
        }

        List<SysTag> createSysTagList = null;
        if (!tags.isEmpty()){
            createSysTagList = new ArrayList<>(tags.size());
            Date createDate = new Date();
            for (String tag : tags){
                SysTag sysTag = new SysTag();
                sysTag.setName(tag);
                sysTag.setType(1);
                sysTag.setCreateDate(createDate);
                createSysTagList.add(sysTag);
            }

            Result<Integer> createTagResult = tagService.createTag(createSysTagList, serviceContext);
            if (!createTagResult.isOk()){
                return createTagResult;
            }
        }

        if (createSysTagList != null)
            sysTagList.addAll(createSysTagList);

        List<SysUserTag> relationList = null;
        if (sysTagList != null) {
            relationList = new ArrayList<>(sysTagList.size());
            Date createDate = new Date();
            for (SysTag sysTag : sysTagList) {
                SysUserTag sysUserTag = new SysUserTag();
                sysUserTag.setUserId(userId);
                sysUserTag.setTagId(sysTag.getId());
                sysUserTag.setType(sysTag.getType());
                sysUserTag.setCreateDate(createDate);
                relationList.add(sysUserTag);
            }
        } else {
            relationList = new ArrayList<>(0);
        }

        Map<String, String> relationMap = new HashMap<>(0);
        relationMap.put(UserGlobalParam.UserMapKeyParam.USER_MAP_KEY, userId.toString());
        Long authBatch = updateAuthBatch(relationMap, relationList);

        if (authBatch > 0){
            result.setData(1);
        }

        return result;
    }

    @Override
    public Result<Integer> associateUserTagIds(Long userId, Set<Long> tags, ServiceContext serviceContext) {
        Result<Integer> result = new Result<>();

        if (userId == null){
            result.setErrorCode(-1);
            result.setErrorMsg("用户ID不能为空");
            return result;
        }
        if (tags == null || tags.isEmpty()){
            result.setErrorCode(-1);
            result.setErrorMsg("标签集合不能为空");
            return result;
        }

        SysTagQueryParam queryParam = new SysTagQueryParam();
        queryParam.setIds(tags);

        List<SysTag> sysTagList = tagService.findListByParams(queryParam);


        if (sysTagList != null && !sysTagList.isEmpty()){
            List<SysUserTag> relationList = new ArrayList<>(sysTagList.size());
            for (SysTag sysTag : sysTagList ){
                SysUserTag sysUserTag = new SysUserTag();
                sysUserTag.setUserId(userId);
                sysUserTag.setTagId(sysTag.getId());
                sysUserTag.setType(sysTag.getType());
                relationList.add(sysUserTag);
            }

            Map<String, String> relationMap = new HashMap<>(0);
            relationMap.put(UserGlobalParam.UserMapKeyParam.USER_MAP_KEY, userId.toString());

            Long authBatch = updateAuthBatch(relationMap, relationList);

            if (authBatch > 0){
                result.setData(1);
            }
        }

        return result;
    }

    @Override
    public Result<ArrayList<String>> findTagNamesByUserId(Long userId, ServiceContext serviceContext) {
        Result<ArrayList<String>> result = new Result<>();

        //
        SysUserTag queryParam = new SysUserTag();
        queryParam.setUserId(userId);
        List<SysUserTag> userTagList = findListByParams(queryParam);

        if (CollectionUtils.isEmpty(userTagList)){
            return result;
        }

        //
        Set<Long> tagIds = new HashSet<>(userTagList.size());
        for (SysUserTag userTag : userTagList){
            tagIds.add(userTag.getTagId());
        }
        SysTagQueryParam tagQueryParam = new SysTagQueryParam();
        tagQueryParam.setIds(tagIds);
        List<SysTag> sysTagList = tagService.findListByParams(tagQueryParam);

        if (CollectionUtils.isEmpty(sysTagList)){
            return result;
        }

        //
        ArrayList<String> tagNameList = new ArrayList<>(sysTagList.size());
        for (SysTag sysTag : sysTagList){
            if (!tagNameList.contains(sysTag.getName())){
                tagNameList.add(sysTag.getName());
            }
        }
        result.setData(tagNameList);

        return result;
    }

    @Override
    public Result<ArrayList<SysTag>> findTagsByUserId(Long userId, ServiceContext serviceContext) {
        Result<ArrayList<SysTag>> result = new Result<>();

        //
        SysUserTag queryParam = new SysUserTag();
        queryParam.setUserId(userId);
        List<SysUserTag> userTagList = findListByParams(queryParam);

        if (CollectionUtils.isEmpty(userTagList)){
            return result;
        }

        //
        Set<Long> tagIds = new HashSet<>(userTagList.size());
        for (SysUserTag userTag : userTagList){
            tagIds.add(userTag.getTagId());
        }
        SysTagQueryParam tagQueryParam = new SysTagQueryParam();
        tagQueryParam.setIds(tagIds);
        List<SysTag> sysTagList = tagService.findListByParams(tagQueryParam);

        if (CollectionUtils.isEmpty(sysTagList)){
            return result;
        }

        if (sysTagList instanceof ArrayList){
            result.setData((ArrayList)sysTagList);
        } else {
            result.setData(new ArrayList<>(sysTagList));
        }

        return result;
    }
}
