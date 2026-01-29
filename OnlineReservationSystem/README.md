# Online Reservation System

## Description
A Java-based application that allows users to reserve and cancel train tickets using a centralized database.

## Technologies Used
- Java
- Eclipse IDE
- MySQL
- JDBC
- Swing

## How to Run the Project

- Install JDK 17
- Install Eclipse IDE
- Create database reservation_db in MySQL
- Execute the above SQL query
- Update database credentials in the Java file
- Run the project from Eclipse

Default Login (if any)
- Username: admin
- Password: admin

## Database Details
- Database Name: reservation_system

### Table Structure
```sql
CREATE TABLE reservation (
  pnr INT BIGINT PRIMARY KEY,
  name VARCHAR(50),
  age INT,
  gender VARCHAR(10),
  train_no VARCHAR(10),
  train_name VARCHAR(50),
  class_type VARCHAR(20),
  journey_date DATE,
  source VARCHAR(50),
  destination VARCHAR(50)
);

CREATE TABLE user (
  id INT PRIMARY KEY,
  username VARCHAR(50),
  password VARCHAR(50)
)


