# Library Management System - Java

A simple console-based **Library Management System** made in Java for the VITyarthi **Build Your Own Project** evaluation. The project is used to manage books, users, book issue and return, due dates, fines, waitlists, and saving data for future use.

## 1. Project Overview

The Library Management System is a command-line application which helps in doing common library related work in an easy way.

The system mainly has two types of users:

- **Admin** – Can add books, register users and view library records.
- **Student/Patron** – Can view books, issue and return books, join a waitlist and check pending fines.

The library information is saved in a local file so that the data can be loaded again when the program is started.

## 2. Problem Statement

Managing a library manually can become difficult when there are many books and users. It is also not easy to keep track of issued books, return dates, fines and waiting lists.

This project provides a simple Java based solution where these operations can be handled from one menu-driven console application. The data also stays saved between different program runs.

## 3. Objectives

The main objectives of this project are:

- Manage books and their availability.
- Register and manage library users.
- Issue and return books.
- Calculate due dates and overdue fines.
- Keep a waitlist when a book is not available.
- Automatically issue a returned book to the next person in the waitlist.
- Save library data using Java serialization.
- Show different Java programming concepts through separate classes.

## 4. Functional Requirements

### Module 1: User Management

- A default administrator account is created when a new library is started.
- Admin can register new users.
- Every user has a unique User ID.
- Users can be either Admin or Patron/Student.
- Duplicate User IDs are not allowed.

### Module 2: Book Management

- Admin can add new books.
- Every book contains a Book ID, title, author and availability status.
- Duplicate Book IDs are not allowed.
- Admin and patrons can view the available library records.
- The system also keeps track of people waiting for a book.

### Module 3: Book Issue and Return

- A patron can issue a book if it is available.
- Every book issue creates a transaction with a transaction ID.
- The due date is set to 15 days after the issue date.
- After returning a book, it becomes available again.
- Invalid Book IDs and books which are not currently issued are handled with proper error messages.

### Module 4: Fine and Waitlist Management

- A fine of **Rs 50 per late day** is charged for late returns.
- Pending fines are stored with the user's information.
- If a book is already issued, a patron can join its waitlist.
- The waitlist works in first-in-first-out order.
- When the book is returned, the next person in the waitlist gets the book automatically.

### Module 5: Data Persistence

- Library information is stored in `library_data.ser`.
- Saved data is loaded when the application starts.
- Data is saved when the user logs out or exits the system.
- If there is no old data, a new library is created.

## 5. Input and Output Structure

### Inputs

The application takes input from the user through the command line using `Scanner`.

Some examples of input are:

- Main menu choice
- Admin or patron login ID
- Book ID
- Book title
- Author name
- User ID
- User name
- Issue date
- Return date
- Waitlist confirmation

### Outputs

The application displays different information such as:

- Menu options
- Library books
- Registered users
- Book issue confirmation
- Due dates
- Fine amounts
- Waitlist messages
- Error and validation messages
- Data loading and saving messages

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
