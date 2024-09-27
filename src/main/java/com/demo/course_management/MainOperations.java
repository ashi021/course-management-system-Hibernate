package com.demo.course_management;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class MainOperations {

    static Scanner sc = new Scanner(System.in);

    // Method to show main menu and perform operations
    public static void mainOps() { 
        while (true) {
            System.out.println("======================================= \n"
            		+ "Main Menu \n"
            		+ "======================================= \n"
            		+ "Press 1: Student Details\n"
                    + "Press 2: Admission Details\n"
                    + "Press 3: Teacher Details\n"
                    + "Press 4: Course Details\n"
                    + "Press 5: Quit");

            int input = 0;

            // Loop until valid input is received
            while (true) {
                try {
                    if (sc.hasNextInt()) {
                        input = sc.nextInt();
                        if (sc.hasNextLine()) {
                            sc.nextLine(); // Consume newline character
                        }
                        break; // Exit loop once valid input is received
                    } else {
                        System.out.println("Invalid input. Please enter a valid number.");
                        sc.nextLine(); // Clear invalid input
                    }
                } catch (NoSuchElementException e) {
                    System.out.println("Error reading input. Please try again.");
                    break; // Break to prevent infinite loop in case of NoSuchElementException
                }
            }

            switch (input) {
                case 1:
                    System.out.println("=======================================");
                    StudentOperations.performStudentOperations();
                    System.out.println("=======================================");
                    break;

                case 2:
                    System.out.println("=======================================");
                    AdmissionOperations.performAdmissionOperations();
                    System.out.println("=======================================");
                    break;

                case 3:
                    System.out.println("=======================================");
                    TeacherOperations.performTeacherOperations();
                    System.out.println("=======================================");
                    break;

                case 4:
                    System.out.println("=======================================");
                    CourseOperations.performCourseOperations();
                    System.out.println("=======================================");
                    break;

                case 5:
                    System.out.println("Exiting the system.!!!!");
                    sc.close(); // Close the scanner when quitting the application
                    System.exit(0); // Quit the application
                    break;

                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        mainOps(); // Start the main menu
    }
}
