package vongshin.log.utils;

import java.io.File;

public class FileUtils {

    public static File getDirAndMake(File file){
        File rootDir = file.getParentFile();
        if(!rootDir.exists()){
            rootDir.mkdirs();
        }
        return rootDir;
    }
}
