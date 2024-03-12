package vongshin.log.appender;

import vongshin.log.LogLevel;

public class LogCatAppender implements Appender {

    @Override
    public int println(int level, String tag, String msg) {
        return android.util.Log.println(level, tag, msg);
    }

    @Override
    public int println(int level, String tag, String msg, Throwable t) {
        int result = 0;
        switch (level) {
            case LogLevel.DEBUG:
                result = android.util.Log.d(tag, msg, t);
                break;
            case LogLevel.INFO:
                result = android.util.Log.i(tag, msg, t);
                break;
            case LogLevel.WARN:
                result = android.util.Log.w(tag, msg, t);
                break;
            case LogLevel.ERROR:
                result = android.util.Log.e(tag, msg, t);
                break;
        }
        return result;
    }
}
