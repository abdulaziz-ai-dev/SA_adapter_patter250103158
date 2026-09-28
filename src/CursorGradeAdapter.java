public class CursorGradeAdapter implements IGradeProvider {
    private LegacyDataCursor cursor;

    public CursorGradeAdapter(LegacyDataCursor cursor) {
        this.cursor = cursor;
    }

    public GradeRecord fetchCurrentGrade() {
        String courseCode = cursor.getString("COURSE_NAME");
        int score = cursor.getInt("STUDENT_SCORE");

        return new GradeRecord(courseCode, score);
    }
}