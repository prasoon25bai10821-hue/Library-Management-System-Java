import java.io.Serializable;

import java.util.LinkedList;
import java.util.Queue;

public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String title;

    private String author;

    private boolean available;

    // Stores the user's waiting for this book
    private Queue<String> waitlist;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
        this.waitlist = new LinkedList<>();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Add a user to  end of the waiting list
    public void addToWaitlist(String userId) {
        waitlist.add(userId);
    }

    // Get the first user waiting for the book
    public String getNextInWaitlist() {
        return waitlist.poll();
    }

    public int getWaitlistSize() {
        return waitlist.size();
    }

    @Override
    public String toString() {
        return "Book ID: " + id
                + " | Title: " + title
                + " | Author: " + author
                + " | Available: " + available
                + " | Waitlist: " + waitlist.size() + " people";
    }
}
