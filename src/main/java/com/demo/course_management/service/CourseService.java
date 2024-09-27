package com.demo.course_management.service;

import java.util.List;
import com.demo.course_management.entities.Course;
import com.demo.course_management.entities.Teacher;

public interface CourseService {
    void addCourse(Course course);
    List<Course> getAllCourses();
    Course getCourseById(Long id);
    void updateCourse(Course course);
    void deleteCourse(Long id);

    // Teacher-related methods
    Teacher getTeacherById(Long teacherId);
    List<Teacher> getAllTeachers();
}
