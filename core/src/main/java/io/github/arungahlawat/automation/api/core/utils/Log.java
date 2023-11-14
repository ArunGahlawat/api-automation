package io.github.arungahlawat.automation.api.core.utils;

import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

public class Log {
    private static Logger log;
    private static boolean isInitialised = false;

    private Log() {
    }

    private static void init() {
        if (isInitialised)
            return;
        init(Log.class.getName());
    }

    public static void init(String logName) {
        if (isInitialised)
            return;
        String logLevel = "false".equals(System.getProperty("logLevel", "false")) ? ("true".equals(System.getProperty("intellij.debug.agent", "INFO")) ? "DEBUG" : "INFO") : System.getProperty("logLevel");
        System.setProperty("org.slf4j.simpleLogger.log." + logName, logLevel);
        log = LoggerFactory.getLogger(logName);
        isInitialised = true;
    }

    public static boolean isInfoEnabled() {
        init();
        return log.isInfoEnabled();
    }

    @Step()
    public static void info(String msg) {
        init();
        log.info(msg);
    }

    @Step
    public static void info(String format, Object arg) {
        init();
        log.info(format, arg);
    }

    @Step
    public static void info(String format, Object arg1, Object arg2) {
        init();
        log.info(format, arg1, arg2);
    }

    @Step
    public static void info(String format, Object... arguments) {
        init();
        log.info(format, arguments);
    }

    @Step
    public static void info(String msg, Throwable t) {
        init();
        log.info(msg, t);
    }

    public static boolean isInfoEnabled(Marker marker) {
        init();
        return log.isInfoEnabled(marker);
    }

    @Step
    public static void info(Marker marker, String msg) {
        init();
        log.info(marker, msg);
    }

    @Step
    public static void info(Marker marker, String format, Object arg) {
        init();
        log.info(marker, format, arg);
    }

    @Step
    public static void info(Marker marker, String format, Object arg1, Object arg2) {
        init();
        log.info(marker, format, arg1, arg2);
    }

    @Step
    public static void info(Marker marker, String format, Object... arguments) {
        init();
        log.info(marker, format, arguments);
    }

    @Step
    public static void info(Marker marker, String msg, Throwable t) {
        init();
        log.info(marker, msg, t);
    }

    public static boolean isWarnEnabled() {
        init();
        return log.isWarnEnabled();
    }

    @Step
    public static void warn(String msg) {
        init();
        log.warn(msg);
    }

    @Step
    public static void warn(String format, Object arg) {
        init();
        log.warn(format, arg);
    }

    @Step
    public static void warn(String format, Object... arguments) {
        init();
        log.warn(format, arguments);
    }

    @Step
    public static void warn(String format, Object arg1, Object arg2) {
        init();
        log.warn(format, arg1, arg2);
    }

    @Step
    public static void warn(String msg, Throwable t) {
        init();
        log.warn(msg, t);
    }

    public static boolean isWarnEnabled(Marker marker) {
        init();
        return log.isWarnEnabled(marker);
    }

    @Step
    public static void warn(Marker marker, String msg) {
        init();
        log.warn(marker, msg);
    }

    @Step
    public static void warn(Marker marker, String format, Object arg) {
        init();
        log.warn(marker, format, arg);
    }

    @Step
    public static void warn(Marker marker, String format, Object arg1, Object arg2) {
        init();
        log.warn(marker, format, arg1, arg2);
    }

    @Step
    public static void warn(Marker marker, String format, Object... arguments) {
        init();
        log.warn(marker, format, arguments);
    }

    @Step
    public static void warn(Marker marker, String msg, Throwable t) {
        init();
        log.warn(marker, msg, t);
    }

    public static boolean isErrorEnabled() {
        init();
        return log.isErrorEnabled();
    }

    @Step
    public static void error(String msg) {
        init();
        log.error(msg);
    }

    @Step
    public static void error(String format, Object arg) {
        init();
        log.error(format, arg);
    }

    @Step
    public static void error(String format, Object arg1, Object arg2) {
        init();
        log.error(format, arg1, arg2);
    }

    @Step
    public static void error(String format, Object... arguments) {
        init();
        log.error(format, arguments);
    }

    @Step
    public static void error(String msg, Throwable t) {
        init();
        log.error(msg, t);
    }

    @Step
    public static boolean isErrorEnabled(Marker marker) {
        init();
        return log.isErrorEnabled(marker);
    }

    @Step
    public static void error(Marker marker, String msg) {
        init();
        log.error(marker, msg);
    }

    @Step
    public static void error(Marker marker, String format, Object arg) {
        init();
        log.error(marker, format, arg);
    }

    @Step
    public static void error(Marker marker, String format, Object arg1, Object arg2) {
        init();
        log.error(marker, format, arg1, arg2);
    }

    @Step
    public static void error(Marker marker, String format, Object... arguments) {
        init();
        log.error(marker, format, arguments);
    }

    @Step
    public static void error(Marker marker, String msg, Throwable t) {
        init();
        log.error(marker, msg, t);
    }

    public static String getName() {
        init();
        return log.getName();
    }

    public static boolean isDebugEnabled() {
        init();
        return log.isDebugEnabled();
    }

    public static void debug(String msg) {
        init();
        log.debug(msg);
    }

    public static void debug(String format, Object arg) {
        init();
        log.debug(format, arg);
    }

    public static void debug(String format, Object arg1, Object arg2) {
        init();
        log.debug(format, arg1, arg2);
    }

    public static void debug(String format, Object... arguments) {
        init();
        log.debug(format, arguments);
    }

    public static void debug(String msg, Throwable t) {
        init();
        log.debug(msg, t);
    }

    public static boolean isDebugEnabled(Marker marker) {
        init();
        return log.isDebugEnabled(marker);
    }

    public static void debug(Marker marker, String msg) {
        init();
        log.debug(marker, msg);
    }

    public static void debug(Marker marker, String format, Object arg) {
        init();
        log.debug(marker, format, arg);
    }

    public static void debug(Marker marker, String format, Object arg1, Object arg2) {
        init();
        log.debug(marker, format, arg1, arg2);
    }

    public static void debug(Marker marker, String format, Object... arguments) {
        init();
        log.debug(marker, format, arguments);
    }

    public static void debug(Marker marker, String msg, Throwable t) {
        init();
        log.debug(marker, msg, t);
    }

    public static boolean isTraceEnabled() {
        init();
        return log.isTraceEnabled();
    }

    public static void trace(String msg) {
        init();
        log.trace(msg);
    }

    public static void trace(String format, Object arg) {
        init();
        log.trace(format, arg);
    }

    public static void trace(String format, Object arg1, Object arg2) {
        init();
        log.trace(format, arg1, arg2);
    }

    public static void trace(String format, Object... arguments) {
        init();
        log.trace(format, arguments);
    }

    public static void trace(String msg, Throwable t) {
        init();
        log.trace(msg, t);
    }

    public static boolean isTraceEnabled(Marker marker) {
        init();
        return log.isTraceEnabled(marker);
    }

    public static void trace(Marker marker, String msg) {
        init();
        log.trace(marker, msg);
    }

    public static void trace(Marker marker, String format, Object arg) {
        init();
        log.trace(marker, format, arg);
    }

    public static void trace(Marker marker, String format, Object arg1, Object arg2) {
        init();
        log.trace(marker, format, arg1, arg2);
    }

    public static void trace(Marker marker, String format, Object... argArray) {
        init();
        log.trace(marker, format, argArray);
    }

    public static void trace(Marker marker, String msg, Throwable t) {
        init();
        log.trace(marker, msg, t);
    }
}
