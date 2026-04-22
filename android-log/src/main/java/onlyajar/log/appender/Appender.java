package onlyajar.log.appender;

public interface Appender {

    void println(int level, String tag, String msg);

    void println(int level, String tag, String msg, Throwable t);
}
