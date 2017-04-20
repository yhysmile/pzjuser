package com.pzj.service.Impl;

import org.springframework.stereotype.Service;

import com.pzj.base.entity.SysUserDraft;
import com.pzj.base.service.sys.IUserDraftService;
import com.pzj.dao.SysUserDraftMapper;

/**
 * Created by Administrator on 2016-12-2.
 */
@Service("userDraftService")
public class UserDraftServiceImpl extends BaseUserServiceImpl<SysUserDraft, SysUserDraftMapper> implements IUserDraftService {
}
