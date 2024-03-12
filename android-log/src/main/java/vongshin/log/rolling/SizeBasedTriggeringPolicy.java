package vongshin.log.rolling;

import java.io.File;

public class SizeBasedTriggeringPolicy implements TriggeringPolicy{
    @Override
    public boolean isTriggeringEvent(File file) {
        return file.length() >= 10485760;
    }
}
