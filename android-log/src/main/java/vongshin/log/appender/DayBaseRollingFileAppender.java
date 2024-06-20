package vongshin.log.appender;

import java.io.File;

import vongshin.log.rolling.DayBasedTriggeringPolicy;
import vongshin.log.rolling.TriggeringPolicy;
import vongshin.log.strategy.DayRollingStrategy;
import vongshin.log.strategy.RollingStrategy;
import vongshin.log.utils.DateUtils;
import vongshin.log.utils.FileUtils;

public class DayBaseRollingFileAppender extends FileAppender{
    private final TriggeringPolicy triggeringPolicy;
    private final RollingStrategy rollingStrategy;
    public DayBaseRollingFileAppender(int retainDay, String filePath) {
        super();
        triggeringPolicy = new DayBasedTriggeringPolicy();
        rollingStrategy = new DayRollingStrategy(retainDay, filePath);
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
