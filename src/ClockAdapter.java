import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

public class ClockAdapter implements IModernCalendar {
    private LegacyClock clock;

    public ClockAdapter(LegacyClock clock) {
        this.clock = clock;
    }

    public LocalDate getCurrentDate() {
        long seconds = clock.getEpochSeconds();
        Instant instant = Instant.ofEpochSecond(seconds);
        return instant.atZone(ZoneOffset.UTC).toLocalDate();
    }
}