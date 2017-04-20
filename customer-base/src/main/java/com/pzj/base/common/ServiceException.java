package com.pzj.base.common;

public class ServiceException extends Exception {

    private static final long serialVersionUID = -4836597156188157511L;

    /** 错误码 */
    private Integer errorCode;

    /** 错误信息 */
    private String errorReason;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Integer errorCode, String errorReason) {
        super(errorCode + ":" + errorReason);
        this.errorCode = errorCode;
        this.errorReason = errorReason;

    }

    /**
     * 获取错误码
     * 
     * @return errorCode 错误码
     */
    public Integer getErrorCode() {
        return errorCode;
    }

    /**
     * 设置错误码
     * 
     * @param errorCode
     *            错误码
     */
    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * 获取错误信息
     * 
     * @return errorReason 错误信息
     */
    public String getErrorReason() {
        return errorReason;
    }

    /**
     * 设置错误信息
     * 
     * @param errorReason
     *            错误信息
     */
    public void setErrorReason(String errorReason) {
        this.errorReason = errorReason;
    }

}
