package onlyajar.log.utils;

import java.io.File;

public class FileUtils {

    public static File getDirAndMake(File file){
        File rootDir = file.getParentFile();
        if(!rootDir.exists()){
            boolean re = rootDir.mkdirs();
            System.out.println("make dir = " + re);
        }
        return rootDir;
    }

    public static File rename(File file, String newName){
        File newFile = new File(file.getParentFile(), newName);
        file.renameTo(newFile);
        return newFile;
    }




}
