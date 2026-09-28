public class CsvUserAdapter implements IUserSource {
    private LegacyCsvUserStore store;

    public CsvUserAdapter(LegacyCsvUserStore store) {
        this.store = store;
    }

    public UserProfile getNextUser() {
        String row = store.fetchNextRow();

        if (row == null) {
            throw new IllegalStateException();
        }

        String[] parts = row.split(",");
        if (parts.length < 3) {
            throw new IllegalStateException();
        }

        int id = Integer.parseInt(parts[0].trim());
        String fullName = parts[1].trim();
        String role = parts[2].trim();

        return new UserProfile(id, fullName, role);
    }
}