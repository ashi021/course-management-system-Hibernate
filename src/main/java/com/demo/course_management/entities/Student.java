package com.demo.course_management.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "student_name", nullable = false, length = 100)
    private String studentName;

    @Column(name = "student_dob", nullable = false)
    private String studentDob; // Change to LocalDate if needed

    @Column(name = "student_email", nullable = false, unique = true)
    private String studentEmail;

    @Column(name = "student_mobile_no", nullable = false)
    private String studentMobileNo;

    @Column(name = "student_address", nullable = false)
    private String studentAddress;

    @Column(name = "student_gender", nullable = false)
    private String studentGender;

    @Column(name = "admission_id") // Add this line if this field is needed
    private Long admissionId; // Assuming admission_id is Long; change as needed

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Admission> admissions;

    // Default constructor
    public Student() {}

    // Parameterized constructor
    public Student(String studentName, String studentDob, String studentEmail, 
                   String studentMobileNo, String studentAddress, 
                   String studentGender) {
        this.studentName = studentName;
        this.studentDob = studentDob;
        this.studentEmail = studentEmail;
        this.studentMobileNo = studentMobileNo;
        this.studentAddress = studentAddress;
        this.studentGender = studentGender;
    }

    // Getters and Setters
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentDob() {
        return studentDob;
    }

    public void setStudentDob(String studentDob) {
        this.studentDob = studentDob;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentMobileNo() {
        return studentMobileNo;
    }

    public void setStudentMobileNo(String studentMobileNo) {
        this.studentMobileNo = studentMobileNo;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public Long getAdmissionId() { // Add this getter
        return admissionId;
    }

    public void setAdmissionId(Long admissionId) { // Add this setter
        this.admissionId = admissionId;
    }

    public List<Admission> getAdmissions() {
        return admissions;
    }

    public void setAdmissions(List<Admission> admissions) {
        this.admissions = admissions;
    }

    @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", studentName=" + studentName + 
                ", studentDob=" + studentDob + ", studentEmail=" + studentEmail + 
                ", studentMobileNo=" + studentMobileNo + ", studentAddress=" + studentAddress + 
                ", studentGender=" + studentGender + ", admissionId=" + admissionId + "]"; // Include admissionId if necessary
    }
}
