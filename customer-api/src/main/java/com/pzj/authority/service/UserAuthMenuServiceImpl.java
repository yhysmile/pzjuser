package com.pzj.authority.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.service.sys.IUserAuthMenuService;

@Service
public class UserAuthMenuServiceImpl implements UserAuthMenuService,
        Serializable {

    private static final long serialVersionUID = -6444694255410045967L;

    @Autowired
    private IUserAuthMenuService iuserAuthMenuService = null;

}
