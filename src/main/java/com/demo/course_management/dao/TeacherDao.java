package com.demo.course_management.dao;

import com.demo.course_management.entities.Course;
import com.demo.course_management.entities.Teacher;

import java.util.List;

// This interface defines methods for teacher-related database operations.
public interface TeacherDao {
    // Method to add a new teacher to the database.
    void addTeacher(Teacher teacher);

    // Method to update an existing teacher's information in the database.
    void updateTeacher(Teacher teacher);

    // Method to get a teacher by their ID.
    Teacher getTeacherById(Long teacherId);

    // Method to get a list of all teachers.
    List<Teacher> getAllTeachers();

    // Method to delete a teacher by their ID.
    void deleteTeacher(Long teacherId);

    // Method to get a list of courses taught by a specific teacher.
    List<Course> getCoursesByTeacher(Long teacherId);

    // Method to get a course by its ID.
    Course getCourseById(Long courseId);
}
