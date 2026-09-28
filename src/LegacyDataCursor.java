public class LegacyDataCursor {
    // Moves cursor. Returns false if no more rows.
    public boolean next() { return true; }
    public String getString(String colName) { return "CS301"; }
    public int getInt(String colName) { return 95; }
}