package com.demo.course_management.daoImpl;

import com.demo.course_management.dao.CourseDao;
import com.demo.course_management.entities.Course;
import com.demo.course_management.entities.Teacher;
import com.demo.course_management.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

// This class implements the CourseDao interface to perform database operations related to courses.
public class CourseDaoImpl implements CourseDao {

    // Method to add a new course to the database.
    @Override
    public void addCourse(Course course) {
        Transaction transaction = null; // Start a transaction
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction(); // Begin the transaction
            session.save(course); // Save the course object
            transaction.commit(); // Commit the transaction
        } catch (Exception e) {
            if (transaction != null) transaction.rollback(); // Rollback if there's an error
            System.err.println("Error while adding course: " + e.getMessage()); // Print the error message
        }
    }

    // Method to get a list of all courses from the database.
    @Override
    public List<Course> getAllCourses() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Course", Course.class).list(); // Retrieve and return all courses
        } catch (Exception e) {
            System.err.println("Error while retrieving all courses: " + e.getMessage()); // Print error message
            return null; // Or consider returning an empty list
        }
    }

    // Method to get a course by its ID.
    @Override
    public Course getCourseById(Long courseId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Course.class, courseId); // Retrieve and return the course
        } catch (Exception e) {
            System.err.println("Error while retrieving course by ID: " + e.getMessage()); // Print error message
            return null; // Return null if course not found
        }
    }

    // Method to update an existing course in the database.
    @Override
    public void updateCourse(Course course) {
        Transaction transaction = null; // Start a transaction
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction(); // Begin the transaction
            session.update(course); // Update the course object
            transaction.commit(); // Commit the transaction
        } catch (Exception e) {
            if (transaction != null) transaction.rollback(); // Rollback if there's an error
            System.err.println("Error while updating course: " + e.getMessage()); // Print error message
        }
    }

    // Method to delete a course by its ID.
    @Override
    public void deleteCourse(Long courseId) {
        Transaction transaction = null; // Start a transaction
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction(); // Begin the transaction
            Course course = session.get(Course.class, courseId); // Get the course by ID
            if (course != null) {
                session.delete(course); // Delete the course if found
            }
            transaction.commit(); // Commit the transaction
        } catch (Exception e) {
            if (transaction != null) transaction.rollback(); // Rollback if there's an error
            System.err.println("Error while deleting course: " + e.getMessage()); // Print error message
        }
    }

    // Method to get a list of all teachers from the database.
    @Override
    public List<Teacher> getAllTeachers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Teacher", Teacher.class).list(); // Retrieve and return all teachers
        } catch (Exception e) {
            System.err.println("Error while retrieving all teachers: " + e.getMessage()); // Print error message
            return null; // Or consider returning an empty list
        }
    }

    // Method to get a teacher by their ID.
    @Override
    public Teacher getTeacherById(Long teacherId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Teacher.class, teacherId); // Retrieve and return the teacher
        } catch (Exception e) {
            System.err.println("Error while retrieving teacher by ID: " + e.getMessage()); // Print error message
            return null; // Return null if teacher not found
        }
    }
}
