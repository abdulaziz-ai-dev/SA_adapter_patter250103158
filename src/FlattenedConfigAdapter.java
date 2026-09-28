import java.util.Map;

public class FlattenedConfigAdapter implements IConfiguration {
    private NestedConfigStore store;

    public FlattenedConfigAdapter(NestedConfigStore store) {
        this.store = store;
    }

    public String getString(String dottedKey) {
        if (dottedKey == null || dottedKey.isEmpty()) {
            return null;
        }

        String[] parts = dottedKey.split("\\.");
        Map<String, Object> currentMap = store.getRawConfig();

        for (int i = 0; i < parts.length; i++) {
            if (currentMap == null) {
                return null;
            }

            Object val = currentMap.get(parts[i]);

            if (i == parts.length - 1) {
                return val != null ? String.valueOf(val) : null;
            }

            if (val instanceof Map) {
                currentMap = (Map<String, Object>) val;
            } else {
                return null;
            }
        }

        return null;
    }
}