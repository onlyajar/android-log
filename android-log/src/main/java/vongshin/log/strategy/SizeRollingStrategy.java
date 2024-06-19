package vongshin.log.strategy;

import java.io.File;

import vongshin.log.file.FileSize;
import vongshin.log.rolling.SizeBasedTriggeringPolicy;
import vongshin.log.rolling.TriggeringPolicy;

public class SizeRollingStrategy implements RollingStrategy{

    private final TriggeringPolicy triggering;

    public SizeRollingStrategy(int logCount, FileSize fileSize) {
        triggering = new SizeBasedTriggeringPolicy(fileSize);
    }

    @Override
    public boolean isRolling(File file) {
        return triggering.isTriggeringEvent(file);
    }

    @Override
    public File getWriteFile(File file) {
        return null;
    }
}
