# Library Management System - Java

A console-based **Library Management System** developed in Java for the VITyarthi **Build Your Own Project** evaluation. The system manages books, library users, book issue/return transactions, due dates, fines, waitlists, and persistent storage.

## 1. Project Overview

The Library Management System provides a simple command-line solution for common library operations.

The system supports two main user roles:

- **Admin** – manages books and users and can view library records.
- **Student/Patron** – views books, issues and returns books, joins a waitlist, and checks pending fines.

Library data is saved to a local serialized file so that information can be restored when the application is started again.

## 2. Problem Statement

Manual library management can make it difficult to keep track of books, users, issue/return transactions, due dates, fines, and waiting lists.

This project provides a Java-based system that centralizes these operations in a menu-driven console application and maintains the library data between program executions.

## 3. Objectives

- Manage library books and their availability.
- Register and manage library users.
- Issue and return books.
- Calculate due dates and overdue fines.
- Maintain a waitlist when a book is unavailable.
- Automatically issue a returned book to the next waitlisted user.
- Persist library data using Java serialization.
- Demonstrate Java programming concepts through a modular implementation.

## 4. Functional Requirements

### Module 1: User Management

- Default administrator account is created when a new library is initialized.
- Admin can register new users.
- Users are identified using unique User IDs.
- Users are classified as Admin or Patron/Student.
- Duplicate User IDs are rejected.

### Module 2: Book Management

- Admin can add books.
- Each book has a Book ID, title, author, and availability status.
- Duplicate Book IDs are rejected.
- Admin and patrons can view the library inventory.
- The system tracks the number of people in a book's waitlist.

### Module 3: Book Issue and Return

- Patrons can issue an available book.
- Each issue creates a transaction with a transaction ID.
- The due date is calculated as 15 days after the issue date.
- A returned book becomes available again.
- Invalid book IDs and books that are not currently issued are handled with error messages.

### Module 4: Fine and Waitlist Management

- Late returns generate a fine of **Rs 50 per late day**.
- Pending fines are stored against the user.
- If a book is unavailable, a patron can join its waitlist.
- The waitlist follows a queue-based first-in-first-out approach.
- When a reserved book is returned, the next waitlisted user is automatically issued the book.

### Module 5: Data Persistence

- Library data is stored in `library_data.ser`.
- Data is loaded when the application starts.
- Data is saved when the user exits or logs out.
- If no previous data exists, the system starts with a fresh library.

## 5. Input and Output Structure

### Inputs

The application accepts input through the command line using `Scanner`.

Examples:

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
- Data-saving/loading messages

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
  +--------------------+
  |                    |
  v                    v
Admin Login       Student/Patron Login
  |                    |
  v                    v
Admin Menu         Patron Menu
  |                    |
  +----------+---------+
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

The project is divided into separate classes such as `Book`, `User`, `Library`, and `Transaction`.

### Encapsulation

Class data is stored in private fields and accessed through methods such as getters and setters.

### Collections Framework

- `HashMap` stores books, users, and active transactions.
- `Queue` with `LinkedList` implements the book waitlist.

### Serialization

`Book`, `User`, `Transaction`, and `Library` implement `Serializable`, allowing library information to be saved and restored.

### Exception Handling

The application handles:

- Invalid numeric menu input
- Invalid date formats
- File loading/saving errors
- Missing saved data

### Date and Time API

`LocalDate` is used for issue and return dates, while `ChronoUnit.DAYS` is used to calculate overdue days.

### Enum

`Role` defines the available roles:

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

> **Important:** The role file must be named `Role.java`, not `Role.jav`, because Java requires a public top-level enum/class to use the matching `.java` source filename.

## 10. Installation and Setup

### Prerequisites

Install:

- Java JDK
- Git (if cloning the GitHub repository)

Check Java installation:

```bash
java -version
javac -version
```

### Clone the Repository

```bash
git clone <YOUR-GITHUB-REPOSITORY-URL>
cd Library-Management-System-Java
```

### Compile the Project

Because the source files are inside `src`:

```bash
javac -d out src/*.java
```

### Run the Project

```bash
java -cp out Main
```

If your terminal is already inside the `src` directory, you can compile and run using:

```bash
javac *.java
java Main
```

## 11. How to Use

### Admin

1. Start the application.
2. Select `1. Login as Admin`.
3. Use the admin menu.
4. Add books or register users.
5. View books or users.
6. Logout to save the data.

The default administrator ID is:

```text
admin
```

### Student/Patron

