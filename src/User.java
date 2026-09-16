import java.io.Serializable;
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;
    private String name;

    private long totalFinesPending;
    private boolean isAdmin;
    public User(String userId, String name, boolean isAdmin) {

        // settingsbasic details when user is created
        this.userId = userId;
       
        this.name = name;
        this.isAdmin = isAdmin;

        // new users dont have any fine at starting
       
        this.totalFinesPending = 0;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public boolean isAdmin() {
        
        return isAdmin;
    }

    public long getTotalFinesPending() {
        return totalFinesPending;
    }

    // add fine amount to users pending fine
    
    public void addFine(long amount) {
        this.totalFinesPending += amount;
    }

    // after paying fine make it zero
    public void payFine() {
        this.totalFinesPending = 0;
    }

    @Override
    public String toString() {

        // checking which role this user have
        String role = isAdmin ? "[ADMIN]" : "[PATRON]";

        return role
                + " User ID: " + userId
                + " | Name: " + name
                + " | Fines: Rs " + totalFinesPending;
    }
}
