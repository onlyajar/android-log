package vongshin.log.rolling;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;

import vongshin.log.file.FileSize;

public class DayBasedTriggeringPolicy implements TriggeringPolicy{

    private int retainDay;

    public DayBasedTriggeringPolicy(int retainDay) {
        this.retainDay = retainDay;
    }

    @Override
    public boolean isTriggeringEvent(File file) {
        return !file.exists();
    }
}
