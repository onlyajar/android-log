package onlyajar.log.appender;

import android.os.Handler;
import android.os.HandlerThread;
import onlyajar.log.LogEvent;
import onlyajar.log.encoder.LayoutEncoder;
import onlyajar.log.encoder.PatternLayoutEncoder;
import onlyajar.log.file.FileOutWriter;
import onlyajar.log.rolling.TriggeringPolicy;
import onlyajar.log.strategy.RollingStrategy;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public abstract class FileAppender implements Appender {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.US);
    HandlerThread handlerThread = new HandlerThread("log-handler-thread");
    private Handler handler = null;
    final LayoutEncoder layoutEncoder = new PatternLayoutEncoder();
    public FileAppender() {
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
        final String logEncode = layoutEncoder.encode(event);
        handler.post(new Runnable() {
            @Override
            public void run(){
                File file = getRollingStrategy().getRealFile();
                boolean rolling = getTriggeringPolicy().isTriggeringEvent(file);
                if(rolling){
                    file =  getRollingStrategy().getRollingFile();
                }
                FileOutWriter fileOutWriter = new FileOutWriter(file);
                fileOutWriter.writeln(logEncode);
            }
        });
    }

    private LogEvent newLogEvent(int level, String tag, String msg, Throwable t){
        String dateTime = simpleDateFormat.format(new Date());
        String thread = Thread.currentThread().getName();
        return new LogEvent(level, tag, msg, t, thread, dateTime);
    }

    public abstract TriggeringPolicy getTriggeringPolicy();

    public abstract RollingStrategy getRollingStrategy();

}
