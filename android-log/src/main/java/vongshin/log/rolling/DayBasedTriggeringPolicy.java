package vongshin.log.rolling;

import java.io.File;
import vongshin.log.utils.DateUtils;

public class DayBasedTriggeringPolicy implements TriggeringPolicy{

    @Override
    public boolean isTriggeringEvent(File file) {
        return !file.exists() || !expire(file.getName());
    }

    private boolean expire(String name){
        String date = DateUtils.getDate();
        return name.contains(date);
    }
}
