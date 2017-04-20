package com.pzj.base.common;

import java.io.Serializable;

/**
 * Created by Administrator on 2016-10-21.
 */
public class UserServiceException extends com.pzj.framework.exception.ServiceException implements Serializable {
    private int errorCode = 14999;

    public UserServiceException(String message) {
        super(message);
    }

    public UserServiceException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }


    public UserServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public int getErrorCode() {
        return errorCode;
    }
}
