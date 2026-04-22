package onlyajar.log;

import android.app.Application;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import onlyajar.log.appender.Appender;
import onlyajar.log.appender.DayBaseRollingFileAppender;
import onlyajar.log.appender.LogCatAppender;
import onlyajar.log.appender.SizeBaseRollingFileAppender;

public final class LogConfiguration {
    private static String LOG_NAME = "journal.log";
    private static class Holder{
        static LogConfiguration INSTANCE = new LogConfiguration();
    }
    private LogConfiguration(){}

    public static LogConfiguration getInstance(){
        return Holder.INSTANCE;
    }

    private final List<Appender> logAppenderList = new ArrayList<>();

    private final Map<Class<?>, Appender> logAppenderMap = new HashMap<>();

    private int logLevel = LogLevel.DEBUG;

    public LogConfiguration addAppender(Appender appender){
        logAppenderMap.put(appender.getClass(), appender);
        resetAppenderList();
        return this;
    }

    public LogConfiguration addLogcatAppender(){
        logAppenderMap.put(LogCatAppender.class, new LogCatAppender());
        resetAppenderList();
        return this;
    }

    /**
     * @param backupDays 备份文件的天数，min=0
     * @param filePath 文件路径
     * @return 文件配置
     */
    public LogConfiguration addDayBasedAppender(int backupDays, String filePath){
        logAppenderMap.put(DayBaseRollingFileAppender.class,new DayBaseRollingFileAppender(backupDays, filePath));
        resetAppenderList();
        return this;
    }

    /**
     *
     * @param backupFiles 备份文件数量， min=0
     * @param fileSize 文件容量 eg. 10KB 10MB 10GB
     * @param filePath 文件路径
     * @return 文件配置
     */
    public LogConfiguration addSizeBasedAppender(int backupFiles, String fileSize, String filePath){
        logAppenderMap.put(SizeBaseRollingFileAppender.class, new SizeBaseRollingFileAppender(backupFiles, fileSize, filePath));
        resetAppenderList();
        return this;
    }
    public LogConfiguration setDefaultSizeBasedConfiguration(){
        String pathFile = getDefaultFilePath() + LOG_NAME;
        addLogcatAppender();
        addSizeBasedAppender(3, "10MB", pathFile);
        setLevel(LogLevel.INFO);
        return this;
    }
    public LogConfiguration setDefaultSizeBasedConfiguration(int logLevel){
        String pathFile = getDefaultFilePath() + LOG_NAME;
        addLogcatAppender();
        addSizeBasedAppender(3, "10MB", pathFile);
        setLevel(logLevel);
        return this;
    }

    public LogConfiguration setDefaultHistoryConfiguration(){
        String pathFile = getDefaultFilePath() + LOG_NAME;
        addLogcatAppender();
        addDayBasedAppender(30, pathFile);
        setLevel(LogLevel.INFO);
        return this;
    }

    public LogConfiguration setDefaultHistoryConfiguration(int logLevel){
        String pathFile = getDefaultFilePath() + LOG_NAME;
        addLogcatAppender();
        addDayBasedAppender(30, pathFile);
        setLevel(logLevel);
        return this;
    }

    public String getDefaultFilePath(){
        String packageName = getApplication().getPackageName();
        return "sdcard/applog/"+packageName+"/";
    }
    public  <T extends Application> T getApplication() {
        try {
            Class<?> threadClazz = Class.forName("android.app.AppGlobals");
            Method method = threadClazz.getMethod("getInitialApplication");
            return (T) method.invoke(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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

    private void resetAppenderList(){
        logAppenderList.clear();
        for(Map.Entry<Class<?>, Appender> entry : logAppenderMap.entrySet()){
            logAppenderList.add(entry.getValue());
        }
    }
}
