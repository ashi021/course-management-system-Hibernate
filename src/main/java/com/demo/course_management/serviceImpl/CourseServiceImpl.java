package com.demo.course_management.serviceImpl;

import com.demo.course_management.dao.CourseDao;
import com.demo.course_management.daoImpl.CourseDaoImpl;
import com.demo.course_management.entities.Course;
import com.demo.course_management.entities.Teacher;
import com.demo.course_management.service.CourseService;

import java.util.List;

// This class implements the CourseService interface and provides methods for course management.
public class CourseServiceImpl implements CourseService {

    private final CourseDao courseDao; // Declare the CourseDao instance

    // No-argument constructor initializing CourseDao with CourseDaoImpl
    public CourseServiceImpl() {
        this.courseDao = new CourseDaoImpl(); // Initialize the CourseDaoImpl here
    }

    // Constructor that allows injecting a CourseDao instance
    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    // Method to add a new course
    public void addCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null"); // Check if course is null
        }
        courseDao.addCourse(course); // Call the DAO to add the course
    }

    @Override
    // Method to get all courses
    public List<Course> getAllCourses() {
        return courseDao.getAllCourses(); // Return the list of all courses
    }

    @Override
    // Method to get a teacher by their ID
    public Teacher getTeacherById(Long teacherId) {
        if (teacherId == null) {
            throw new IllegalArgumentException("Teacher ID cannot be null"); // Check if teacher ID is null
        }
        return courseDao.getTeacherById(teacherId); // Call the DAO to get the teacher
    }

    @Override
    // Method to get all teachers
    public List<Teacher> getAllTeachers() {
        return courseDao.getAllTeachers(); // Return the list of all teachers
    }

    @Override
    // Method to get a course by its ID
    public Course getCourseById(Long courseId) {
        if (courseId == null) {
            throw new IllegalArgumentException("Course ID cannot be null"); // Check if course ID is null
        }
        return courseDao.getCourseById(courseId); // Call the DAO to get the course
    }

    @Override
    // Method to update an existing course
    public void updateCourse(Course course) {
        if (course == null || course.getCourseId() == null) {
            throw new IllegalArgumentException("Course or Course ID cannot be null"); // Check if course or ID is null
        }
        courseDao.updateCourse(course); // Call the DAO to update the course
    }

    @Override
    // Method to delete a course by its ID
    public void deleteCourse(Long courseId) {
        if (courseId == null) {
            throw new IllegalArgumentException("Course ID cannot be null"); // Check if course ID is null
        }
        courseDao.deleteCourse(courseId); // Call the DAO to delete the course
    }
}
