import java.time.LocalDate;

import java.time.temporal.ChronoUnit;
public class FineUtils {

    private static final int FINE_PER_DAY = 50;

    // this method calculate the return date of book
    
    public static LocalDate calculateDueDate(LocalDate issueDate) {
        return issueDate.plusDays(15);
    }

    // checking how much fine is there if book is returned late
    public static long calculateFine(LocalDate dueDate, LocalDate returnDate) {

        if (!returnDate.isAfter(dueDate)) {
            
            return 0;
        }

        long daysLate = ChronoUnit.DAYS.between(dueDate, returnDate);

        // fine is 50 rupees for each late day
        
        return daysLate * FINE_PER_DAY;
    }
}
