package onlyajar.log.strategy;

import java.io.File;
import java.io.IOException;
import onlyajar.log.utils.DateUtils;
import onlyajar.log.utils.FileUtils;

public class DayRollingStrategy implements RollingStrategy{

    private final int backupDays;
    private final File rootDir;
    private final String name;

    public DayRollingStrategy(int backupDays, String filePath) {
        this.backupDays = backupDays;
        File file = new File(filePath);
        rootDir = FileUtils.getDirAndMake(file);
        name = file.getName();
    }

    @Override
    public File getRealFile() {
        String realName = getRealName(DateUtils.getDate());
        return new File(rootDir, realName);
    }

    @Override
    public File getRollingFile() {
        File realFile = getRealFile();
        if(!realFile.exists()){
            try {
                realFile.createNewFile();
                deleteOldFile(rootDir, backupDays);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return realFile;
    }

    private String getRealName(String date){
        String realName;
        int index = name.lastIndexOf('.');
        if(index < 0){
            realName = name + date;
        }else {
            realName = name.substring(0, index) + "."+ date + name.substring(index);
        }
        return realName;
    }


    private void deleteOldFile(File dir, int days){
        String bounds = getRealName(DateUtils.getBeforeDate(days));
        String namePrefix = getNamePrefix();
        File[] files = dir.listFiles();
        for (File f: files) {
            if(f.isFile() && f.getName().startsWith(namePrefix) && bounds.compareTo(f.getName()) > 0) {
                f.delete();
            }
        }
    }

    private String getNamePrefix(){
        int index = name.lastIndexOf('.');
        if(index < 0){
            return name;
        }else {
            return name.substring(0, index);
        }
    }
}
