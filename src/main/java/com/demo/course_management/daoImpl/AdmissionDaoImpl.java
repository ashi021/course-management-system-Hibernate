package com.demo.course_management.daoImpl;

import com.demo.course_management.dao.AdmissionDao;
import com.demo.course_management.entities.Admission;
import com.demo.course_management.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AdmissionDaoImpl implements AdmissionDao {

    @Override
    public void saveAdmission(Admission admission) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // Log the admission details
            System.out.println("Saving Admission: " + admission);

            session.save(admission);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error while saving admission: " + e.getMessage());
        }
    }

    @Override
    public void updateAdmission(Admission admission) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(admission);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error while updating admission: " + e.getMessage());
        }
    }

    @Override
    public void deleteAdmission(Long admissionId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Admission admission = session.get(Admission.class, admissionId);
            if (admission != null) {
                session.delete(admission);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error while deleting admission: " + e.getMessage());
        }
    }

    @Override
    public Admission findAdmissionById(Long admissionId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Admission.class, admissionId);
        } catch (Exception e) {
            System.err.println("Error while retrieving admission by ID: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Admission> findAllAdmissions() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Admission", Admission.class).getResultList(); // Use getResultList() instead of list()
        } catch (Exception e) {
            System.err.println("Error while retrieving all admissions: " + e.getMessage());
            return List.of(); // Return an empty list instead of null
        }
    }
}
