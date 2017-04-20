package com.pzj.common.log;

import org.slf4j.event.Level;

/**
 * Created by Administrator on 2016-10-10.
 */
public class Slf4jLevelHelp {
    public static boolean isError(Level level){
        return level == Level.ERROR;
    }

    public static boolean isWarn(Level level){
        return level == Level.WARN;
    }

    public static boolean isInfo(Level level){
        return level == Level.INFO;
    }

    public static boolean isDebug(Level level){
        return level == Level.DEBUG;
    }

    public static boolean isTrace(Level level){
        return level == Level.TRACE;
    }
}
