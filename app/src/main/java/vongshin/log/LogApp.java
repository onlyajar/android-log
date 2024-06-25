package vongshin.log;

import android.app.Application;

public class LogApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LogConfiguration.getInstance()
                .addLogcatAppender()
                .addDayBasedAppender(2, "sdcard/aloga/likemis.log")
                .addSizeBasedAppender(3, "5MB", "sdcard/alogb/likemis.log")
                .setLevel(LogLevel.DEBUG);
    }
}
