package vongshin.log.utils;

import java.io.File;

public class FileUtils {

    public static File getDirAndMake(File file){
        File rootDir = file.getParentFile();
        System.out.println(rootDir.getPath() + rootDir.exists());
        if(!rootDir.exists()){
            boolean re = rootDir.mkdir();
            System.out.println("re" + re);
            System.out.println("re" + rootDir.isDirectory());
        }
        return rootDir;
    }
}
