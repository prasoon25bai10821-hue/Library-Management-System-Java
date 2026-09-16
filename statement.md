# Library Management System - Project Statement

## 1. Problem Statement

Managing a library manually can become difficult when there are many books and users. It can be hard to keep correct records of available books, issued books, return dates, fines, transactions, and waiting lists.

The **Library Management System** is a Java-based application created to make these common library tasks easier to manage through a command-line interface. The system allows the administrator to manage books and users, while students or patrons can view books, issue and return books, join a waitlist, and check their pending fines.

The main purpose of this project is to bring these operations together in one simple system and also keep the library data saved between different program runs.

## 2. Scope of the Project

The project covers the basic operations that are needed in a small library management system.

The system provides the following features:

- Adding books and managing the library inventory.
- Registering users and supporting Admin and Student/Patron roles.
- Viewing library books and registered users.
- Issuing and returning books.
- Automatically calculating the due date.
- Calculating fines when a book is returned late.
- Managing a waitlist for books that are already issued.
- Automatically giving a returned book to the next person in the waitlist.
- Saving library information using Java serialization.
- Handling invalid inputs and common errors through the command-line interface.

The current project is designed as a **console-based Java application**. It does not currently include a graphical user interface, web interface, external database server, online login system, or online payment system.

## 3. Target Users

### Admin / Library Administrator

The Admin is responsible for managing the main library records.

Admin can:

- Add new books.
- Register new users.
- View all books.
- View all registered users.
- Save the library data.

### Student / Patron

Students or patrons are the users who borrow books from the library.

A patron can:

- View all books.
- Issue an available book.
- Return an issued book.
- Join the waitlist if a book is not available.
- Check their pending fines.

## 4. High-Level Features

### 4.1 User Management

The user management part of the system:

- Supports Admin and Student/Patron roles.
- Allows the Admin to register new users.
- Uses a unique User ID for each user.
- Does not allow duplicate User IDs.
- Stores user information along with their pending fines.

### 4.2 Book Management

The book management part allows the Admin to:

- Add new books.
- Store Book ID, title, author, and availability information.
- Prevent duplicate Book IDs.
- View the current library inventory.

### 4.3 Book Issue and Return

The system allows patrons to:

- Issue a book when it is available.
- Create a transaction whenever a book is issued.
- Calculate the due date from the issue date.
- Mark the book as unavailable after it is issued.
- Make the book available again after it is returned.

### 4.4 Fine Management

The fine system works as follows:

- A book can be borrowed for 15 days.
- A fine is calculated if the book is returned after its due date.
- The fine is **Rs 50 for each late day**.
- The pending fine amount is stored with the user's information.

### 4.5 Waitlist Management

The waitlist feature is used when a book is already checked out.

It:

- Allows patrons to join the waitlist for an unavailable book.
- Keeps users in the order in which they joined the waitlist.
- Automatically issues the returned book to the next waitlisted patron.

### 4.6 Data Persistence

The project uses Java serialization to keep the library data saved.

It:

- Saves library data to a local serialized file.
- Loads the saved information when the application starts.
- Keeps the data available between different program executions.

### 4.7 Input Validation and Error Handling

The system also checks for common input and program errors.

It:

- Validates menu choices.
- Does not accept empty text input.
- Handles incorrect date formats.
- Detects duplicate books and users.
- Handles invalid Book IDs and invalid return operations.
- Handles errors while saving or loading library data.

## 5. Project Context

This project is developed using Java and demonstrates several important programming concepts used in the course. These include object-oriented programming, Java collections, exception handling, date and time handling, and file-based object serialization.

The source code is divided into different Java classes and stored inside the `src` folder. Each class is responsible for a particular part of the system, which makes the project easier to understand and maintain.
