package vongshin.log;

import java.util.ArrayList;
import java.util.List;

import vongshin.log.appender.Appender;

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

    public LogConfiguration setLevel(int level){
        logLevel = level;
        return this;
    }
}
