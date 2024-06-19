package vongshin.log.appender;

import java.io.File;

import vongshin.log.strategy.DayRollingStrategy;
import vongshin.log.strategy.RollingStrategy;

public class DayBaseRollingFileAppender extends FileAppender{
    private int retainDay;
    private final DayRollingStrategy rollingStrategy;
    public DayBaseRollingFileAppender(int retainDay, String filePath) {
        super(filePath);
        this.retainDay = retainDay;
        rollingStrategy = new DayRollingStrategy(retainDay);
    }

    @Override
    public RollingStrategy getRollingStrategy() {
        return rollingStrategy;
    }

    @Override
    public File getFile(String filePath) {
        File configFile = new File(filePath);
        return rollingStrategy.getWriteFile(configFile);
    }
}
