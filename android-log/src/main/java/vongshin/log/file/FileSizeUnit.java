package vongshin.log.file;

public enum FileSizeUnit {
    Bytes(1L),
    KB(1024L),
    MB(1048576L),
    GB(1073741824L);

    private long factor;

    FileSizeUnit(long factor) {
        this.factor = factor;
    }

    public long getFactor() {
        return factor;
    }
}
