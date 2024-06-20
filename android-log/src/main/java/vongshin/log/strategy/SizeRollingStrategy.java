package vongshin.log.strategy;

import java.io.File;
import java.io.IOException;
import vongshin.log.utils.FileUtils;

public class SizeRollingStrategy implements RollingStrategy{
    private final int logCount;
    private final File rootDir;
    private final String name;
    public SizeRollingStrategy(int logCount, String filePath) {
        this.logCount = logCount;
        File file = new File(filePath);
        rootDir = FileUtils.getDirAndMake(file);
        name = file.getName();
    }

    @Override
    public File getRealFile() {
        File file = new File(rootDir, name);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    /**
     * 1、判断文件滚动到底了，进行删除 eg. delete log.max.log
     * 2、修改滚动文件的名字 eg. log.1.log ->log.2.log
     * 3、修改当前写入文件的名字 log.log -> log.1.log
     * 4、创建新的当前写入文件 eg. new log.log
     * @return
     */

    @Override
    public File getRollingFile() {
        File maxFile = new File(rootDir, getBackupName(logCount));
        if(maxFile.exists()) maxFile.delete();
        for (int i = logCount -1 ; i > 0 ; i--) {
            renameFileToUp(i);
        }
        File file = new File(rootDir, name);
        FileUtils.rename(file, getBackupName(1));
        return getRealFile();
    }

    private void renameFileToUp(int index){
        File oldFile = new File(rootDir, getBackupName(index));
        if(!oldFile.exists()) return;
        FileUtils.rename(oldFile, getBackupName(index + 1));
    }


    private String getBackupName(int sequence){
        String backupName;
        int index = name.lastIndexOf('.');
        if(index < 0){
            backupName = name + sequence;
        }else {
            backupName = name.substring(0, index) + "."+ sequence + name.substring(index);
        }
        return backupName;
    }
}
