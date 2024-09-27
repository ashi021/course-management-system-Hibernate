package com.demo.course_management.dao;

import com.demo.course_management.entities.Course;
import com.demo.course_management.entities.Teacher;

import java.util.List;

public interface CourseDao {
    void addCourse(Course course);
    void updateCourse(Course course);
    Course getCourseById(Long courseId);
    List<Course> getAllCourses();
    void deleteCourse(Long courseId);
	List<Teacher> getAllTeachers();
	Teacher getTeacherById(Long teacherId);
}
