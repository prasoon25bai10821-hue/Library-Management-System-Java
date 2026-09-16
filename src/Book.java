import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String title;
    private String author;
    private boolean isAvailable;
    private Queue<String> waitlist;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        this.waitlist = new LinkedList<>();
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
    
    public void addToWaitlist(String userId) {
        waitlist.add(userId);
    }
    
    public String getNextInWaitlist() {
        return waitlist.poll(); // Returns and removes the first person in line, or null if empty
    }

    public int getWaitlistSize() {
        return waitlist.size();
    }

    @Override
    public String toString() {
        return "Book ID: " + id + " | Title: " + title + " | Author: " + author + 
               " | Available: " + isAvailable + " | Waitlist: " + waitlist.size() + " people";
    }
}