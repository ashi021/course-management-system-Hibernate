package com.demo.course_management.serviceImpl;

import com.demo.course_management.dao.CourseDao;
import com.demo.course_management.daoImpl.CourseDaoImpl;
import com.demo.course_management.entities.Course;
import com.demo.course_management.entities.Teacher;
import com.demo.course_management.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    private final CourseDao courseDao;
    
 // No-argument constructor initializing CourseDao
    public CourseServiceImpl() {
        this.courseDao = new CourseDaoImpl(); // Initialize the CourseDaoImpl here
    }

    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public void addCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null");
        }
        courseDao.addCourse(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }

    @Override
    public Teacher getTeacherById(Long teacherId) {
        if (teacherId == null) {
            throw new IllegalArgumentException("Teacher ID cannot be null");
        }
        return courseDao.getTeacherById(teacherId);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return courseDao.getAllTeachers();
    }

    @Override
    public Course getCourseById(Long courseId) {
        if (courseId == null) {
            throw new IllegalArgumentException("Course ID cannot be null");
        }
        return courseDao.getCourseById(courseId);
    }

    @Override
    public void updateCourse(Course course) {
        if (course == null || course.getCourseId() == null) {
            throw new IllegalArgumentException("Course or Course ID cannot be null");
        }
        courseDao.updateCourse(course);
    }

    @Override
    public void deleteCourse(Long courseId) {
        if (courseId == null) {
            throw new IllegalArgumentException("Course ID cannot be null");
        }
        courseDao.deleteCourse(courseId);
    }
}
