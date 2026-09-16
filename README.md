# Library Management System - Java

A simple console-based **Library Management System** made in Java for the VITyarthi **Build Your Own Project** evaluation. The project helps to manage books, users, book issue and return, due dates, fines, waitlists, and saved library data.

## 1. Project Overview

The Library Management System is a command-line application made to handle some common library operations in a simple way.

The system mainly has two types of users:

- **Admin** – manages books and users and can also view library records.
- **Student/Patron** – can view books, issue and return books, join a waitlist, and check pending fines.

The library data is saved in a local file. Because of this, the information can be loaded again when the application is started next time.

## 2. Problem Statement

Managing a library manually can be difficult when there are many books and users. It can also become confusing to keep track of issued books, return dates, fines, and waiting lists.

This project provides a Java-based solution for handling these operations through a menu-driven console application. The library data is also saved so that it can be used again after restarting the program.

## 3. Objectives

The main objectives of this project are:

- Manage library books and their availability.
- Register and manage library users.
- Issue and return books.
- Calculate due dates and overdue fines.
- Maintain a waitlist when a book is not available.
- Automatically issue a returned book to the next person in the waitlist.
- Save library data using Java serialization.
- Demonstrate different Java programming concepts through a modular project.

## 4. Functional Requirements

### Module 1: User Management

- A default administrator account is created when a new library is initialized.
- Admin can register new users.
- Every user is identified using a unique User ID.
- Users can be classified as Admin or Patron/Student.
- Duplicate User IDs are not allowed.

### Module 2: Book Management

- Admin can add new books.
- Each book contains a Book ID, title, author, and availability status.
- Duplicate Book IDs are not allowed.
- Admin and patrons can view the library inventory.
- The system keeps track of the number of people waiting for a book.

### Module 3: Book Issue and Return

- Patrons can issue a book if it is available.
- Every issue creates a transaction with a transaction ID.
- The due date is calculated as 15 days after the issue date.
- A returned book becomes available again.
- Invalid Book IDs and books that are not currently issued are handled with error messages.

### Module 4: Fine and Waitlist Management

- A fine of **Rs 50 per late day** is charged for late returns.
- Pending fines are stored against the user.
- If a book is unavailable, a patron can join its waitlist.
- The waitlist follows a first-in-first-out queue system.
- When a reserved book is returned, the next waitlisted user is automatically issued the book.

### Module 5: Data Persistence

- Library data is stored in `library_data.ser`.
- Data is loaded when the application starts.
- Data is saved when the user exits or logs out.
- If no previous data is available, the system starts with a fresh library.

## 5. Input and Output Structure

### Inputs

The application takes input through the command line using `Scanner`.

Some examples of input are:

- Main menu choice
- Admin/patron login ID
- Book ID
- Book title
- Author name
- User ID
- User name
- Issue date
- Return date
- Waitlist confirmation

### Outputs

The application displays:

- Menu options
- Book inventory
- Registered users
- Book issue confirmation
- Due dates
- Fine amounts
- Waitlist notifications
- Validation and error messages
- Data saving and loading messages

## 6. System Workflow

```text
Start
  |
  v
Load saved library data
  |
  v
Main Menu
  |
  +-------------------------+
  |                         |
  v                         v
Admin Login           Student/Patron Login
  |                         |
  v                         v
Admin Menu             Patron Menu
  |                         |
  +------------+------------+
               |
               v
        Perform Operation
               |
               v
       Save Library Data
               |
               v
              Exit
```

## 7. Technologies and Tools Used

- **Programming Language:** Java
- **Java APIs:** `java.util`, `java.time`, `java.io`
- **Data Structures:** `HashMap`, `Queue`, `LinkedList`
- **Date Handling:** `LocalDate`, `ChronoUnit`
- **Persistence:** Java Object Serialization
- **Input Handling:** `Scanner`
- **Version Control:** Git / GitHub
- **Application Type:** Command-Line Interface (CLI)

## 8. Java Concepts Demonstrated

### Object-Oriented Programming

The project is divided into separate classes such as `Book`, `User`, `Library`, and `Transaction`. Each class handles a specific part of the library system.

### Encapsulation

The data members of the classes are kept private and are accessed using methods such as getters and setters.

### Collections Framework

Different Java collections are used to store and manage the project data.

- `HashMap` is used to store books, users, and active transactions.
- `Queue` with `LinkedList` is used to manage the book waitlist.

### Serialization

`Book`, `User`, `Transaction`, and `Library` implement `Serializable`. This allows the library information to be saved and loaded again.

### Exception Handling

The application handles different types of errors such as:

- Invalid numeric menu input
- Invalid date formats
- File loading and saving errors
- Missing saved data

### Date and Time API

`LocalDate` is used for issue and return dates. `ChronoUnit.DAYS` is used to calculate the number of overdue days.

### Enum

The `Role` enum defines the available roles:

- `ADMIN`
- `STUDENT`

## 9. Project Structure

The Java source files are kept inside the `src` folder.

```text
Library-Management-System-Java/
│
├── README.md
├── statement.md
│
└── src/
    ├── Main.java
    ├── Library.java
    ├── Book.java
    ├── User.java
    ├── Transaction.java
    ├── DataStorage.java
    ├── FineUtils.java
    └── Role.java
```

> **Important:** The role file must be named `Role.java`, not `Role.jav`, because Java requires a public top-level enum or class to use the matching `.java` source filename.

## 10. Installation and Setup

### Prerequisites

Before running the project, install:

- Java JDK
- Git, if you want to clone the GitHub repository

You can check whether Java is installed by using:

