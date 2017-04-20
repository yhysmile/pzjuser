package com.pzj.common.log;

import ch.qos.logback.classic.Level;

/**
 * Created by Administrator on 2016-10-10.
 */
public class LogbackLevelHelp {
    public static boolean isError(Level level){
        return level == Level.ERROR;
    }
}
