package com.demo.course_management;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.demo.course_management.entities.Admission;
import com.demo.course_management.entities.Course;
import com.demo.course_management.entities.Student;
import com.demo.course_management.service.AdmissionService;
import com.demo.course_management.service.CourseService; // Import CourseService
import com.demo.course_management.service.StudentService;
import com.demo.course_management.serviceImpl.AdmissionServiceImpl;
import com.demo.course_management.serviceImpl.CourseServiceImpl; // Import CourseServiceImpl
import com.demo.course_management.serviceImpl.StudentServiceImpl;

public class AdmissionOperations {

    // Create the AdmissionService, StudentService, and CourseService instances
    private static AdmissionService admissionService = new AdmissionServiceImpl();
    private static StudentService studentService = new StudentServiceImpl();
    private static CourseService courseService = new CourseServiceImpl(); // Initialize CourseService
    private static Scanner sc = new Scanner(System.in);

    public static Admission collectAdmissionInputs() {
        System.out.println("Enter Admission Date (YYYY-MM-DD): ");
        String dateStr = sc.nextLine(); // Parse it as needed
        Date admissionDate = java.sql.Date.valueOf(dateStr);

        System.out.println("Enter Course ID: ");
        Long courseId = sc.nextLong();
        sc.nextLine(); // Consume newline

        System.out.println("Enter Student ID: ");
        Long studentId = sc.nextLong();
        sc.nextLine(); // Consume newline

        Student student = studentService.findStudentById(studentId);
        if (student == null) {
            System.out.println("Invalid Student ID. Please add the student first.");
            return null;
        }

        // Retrieve the Course from the courseService
        Course course = courseService.getCourseById(courseId);
        if (course == null) {
            System.out.println("Invalid Course ID. Please try again.");
            return null;
        }

        // Create and return the Admission object
        return new Admission(admissionDate, course, student);
    }

    // Method to perform various admission-related operations
    public static void manageAdmissionOperations() {
        while (true) {
            System.out.println("Admission Operations \n"
            		+ "======================================= \n"
            		+ "Press 1: Add Admission\n"
                    + "Press 2: Retrieve All Admissions\n"
                    + "Press 3: Update Admission\n"
                    + "Press 4: Delete Admission\n"
                    + "Press 5: Return to Main Menu");

            int input = sc.nextInt();
            sc.nextLine(); // Consume newline after int input

            switch (input) {
                case 1: // Add Admission
                    Admission admission = collectAdmissionInputs();
                    if (admission != null) {
                        admissionService.saveAdmission(admission);
                        System.out.println("Admission Data has been saved successfully: " + admission);
                    }
                    break;

                case 2: // Retrieve All Admissions
                    List<Admission> admissions = admissionService.findAllAdmissions();
                    if (admissions.isEmpty()) {
                        System.out.println("No admissions found.");
                    } else {
                        for (Admission a : admissions) {
                            System.out.println(a);
                        }
                    }
                    break;

                case 3: // Update Admission
                    System.out.println("Enter Admission ID to update:");
                    Long admissionId = sc.nextLong();
                    sc.nextLine(); // Consume newline

                    Admission existingAdmission = admissionService.findAdmissionById(admissionId);
                    if (existingAdmission != null) {
                        System.out.println("Existing Admission Details: " + existingAdmission);
                        Admission updatedAdmission = collectAdmissionInputs();
                        if (updatedAdmission != null) {
                            updatedAdmission.setAdmissionId(admissionId); // Set the ID for the updated admission
                            admissionService.updateAdmission(updatedAdmission);
                            System.out.println("Admission Data has been updated successfully: " + updatedAdmission);
                        }
                    } else {
                        System.out.println("Admission ID not found.");
                    }
                    break;

                case 4: // Delete Admission
                    System.out.println("Enter Admission ID to delete:");
                    Long idToDelete = sc.nextLong();
                    sc.nextLine(); // Consume newline
                    admissionService.deleteAdmission(idToDelete);
                    System.out.println("Admission with ID " + idToDelete + " has been deleted successfully.");
                    break;

                case 5: 
                	System.out.println("Returning to Main Menu ....");
                	return; // Exit this loop

                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }

    // Public method to invoke admission operations
    public static void performAdmissionOperations() {
        manageAdmissionOperations(); // Call the method to manage admission operations
    }
}
