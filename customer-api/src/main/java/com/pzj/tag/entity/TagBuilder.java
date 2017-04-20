package com.pzj.tag.entity;

import com.pzj.base.common.ServiceException;
import com.pzj.base.entity.SysTag;
import com.pzj.util.CommonBuiler;
import com.pzj.util.CommonCheck;

/**
 * Created by Administrator on 2016-11-9.
 */
public class TagBuilder  extends CommonBuiler<SysTag, Tag> {
    public final static TagBuilder ATagBuilder = new TagBuilder();

    @Override
    public Tag convertFrom(SysTag entity) {
        if (entity == null)
            return null;

        Tag tag = new Tag();
        tag.setId(entity.getId());
        tag.setName(entity.getName());
        tag.setType(entity.getType());
        tag.setCreateDate(entity.getCreateDate());

        return tag;
    }

    @Override
    public SysTag convertTo(Tag tag) {
        if (tag == null)
            return null;

        SysTag entity = new SysTag();
        entity.setId(tag.getId());
        entity.setName(tag.getName());
        entity.setType(tag.getType());
        entity.setCreateDate(tag.getCreateDate());

        return entity;
    }

    @Override
    protected void validtionValueWhenCreate(Tag entity, CommonCheck check) throws ServiceException {

    }

    @Override
    protected void customValueWhenCreate(Tag entity) {

    }

    @Override
    protected void customValueWhenModify(Tag entity) {

    }
}
