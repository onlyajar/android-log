package vongshin.log;

public class Log {
    public static void d(String tag, String msg) {
        android.util.Log.d(tag, msg);
    }

    public static void d(String tag, String msg, Throwable t) {
        android.util.Log.d(tag, msg, t);
    }

    public static void i(String tag, String msg) {
        android.util.Log.i(tag, msg);
    }

    public static void i(String tag, String msg, Throwable t) {
        android.util.Log.i(tag, msg, t);
    }

    public static void w(String tag, String msg) {
        android.util.Log.w(tag, msg);
    }

    public static void w(String tag, String msg, Throwable t) {
        android.util.Log.w(tag, msg, t);
    }

    public static void e(String tag, String msg) {
        android.util.Log.e(tag, msg);
    }

    public static void e(String tag, String msg, Throwable t) {
        android.util.Log.e(tag, msg, t);
    }

    public static void println(int level, String tag, String msg, Throwable t) {
        if (t == null) {
            android.util.Log.println(level, tag, msg);
        } else {
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

}
