package onlyajar.log.appender;


import onlyajar.log.file.FileSize;
import onlyajar.log.rolling.SizeBasedTriggeringPolicy;
import onlyajar.log.rolling.TriggeringPolicy;
import onlyajar.log.strategy.RollingStrategy;
import onlyajar.log.strategy.SizeRollingStrategy;

public class SizeBaseRollingFileAppender extends FileAppender{
    private final RollingStrategy rollingStrategy;
    private final TriggeringPolicy triggeringPolicy;
    public SizeBaseRollingFileAppender(int backupFiles, String maxSize, String filePath) {
        super();
        triggeringPolicy = new SizeBasedTriggeringPolicy(FileSize.valueOf(maxSize));
        rollingStrategy = new SizeRollingStrategy(backupFiles, filePath);

    }

    @Override
    public TriggeringPolicy getTriggeringPolicy() {
        return triggeringPolicy;
    }

    @Override
    public RollingStrategy getRollingStrategy() {
        return rollingStrategy;
    }
}
