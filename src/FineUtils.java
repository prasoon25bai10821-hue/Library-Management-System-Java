import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FineUtils {
    private static final int FINE_PER_DAY = 50; // 50 Rs per day

    public static LocalDate calculateDueDate(LocalDate issueDate) {
        return issueDate.plusDays(15);
    }

    public static long calculateFine(LocalDate dueDate, LocalDate returnDate) {
        if (returnDate.isAfter(dueDate)) {
            long daysLate = ChronoUnit.DAYS.between(dueDate, returnDate);
            return daysLate * FINE_PER_DAY;
        }
        return 0;
    }
}