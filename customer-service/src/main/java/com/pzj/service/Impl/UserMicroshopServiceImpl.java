package com.pzj.service.Impl;

import com.pzj.base.common.impl.BaseServiceImpl;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysUserMicroshop;
import com.pzj.base.entity.query.SysUserMicroshopQuery;
import com.pzj.base.service.sys.IUserMicroshopService;
import com.pzj.common.error.UserErrorCode;
import com.pzj.dao.SysUserMicroshopMapper;
import com.pzj.framework.context.Result;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016-12-13.
 */
@Service("userWechatService")
public class UserMicroshopServiceImpl extends BaseServiceImpl<SysUserMicroshop, SysUserMicroshopMapper> implements IUserMicroshopService {

    public Result<Long> createMicroshop(SysUserMicroshop userWechat) {
        Result<Long> result = new Result<>();

        if (checkCreaCteUserWechat(userWechat, result)) return result;


        userWechat.setCreateDate(new Date());
        Long insertId = this.insert(userWechat);
        result.setData(insertId);
        return result;
    }

    private boolean checkCreaCteUserWechat(SysUserMicroshop userWechat, Result<Long> result) {
        if (userWechat == null){
            UserErrorCode.setResultError(result, UserErrorCode.Wechat_Null);
            return true;
        }
        if (userWechat.getUserId() == null){
            UserErrorCode.setResultError(result, UserErrorCode.Wechat_UserId_Null);
            return true;
        }
        return false;
    }

    @Override
    public Result<Boolean> modifyMicroshop(SysUserMicroshop userWechat) {
        Result<Boolean> result = new Result<>();

        if (checkModifyUserWechat(userWechat, result)) return result;

        userWechat.setUpdateDate(new Date());
        Integer update = mapper.updateByUserId(userWechat);
        result.setData(update > 0);
        return result;
    }

    private boolean checkModifyUserWechat(SysUserMicroshop userWechat, Result<Boolean> result) {
        if (userWechat == null){
            UserErrorCode.setResultError(result, UserErrorCode.Wechat_Null);
            return true;
        }
        if (userWechat.getId() == null && userWechat.getUserId() == null){
            UserErrorCode.setResultError(result, UserErrorCode.Wechat_Id_Null);
            return true;
        }
        return false;
    }


    @Override
    public Result<SysUserMicroshop> findByUserId(Long userId) {
        Result<SysUserMicroshop> result = new Result<>();
        if (userId == null) {
            UserErrorCode.setResultError(result, UserErrorCode.User_Id_Null);
            return result;
        }

        SysUserMicroshopQuery param = new SysUserMicroshopQuery();
        param.setUserId(userId);
        List<SysUserMicroshop> queryResult = findListByParams(param);

        if (CollectionUtils.isNotEmpty(queryResult)){
            result.setData(queryResult.get(0));
        }

        return result;
    }

    @Override
    public Result<PageList<SysUserMicroshop>> findByParams(SysUserMicroshopQuery userWechatQuery, PageModel pageModel) {
        Result<PageList<SysUserMicroshop>> result = new Result<>();
        PageList<SysUserMicroshop> queryResult = queryPageByParamMap(pageModel, userWechatQuery);
        result.setData(queryResult);
        return result;
    }

}
