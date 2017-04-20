package com.pzj.log.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysLog;
import com.pzj.base.service.sys.ILogService;
import com.pzj.log.entity.OperatorLog;
import com.pzj.log.entity.OperatorLogBuilder;
import com.pzj.util.PojoUtil;

@Service
public class OperatorLogServiceImpl implements OperatorLogService {

    @Autowired
    private ILogService logService;

    private static Logger logger = Logger.getLogger(OperatorLogServiceImpl.class);
    
    private static OperatorLogBuilder builer = new OperatorLogBuilder();


    /**
     * 创建日志信息
     * 
     * @param operatorLog
     *            日志实体
     */
    public Integer createOperatorLog(OperatorLog operatorLog) throws Exception {
        if (operatorLog == null) {
            return 0;
        }
        SysLog sysLog = builer.convertTo(operatorLog);
        Long num = logService.insert(sysLog);
        logger.info("创建一条日志信息：（日志ID=" + num + "）");
        return Integer.valueOf(num.toString());
    }

    public OperatorLog getOperatorLogById(Long id) throws Exception {
        OperatorLog operatorLog = null;
        if (id < 1) {
            return null;
        }
        SysLog sysLog = logService.getById(id);
        if (sysLog != null) {
            operatorLog = new OperatorLog();
            PojoUtil.copyProperties(sysLog, operatorLog);
        }
        return operatorLog;
    }

    public PageList<OperatorLog> findOperatorLogByParams(Integer pageNo,
            Integer pageSize, OperatorLog operatorLog) throws Exception {
        PageList<SysLog> pageList = null;
        
        SysLog sysLog = builer.convertTo(operatorLog);
        
        if (null != sysLog) {
            if (!StringUtils.isEmpty(sysLog.getPosition())) {
                sysLog.setPosition(sysLog.getPosition() + "%");
            }
            if (!StringUtils.isEmpty(sysLog.getCreateBy())) {
                sysLog.setCreateBy(sysLog.getCreateBy() + "%");
            }
            if (!StringUtils.isEmpty(sysLog.getRemoteAddr())) {
                sysLog.setRemoteAddr(sysLog.getRemoteAddr() + "%");
            }
        }

        // 查询
        PageModel pm = new PageModel(pageNo, pageSize, null);
        pageList = logService.queryPageByParamMap(pm, sysLog);

        // 转换
        List<OperatorLog> operatorLogList = null;
        if (pageList != null && !pageList.isEmpty()) {
            List<SysLog> sysLogList = pageList.getResultList();
            operatorLogList = builer.buildSource(sysLogList);
        }

        PageList<OperatorLog> result = new PageList<OperatorLog>();
        result.setPageBean(pageList.getPageBean());
        result.setResultList(operatorLogList);

        return result;
    }

    public List<OperatorLog> findOperatorLogList(OperatorLog operatorLog)
            throws Exception {
        List<OperatorLog> result = null;

        // 准备查询转化
        SysLog sysLog = new SysLog();
        if (operatorLog != null) {
            PojoUtil.copyProperties(operatorLog, sysLog);
        }

        // 查询
        List<SysLog> sysLogList = logService.findListByParams(sysLog);

        // 结果转换
        if (sysLogList != null && !sysLogList.isEmpty()) {
            result = new ArrayList<OperatorLog>();
            for (SysLog log : sysLogList) {
                OperatorLog operatorLog_ = new OperatorLog();
                PojoUtil.copyProperties(log, operatorLog);
                result.add(operatorLog_);
            }

        }
        return result;
    }

}
