public class ExpensiveRemoteDatabase {
    public String queryById(int queryId) {
        // Simulates expensive operation
        return "DATA_FOR_" + queryId;
    }
}