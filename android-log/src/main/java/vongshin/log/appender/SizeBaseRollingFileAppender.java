package vongshin.log.appender;

import java.io.File;

import vongshin.log.file.FileSize;
import vongshin.log.rolling.SizeBasedTriggeringPolicy;
import vongshin.log.strategy.RollingStrategy;
import vongshin.log.strategy.SizeRollingStrategy;

public class SizeBaseRollingFileAppender extends FileAppender{
    private final int logCount;
    private final FileSize fileSize;

    public SizeBaseRollingFileAppender(int logCount, String maxSize, String filePath) {
        super(filePath);
        this.logCount = logCount;
        fileSize = FileSize.valueOf(maxSize);
    }

    @Override
    public RollingStrategy getRollingStrategy() {
        return new SizeRollingStrategy(logCount, fileSize);
    }

    @Override
    public File getFile(String filePath) {
        return null;
    }
}
