package onlyajar.log.appender;

import onlyajar.log.rolling.DayBasedTriggeringPolicy;
import onlyajar.log.rolling.TriggeringPolicy;
import onlyajar.log.strategy.DayRollingStrategy;
import onlyajar.log.strategy.RollingStrategy;


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