```bash
java -version
javac -version
```

### Clone the Repository

```bash
git clone https://github.com/prasoon25bai10821-hue/Library-Management-System-Java
cd Library-Management-System-Java
```

### Compile the Project

Since all Java source files are inside the `src` folder, use:

```bash
javac -d out src/*.java
```

### Run the Project

```bash
java -cp out Main
```

If your terminal is already inside the `src` directory, you can also compile and run it using:

```bash
javac *.java
java Main
```

## 11. How to Use

### Admin

1. Start the application.
2. Select `1. Login as Admin`.
3. The admin menu will be displayed.
4. Add books or register new users.
5. View all books or users.
6. Logout when finished to save the data.

The default administrator ID is:

```text
admin
```

### Student/Patron

1. Ask the administrator to register a user.
2. Select `2. Login as Student/Patron`.
3. Enter the registered User ID.
4. View the available books.
5. Issue a book if it is available.
6. Enter the issue date in `YYYY-MM-DD` format.
7. Return the book using the actual return date.
8. Check pending fines when required.

### Waitlist

If a requested book is already checked out:

1. The system shows that the book is unavailable.
2. The patron can choose to join the waitlist.
3. The request is stored according to queue order.
4. When the book is returned, the next waitlisted patron is automatically issued the book.

## 12. Fine Calculation

The system provides a **15-day borrowing period**.

```text
Due Date = Issue Date + 15 days
```

The fine is calculated using:

```text
Fine = Number of Late Days × Rs 50
```

For example:

```text
Issue Date  : 2026-09-01
Due Date    : 2026-09-16
Return Date : 2026-09-19

Late Days   : 3
Fine        : 3 × Rs 50 = Rs 150
```

## 13. Data Storage

The application uses Java object serialization for storing library information.

The saved file is:

```text
library_data.ser
```

The `DataStorage` class is responsible for:

- Saving the `Library` object.
- Loading the previously saved `Library` object.
- Creating a fresh library if no previous data is available.

## 14. Error Handling and Validation

The application checks different types of input and system conditions:

- Non-numeric menu input is rejected.
- Empty text input is not accepted.
- Invalid dates are handled using `DateTimeParseException`.
- Duplicate Book IDs are rejected.
- Duplicate User IDs are rejected.
- Invalid Book IDs are reported.
- Trying to return a book that is not currently issued is reported.
- File storage errors are caught and reported.

## 15. Non-Functional Requirements

### Usability

The system uses a simple menu-driven CLI, so users can navigate the application by selecting numbered options.

### Reliability

Library data is saved to disk during logout and system exit. This allows the information to remain available when the application is started again.

### Maintainability

The project separates different responsibilities into classes such as `Library`, `Book`, `User`, `Transaction`, `DataStorage`, and `FineUtils`. This makes the project easier to understand and modify.

### Error Handling

Invalid menu choices, invalid dates, duplicate records, missing books, and storage problems are handled through validation and exception handling.

### Resource Efficiency

`HashMap` provides efficient key-based access to books, users, and active transactions. A queue is used to keep the waitlist in the correct order.

### Scalability

The current design allows more features to be added later, such as book search, categories, authentication, fine payment, reports, and database integration.

## 16. Testing Instructions

The current project is a CLI application, so its functionality can be tested by manually going through the different available workflows.

### Test Case 1: Add a Book

```text
Admin Login
→ Add New Book
→ Enter Book ID
→ Enter Title
→ Enter Author
→ View All Books
```

**Expected Result:** The newly added book appears in the library inventory.

### Test Case 2: Duplicate Book ID

Try adding a book using a Book ID that already exists.

**Expected Result:**

```text
Error: Book ID already exists.
```

### Test Case 3: Issue a Book

```text
Student/Patron Login
→ Issue a Book
→ Enter Book ID
→ Enter Issue Date
```

**Expected Result:** The book becomes unavailable and its due date is displayed.

### Test Case 4: Waitlist

Try to issue a book that is already checked out.

**Expected Result:** The system offers the patron an option to join the waitlist.

### Test Case 5: Late Return

Return a book after its due date.

**Expected Result:** The correct fine is added to the user's pending fines.

### Test Case 6: Data Persistence

1. Add some users and books.
2. Exit the application.
3. Start the application again.

**Expected Result:** The previously saved library information is loaded from `library_data.ser`.

## 17. Current Scope

The current version of the project focuses on:

- Admin and patron roles
- Book management
- User registration
- Book issue and return
- Due-date calculation
- Fine calculation
- Waitlist management
- Local persistent storage
- CLI interaction

## 18. Future Enhancements

Some possible improvements for the future are:

- Search books by title, author, or ID.
- Edit and delete book/user records.
- Add username and password authentication.
- Add fine payment through the patron menu.
- Add transaction history and reports.
- Add database support using MySQL/PostgreSQL.
- Create a GUI or web interface.
- Add unit testing using JUnit.
- Use the `Role` enum throughout the project for better role management.
- Add more input validation for dates and invalid return dates.

## 19. Design and Documentation

The VITyarthi project requirements also include different design and documentation artefacts such as:

- Problem Statement
- Objectives
- Functional Requirements
- Non-functional Requirements
- System Architecture Diagram
- Process/Workflow Diagram
- Use Case Diagram
- Class Diagram / Component Diagram
- Sequence Diagram
- Storage/ER/Schema design where applicable

These artefacts can be included in the project report and/or repository documentation according to the course instructions.

## 20. References

- Java Documentation / Java Standard Library
- VITyarthi - Build Your Own Project instructions
