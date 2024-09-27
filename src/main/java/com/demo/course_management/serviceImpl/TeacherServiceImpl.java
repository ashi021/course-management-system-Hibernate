package com.demo.course_management.serviceImpl;

import com.demo.course_management.dao.TeacherDao;
import com.demo.course_management.entities.Course;
import com.demo.course_management.entities.Teacher;
import com.demo.course_management.service.TeacherService;
import org.hibernate.Hibernate; // Import for Hibernate.initialize
import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    
    private final TeacherDao teacherDao;

    // Constructor accepting TeacherDao
    public TeacherServiceImpl(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public void addTeacher(Teacher teacher) {
        // Adding a new teacher
        teacherDao.addTeacher(teacher);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        // Retrieving all teachers and initializing courses
        List<Teacher> teachers = teacherDao.getAllTeachers();
        for (Teacher teacher : teachers) {
            Hibernate.initialize(teacher.getCourses()); // Ensure courses are initialized
        }
        return teachers;
    }

    @Override
    public Teacher getTeacherById(Long id) {
        // Retrieving a teacher by ID
        return teacherDao.getTeacherById(id);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        // Updating an existing teacher
        teacherDao.updateTeacher(teacher);
    }

    @Override
    public void deleteTeacher(Long id) {
        // Deleting a teacher by ID
        teacherDao.deleteTeacher(id);
    }

    @Override
    public Course getCourseById(Long courseId) {
        // Fetching a course by ID
        return teacherDao.getCourseById(courseId);
    }
}
