package com.demo.course_management.serviceImpl;

import com.demo.course_management.dao.TeacherDao;
import com.demo.course_management.entities.Course;
import com.demo.course_management.entities.Teacher;
import com.demo.course_management.service.TeacherService;
import org.hibernate.Hibernate; // Import for Hibernate.initialize
import java.util.List;

// This class implements the TeacherService interface for teacher management
public class TeacherServiceImpl implements TeacherService {

    private final TeacherDao teacherDao; // Declare the TeacherDao instance

    // Constructor accepting TeacherDao
    public TeacherServiceImpl(TeacherDao teacherDao) {
        this.teacherDao = teacherDao; // Initialize the TeacherDao
    }

    @Override
    // Method to add a new teacher
    public void addTeacher(Teacher teacher) {
        teacherDao.addTeacher(teacher); // Call the DAO to add the teacher
    }

    @Override
    // Method to get all teachers
    public List<Teacher> getAllTeachers() {
        // Retrieving all teachers and initializing their courses
        List<Teacher> teachers = teacherDao.getAllTeachers(); // Get the list of teachers
        for (Teacher teacher : teachers) {
            Hibernate.initialize(teacher.getCourses()); // Ensure courses are initialized
        }
        return teachers; // Return the list of teachers
    }

    @Override
    // Method to get a teacher by ID
    public Teacher getTeacherById(Long id) {
        return teacherDao.getTeacherById(id); // Call the DAO to get the teacher
    }

    @Override
    // Method to update an existing teacher
    public void updateTeacher(Teacher teacher) {
        teacherDao.updateTeacher(teacher); // Call the DAO to update the teacher
    }

    @Override
    // Method to delete a teacher by ID
    public void deleteTeacher(Long id) {
        teacherDao.deleteTeacher(id); // Call the DAO to delete the teacher
    }

    @Override
    // Method to fetch a course by its ID
    public Course getCourseById(Long courseId) {
        return teacherDao.getCourseById(courseId); // Call the DAO to get the course
    }
}
