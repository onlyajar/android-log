package vongshin.log.appender;

import vongshin.log.LogLevel;

public class LogCatAppender implements Appender {

    @Override
    public void println(int level, String tag, String msg) {
        android.util.Log.println(level, tag, msg);
    }

    @Override
    public void println(int level, String tag, String msg, Throwable t) {
        switch (level) {
            case LogLevel.DEBUG:
                android.util.Log.d(tag, msg, t);
                break;
            case LogLevel.INFO:
                android.util.Log.i(tag, msg, t);
                break;
            case LogLevel.WARN:
                android.util.Log.w(tag, msg, t);
                break;
            case LogLevel.ERROR:
                android.util.Log.e(tag, msg, t);
                break;
        }
    }
}
