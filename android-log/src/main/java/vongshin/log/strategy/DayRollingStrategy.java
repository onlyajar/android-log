package vongshin.log.strategy;

import java.io.File;
import java.io.IOException;

import vongshin.log.rolling.DayBasedTriggeringPolicy;
import vongshin.log.rolling.TriggeringPolicy;
import vongshin.log.utils.DateUtils;
import vongshin.log.utils.FileUtils;

public class DayRollingStrategy implements RollingStrategy{

    private final int retainDay;

    private final TriggeringPolicy triggering;

    public DayRollingStrategy(int retainDay) {
        this.retainDay = retainDay;
        triggering = new DayBasedTriggeringPolicy(retainDay);
    }

    @Override
    public boolean isRolling(File file) {
        return triggering.isTriggeringEvent(file);
    }

    @Override
    public File getWriteFile(File file) {
        File rootDir = FileUtils.getDirAndMake(file);
        String name = file.getName();
        String realName = getRealName(name, DateUtils.getDate());
        File realFile = new File(rootDir, realName);
        if(!realFile.exists()){
            try {
                realFile.createNewFile();
                // TODO:SHIN 2024/6/19 delete 

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return realFile;
    }

    private String getRealName(String name, String date){
        String realName;
        int index = name.lastIndexOf('.');
        if(index < 0){
            realName = name + date;
        }else {
            realName = name.substring(0, index) + "."+ date + name.substring(index);
        }
        return realName;
    }
}
