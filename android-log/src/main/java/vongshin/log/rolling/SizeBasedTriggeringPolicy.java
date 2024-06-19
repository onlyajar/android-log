package vongshin.log.rolling;

import java.io.File;

import vongshin.log.file.FileSize;

public class SizeBasedTriggeringPolicy implements TriggeringPolicy{

    private FileSize fileSize;

    public SizeBasedTriggeringPolicy(FileSize fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public boolean isTriggeringEvent(File file) {
        return file.length() >= fileSize.getSize();
//        return file.length() >= 10485760;
    }
}
