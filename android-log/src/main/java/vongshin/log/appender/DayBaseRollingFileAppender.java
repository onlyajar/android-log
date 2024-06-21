package vongshin.log.appender;

import vongshin.log.rolling.DayBasedTriggeringPolicy;
import vongshin.log.rolling.TriggeringPolicy;
import vongshin.log.strategy.DayRollingStrategy;
import vongshin.log.strategy.RollingStrategy;


public class DayBaseRollingFileAppender extends FileAppender{
    private final TriggeringPolicy triggeringPolicy;
    private final RollingStrategy rollingStrategy;
    public DayBaseRollingFileAppender(int backupDays, String filePath) {
        super();
        triggeringPolicy = new DayBasedTriggeringPolicy();
        rollingStrategy = new DayRollingStrategy(backupDays, filePath);
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
