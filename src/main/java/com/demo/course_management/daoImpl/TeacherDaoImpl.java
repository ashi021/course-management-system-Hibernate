package com.demo.course_management.daoImpl;

import com.demo.course_management.dao.TeacherDao;
import com.demo.course_management.entities.Course;
import com.demo.course_management.entities.Teacher;
import com.demo.course_management.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

// This class implements the TeacherDao interface to perform database operations related to teachers.
public class TeacherDaoImpl implements TeacherDao {

    // Method to add a new teacher to the database.
    @Override
    public void addTeacher(Teacher teacher) {
        Transaction transaction = null; // Start a transaction
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction(); // Begin the transaction
            session.save(teacher); // Save the teacher object
            transaction.commit(); // Commit the transaction
        } catch (Exception e) {
            if (transaction != null) transaction.rollback(); // Rollback if there's an error
            e.printStackTrace(); // Print the stack trace for debugging
        }
    }

    // Method to get a list of all teachers from the database.
    @Override
    public List<Teacher> getAllTeachers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Teacher", Teacher.class).list(); // Retrieve and return all teachers
        }
    }

    // Method to get a teacher by their ID.
    @Override
    public Teacher getTeacherById(Long teacherId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Teacher.class, teacherId); // Retrieve and return the teacher
        }
    }

    // Method to update an existing teacher in the database.
    @Override
    public void updateTeacher(Teacher teacher) {
        Transaction transaction = null; // Start a transaction
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction(); // Begin the transaction
            session.update(teacher); // Update the teacher object
            transaction.commit(); // Commit the transaction
        } catch (Exception e) {
            if (transaction != null) transaction.rollback(); // Rollback if there's an error
            e.printStackTrace(); // Print the stack trace for debugging
        }
    }

    // Method to delete a teacher by their ID.
    @Override
    public void deleteTeacher(Long teacherId) {
        Transaction transaction = null; // Start a transaction
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction(); // Begin the transaction
            Teacher teacher = session.get(Teacher.class, teacherId); // Get the teacher by ID
            if (teacher != null) {
                session.delete(teacher); // Delete the teacher if found
            }
            transaction.commit(); // Commit the transaction
        } catch (Exception e) {
            if (transaction != null) transaction.rollback(); // Rollback if there's an error
            e.printStackTrace(); // Print the stack trace for debugging
        }
    }

    // Method to get a list of courses taught by a specific teacher.
    @Override
    public List<Course> getCoursesByTeacher(Long teacherId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Teacher teacher = session.get(Teacher.class, teacherId); // Get the teacher by ID
            if (teacher != null) {
                return teacher.getCourses(); // Get the list of courses taught by the teacher
            }
            return null; // Return null if teacher not found
        }
    }

    // Method to get a course by its ID.
    @Override
    public Course getCourseById(Long courseId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Course.class, courseId); // Retrieve and return the course
        }
    }
}
