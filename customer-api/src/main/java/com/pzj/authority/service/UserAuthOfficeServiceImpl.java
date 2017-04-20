package com.pzj.authority.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pzj.base.service.sys.IUserAuthOfficeService;

@Component
public class UserAuthOfficeServiceImpl implements UserAuthOfficeService,
        Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = -7309108152633794515L;

    @Autowired
    private IUserAuthOfficeService iuserAuthOfficeService = null;

}
