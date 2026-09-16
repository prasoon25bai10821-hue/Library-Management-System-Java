import  java.util. HashMap;

import java. time.LocalDate;

import   java. io. Serializable;
public class Library implements Serializable {

    private static final long serialVersionUID = 1L;

    private HashMap<String, Book> books = new HashMap<>();
    private HashMap<String, User> users = new HashMap<>();

    private HashMap<String, Transaction> activeTransactions = new HashMap<>();

    public Library() {
        // adding a admin account while library is created
        users.put("admin", new User("admin", "System Administrator", true));
    }

    public User getUser(String userId) {
        
        return users.get(userId);
    }
    public void addBook(Book book) {
        
        String bookId = book.getId();
         if (books.containsKey(bookId)) {
           
            System.out.println("Error: Book ID already exists.");
            return;
        }
        books.put(bookId, book);
        
        System.out.println("Book added successfully!");
    }
    public void addUser(User user) {
        
        String userId = user.getUserId();
        if (users.containsKey(userId)) {
            System.out.println("Error: User ID already registered.");
            return;
        }
        users.put(userId, user);
        
        System.out.println("User registered successfully!");
    }
    public boolean issueBook(String bookId, String userId, LocalDate issueDate) {

       
        if (!books.containsKey(bookId)) {
            System.out.println("Error: Invalid Book ID.");
            return false;
        }

        Book book = books.get(bookId);

        if (!book.isAvailable()) {
            System.out.println("Book is currently checked out.");
            return false;
        }

        book.setAvailable(false);

        Transaction transaction = new Transaction(bookId, userId, issueDate);
        activeTransactions.put(bookId, transaction);

        System.out.println("Success! Book issued. Due Date: "
                + transaction.getDueDate());

        return true;
    }

    public void addToWaitlist(String bookId, String userId) {
        Book book = books.get(bookId);

        book.addToWaitlist(userId);

        System.out.println("You have been added to the waitlist. Position: "
                + book.getWaitlistSize());
    }
    public void returnBook(String bookId, LocalDate returnDate) {

        if (!activeTransactions.containsKey(bookId)) {
            System.out.println("Error: This book is not currently issued.");
            return;
        }

        Transaction transaction = activeTransactions.get(bookId);
        User user = users.get(transaction.getUserId());
        Book book = books.get(bookId);

        long fine = FineUtils.calculateFine(
                transaction.getDueDate(), returnDate);

        if (fine > 0) {
            user.addFine(fine);
            System.out.println("WARNING: Book returned late! Fine added: Rs " + fine);
        }

        book.setAvailable(true);
        activeTransactions.remove(bookId);

        System.out.println("Book returned successfully.");

        // checking that someone is waiting for the book??
        String nextUserId = book.getNextInWaitlist();

        if (nextUserId != null) {
            System.out.println("\n*** WAITLIST ALERT ***");
            System.out.println("This book was reserved! Automatically issuing "
                    + "to waitlisted user: " + nextUserId);

            issueBook(bookId, nextUserId, returnDate);
        }
    }
    public void displayUsers() {
        
        System.out.println("\n--- Registered Users ---");

        for (User user : users.values()) {
            System.out.println(user.toString());
        }
    }

    public void displayBooks() {
       
        System.out.println("\n--- Library Inventory ---");

        
        for (Book book : books.values()) {
           
            System.out.println(book.toString());
        }
    }
}