1. Ask the administrator to register a user.
2. Select `2. Login as Student/Patron`.
3. Enter the registered User ID.
4. View books.
5. Issue an available book.
6. Enter the issue date in `YYYY-MM-DD` format.
7. Return the book by entering the actual return date.
8. Check pending fines when required.

### Waitlist

If a requested book is already checked out:

1. The system reports that the book is unavailable.
2. The patron can choose to join the waitlist.
3. The request is stored in queue order.
4. When the book is returned, the next waitlisted patron is automatically issued the book.

## 12. Fine Calculation

The system provides a **15-day borrowing period**.

```text
Due Date = Issue Date + 15 days
```

Late fine:

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

The application uses Java object serialization.

The saved file is:

```text
library_data.ser
```

`DataStorage` provides methods for:

- Saving the `Library` object.
- Loading the previously saved `Library` object.
- Starting with a fresh library if no previous data exists.

## 14. Error Handling and Validation

The application validates several types of input and system conditions:

- Non-numeric menu input is rejected.
- Empty text input is not accepted.
- Invalid dates are caught using `DateTimeParseException`.
- Duplicate Book IDs are rejected.
- Duplicate User IDs are rejected.
- Invalid Book IDs are reported.
- Attempting to return a book that is not currently issued is reported.
- File storage errors are caught and reported.

## 15. Non-Functional Requirements

### Usability

The system uses a simple menu-driven CLI so that users can navigate the application through numbered options.

### Reliability

Library data is saved to disk during logout and system exit, allowing information to persist across program executions.

### Maintainability

The implementation separates responsibilities into multiple classes such as `Library`, `Book`, `User`, `Transaction`, `DataStorage`, and `FineUtils`.

### Error Handling

Invalid menu choices, invalid dates, duplicate records, missing books, and storage problems are handled through validation and exception handling.

### Resource Efficiency

`HashMap` provides efficient key-based access to books, users, and active transactions, while a queue is used for ordered waitlist management.

### Scalability

The modular design allows additional features such as search, book categories, authentication, fine payment, reports, and database integration to be added later.

## 16. Testing Instructions

The current project is a CLI application, so functionality can be tested through manual validation of the available workflows.

### Test Case 1: Add a Book

```text
Admin Login
→ Add New Book
→ Enter Book ID
→ Enter Title
→ Enter Author
→ View All Books
```

**Expected Result:** The new book appears in the library inventory.

### Test Case 2: Duplicate Book ID

Add a book using an existing Book ID.

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

**Expected Result:** The book becomes unavailable and a due date is displayed.

### Test Case 4: Waitlist

Try to issue a book that is already checked out.

**Expected Result:** The system offers the patron the option to join the waitlist.

### Test Case 5: Late Return

Return a book after its due date.

**Expected Result:** The appropriate fine is added to the user's pending fines.

### Test Case 6: Data Persistence

1. Add users/books.
2. Exit the application.
3. Start the application again.

**Expected Result:** Previously saved library information is loaded from `library_data.ser`.

## 17. Current Scope

The current version focuses on:

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

Possible future improvements include:

- Search books by title, author, or ID.
- Edit and delete book/user records.
- Dedicated login/password authentication.
- Fine payment through the patron menu.
- Transaction history and reports.
- Database integration using MySQL/PostgreSQL.
- GUI or web interface.
- Unit testing using JUnit.
- Better role management using the `Role` enum throughout the application.
- Input validation for date ranges and invalid return dates.

## 19. Design and Documentation

The VITyarthi project requirements also call for design artefacts such as:

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

These artefacts should be included in the project report and/or repository documentation as required by the course instructions.

## 20. Academic Requirements Checklist

| Requirement | Status |
|---|---|
| Original project relevant to course | ✅ Library Management System |
| At least 3 functional modules | ✅ |
| Clear input/output structure | ✅ |
| Logical user workflow | ✅ |
| At least 4 non-functional requirements specified | ✅ |
| Proper architectural/modular design | ✅ Multiple Java classes |
| Subject concepts demonstrated | ✅ OOP, Collections, Serialization, Exceptions, Date API |
| 5–10 meaningful classes/files | ✅ 8 Java source files |
| Proper folder structure | ✅ `src/` |
| Validation/error handling | ✅ |
| Git/GitHub | ⚠️ Must be maintained/submitted by student |
| README.md | ✅ This file |
| statement.md | ⚠️ Must be created separately |
| Testing | ⚠️ Manual testing can be documented; automated unit tests are not currently included |
| Design diagrams | ⚠️ Must be created separately |
| Detailed project report PDF | ⚠️ Must be submitted separately |

## 21. References

- Java Documentation / Java Standard Library
- VITyarthi - Build Your Own Project instructions
