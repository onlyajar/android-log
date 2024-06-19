package vongshin.log.strategy;

import java.io.File;

public interface RollingStrategy {
    boolean isRolling(File file);

    File getWriteFile(File file);
}
