**Course Management System**
📚 Overview
Welcome to the Course Management System! This console-based Java application is designed to simplify the management of students, teachers, courses, and admissions in educational institutions. Built using Hibernate JPA for object-relational mapping and MySQL for data storage, this system provides an efficient way to handle the various aspects of academic administration.

🌟 Features
Student Management:

Add, view, update, and delete student records.
Track student details such as name, address, email, mobile number, gender, and date of birth.
Teacher Management:

Manage teacher profiles with information like qualifications, salary, and contact details.
Add and remove teachers as needed.
Course Management:

Create and manage courses, including their names, durations, credit values, and maximum enrollment capacities.
Associate courses with specific teachers.
Admission Management:

Facilitate student admissions into courses, tracking admission dates and related course details.
🛠️ Technologies Used
Programming Language: Java
ORM Framework: Hibernate JPA
Database: MySQL
Development Tools: Maven (for build management)
🏗️ Entities Overview
1. Student
studentId: Unique identifier for each student.
studentName: Full name of the student.
studentAddress: Residential address.
studentEmail: Email address (unique).
studentMobileNo: Mobile number.
studentGender: Gender of the student.
studentDob: Date of birth.
2. Teacher
teacherId: Unique identifier for each teacher.
teacherName: Full name.
teacherEmail: Email address.
teacherMobileNo: Mobile number.
qualification: Educational qualifications.
salary: Salary details.
3. Course
courseId: Unique identifier for each course.
courseName: Name of the course.
courseDuration: Duration of the course.
credits: Credits associated with the course.
maxEnrollment: Maximum number of students allowed.
4. Admission
admissionId: Unique identifier for admission records.
admissionDate: Date of admission.
courseId: ID of the course the student is admitted to.
studentId: ID of the student being admitted.
📦 Setup and Installation
Clone the Repository:

bash
Copy code
git clone https://github.com/yourusername/course-management-system.git
Navigate to the Project Directory:

bash
Copy code
cd course-management-system
Build the Project: Use Maven to build the project:

bash
Copy code
mvn clean install
Configure Database Connection: Update your application.properties or relevant configuration file with your MySQL database connection details.

Run the Application: Execute the main application class to launch the Course Management System.

🚀 Usage
The application operates in a console environment.
Follow the on-screen prompts to navigate through various functionalities, including adding and managing students, teachers, courses, and admissions.
🤝 Contributing
Contributions are welcome! If you have suggestions for improvements or features, feel free to open an issue or submit a pull request.
