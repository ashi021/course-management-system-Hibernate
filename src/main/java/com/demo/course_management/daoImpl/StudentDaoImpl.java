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
	        
	        // Ensure admission_id is set if required
	        if (student.getAdmissions() != null && !student.getAdmissions().isEmpty()) {
	            // Set the admissionId based on the first admission, or handle as needed
	            Admission firstAdmission = student.getAdmissions().get(0);
	            // Ensure admission has the necessary attributes set
	            session.save(firstAdmission);
	        }
	        
	        session.save(student);
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
                session.delete(student);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error while deleting student: " + e.getMessage());
        }
    }
}
