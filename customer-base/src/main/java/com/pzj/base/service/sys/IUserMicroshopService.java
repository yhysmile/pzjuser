package com.pzj.base.service.sys;

import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysUserMicroshop;
import com.pzj.base.entity.query.SysUserMicroshopQuery;
import com.pzj.framework.context.Result;

/**
 * Created by Administrator on 2016-12-13.
 */
@Deprecated
public interface IUserMicroshopService {

    /**
     * 已废弃，请使用 com.pzj.core.customer.microshop.MicroshopService#modifyMicroshop 接口
     * 修改用户微信微店信息
     * @param userMicroshop
     * @return
     */
    @Deprecated
    Result<Boolean> modifyMicroshop(SysUserMicroshop userMicroshop);

    /**
     * 已废弃，请使用 com.pzj.core.customer.microshop.MicroshopService#queryMicroshopByMasterId(java.lang.Long) 接口
     * 根据用户id查询用户微信微店信息
     * @param userId
     * @return
     */
    @Deprecated
    Result<SysUserMicroshop> findByUserId(Long userId);

    /**
     * 已废弃，无使用场景。
     * 根据多个条件查询用户微信微店信息
     * @param userMicroshopQuery
     * @param pageModel
     * @return
     */
    @Deprecated
    Result<PageList<SysUserMicroshop>> findByParams(SysUserMicroshopQuery userMicroshopQuery, PageModel pageModel);
}
