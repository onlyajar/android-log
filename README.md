# startup

[![](https://www.jitpack.io/v/onlyajar/android-log.svg)](https://www.jitpack.io/#onlyajar/android-log)
### 快速配置 

#### gradle
```groovy
implementation 'com.github.onlyajar:android-log:0.0.1'
```
#### gradle.kts
```groovy
implementation("com.github.onlyajar:android-log:0.0.1")
```

### 使用说明
```java
public void initLogger() {
    LogConfiguration.getInstance()
            .addLogcatAppender()
            .addDayBasedAppender(2, "sdcard/aloga/likemis.log")
            .addSizeBasedAppender(3, "5MB", "sdcard/alogb/likemis.log")
            .setLevel(LogLevel.DEBUG);
}
```

