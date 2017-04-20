package com.pzj.base.service.sys;

import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysUserMicroshop;
import com.pzj.base.entity.query.SysUserMicroshopQuery;
import com.pzj.framework.context.Result;

/**
 * Created by Administrator on 2016-12-13.
 */
public interface IUserMicroshopService {

    /**
     * 修改用户微信微店信息
     * @param userMicroshop
     * @return
     */
    Result<Boolean> modifyMicroshop(SysUserMicroshop userMicroshop);

    /**
     * 根据用户id查询用户微信微店信息
     * @param userId
     * @return
     */
    Result<SysUserMicroshop> findByUserId(Long userId);

    /**
     * 根据多个条件查询用户微信微店信息
     * @param userMicroshopQuery
     * @param pageModel
     * @return
     */
    Result<PageList<SysUserMicroshop>> findByParams(SysUserMicroshopQuery userMicroshopQuery, PageModel pageModel);
}
