package vongshin.log;

public interface LogOut {
    /**
     *
     * @param level    log level
     * @param tag      log tag
     * @param massage  log msg
     * @param tr       log tr
     * @return         result
     */
    int println(int level, String tag, String massage, Throwable tr);
}
