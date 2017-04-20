package com.pzj.log.service;

import java.util.List;

import com.pzj.base.common.utils.PageList;
import com.pzj.log.entity.OperatorLog;

/**
 * 系统日志接口
 * 
 * @author huxn
 * @mail huxiaona@mftour.cn
 * @date 2015-9-11 上午11:11：58
 * 
 */
public interface OperatorLogService {

    /**
     * 创建日志信息
     * 
     * @param operatorLog
     *            日志实体
     */
    Integer createOperatorLog(OperatorLog operatorLog) throws Exception;

    /**
     * 根据主键id获取日志信息
     * 
     * @param id
     *            用户主键id
     * @return
     */
    OperatorLog getOperatorLogById(Long id) throws Exception;

    /**
     * 分页查询日志列表，支持多参数
     * 
     * @param pageNo
     *            当前页码
     * @param pageSize
     *            每页显示记录数
     * @param operatorLog
     *            日志实体
     * @return 分页对象
     */
    PageList<OperatorLog> findOperatorLogByParams(Integer pageNo,
            Integer pageSize, OperatorLog operatorLog) throws Exception;

    /**
     * 按条件查询所有日志
     * 
     * @param operatorLog
     *            日志实体
     * 
     */
    public List<OperatorLog> findOperatorLogList(OperatorLog operatorLog)
            throws Exception;

}
