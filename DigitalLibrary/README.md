# Digital Library Management System

## Description
A web-based library system where admins manage books and users can borrow and return books.

## Technologies Used
- Java
- Servlets
- JSP
- MySQL
- JDBC
- Tomcat

## Database Details
Database Name: digital_library

## How To Run
- Import project into Eclipse
- Configure MySQL & Tomcat
- Execute SQL queries
- Run on server


### Tables
```sql
CREATE TAble admin (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50),
  password VARCHAR(50)
)
CREATE TABLE books (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(100),
  author VARCHAR(100),
  category VARCHAR(50),
  quantity INT
);

CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50),
  email VARCHAR(50),
  password VARCHAR(50)
);

CREATE TABLE borrow_books (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  book_id INT,
  status VARCHAR(20)
);

CREATE TABLE issued_books (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  book_id INT,
  issue_date DATE,
  return_date DATE,
  fine INT
);
