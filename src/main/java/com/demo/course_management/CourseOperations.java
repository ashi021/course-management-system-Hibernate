package com.demo.course_management;

import java.util.List;
import java.util.Scanner;

import com.demo.course_management.entities.Course;
import com.demo.course_management.entities.Teacher;
import com.demo.course_management.service.CourseService;
import com.demo.course_management.serviceImpl.CourseServiceImpl;
import com.demo.course_management.dao.CourseDao;
import com.demo.course_management.daoImpl.CourseDaoImpl;

public class CourseOperations {

    // Create the CourseDao and CourseService instances
    private static CourseDao courseDao = new CourseDaoImpl();
    private static CourseService courseService = new CourseServiceImpl(courseDao);
    private static Scanner sc = new Scanner(System.in);

    public static Course collectCourseInputs() {
        System.out.println("Enter Course Name: ");
        String courseName = sc.nextLine();

        System.out.println("Enter Course Duration: ");
        String courseDuration = sc.nextLine();

        System.out.println("Enter Credits: ");
        int credits = sc.nextInt();
        sc.nextLine(); // Consume newline

        System.out.println("Enter Max Enrollment: ");
        int maxEnrollment = sc.nextInt();
        sc.nextLine(); // Consume newline

        // Collect Teacher information
        Teacher teacher = selectTeacher(); // Call method to select teacher

        return new Course(courseName, courseDuration, credits, maxEnrollment, teacher);
    }

    public static Teacher selectTeacher() {
        // Assume a TeacherService exists to retrieve teachers
        List<Teacher> teachers = courseService.getAllTeachers(); // Ensure this method exists

        if (teachers.isEmpty()) {
            System.out.println("No available teachers. Please add a teacher first.");
            return null; // Or handle the case as needed
        }

        System.out.println("Available Teachers:");
        for (Teacher teacher : teachers) {
            System.out.println(teacher.getTeacherId() + ": " + teacher.getTeacherName());
        }

        System.out.println("Enter Teacher ID to select a teacher:");
        Long teacherId = sc.nextLong();
        sc.nextLine(); // Consume newline

        // Fetch the Teacher object by ID
        Teacher teacher = courseService.getTeacherById(teacherId); // Ensure this method exists in your service
        if (teacher == null) {
            System.out.println("Invalid Teacher ID. Please try again.");
            return selectTeacher(); // Recursively call until valid input
        }

        return teacher;
    }

    // Method to perform various course-related operations
    public static void manageCourseOperations() {
        while (true) {
            System.out.println("Course Operations \n"
            		+ "======================================= \n"
            		+ "Press 1: Add Course\n"
                    + "Press 2: Retrieve All Courses\n"
                    + "Press 3: Update Course\n"
                    + "Press 4: Delete Course\n"
                    + "Press 5: Return to Main Menu");

            int input = sc.nextInt();
            sc.nextLine(); // Consume newline after int input

            switch (input) {
                case 1: // Add Course
                    Course course = collectCourseInputs();
                    courseService.addCourse(course);
                    System.out.println("Course Data has been saved successfully: " + course);
                    break;

                case 2: // Retrieve All Courses
                    List<Course> courses = courseService.getAllCourses();
                    if (courses.isEmpty()) {
                        System.out.println("No courses found.");
                    } else {
                        for (Course c : courses) {
                            System.out.println(c);
                        }
                    }
                    break;

                case 3: // Update Course
                    System.out.println("Enter Course ID to update:");
                    Long courseId = sc.nextLong();
                    sc.nextLine(); // Consume newline

                    Course existingCourse = courseService.getCourseById(courseId);
                    if (existingCourse != null) {
                        System.out.println("Existing Course Details: " + existingCourse);
                        Course updatedCourse = collectCourseInputs();
                        updatedCourse.setCourseId(courseId); // Set the ID for the updated course
                        courseService.updateCourse(updatedCourse);
                        System.out.println("Course Data has been updated successfully: " + updatedCourse);
                    } else {
                        System.out.println("Course ID not found.");
                    }
                    break;

                case 4: // Delete Course
                    System.out.println("Enter Course ID to delete:");
                    Long idToDelete = sc.nextLong();
                    sc.nextLine(); // Consume newline
                    courseService.deleteCourse(idToDelete);
                    System.out.println("Course with ID " + idToDelete + " has been deleted successfully.");
                    break;

                case 5: 
                	System.out.println("Returning to Main Menu ....");
                	return; // Exit this loop

                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }

    // Public method to invoke course operations
    public static void performCourseOperations() {
        manageCourseOperations(); // Call the method to manage course operations
    }
}
