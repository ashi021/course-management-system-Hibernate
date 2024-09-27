package com.demo.course_management.daoImpl;

import com.demo.course_management.dao.CourseDao;
import com.demo.course_management.entities.Course;
import com.demo.course_management.entities.Teacher;
import com.demo.course_management.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CourseDaoImpl implements CourseDao {

    @Override
    public void addCourse(Course course) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(course);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error while adding course: " + e.getMessage());
        }
    }

    @Override
    public List<Course> getAllCourses() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Course", Course.class).list();
        } catch (Exception e) {
            System.err.println("Error while retrieving all courses: " + e.getMessage());
            return null; // Or consider returning an empty list
        }
    }

    @Override
    public Course getCourseById(Long courseId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Course.class, courseId);
        } catch (Exception e) {
            System.err.println("Error while retrieving course by ID: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void updateCourse(Course course) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(course);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error while updating course: " + e.getMessage());
        }
    }

    @Override
    public void deleteCourse(Long courseId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Course course = session.get(Course.class, courseId);
            if (course != null) {
                session.delete(course);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error while deleting course: " + e.getMessage());
        }
    }

    @Override
    public List<Teacher> getAllTeachers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Teacher", Teacher.class).list();
        } catch (Exception e) {
            System.err.println("Error while retrieving all teachers: " + e.getMessage());
            return null; // Or consider returning an empty list
        }
    }

    @Override
    public Teacher getTeacherById(Long teacherId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Teacher.class, teacherId);
        } catch (Exception e) {
            System.err.println("Error while retrieving teacher by ID: " + e.getMessage());
            return null;
        }
    }
}
