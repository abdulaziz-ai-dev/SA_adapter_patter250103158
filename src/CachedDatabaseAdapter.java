import java.util.HashMap;
import java.util.Map;

public class CachedDatabaseAdapter implements ICachedDataService {
    private ExpensiveRemoteDatabase database;
    private Map<Integer, String> cache = new HashMap<>();
    private int hitCounter = 0;

    public CachedDatabaseAdapter(ExpensiveRemoteDatabase database) {
        this.database = database;
    }

    public String read(int id) {
        if (cache.containsKey(id)) {
            hitCounter++;
            return cache.get(id);
        }

        String data = database.queryById(id);
        cache.put(id, data);
        return data;
    }

    public int getCacheHitCount() {
        return hitCounter;
    }
}