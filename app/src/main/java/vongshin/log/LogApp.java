package vongshin.log;

import android.app.Application;

public class LogApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LogConfiguration.getInstance()
                .addLogcatAppender()
                .addDayBasedAppender(5, "sdcard/aloga/likemis.log")
                .setLevel(LogLevel.DEBUG);
    }
}
