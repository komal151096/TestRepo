package com.lov2code.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lov2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// Create session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create session

		Session session = factory.getCurrentSession();

		try {
			 int studentId=2;
			  // Now get a new session and start the transaction
			 session=factory.getCurrentSession();
			 session.beginTransaction();
			 
			 // Retrieve students based on ID  : Primary key
			 System.out.println("\nGetting Student Id with: "+ studentId);
			 
			 Student myStudent=session.get(Student.class, studentId);
			 
			 // Delete the student
			// System.out.println("Deleting the Student: " + myStudent);
			 // session.delete(myStudent);
			 
			 // Delete the Student where ID =4
			 System.out.println("Deleting the Student ID=4");
			 session.createQuery("delete from Student where id in (6, 7, 8)").executeUpdate();

			
			// Commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
