public class DatabaseAdapter implements IRepository {
    private LegacyDatabaseConnection connection;

    public DatabaseAdapter(LegacyDatabaseConnection connection) {
        this.connection = connection;
    }

    public String findById(int id) throws RecordNotFoundException, DatabaseLockedException {
        String[] outBuffer = new String[1];
        int status = connection.executeFetch(id, outBuffer);

        if (status == -1) {
            throw new RecordNotFoundException("Record not found");
        }
        if (status == -2) {
            throw new DatabaseLockedException("Database locked");
        }

        return outBuffer[0];
    }
}