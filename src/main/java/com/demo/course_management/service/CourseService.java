package com.demo.course_management.service;

import java.util.List;
import com.demo.course_management.entities.Course;
import com.demo.course_management.entities.Teacher;

// This interface defines the service methods for managing courses and teachers.
public interface CourseService {
    
    // Method to add a new course.
    void addCourse(Course course);
    
    // Method to get a list of all courses.
    List<Course> getAllCourses();
    
    // Method to get a course by its ID.
    Course getCourseById(Long id);
    
    // Method to update an existing course.
    void updateCourse(Course course);
    
    // Method to delete a course by its ID.
    void deleteCourse(Long id);

    // Teacher-related methods
    
    // Method to get a teacher by their ID.
    Teacher getTeacherById(Long teacherId);
    
    // Method to get a list of all teachers.
    List<Teacher> getAllTeachers();
}
