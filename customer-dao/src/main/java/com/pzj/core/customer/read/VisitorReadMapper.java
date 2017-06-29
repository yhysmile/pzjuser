package com.pzj.core.customer.read;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pzj.core.customer.entitys.PageEntity;
import com.pzj.core.customer.entitys.VisitorEntity;

/**
 * Created by Administrator on 2017-2-23.
 */
public interface VisitorReadMapper {

    List<VisitorEntity> queryVisitorPage(@Param("visitor") VisitorEntity visitor, @Param("page") PageEntity page);

    Integer countVisitorPage(@Param("visitor") VisitorEntity visitor, @Param("page") PageEntity page);

    VisitorEntity queryVisitorDetailById(@Param("id") Long id);

    List<VisitorEntity> queryVisitorByNameMobile(@Param("nameOrMobile") String nameOrMobile, @Param("supplierId") Long supplierId);
}
