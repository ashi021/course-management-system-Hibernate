package com.demo.course_management.dao;

import com.demo.course_management.entities.Course;
import com.demo.course_management.entities.Teacher;

import java.util.List;

public interface TeacherDao {
    void addTeacher(Teacher teacher);
    void updateTeacher(Teacher teacher);
    Teacher getTeacherById(Long teacherId);
    List<Teacher> getAllTeachers();
    void deleteTeacher(Long teacherId);
	List<Course> getCoursesByTeacher(Long teacherId);
	Course getCourseById(Long courseId);
}
