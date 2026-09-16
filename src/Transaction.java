import java.time.LocalDate;
import java.io.Serializable;

public class Transaction implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int idCounter = 1000;
    
    private String transactionId;
    private String bookId;
    private String userId;
    private LocalDate issueDate;
    private LocalDate dueDate;

    public Transaction(String bookId, String userId, LocalDate issueDate) {
        this.transactionId = "TXN" + (++idCounter);
        this.bookId = bookId;
        this.userId = userId;
        this.issueDate = issueDate;
        this.dueDate = FineUtils.calculateDueDate(issueDate);
    }

    public String getUserId() { return userId; }
    public LocalDate getDueDate() { return dueDate; }

    @Override
    public String toString() {
        return "TXN ID: " + transactionId + " | Book: " + bookId + " | User: " + userId + 
               " | Issued: " + issueDate + " | Due: " + dueDate;
    }
}