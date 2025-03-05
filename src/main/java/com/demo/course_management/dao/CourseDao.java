package com.demo.course_management.dao;

import com.demo.course_management.entities.Course;
import com.demo.course_management.entities.Teacher;

import java.util.List;

// This interface defines methods for course-related database operations.
public interface CourseDao {
    // Method to add a new course to the database.
    void addCourse(Course course);

    // Method to update an existing course in the database.
    void updateCourse(Course course);

    // Method to get a course by its ID.
    Course getCourseById(Long courseId);

    // Method to get a list of all courses.
    List<Course> getAllCourses();

    // Method to delete a course by its ID.
    void deleteCourse(Long courseId);

    // Method to get a list of all teachers.
    List<Teacher> getAllTeachers();

    // Method to get a teacher by their ID.
    Teacher getTeacherById(Long teacherId);
}
