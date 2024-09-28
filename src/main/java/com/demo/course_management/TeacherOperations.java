package com.demo.course_management;

import com.demo.course_management.entities.Course;
import com.demo.course_management.entities.Teacher;
import com.demo.course_management.service.TeacherService;
import com.demo.course_management.serviceImpl.TeacherServiceImpl;
import com.demo.course_management.dao.TeacherDao;
import com.demo.course_management.daoImpl.TeacherDaoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherOperations {

    private static final TeacherDao teacherDao = new TeacherDaoImpl();
    private static final TeacherService teacherService = new TeacherServiceImpl(teacherDao);
    private static final Scanner sc = new Scanner(System.in);

    public static Teacher collectTeacherInputs() {
        String teacherName = getInput("Enter Teacher Name: ");
        String teacherMobileNo = getInput("Enter Teacher Mobile No: ");
        String teacherEmail = getInput("Enter Teacher Email: ");
        String qualification = getInput("Enter Teacher Qualification: ");

        double salary = getSalaryInput();
        //Long courseId = getCourseIdInput();

        // Create a new Teacher object
        Teacher teacher = new Teacher(teacherName, teacherMobileNo, teacherEmail, qualification, salary, new ArrayList<>());

        // If a course ID is provided (not zero), set the teacher to that course
//        if (courseId != 0) {
//            Course course = teacherService.getCourseById(courseId); // Fetch the course by ID
//            if (course != null) {
//                teacher.getCourses().add(course); // Add course to teacher's list of courses
//            } else {
//                System.out.println("Course with ID " + courseId + " does not exist. Teacher will not be associated with any course.");
//            }
//        }

        return teacher;
    }

    private static String getInput(String prompt) {
        System.out.print(prompt);
        String input = sc.nextLine();
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty");
        }
        return input;
    }

    private static double getSalaryInput() {
        while (true) {
            System.out.print("Enter Teacher Salary: ");
            try {
                String salaryInput = sc.nextLine().replace(",", ""); // Remove comma
                double salary = Double.parseDouble(salaryInput);
                if (salary < 0) {
                    System.out.println("Salary cannot be negative. Please try again.");
                } else {
                    return salary;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid salary format. Please enter a valid number.");
            }
        }
    }

//    private static Long getCourseIdInput() {
//        while (true) {
//            System.out.print("Enter Course ID (if any, otherwise enter 0): ");
//            try {
//                Long courseId = sc.nextLong();
//                sc.nextLine(); // Consume newline
//                return courseId;
//            } catch (Exception e) {
//                System.out.println("Invalid input. Please enter a numeric Course ID.");
//                sc.nextLine(); // Consume the invalid input
//            }
//        }
//    }

    // Method to display teachers with their courses
    public static void displayTeachersWithCourses(List<Teacher> teachers) {
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
            List<Course> courses = teacher.getCourses(); // Assuming getCourses() returns List<Course>
            if (courses != null && !courses.isEmpty()) {
                System.out.println("Courses taught by " + teacher.getTeacherName() + ":");
                for (Course course : courses) {
                    System.out.println("  Course ID: " + course.getCourseId() + ", Course Name: " + course.getCourseName());
                }
            } else {
                System.out.println("  No courses taught by this teacher.");
            }
        }
    }

    public static void manageTeacherOperations() {
        while (true) {
            System.out.println("Teacher Operations \n"
            		+ "======================================= \n"
            		+ "Press 1: Add Teacher\n" 
            		+ "Press 2: Retrieve All Teachers\n" 
            		+ "Press 3: Update Teacher\n" 
            		+ "Press 4: Delete Teacher\n" 
            		+ "Press 5: Return to Main Menu");

            int input = getValidIntInput();

            switch (input) {
                case 1:
                    Teacher teacher = collectTeacherInputs();
                    teacherService.addTeacher(teacher);
                    System.out.println("Teacher Data has been saved successfully: " + teacher);
                    break;

                case 2:
                    List<Teacher> teachers = teacherService.getAllTeachers();
                    if (teachers.isEmpty()) {
                        System.out.println("No teachers found.");
                    } else {
                        displayTeachersWithCourses(teachers); // Call to display teachers with courses
                    }
                    break;

                case 3:
                    updateTeacher();
                    break;

                case 4:
                    deleteTeacher();
                    break;

                case 5:
                	System.out.println("Returning to Main Menu ....");
                	return; // Exit this loop

                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }

    private static int getValidIntInput() {
        while (true) {
            try {
                int input = sc.nextInt();
                sc.nextLine(); // Consume newline
                return input;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                sc.nextLine(); // Consume the invalid input
            }
        }
    }

    private static void updateTeacher() {
        System.out.print("Enter Teacher ID to update: ");
        Long teacherIdToUpdate = sc.nextLong();
        sc.nextLine(); // Consume newline

        Teacher existingTeacher = teacherService.getTeacherById(teacherIdToUpdate);
        if (existingTeacher != null) {
            System.out.println("Existing Teacher Details: " + existingTeacher);
            Teacher updatedTeacher = collectTeacherInputs();
            updatedTeacher.setTeacherId(teacherIdToUpdate);
            teacherService.updateTeacher(updatedTeacher);
            System.out.println("Teacher Data has been updated successfully: " + updatedTeacher);
        } else {
            System.out.println("Teacher ID not found.");
        }
    }

    private static void deleteTeacher() {
        System.out.print("Enter Teacher ID to delete: ");
        Long idToDelete = sc.nextLong();
        sc.nextLine(); // Consume newline
        System.out.printf("Are you sure you want to delete teacher with ID %d? (yes/no) ", idToDelete);
        String confirmation = sc.nextLine();
        if ("yes".equalsIgnoreCase(confirmation)) {
            teacherService.deleteTeacher(idToDelete);
            System.out.println("Teacher with ID " + idToDelete + " has been deleted successfully.");
        } else {
            System.out.println("Deletion canceled.");
        }
    }

    public static void performTeacherOperations() {
        manageTeacherOperations();
    }
}
