package com.lov2code.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lov2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).buildSessionFactory();
		// Create Session
		Session  session = factory.getCurrentSession();
		
		try {
			
			System.out.println("Creating Student Object");
			// Create Student Object
		Student student = new Student ("Tanmay", "Tripathi", "tanmay999@gmail.com");
		
		// Start the transaction
		session.beginTransaction();
		
		// Save the Student object
		System.out.println("Saving the Student.... \n\n student" + student);
		session.save(student);
		
		// Commit the transaction
		session.getTransaction().commit();
		
		System.out.println("Done!");
			
		} finally {
			factory.close();
		}
		
	}

}
