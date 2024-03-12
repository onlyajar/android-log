package vongshin.log.appender;

public interface Appender {

    int println(int level, String tag, String msg);

    int println(int level, String tag, String msg, Throwable t);
}
