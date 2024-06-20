package vongshin.log;

import java.util.ArrayList;
import java.util.List;

import vongshin.log.appender.Appender;
import vongshin.log.appender.DayBaseRollingFileAppender;
import vongshin.log.appender.LogCatAppender;
import vongshin.log.appender.SizeBaseRollingFileAppender;

public final class LogConfiguration {

    private static class Holder{
        static LogConfiguration INSTANCE = new LogConfiguration();
    }
    private LogConfiguration(){}

    public static LogConfiguration getInstance(){
        return Holder.INSTANCE;
    }

    private final List<Appender> logAppenderList = new ArrayList<>();
    private int logLevel = LogLevel.DEBUG;
    public LogConfiguration addAppender(Appender appender){
        logAppenderList.add(appender);
        return this;
    }

    public LogConfiguration addLogcatAppender(){
        logAppenderList.add(new LogCatAppender());
        return this;
    }

    public LogConfiguration addDayBasedAppender(int day, String filePath){
        logAppenderList.add(new DayBaseRollingFileAppender(day, filePath));
        return this;
    }
    public LogConfiguration addSizeBasedAppender(int count, String size, String filePath){
        logAppenderList.add(new SizeBaseRollingFileAppender(count, size, filePath));
        return this;
    }


    public LogConfiguration setLevel(int level){
        logLevel = level;
        return this;
    }

    public int getLogLevel() {
        return logLevel;
    }

    public List<Appender> getLogAppender() {
        return logAppenderList;
    }
}
