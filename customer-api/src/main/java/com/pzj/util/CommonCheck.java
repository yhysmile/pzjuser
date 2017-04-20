package com.pzj.util;

import static com.pzj.util.ServiceUtil.checkEmpty;

import com.pzj.base.common.ServiceException;

public enum CommonCheck {
    Full {
        @Override
        public void check(Long data, CommonCheckData checkData) throws ServiceException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void check(String data, CommonCheckData checkData) throws ServiceException {
            checkEmpty(data, checkData.emptyMessage);
        }
    },
    Null {

        @Override
        public void check(Long data, CommonCheckData checkData) throws ServiceException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void check(String data, CommonCheckData checkData) throws ServiceException {
            // TODO Auto-generated method stub
            
        }
    },
    Null_Size {

        @Override
        public void check(Long data, CommonCheckData checkData) throws ServiceException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void check(String data, CommonCheckData checkData) throws ServiceException {
            // TODO Auto-generated method stub
            
        }
    };
    
    public abstract void check(Long data, CommonCheckData checkData) throws ServiceException;
    
    public abstract void check(String data, CommonCheckData checkData) throws ServiceException;
}
