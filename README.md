**Course Management System**
A Course Management System that allows students to enroll in courses, teachers to manage courses, and an admin to handle admissions and course assignments.

**Features**
✔ Student registration and course enrollment
✔ Teacher management and course assignment
✔ Admission handling and approval
✔ Hibernate-based database interaction
✔ MySQL database integration

**Tech Stack**
Backend: Java, Hibernate (ORM)
Database: MySQL
Build Tool: Maven/Gradle
Version Control: Git & GitHub

Setup Instructions
1. Clone the Repository

git clone https://github.com/your-username/course-management.git
cd course-management

2. Configure Database
Open hibernate.cfg.xml
Set up your MySQL credentials:

<property name="hibernate.connection.username">your-username</property>
<property name="hibernate.connection.password">your-password</property>

Ensure MySQL is running and create a database:

CREATE DATABASE course_management_system;

3. Build and Run the Project
Using Maven:

mvn clean install
mvn exec:java
or using Gradle:

gradle build
gradle run

**Database Schema
Table	Description**
Student	Stores student details
Teacher	Stores teacher details
Course	Stores course details
Admission	Tracks admissions status


**Contributing**
Fork the repository
Create a new branch (git checkout -b feature-name)
Commit changes (git commit -m "Added new feature")
Push (git push origin feature-name)
Open a Pull Request
