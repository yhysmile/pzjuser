package com.pzj.common.log;

import ch.qos.logback.classic.Level;

/**
 * Created by Administrator on 2016-10-10.
 */
public class Slf4jToLogbackLevel {
    public static Level convert(org.slf4j.event.Level slf4jLevel){
        if (Slf4jLevelHelp.isError(slf4jLevel))
            return Level.ERROR;
        if (Slf4jLevelHelp.isWarn(slf4jLevel))
            return Level.WARN;
        if (Slf4jLevelHelp.isInfo(slf4jLevel))
            return Level.INFO;
        if (Slf4jLevelHelp.isDebug(slf4jLevel))
            return Level.DEBUG;
        if (Slf4jLevelHelp.isTrace(slf4jLevel))
            return Level.TRACE;
        return null;
    }
}
