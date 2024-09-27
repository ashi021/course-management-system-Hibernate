package com.demo.course_management.service;

import com.demo.course_management.entities.Course;
import com.demo.course_management.entities.Teacher;
import java.util.List;

public interface TeacherService {
    void addTeacher(Teacher teacher);
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(Long id);
    void updateTeacher(Teacher teacher);
    void deleteTeacher(Long id);
    Course getCourseById(Long courseId); // Method to fetch course by ID
}
