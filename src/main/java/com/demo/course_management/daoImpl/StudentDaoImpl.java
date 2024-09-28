package com.demo.course_management.daoImpl;

import com.demo.course_management.dao.StudentDao;
import com.demo.course_management.entities.Admission;
import com.demo.course_management.entities.Student;
import com.demo.course_management.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public void saveStudent(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            
            // Ensure the admission is set
            Admission admission = student.getAdmission();
            if (admission != null) {
                // Set the student reference in the admission
                admission.setStudent(student);
                session.save(admission); // Save the admission first
            }
            
            session.save(student); // Save the student
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error while saving student: " + e.getMessage());
        }
    }

    @Override
    public List<Student> findAllStudents() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Student", Student.class).list();
        } catch (Exception e) {
            System.err.println("Error while retrieving all students: " + e.getMessage());
            return null; // Or consider returning an empty list
        }
    }

    @Override
    public Student findStudentById(Long studentId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Student.class, studentId);
        } catch (Exception e) {
            System.err.println("Error while retrieving student by ID: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void updateStudent(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(student);
            // If updating, ensure admission is also updated if it exists
            Admission admission = student.getAdmission();
            if (admission != null) {
                admission.setStudent(student);
                session.update(admission); // Update the admission as well
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error while updating student: " + e.getMessage());
        }
    }

    @Override
    public void deleteStudent(Long studentId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, studentId);
            if (student != null) {
                // Also delete the admission if it exists
                Admission admission = student.getAdmission();
                if (admission != null) {
                    session.delete(admission); // Delete the admission first
                }
                session.delete(student); // Then delete the student
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error while deleting student: " + e.getMessage());
        }
    }
}
