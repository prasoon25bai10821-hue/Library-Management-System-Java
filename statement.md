# Library Management System - Project Statement

## 1. Problem Statement

Traditional or manual library management can make it difficult to maintain accurate information about books, users, book availability, issue and return transactions, due dates, fines, and waiting lists.

The **Library Management System** is developed as a Java-based application to provide a structured way of managing these common library activities through a command-line interface. The system allows an administrator to manage books and users, while students/patrons can view books, issue and return books, join a waitlist, and check pending fines.

The project addresses the problem of organizing these operations in one system while maintaining library information between program executions.

## 2. Scope of the Project

The scope of this project covers the core operations required for a small library management system.

The system includes:

- Book registration and library inventory management.
- User registration and role-based access for Admin and Student/Patron users.
- Viewing available library books and registered users.
- Book issue and return operations.
- Automatic due-date calculation.
- Fine calculation for late returns.
- Waitlist management for unavailable books.
- Automatic issue of a returned book to the next waitlisted user.
- Persistent storage of library information using Java serialization.
- Input validation and error handling through the command-line interface.

The project is designed as a **console-based Java application**. Its current scope does not include a graphical user interface, web interface, external database server, online authentication, or online payment services.

## 3. Target Users

### Admin / Library Administrator

The administrator is responsible for managing the library's books and users.

Admin functions include:

- Adding new books.
- Registering new users.
- Viewing all books.
- Viewing all registered users.
- Saving library data.

### Student / Patron

Students or patrons are the users who borrow books from the library.

Patron functions include:

- Viewing all books.
- Issuing an available book.
- Returning an issued book.
- Joining the waitlist when a book is unavailable.
- Checking pending fines.

## 4. High-Level Features

### 4.1 User Management

- Supports Admin and Student/Patron roles.
- Provides user registration through the Admin menu.
- Uses unique User IDs.
- Prevents duplicate User IDs.
- Maintains user information and pending fines.

### 4.2 Book Management

- Allows the Admin to add books.
- Stores Book ID, title, author, and availability status.
- Prevents duplicate Book IDs.
- Displays the current library inventory.

### 4.3 Book Issue and Return

- Allows patrons to issue available books.
- Creates a transaction for each issue.
- Calculates the due date from the issue date.
- Marks issued books as unavailable.
- Marks returned books as available.

### 4.4 Fine Management

- Provides a 15-day borrowing period.
- Calculates fines for overdue returns.
- Applies a fine of Rs 50 for each late day.
- Maintains the user's pending fine amount.

### 4.5 Waitlist Management

- Allows patrons to join a waitlist when a book is already checked out.
- Maintains the waitlist in queue order.
- Automatically issues the returned book to the next waitlisted patron.

### 4.6 Data Persistence

- Saves library data to a local serialized file.
- Loads saved data when the application starts.
- Provides persistence across application executions.

### 4.7 Input Validation and Error Handling

- Validates menu input.
- Rejects empty text input.
- Handles invalid date formats.
- Detects duplicate books and users.
- Handles invalid book IDs and invalid return operations.
- Handles file storage and loading errors.

## 5. Project Context

The project is implemented using Java and demonstrates programming concepts relevant to a coding-based course, including object-oriented programming, collections, exception handling, date/time handling, and file-based object serialization.

The source code is organized into multiple Java classes inside the `src` folder, providing a modular structure for the system.
