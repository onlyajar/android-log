package vongshin.log.appender;

import java.io.File;

import vongshin.log.file.FileSize;
import vongshin.log.rolling.SizeBasedTriggeringPolicy;
import vongshin.log.rolling.TriggeringPolicy;
import vongshin.log.strategy.RollingStrategy;
import vongshin.log.strategy.SizeRollingStrategy;

public class SizeBaseRollingFileAppender extends FileAppender{
    private final RollingStrategy rollingStrategy;
    private final TriggeringPolicy triggeringPolicy;
    public SizeBaseRollingFileAppender(int logCount, String maxSize, String filePath) {
        super();
        triggeringPolicy = new SizeBasedTriggeringPolicy(FileSize.valueOf(maxSize));
        rollingStrategy = new SizeRollingStrategy(logCount, filePath);

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
