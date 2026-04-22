package onlyajar.log.strategy;

import java.io.File;

public interface RollingStrategy {

    File getRealFile();

    File getRollingFile();
}
