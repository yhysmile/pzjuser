package com.pzj.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.pzj.base.service.sys.*;

@Cacheable
@Component
public class CommonServiceImpl {

	@Autowired
	protected IRoleService iroleService = null;

	@Autowired
	protected IMenuService imenuService = null;

	@Autowired
	protected IUserService iuserService = null;

	@Autowired
	protected IOfficeService iofficeService = null;

	@Autowired
	protected IRoleAuthMenuService iroleAuthMenuService = null;

	@Autowired
	protected IUserAuthRoleService iuserAuthRoleService = null;

	@Autowired
	protected IRoleAuthOfficeService iroleAuthOfficeService = null;

}