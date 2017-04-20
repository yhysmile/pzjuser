package com.pzj.common.log;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;

/**
 * Created by Administrator on 2016-10-10.
 */
public class LogbackConfigFileHelp {
    public static void loadConfigFile(String filePath){
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        JoranConfigurator configurator = new JoranConfigurator();
        configurator.setContext(lc);
        lc.reset();
        try {
            configurator.doConfigure(filePath);
        } catch (JoranException e) {
            e.printStackTrace();
        }
        StatusPrinter.printInCaseOfErrorsOrWarnings(lc);
    }
}
