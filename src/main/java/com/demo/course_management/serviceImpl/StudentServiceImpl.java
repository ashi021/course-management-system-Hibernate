package com.demo.course_management.serviceImpl;

import com.demo.course_management.dao.StudentDao;
import com.demo.course_management.daoImpl.StudentDaoImpl; // Import the implementation
import com.demo.course_management.entities.Student;
import com.demo.course_management.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    // Constructor to initialize the StudentDao
    public StudentServiceImpl() {
        this.studentDao = new StudentDaoImpl(); // Instantiate the DAO directly
    }

    @Override
    public void saveStudent(Student student) {
        studentDao.saveStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentDao.deleteStudent(studentId);
    }

    @Override
    public Student findStudentById(Long studentId) {
        return studentDao.findStudentById(studentId);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentDao.findAllStudents();
    }
}
