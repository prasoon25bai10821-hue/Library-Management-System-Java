import java.util.HashMap;
import java.time.LocalDate;
import java.io.Serializable;

public class Library implements Serializable {
    private static final long serialVersionUID = 1L;
    private HashMap<String, Book> books = new HashMap<>();
    private HashMap<String, User> users = new HashMap<>();
    private HashMap<String, Transaction> activeTransactions = new HashMap<>();

    public Library() {
        // Create a default admin if the system is completely empty
        users.put("admin", new User("admin", "System Administrator", true));
    }

    public User getUser(String userId) { return users.get(userId); }

    public void addBook(Book book) {
        if (books.containsKey(book.getId())) {
            System.out.println("Error: Book ID already exists.");
        } else {
            books.put(book.getId(), book);
            System.out.println("Book added successfully!");
        }
    }

    public void addUser(User user) {
        if (users.containsKey(user.getUserId())) {
            System.out.println("Error: User ID already registered.");
        } else {
            users.put(user.getUserId(), user);
            System.out.println("User registered successfully!");
        }
    }

    public boolean issueBook(String bookId, String userId, LocalDate issueDate) {
        if (!books.containsKey(bookId)) {
            System.out.println("Error: Invalid Book ID.");
            return false;
        }
        
        Book book = books.get(bookId);
        if (!book.isAvailable()) {
            System.out.println("Book is currently checked out.");
            return false; // Returns false so Main.java can trigger the waitlist prompt
        }

        book.setAvailable(false);
        Transaction txn = new Transaction(bookId, userId, issueDate);
        activeTransactions.put(bookId, txn);
        
        System.out.println("Success! Book issued. Due Date: " + txn.getDueDate());
        return true;
    }
    
    public void addToWaitlist(String bookId, String userId) {
        Book book = books.get(bookId);
        book.addToWaitlist(userId);
        System.out.println("You have been added to the waitlist. Position: " + book.getWaitlistSize());
    }

    public void returnBook(String bookId, LocalDate returnDate) {
        if (!activeTransactions.containsKey(bookId)) {
            System.out.println("Error: This book is not currently issued.");
            return;
        }

        Transaction txn = activeTransactions.get(bookId);
        User user = users.get(txn.getUserId());
        Book book = books.get(bookId);

        long fine = FineUtils.calculateFine(txn.getDueDate(), returnDate);
        if (fine > 0) {
            user.addFine(fine);
            System.out.println("WARNING: Book returned late! Fine added: Rs " + fine);
        }

        book.setAvailable(true);
        activeTransactions.remove(bookId);
        System.out.println("Book returned successfully.");

        // Waitlist Logic
        String nextUserId = book.getNextInWaitlist();
        if (nextUserId != null) {
            System.out.println("\n*** WAITLIST ALERT ***");
            System.out.println("This book was reserved! Automatically issuing to waitlisted user: " + nextUserId);
            issueBook(bookId, nextUserId, returnDate); // Auto-issue to the next person
        }
    }

    public void displayUsers() {
        System.out.println("\n--- Registered Users ---");
        for (User u : users.values()) System.out.println(u.toString());
    }
    
    public void displayBooks() {
        System.out.println("\n--- Library Inventory ---");
        for (Book b : books.values()) System.out.println(b.toString());
    }
}