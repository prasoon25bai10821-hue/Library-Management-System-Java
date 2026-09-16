import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Main {
    private static Library library;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Load persistent data
        library = DataStorage.loadLibrary();
        
        while (true) {
            System.out.println("\n=================================");
            System.out.println("  Welcome to the Library System  ");
            System.out.println("=================================");
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as Student/Patron");
            System.out.println("3. Exit System");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Error: Please enter a number.");
                scanner.nextLine();
                continue;
            }
            int mainChoice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (mainChoice == 1) {
                // Automatically fetch the default admin account
                User admin = library.getUser("admin");
                System.out.println("\nWelcome, System Administrator!");
                adminMenu(admin);
            } else if (mainChoice == 2) {
                String loginId = getValidInput("Enter your Student/Patron ID: ");
                User patron = library.getUser(loginId);
                
                if (patron == null) {
                    System.out.println("Error: User not found. Please ask an Admin to register you.");
                } else if (patron.isAdmin()) {
                    System.out.println("Error: This is an Admin ID. Please use Option 1.");
                } else {
                    System.out.println("\nWelcome, " + patron.getName() + "!");
                    patronMenu(patron);
                }
            } else if (mainChoice == 3) {
                DataStorage.saveLibrary(library);
                System.out.println("System shutting down. All data saved.");
                break;
            } else {
                System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }
        }
        scanner.close();
    }

    // Role 1: Admin Menu
    private static void adminMenu(User admin) {
        int choice = 0;
        do {
            System.out.println("\n--- ADMIN MENU ---");
            System.out.println("1. Add New Book");
            System.out.println("2. Register New User");
            System.out.println("3. View All Books");
            System.out.println("4. View All Users");
            System.out.println("5. Logout to Main Menu (Saves Data)");
            System.out.print("Choice: ");
            
            if (!scanner.hasNextInt()) {
                System.out.println("Error: Please enter a valid number.");
                scanner.nextLine();
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    String bId = getValidInput("Enter Book ID (e.g., B101): ");
                    String title = getValidInput("Enter Title: ");
                    String author = getValidInput("Enter Author: ");
                    library.addBook(new Book(bId, title, author));
                    break;
                case 2:
                    String uId = getValidInput("Enter User ID (e.g., U201): ");
                    String name = getValidInput("Enter Name: ");
                    String role = getValidInput("Is this user an Admin? (Y/N): ");
                    boolean isAdmin = role.equalsIgnoreCase("Y");
                    library.addUser(new User(uId, name, isAdmin));
                    break;
                case 3:
                    library.displayBooks();
                    break;
                case 4:
                    library.displayUsers();
                    break;
                case 5:
                    System.out.println("Logging out...");
                    DataStorage.saveLibrary(library);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }

    //Role 2: Patron Men
    private static void patronMenu(User patron) {
        int choice = 0;
        do {
            System.out.println("\n--- PATRON MENU ---");
            System.out.println("1. View All Books");
            System.out.println("2. Issue a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Check My Fines");
            System.out.println("5. Logout to Main Menu (Saves Data)");
            System.out.print("Choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Error: Please enter a valid number.");
                scanner.nextLine();
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        library.displayBooks();
                        break;
                    case 2:
                        String issueBId = getValidInput("Enter Book ID to issue: ");
                        String iDateStr = getValidInput("Enter Today's Date (YYYY-MM-DD): ");
                        LocalDate iDate = LocalDate.parse(iDateStr);
                        
                        boolean success = library.issueBook(issueBId, patron.getUserId(), iDate);
                        if (!success) {
                            String wait = getValidInput("Would you like to join the waitlist for this book? (Y/N): ");
                            if (wait.equalsIgnoreCase("Y")) {
                                library.addToWaitlist(issueBId, patron.getUserId());
                            }
                        }
                        break;
                    case 3:
                        String returnBId = getValidInput("Enter Book ID to return: ");
                        String rDateStr = getValidInput("Enter Actual Return Date (YYYY-MM-DD): ");
                        LocalDate rDate = LocalDate.parse(rDateStr);
                        library.returnBook(returnBId, rDate);
                        break;
                    case 4:
                        System.out.println("Total Pending Fines: Rs " + patron.getTotalFinesPending());
                        break;
                    case 5:
                        System.out.println("Logging out...");
                        DataStorage.saveLibrary(library);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Error: Invalid date format. Please strictly use YYYY-MM-DD.");
            }
        } while (choice != 5);
    }

    private static String getValidInput(String prompt) {
        String input = "";
        while (input.trim().isEmpty()) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
        }
        return input;
    }
}