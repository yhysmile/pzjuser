package com.pzj.core.customer.profile;

import java.io.Serializable;

/**
 * Created by Administrator on 2017-2-16.
 */
public class CreateCustomerReport implements Serializable {
    /**
     * 创建时的用户名
     */
    private String loginName;

    /**
     * 传入参数时索引位置
     */
    private int paramIndex;

    /**
     * 错误码
     */
    private int errorCode;
    /**
     * 错误描述
     */
    private String errorMsg;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public int getParamIndex() {
        return paramIndex;
    }

    public void setParamIndex(int paramIndex) {
        this.paramIndex = paramIndex;
    }
}
