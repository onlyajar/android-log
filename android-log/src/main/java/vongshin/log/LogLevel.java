package vongshin.log;

import android.util.Log;

public class LogLevel {

    /**
     * @see android.util.Log#VERBOSE
     */
    public static final int VERBOSE = Log.VERBOSE;

    /**
     * @see android.util.Log#DEBUG
     */
    public static final int DEBUG = Log.DEBUG;

    /**
     * @see android.util.Log#INFO
     */
    public static final int INFO = Log.INFO;

    /**
     * @see android.util.Log#WARN
     */
    public static final int WARN = Log.WARN;

    /**
     * @see android.util.Log#ERROR
     */
    public static final int ERROR = Log.ERROR;

    /**
     * @see android.util.Log#ASSERT
     */
    public static final int ASSERT = Log.ASSERT;

    public static String getLevelName(int Level) {
        String levelName;
        switch (Level) {
            case VERBOSE:
                levelName = "VERBOSE";
                break;
            case DEBUG:
                levelName = "DEBUG";
                break;
            case INFO:
                levelName = "INFO";
                break;
            case WARN:
                levelName = "WARN";
                break;
            case ERROR:
                levelName = "ERROR";
                break;
            case ASSERT:
                levelName = "ASSERT";
                break;
            default:
                if (Level < VERBOSE) {
                    levelName = "VERBOSE-" + (VERBOSE - Level);
                } else {
                    levelName = "ASSERT+" + (Level - ASSERT);
                }
                break;
        }
        return levelName;
    }

}
