package com.demo.course_management;

import java.util.List;
import java.util.Scanner;

import com.demo.course_management.entities.Student;
import com.demo.course_management.service.StudentService;
import com.demo.course_management.serviceImpl.StudentServiceImpl;

public class StudentOperations {

    // Create the StudentService instance
    private static StudentService studentService = new StudentServiceImpl();
    private static Scanner sc = new Scanner(System.in);

    public static Student collectStudentInputs() {
        System.out.println("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.println("Enter Student DOB (YYYY-MM-DD): ");
        String dob = sc.nextLine();

        System.out.println("Enter Student Email: ");
        String email = sc.nextLine();

        System.out.println("Enter Student Mobile Number: ");
        String mobileNo = sc.nextLine();

        System.out.println("Enter Student Address: ");
        String address = sc.nextLine();

        System.out.println("Enter Student Gender: ");
        String gender = sc.nextLine();

        return new Student(name, dob, email, mobileNo, address, gender);
    }

    // Method to perform various student-related operations
    public static void manageStudentOperations() {
        while (true) {
            System.out.println("Student Operations \n"
            		+ "======================================= \n"
            		+ "Press 1: Add Student\n"
                    + "Press 2: Retrieve All Students\n"
                    + "Press 3: Update Student\n"
                    + "Press 4: Delete Student\n"
                    + "Press 5: Return to Main Menu");

            int input = sc.nextInt();
            sc.nextLine(); // Consume newline after int input

            switch (input) {
                case 1: // Add Student
                    Student student = collectStudentInputs();
                    studentService.saveStudent(student);
                    System.out.println("Student Data has been saved successfully: " + student);
                    break;

                case 2: // Retrieve All Students
                    List<Student> students = studentService.findAllStudents();
                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        for (Student s : students) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 3: // Update Student
                    System.out.println("Enter Student ID to update:");
                    Long studentId = sc.nextLong();
                    sc.nextLine(); // Consume newline

                    Student existingStudent = studentService.findStudentById(studentId);
                    if (existingStudent != null) {
                        System.out.println("Existing Student Details: " + existingStudent);
                        Student updatedStudent = collectStudentInputs();
                        updatedStudent.setStudentId(studentId); // Set the ID for the updated student
                        studentService.updateStudent(updatedStudent);
                        System.out.println("Student Data has been updated successfully: " + updatedStudent);
                    } else {
                        System.out.println("Student ID not found.");
                    }
                    break;

                case 4: // Delete Student
                    System.out.println("Enter Student ID to delete:");
                    Long idToDelete = sc.nextLong();
                    sc.nextLine(); // Consume newline
                    studentService.deleteStudent(idToDelete);
                    System.out.println("Student with ID " + idToDelete + " has been deleted successfully.");
                    break;

                case 5: 
                	System.out.println("Returning to Main Menu ....");
                	return; // Exit this loop

                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }

    // Public method to invoke student operations
    public static void performStudentOperations() {
        manageStudentOperations(); // Call the method to manage student operations
    }
}
