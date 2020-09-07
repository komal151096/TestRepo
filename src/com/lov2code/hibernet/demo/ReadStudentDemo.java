package com.lov2code.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lov2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// Create session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create session

		Session session = factory.getCurrentSession();

		try {
			// Use the session object to save java object
			System.out.println("Creating a new Student object...");

			// Create the student object
			Student tempStudent = new Student("Lakshmi", "Mishra", "mishralax999@gmail.com");

			// Start transaction
			session.beginTransaction();

			// Save the student object
			System.out.println("Saving the Student...");
			System.out.println(tempStudent);

			session.save(tempStudent);
			// Commit transaction
			session.getTransaction().commit();

			// My new code

			// Find out the student's primary key
			System.out.println("Saved Student. Generated Id: " + tempStudent.getId());

			// Now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// Retrieve Student based on the id: Primary key
			System.out.println("\nGetting Student with ID: " + tempStudent.getId());

			Student myStudent = session.get(Student.class, tempStudent.getId());

			System.out.println(" Get Complete: " + myStudent);

			// Commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
