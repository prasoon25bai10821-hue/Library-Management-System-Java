import java.time. LocalDate;

import  java.time.temporal. ChronoUnit;



public class FineUtils {

    private static final int FINE_PER_DAY = 50;

    
    // The date is been caculating by which the book been returned.
    
   
    public  static LocalDate  calculateDueDate(LocalDate issueDate) {
        
        return  issueDate.plusDays( 15);
    }

    // the fine being calculated if book is returned after the due date
    public static long  calculateFine(LocalDate dueDate, LocalDate returnDate) {

        if (!returnDate.isAfter (dueDate)) {
            return 0;
        }

        long  daysLate = ChronoUnit.DAYS.between(dueDate, returnDate);
        
        return daysLate * FINE_PER_DAY;
    }
}
