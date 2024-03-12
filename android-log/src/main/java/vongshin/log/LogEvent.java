package vongshin.log;

final public class LogEvent {
    private int level;

    private String tag;

    private String message;

    private Throwable tr;

    private String thread;

    private String dateTime;

    public LogEvent(int level, String tag, String message) {
       this(level, tag, message, null);
    }

    public LogEvent(int level, String tag, String message, Throwable tr) {
        this.level = level;
        this.tag = tag;
        this.message = message;
        this.tr = tr;
    }

    public LogEvent(int level, String tag, String message, Throwable tr, String thread, String dateTime) {
        this.level = level;
        this.tag = tag;
        this.message = message;
        this.tr = tr;
        this.thread = thread;
        this.dateTime = dateTime;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Throwable getTr() {
        return tr;
    }

    public void setTr(Throwable tr) {
        this.tr = tr;
    }

    public String getThread() {
        return thread;
    }

    public String getDateTime() {
        return dateTime;
    }
}
