# Employee Management System

A Java-based web application that performs employee record management using **Java Servlets, JDBC, MySQL, and Apache Tomcat**. The system allows users to add, view, update, and delete employee records through a simple and user-friendly interface.


## Features

- Add new employee records
- View employee details
- Update employee information
- Delete employee records
- Responsive HTML and CSS interface
- Database connectivity using JDBC
- Deployed on Apache Tomcat


## Technologies Used

### Frontend
- HTML5
- CSS3

### Backend
- Java
- Java Servlets
- JDBC (Java Database Connectivity)

### Database
- MySQL

### Server
- Apache Tomcat 9

### IDE
- Eclipse IDE

### Version Control
- Git & GitHub


## Project Structure

employee/
│
├── WEB-INF/
│   ├── classes/
│   ├── lib/
│   └── web.xml
│
├── deletef.html
├── home.css
├── homef.html
├── readf.html
├── store.css
├── storef.html
├── update.css
├── updatef.html
│
├── README.md
└── .gitignore


## System Architecture


User
   │
   ▼
HTML/CSS Pages
   │
   ▼
Java Servlets
   │
   ▼
JDBC
   │
   ▼
MySQL Database
   │
   ▼
Apache Tomcat Server
```


## Prerequisites

Before running the project, install the following:

- Java JDK 22 (or Java JDK 8 and later)
- Eclipse IDE
- Apache Tomcat 9
- MySQL Server
- MySQL JDBC Driver


## Database Configuration

Create a database in MySQL:

```sql
CREATE DATABASE employee_db;

Update the database connection details in your Java code:

```java
String url = "jdbc:mysql://localhost:3306/employee_db";
String username = "root";
String password = "your_password";


## How to Run

1. Clone the repository.

```bash
git clone https://github.com/BhuvanendraVelde/employee.git

2. Import the project into Eclipse.

3. Add the MySQL JDBC driver (`mysql.jar`) to the `WEB-INF/lib` folder.

4. Configure Apache Tomcat in Eclipse.

5. Start the Tomcat server.

6. Open your browser and navigate to:

http://localhost:8080/employee/homef.html


## CRUD Operations

- **Create** – Add a new employee.
- **Read** – Display employee details.
- **Update** – Modify employee information.
- **Delete** – Remove employee records.


## Future Enhancements

- User Authentication (Login)
- Role-Based Access Control
- Employee Search and Filter
- Pagination
- Dashboard with Charts
- Spring Boot Migration
- REST API Support


## Author

**Bhuvanendra Velde**

- LinkedIn: https://linkedin.com/in/veldebhuvanendra



## License

This project is developed for educational and learning purposes.
