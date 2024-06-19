package vongshin.log.appender;

import android.os.Handler;
import android.os.HandlerThread;
import vongshin.log.LogEvent;
import vongshin.log.encoder.LayoutEncoder;
import vongshin.log.encoder.PatternLayoutEncoder;
import vongshin.log.file.FileOutWriter;
import vongshin.log.strategy.RollingStrategy;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public abstract class FileAppender implements Appender {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.US);
    HandlerThread handlerThread = new HandlerThread("log-handler-thread");
    private Handler handler = null;
    final LayoutEncoder layoutEncoder = new PatternLayoutEncoder();
    final RollingStrategy rollingStrategy = getRollingStrategy();
    private String filePath;
    public FileAppender(String filePath) {
        this.filePath = filePath;
        handlerThread.start();
        handler = new Handler(handlerThread.getLooper());
    }

    @Override
    public void println(int level, String tag, String msg) {
        this.println(level, tag, msg, null);
    }

    @Override
    public void println(int level, String tag, String msg, Throwable t) {
        LogEvent event = newLogEvent(level, tag, msg, t);
        String logEncode = layoutEncoder.encode(event);
        handler.post(()->{
            File file = getFile(filePath);
            boolean rolling = rollingStrategy.isRolling(file);
            if(rolling){
                file =  rollingStrategy.getWriteFile(file);
            }
            FileOutWriter fileOutWriter = new FileOutWriter(file);
            fileOutWriter.writeln(logEncode);
        });
    }

    private LogEvent newLogEvent(int level, String tag, String msg, Throwable t){
        String dateTime = simpleDateFormat.format(new Date());
        String thread = Thread.currentThread().getName();
        return new LogEvent(level, tag, msg, t, thread, dateTime);
    }

    public abstract RollingStrategy getRollingStrategy();

    public abstract File getFile(String filePath);

}
