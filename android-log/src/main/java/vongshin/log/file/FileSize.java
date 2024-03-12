package vongshin.log.file;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileSize {
    private static final Pattern FILE_SIZE_PATTERN = Pattern.compile("([0-9]+)\\s*(|kb|mb|gb)s?", 2);
    final long size;

    public FileSize(long size) {
        this.size = size;
    }

    public FileSize(long size, FileSizeUnit unit) {
        this.size = size * unit.getFactor();
    }
    public long getSize() {
        return this.size;
    }

    public static FileSize valueOf(String fileSize) {
        Matcher matcher = FILE_SIZE_PATTERN.matcher(fileSize);
        if (matcher.matches()) {
            long size = Long.valueOf(matcher.group(1));
            String unit = matcher.group(2);
            long factor;
            if (unit.equalsIgnoreCase("")) {
                factor = FileSizeUnit.Bytes.getFactor();
            } else if (unit.equalsIgnoreCase("kb")) {
                factor = FileSizeUnit.KB.getFactor();
            } else if (unit.equalsIgnoreCase("mb")) {
                factor = FileSizeUnit.MB.getFactor();
            } else {
                if (!unit.equalsIgnoreCase("gb")) {
                    throw new IllegalStateException("Unexpected " + unit);
                }
                factor = FileSizeUnit.GB.getFactor();
            }
            return new FileSize(size * factor);
        } else {
            throw new IllegalArgumentException("String value [" + fileSize + "] is not in the expected format.");
        }
    }

    public String toString() {
        long kbs = this.size / 1024L;
        if (kbs == 0L) {
            return this.size + " Bytes";
        } else {
            long mbs = this.size / 1048576L;
            if (mbs == 0L) {
                return kbs + " KB";
            } else {
                long gbs = this.size / 1073741824L;
                return gbs == 0L ? mbs + " MB" : gbs + " GB";
            }
        }
    }
}
