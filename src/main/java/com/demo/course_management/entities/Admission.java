package com.demo.course_management.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "admission")
public class Admission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admission_id")
    private Long admissionId;

    @Column(name = "admission_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date admissionDate;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @OneToOne 
    @JoinColumn(name = "student_id",unique= true, nullable = false)
    private Student student;

    // Default constructor
    public Admission() {}

    // Parameterized constructor
    public Admission(Date admissionDate, Course course, Student student) {
        this.admissionDate = admissionDate;
        this.course = course;
        this.student = student;
    }

    // Getters and Setters
    public Long getAdmissionId() {
        return admissionId;
    }

    public void setAdmissionId(Long admissionId) {
        this.admissionId = admissionId;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        String studentInfo = student != null ? 
                             "Student [studentId=" + student.getStudentId() + 
                             ", studentName=" + student.getStudentName() + "]" 
                             : "No student assigned";
        
        return "Admission [admissionId=" + admissionId + 
               ", admissionDate=" + admissionDate + 
               ", courseId=" + (course != null ? course.getCourseId() : "N/A") + 
               ", " + studentInfo + "]";
    }

}
