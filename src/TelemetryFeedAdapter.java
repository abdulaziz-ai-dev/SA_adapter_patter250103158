import java.util.LinkedHashMap;
import java.util.Map;

public class TelemetryFeedAdapter implements ITelemetryService {
    private LegacySensorFeed feed;

    public TelemetryFeedAdapter(LegacySensorFeed feed) {
        this.feed = feed;
    }

    public Map<String, String> getCleanTelemetry() {
        Map<String, String> map = new LinkedHashMap<>();
        String raw = feed.getRawTelemetry();

        if (raw == null || raw.trim().isEmpty()) {
            return map;
        }

        String[] pairs = raw.split(";");
        for (String pair : pairs) {
            pair = pair.trim();
            if (pair.isEmpty()) {
                continue;
            }

            if (pair.contains("=")) {
                String[] parts = pair.split("=", 2);
                String key = parts[0].trim();
                String value = parts[1].trim();
                map.put(key, value);
            }
        }

        return map;
    }
}