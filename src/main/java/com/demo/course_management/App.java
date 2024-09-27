package com.demo.course_management;

import java.time.LocalDate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.demo.course_management.entities.Student;

public class App {
    public static void main(String[] args) {
//        // Obtain a Hibernate SessionFactory
//        SessionFactory factory = HibernateUtil.getSessionFactory();
//        
//        // Create new Student objects
//        LocalDate date1 = LocalDate.of(1988, 1, 13);
//        //Student student1 = new Student("S111", "Oliver", "oliver@gmail.com", "6742906745", "123 Main St", date1, "M");
//        
//        LocalDate date2 = LocalDate.of(1995, 5, 22);
//        Student student2 = new Student("S113", "Sophia", "sophia@gmail.com", "9876543210", "456 Elm St", date2, "F");
//
//        // Open a new session
//        Session session = factory.openSession();
//        
//        // Begin a transaction
//        Transaction transaction = session.beginTransaction();
//        
//        // Save the students to the database
//        //session.save(student1);
//        session.save(student2);
//        
//        // Commit the transaction
//        transaction.commit();
//        
//        // Close the session and factory
//        session.close();
//        factory.close();
    }
}
