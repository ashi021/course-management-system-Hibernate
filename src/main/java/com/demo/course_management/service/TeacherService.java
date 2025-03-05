package com.demo.course_management.service;

import com.demo.course_management.entities.Course;
import com.demo.course_management.entities.Teacher;
import java.util.List;

// This interface defines the service methods for managing teachers and their courses.
public interface TeacherService {
    
    // Method to add a new teacher.
    void addTeacher(Teacher teacher);
    
    // Method to get a list of all teachers.
    List<Teacher> getAllTeachers();
    
    // Method to get a teacher by their ID.
    Teacher getTeacherById(Long id);
    
    // Method to update an existing teacher's details.
    void updateTeacher(Teacher teacher);
    
    // Method to delete a teacher by their ID.
    void deleteTeacher(Long id);
    
    // Method to fetch a course by its ID.
    Course getCourseById(Long courseId);
}
