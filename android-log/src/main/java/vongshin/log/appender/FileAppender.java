package vongshin.log.appender;

import android.os.HandlerThread;
import vongshin.log.LogEvent;
import vongshin.log.encoder.LayoutEncoder;
import vongshin.log.encoder.PatternLayoutEncoder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FileAppender implements Appender {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.US);
    HandlerThread handlerThread = new HandlerThread("log-handler-thread");
    final LayoutEncoder layoutEncoder = new PatternLayoutEncoder();

    @Override
    public int println(int level, String tag, String msg) {
        return 0;
    }

    @Override
    public int println(int level, String tag, String msg, Throwable t) {
        return 0;
    }

    private LogEvent newLogEvent(int level, String tag, String msg, Throwable t){
        String dateTime = simpleDateFormat.format(new Date());
        String thread = Thread.currentThread().getName();
        return new LogEvent(level, tag, msg, t, thread, dateTime);
    }

}
