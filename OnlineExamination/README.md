# Online Examination System

## Description
A web-based Java application that allows users to take MCQ-based exams with timer and auto-submit functionality.

## Technologies Used
- Java
- Servlets
- JSP
- MySQL
- Tomcat Server

## How to Run
- Import project into Eclipse
- Configure Tomcat Server
- Create database and tables
- Run project on server
- Access via browser

## Database Details
Database Name: online_exam

### Tables
```sql
CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50),
  password VARCHAR(50),
  email VARCHAR(50)
);

CREATE TABLE questions (
  id INT AUTO_INCREMENT PRIMARY KEY,
  question VARCHAR(225),
  opt1 VARCHAR(100),
  opt2 VARCHAR(100),
  opt3 VARCHAR(100),
  opt4 VARCHAR(100),
  answer VARCHAR(100)
);

