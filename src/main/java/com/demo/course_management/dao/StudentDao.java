package com.demo.course_management.dao;

import com.demo.course_management.entities.Student;
import java.util.List;

public interface StudentDao {
    void saveStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Long studentId);
    Student findStudentById(Long studentId);
    List<Student> findAllStudents();
}
