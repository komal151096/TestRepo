package com.lov2code.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lov2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// Create session Factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// Create session
		
		Session session = factory.getCurrentSession();
		
		try {
			// Use the session object to save java object
			System.out.println("Creating a new Student object...");
			
			// Create the student object
			Student tempStudent = new Student("Tanmay", "Tripathi", "tanmay@gmail.com");
			
			// Start transaction
			session.beginTransaction();
			
			// Save the student object
			System.out.println("Saving the Student...");
			session.save(tempStudent);
			// Commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
