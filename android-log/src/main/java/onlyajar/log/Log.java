package onlyajar.log;

import onlyajar.log.appender.Appender;

public class Log {
    public static void d(String tag, String msg) {
        println(LogLevel.DEBUG, tag, msg);
    }

    public static void d(String tag, String msg, Throwable t) {
        println(LogLevel.DEBUG, tag, msg, t);
    }

    public static void i(String tag, String msg) {
        println(LogLevel.INFO, tag, msg);
    }

    public static void i(String tag, String msg, Throwable t) {
        println(LogLevel.INFO, tag, msg, t);
    }

    public static void w(String tag, String msg) {
        println(LogLevel.WARN, tag, msg);
    }

    public static void w(String tag, String msg, Throwable t) {
        println(LogLevel.WARN, tag, msg, t);
    }

    public static void e(String tag, String msg) {
        println(LogLevel.ERROR, tag, msg);
    }

    public static void e(String tag, String msg, Throwable t) {
        println(LogLevel.ERROR, tag, msg, t);
    }

    public static void println(int level, String tag, String msg) {
        int logLevel = LogConfiguration.getInstance().getLogLevel();
        if(level < logLevel){
            return;
        }
        for (Appender appender : LogConfiguration.getInstance().getLogAppender()) {
            appender.println(level, tag, msg);
        }
    }

    public static void println(int level, String tag, String msg, Throwable t) {
        int logLevel = LogConfiguration.getInstance().getLogLevel();
        if(level < logLevel){
            return;
        }
        for (Appender appender : LogConfiguration.getInstance().getLogAppender()) {
            appender.println(level, tag, msg, t);
        }

    }

}
