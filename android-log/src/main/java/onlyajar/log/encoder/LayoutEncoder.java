package onlyajar.log.encoder;

import onlyajar.log.LogEvent;

public interface LayoutEncoder {
    String encode(LogEvent event);
}
