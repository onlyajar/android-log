package vongshin.log.encoder;

import android.util.Log;
import vongshin.log.LogEvent;
import vongshin.log.LogLevel;

public class PatternLayoutEncoder implements LayoutEncoder{
    /**
     *    <!--格式化输出：%d表示日期，%thread表示线程名，%-5level：级别从左显示5个字符宽度%msg：日志消息，%n是换行符-->
     *             <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} - %msg%n</pattern>
     * @param event
     * @return
     */
    @Override
    public String encode(LogEvent event) {
        return new StringBuilder()
                .append(event.getDateTime())
                .append(" [")
                .append(event.getThread())
                .append(']')
                .append(" -")
                .append(LogLevel.getLevelName(event.getLevel()))
                .append(' ')
                .append(event.getTag())
                .append(' ')
                .append(event.getMessage())
                .append(Log.getStackTraceString(event.getTr()))
                .toString();
    }
}
