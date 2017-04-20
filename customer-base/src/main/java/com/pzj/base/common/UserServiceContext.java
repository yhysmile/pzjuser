package com.pzj.base.common;

import com.pzj.framework.context.ServiceContext;
import org.slf4j.event.Level;

/**
 * 用户服务上下文
 * Created by wuliqing on 2016-10-11.
 */
public class UserServiceContext extends ServiceContext {
    /**
     * 日志级别
     */
    private Level logLevel = null;

    public Level getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(Level logLevel) {
        this.logLevel = logLevel;
    }
}
