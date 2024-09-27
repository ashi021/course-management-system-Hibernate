package com.demo.course_management.service;

import com.demo.course_management.entities.Student;
import java.util.List;

public interface StudentService {
    void saveStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Long studentId);
    Student findStudentById(Long studentId);
    List<Student> findAllStudents();
}
