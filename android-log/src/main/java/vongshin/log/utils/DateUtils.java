package vongshin.log.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
    public static String getDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.CHINA);
//        return simpleDateFormat.format(new Date());
        return "20240624";
    }

    public static String getBeforeDate(int days){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.CHINA);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -days);
//        return simpleDateFormat.format(calendar.getTime());
        return "20240622";
    }
}
