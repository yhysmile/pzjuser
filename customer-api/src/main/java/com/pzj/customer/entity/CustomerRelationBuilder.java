package com.pzj.customer.entity;

import com.pzj.base.common.ServiceException;
import com.pzj.base.entity.SysUserRelation;

/**
 * Created by Administrator on 2015-12-22.
 */
public class CustomerRelationBuilder {

    public final static CustomerRelationBuilder ACustomerRelationBuilder = new CustomerRelationBuilder();

    protected CustomerRelation convertFrom(SysUserRelation entity) {
        CustomerRelation relation = new CustomerRelation();
        relation.setId(entity.getId());
        relation.setUserId(entity.getUserId());
        relation.setRelUserId(entity.getRelUserId());
        relation.setRelType(entity.getRelType());
        relation.setUserName(entity.getUserName());
        relation.setRelUserName(entity.getRelUserName());

        return relation;
    }

    protected SysUserRelation convertTo(CustomerRelation entity) {
        SysUserRelation relation = new SysUserRelation();
        relation.setId(entity.getId());
        relation.setUserId(entity.getUserId());
        relation.setRelUserId(entity.getRelUserId());
        relation.setRelType(entity.getRelType());
        relation.setUserName(entity.getUserName());
        relation.setRelUserName(entity.getRelUserName());

        return relation;
    }


    /**
     * 从底层数据实体转换为API层业务实体
     *
     * @param sourceList
     * @return
     */
    public CustomerRelation buildSource(SysUserRelation sourceList){
        return convertFrom(sourceList);
    }


    public SysUserRelation buildNewOrExisted(CustomerRelation entity) {
        return convertTo(entity);
    }

}
