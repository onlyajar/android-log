package vongshin.log.out;

import android.util.Log;
import vongshin.log.LogEvent;
import vongshin.log.LogLevel;
public class LogCatLogOut implements LogOut{

    @Override
    public int println(LogEvent logEvent) {
        switch (logEvent.getLevel()){
            case LogLevel.VERBOSE:
                if(logEvent.getTr() == null){
                    return Log.v(logEvent.getTag(), logEvent.getMessage());
                }else {
                    return Log.v(logEvent.getTag(), logEvent.getMessage(), logEvent.getTr());
                }
            case LogLevel.DEBUG:
                if(logEvent.getTr() == null){
                    return Log.d(logEvent.getTag(), logEvent.getMessage());
                }else {
                    return Log.d(logEvent.getTag(), logEvent.getMessage(), logEvent.getTr());
                }
            case LogLevel.INFO:
                if(logEvent.getTr() == null){
                    return Log.i(logEvent.getTag(), logEvent.getMessage());
                }else {
                    return Log.i(logEvent.getTag(), logEvent.getMessage(), logEvent.getTr());
                }
            case LogLevel.WARN:
                if(logEvent.getTr() == null){
                    return Log.w(logEvent.getTag(), logEvent.getMessage());
                }else {
                    return Log.i(logEvent.getTag(), logEvent.getMessage(), logEvent.getTr());
                }
            case LogLevel.ERROR:
        }
        return 0;
    }
}
