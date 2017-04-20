package com.pzj.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pzj.base.entity.SysUserRelation;
import com.pzj.customer.entity.CustomerRelation;

public class CustomerRelationUtil {

    public static SysUserRelation convert2Entity(CustomerRelation vo) {
        if (vo == null) {
            return null;
        }
        SysUserRelation entity = new SysUserRelation();
        BeanUtils.copyProperties(vo, entity);

        return entity;
    }

    public static CustomerRelation convert2VO(SysUserRelation entity) {
        if (entity == null) {
            return null;
        }
        CustomerRelation vo = new CustomerRelation();
        BeanUtils.copyProperties(entity, vo);
        return vo;
    }

    public static List<CustomerRelation> convert2VoList(
            List<SysUserRelation> entityList) {
        List<CustomerRelation> relList = new ArrayList<CustomerRelation>();

        if (entityList != null) {
            for (SysUserRelation entity : entityList) {
                relList.add(convert2VO(entity));
            }
        }

        return relList;
    }
}
