package com.pzj.common.log;

import org.slf4j.Marker;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.turbo.TurboFilter;
import ch.qos.logback.core.spi.FilterReply;

/**
 * Created by Administrator on 2016-10-9.
 */
public class LogSessionDynamicConfigFilter extends TurboFilter {
    @Override
    public FilterReply decide(Marker marker, Logger logger, Level level, String s, Object[] objects, Throwable throwable) {
        org.slf4j.event.Level slftjLevel = LogSession.getLevel();

        // 转换成Logback的Level
        Level sessionLogLevel = Slf4jToLogbackLevel.convert(slftjLevel);

        if (sessionLogLevel == null)
            return FilterReply.NEUTRAL;

        // 比较级别，如果日志的级别大于等于LogSession中的级别就打印出来
        if (level.isGreaterOrEqual(sessionLogLevel)){
            return FilterReply.ACCEPT;
        }

        return FilterReply.DENY;
    }
}
