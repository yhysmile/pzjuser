package com.pzj.core.customer.read;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pzj.core.customer.profile.PageEntity;
import com.pzj.core.customer.profile.VisitorEntity;

/**
 * Created by Administrator on 2017-2-23.
 */
public interface VisitorReadMapper {

	public List<VisitorEntity> queryVisitorPage(@Param("visitor") VisitorEntity visitor, @Param("page") PageEntity page);

	public Integer countVisitorPage(@Param("visitor") VisitorEntity visitor, @Param("page") PageEntity page);

	public VisitorEntity queryVisitorDetailById(@Param("id") Long id);

	public List<VisitorEntity> queryVisitorByNameMobile(@Param("nameOrMobile") String nameOrMobile);
}
