package onlyajar.log.rolling;

import java.io.File;

public interface TriggeringPolicy {
    boolean isTriggeringEvent(File file);
}
