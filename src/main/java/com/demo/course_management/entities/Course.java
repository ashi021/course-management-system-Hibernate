package com.demo.course_management.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "course_name", nullable = false, length = 100)
    private String courseName;

    @Column(name = "course_duration", nullable = false, length = 50)
    private String courseDuration;

    @Column(name = "credits", nullable = false)
    private int credits;

    @Column(name = "max_enrollment", nullable = false)
    private int maxEnrollment;

    // One Course can have Many Admissions (mapped by course in Admission entity)
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Admission> admissions;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = true) // Allow null if a course can exist without a teacher
    private Teacher teacher;

    // Default constructor
    public Course() {}

    // Parameterized constructor
    public Course(String courseName, String courseDuration, int credits, int maxEnrollment, Teacher teacher) {
        this.courseName = courseName;
        this.courseDuration = courseDuration;
        this.credits = credits;
        this.maxEnrollment = maxEnrollment;
        this.teacher = teacher;
    }

    // Getters and Setters
    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getMaxEnrollment() {
        return maxEnrollment;
    }

    public void setMaxEnrollment(int maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }

    public List<Admission> getAdmissions() {
        return admissions;
    }

    public void setAdmissions(List<Admission> admissions) {
        this.admissions = admissions;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        String teacherInfo = teacher != null ? 
                             "Teacher [teacherId=" + teacher.getTeacherId() + 
                             ", teacherName=" + teacher.getTeacherName() + "]" 
                             : "No teacher assigned";
        
        return "Course [courseId=" + courseId + ", courseName=" + courseName 
                + ", courseDuration=" + courseDuration + ", credits=" + credits 
                + ", maxEnrollment=" + maxEnrollment + ", teacher=" + teacherInfo + "]";
    }
}
