package com.pzj.common.log;

import com.pzj.base.common.UserServiceContext;
import com.pzj.framework.context.ServiceContext;
import org.slf4j.event.Level;

/**
 * Created by Administrator on 2016-10-9.
 */
public class LogSession {
    private static ThreadLocal<Level> levelConfig = new ThreadLocal<Level>();

    public static Level getLevel() {
        return levelConfig.get();
    }

    public static void setLevel(Level levelValue){
        levelConfig.set(levelValue);
    }

    public static void logBegin(ServiceContext serviceContext){
        if (serviceContext == null || !(serviceContext instanceof UserServiceContext))
            return;
        UserServiceContext userServiceContext = (UserServiceContext)serviceContext;

        LogSession.setLevel(userServiceContext.getLogLevel());
    }

    public static void logEnd(){
        LogSession.setLevel(null);
    }
}
