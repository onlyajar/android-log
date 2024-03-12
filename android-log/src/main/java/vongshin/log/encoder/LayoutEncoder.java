package vongshin.log.encoder;

import vongshin.log.LogEvent;

public interface LayoutEncoder {
    String encode(LogEvent event);
}
