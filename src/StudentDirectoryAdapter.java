public class StudentDirectoryAdapter implements IModernDirectory {
    private LegacyStudentDirectory directory;

    public StudentDirectoryAdapter(LegacyStudentDirectory directory) {
        this.directory = directory;
    }

    public int size() {
        return directory.totalEntries();
    }

    public String get(int zeroBasedIndex) {
        if (zeroBasedIndex < 0 || zeroBasedIndex >= size()) {
            throw new IndexOutOfBoundsException();
        }

        return directory.getStudentAt(zeroBasedIndex + 1);
    }
}