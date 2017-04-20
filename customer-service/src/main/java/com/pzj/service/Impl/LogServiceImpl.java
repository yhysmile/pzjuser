package com.pzj.service.Impl;

import org.springframework.stereotype.Service;

import com.pzj.base.common.impl.BaseServiceImpl;
import com.pzj.base.entity.SysLog;
import com.pzj.base.service.sys.ILogService;
import com.pzj.dao.SysLogMapper;

/**
 * 操作日志实现类
 * 
 * @author shiyue
 * 
 */
@Service("logService")
public class LogServiceImpl extends BaseServiceImpl<SysLog, SysLogMapper>
        implements ILogService {

}
