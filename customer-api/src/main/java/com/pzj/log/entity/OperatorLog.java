package com.pzj.log.entity;

import java.io.Serializable;
import java.util.Date;

import com.pzj.util.CommonEntity;

public class OperatorLog extends CommonEntity implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    /** 日志类型 */
    private String type;

    /** 创建者 */
    private String createBy;

    /** 创建时间最大范围 */
    private Date createDateEnd;

    /** 操作IP地址 */
    private String remoteAddr;

    /** 用户代理 */
    private String userAgent;

    /** 请求URI */
    private String requestUri;

    /** 操作方式 */
    private String method;

    /**
     * 数据来源
     */
    private String dataSource;
    
    /**
     * 操作岗位
     */
    private String position;
    
    /**
     * 电话
     */
    private String telephone;
    
    /**
     * 操作客户端
     */
    private String client;
    
    /**
     * 创建者id
     */
    private Long createId;
    
    /**
     * 操作提交的数据
     */
    private String params;
    
    /**
     * 异常信息
     */
    private String exception;

    /**
     * 获取日志类型
     * 
     * @return type 日志类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置日志类型
     * 
     * @param type
     *            日志类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取创建者
     * 
     * @return createBy 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者
     * 
     * @param createBy
     *            创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取操作IP地址
     * 
     * @return remoteAddr 操作IP地址
     */
    public String getRemoteAddr() {
        return remoteAddr;
    }

    /**
     * 设置操作IP地址
     * 
     * @param remoteAddr
     *            操作IP地址
     */
    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr;
    }

    /**
     * 获取用户代理
     * 
     * @return userAgent 用户代理
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * 设置用户代理
     * 
     * @param userAgent
     *            用户代理
     */
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    /**
     * 获取请求URI
     * 
     * @return requestUri 请求URI
     */
    public String getRequestUri() {
        return requestUri;
    }

    /**
     * 设置请求URI
     * 
     * @param requestUri
     *            请求URI
     */
    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    /**
     * 获取操作方式
     * 
     * @return method 操作方式
     */
    public String getMethod() {
        return method;
    }

    /**
     * 设置操作方式
     * 
     * @param method
     *            操作方式
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 获取数据来源
     * 
     * @return dataSource 数据来源
     */
    public String getDataSource() {
        return dataSource;
    }

    /**
     * 设置数据来源
     * 
     * @param dataSource
     *            数据来源
     */
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取查询匹配创建时间的最大范围
     * @return
     */
    public Date getCreateDateEnd() {
        return createDateEnd;
    }

    /**
     * 设置查询匹配创建时间的最大范围
     * @param createDateEnd
     */
    public void setCreateDateEnd(Date createDateEnd) {
        this.createDateEnd = createDateEnd;
    }

    /**
     * 获取操作岗位
     * @return
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置操作岗位
     * @param position
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * 获取客户端
     * @return
     */
    public String getClient() {
        return client;
    }

    /**
     * 设置客户端
     * @param client
     */
    public void setClient(String client) {
        this.client = client;
    }

    /**
     * 获取创建者id
     * @return
     */
    public Long getCreateId() {
        return createId;
    }

    /**
     * 设置创建者id
     * @param createId
     */
    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    /**
     * 获取电话
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置电话 
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 获取操作提交的数据
     * @return the params
     */
    public String getParams() {
        return params;
    }

    /**
     * 设置操作提交的数据
     * @param params the params to set
     */
    public void setParams(String params) {
        this.params = params;
    }

    /**
     * 获取异常信息
     * @return the exception
     */
    public String getException() {
        return exception;
    }

    /**
     * 设置异常信息
     * @param exception the exception to set
     */
    public void setException(String exception) {
        this.exception = exception;
    }

}
