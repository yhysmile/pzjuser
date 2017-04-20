package com.pzj.log.entity;

import com.pzj.base.common.ServiceException;
import com.pzj.base.entity.SysLog;
import com.pzj.util.CommonBuiler;
import com.pzj.util.CommonCheck;

public class OperatorLogBuilder extends CommonBuiler<SysLog, OperatorLog> {

    @Override
    public OperatorLog convertFrom(SysLog entity) {
        if (entity == null) {
            return null;
        }
        
        OperatorLog log = new OperatorLog();
        log.setId(entity.getId());
        log.setType(entity.getType());
        log.setCreateBy(entity.getCreateBy());
        log.setCreateId(entity.getCreateId());
        log.setCreateDate(entity.getCreateDate());
        log.setCreateDateEnd(entity.getCreateDateEnd());
        log.setRemoteAddr(entity.getRemoteAddr());
        log.setUserAgent(entity.getUserAgent());
        log.setRequestUri(entity.getRequestUri());
        log.setMethod(entity.getMethod());
        log.setParams(entity.getParams());
        log.setException(entity.getException());
        log.setDataSource(entity.getDataSource());
        log.setPosition(entity.getPosition());
        log.setTelephone(entity.getTelephone());
        log.setClient(entity.getClient());
        
        return log;
    }

    @Override
    public SysLog convertTo(OperatorLog entity) {
        if (entity == null) {
            return null;
        }
        
        SysLog log = new SysLog();
        log.setId(entity.getId());
        log.setType(entity.getType());
        log.setCreateBy(entity.getCreateBy());
        log.setCreateId(entity.getCreateId());
        log.setCreateDate(entity.getCreateDate());
        log.setCreateDateEnd(entity.getCreateDateEnd());
        log.setRemoteAddr(entity.getRemoteAddr());
        log.setUserAgent(entity.getUserAgent());
        log.setRequestUri(entity.getRequestUri());
        log.setMethod(entity.getMethod());
        log.setParams(entity.getParams());
        log.setException(entity.getException());
        log.setDataSource(entity.getDataSource());
        log.setPosition(entity.getPosition());
        log.setTelephone(entity.getTelephone());
        log.setClient(entity.getClient());
        
        return log;
    }

    @Override
    protected void validtionValueWhenCreate(OperatorLog entity, CommonCheck check) throws ServiceException {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void customValueWhenCreate(OperatorLog entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void customValueWhenModify(OperatorLog entity) {
        // TODO Auto-generated method stub
        
    }
}
