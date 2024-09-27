package com.demo.course_management.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "teacher_name", nullable = false)
    private String teacherName;

    @Column(name = "teacher_mobileno", nullable = false)
    private String teacherMobileNo;


    @Column(name = "teacher_email", nullable = false)
    private String teacherEmail;

    @Column(name = "qualification", nullable = false)
    private String qualification;

    @Column(name = "salary", nullable = false)
    private Double salary;

    // One Teacher can teach Many Courses
    @OneToMany(mappedBy = "teacher", fetch = FetchType.EAGER)
    private List<Course> courses;

    // Default constructor
    public Teacher() {}

    // Parameterized constructor
    public Teacher(String teacherName, String teacherMobileNo, String teacherEmail, String qualification, Double salary, List<Course> courses) {
        this.teacherName = teacherName;
        this.teacherMobileNo = teacherMobileNo;
        this.teacherEmail = teacherEmail;
        this.qualification = qualification;
        this.salary = salary;
        this.courses = courses;
    }

    // Getters and Setters
    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherMobileNo() {
        return teacherMobileNo;
    }

    public void setTeacherMobileNo(String teacherMobileNo) {
        this.teacherMobileNo = teacherMobileNo;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Teacher [teacherId=" + teacherId + ", teacherName=" + teacherName + 
               ", teacherMobileNo=" + teacherMobileNo + ", teacherEmail=" + teacherEmail +
               ", qualification=" + qualification + ", salary=" + salary + "]";
    }
}
