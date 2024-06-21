package vongshin.log.appender;


import vongshin.log.file.FileSize;
import vongshin.log.rolling.SizeBasedTriggeringPolicy;
import vongshin.log.rolling.TriggeringPolicy;
import vongshin.log.strategy.RollingStrategy;
import vongshin.log.strategy.SizeRollingStrategy;

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
