package com.lov2code.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lov2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create session Factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
				
				// Create session
				
				Session session = factory.getCurrentSession();
				
				try {
					// Use the session object to save java object
					System.out.println("Creating 3 Student object...");
					
					// Create the 3 student object
					Student tempStudent1 = new Student("Pawan", "Singh", "pawan@gmail.com");
					Student tempStudent2 = new Student("Reeti", "Singh", "reeti@gmail.com");
					Student tempStudent3 = new Student("Vishnu", "Rajawat", "vishnu@gmail.com");
					
					// Start transaction
					session.beginTransaction();
					
					// Save the student object
					System.out.println("Saving the Student...");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					// Commit transaction
					session.getTransaction().commit();
					System.out.println("Done!");
				} finally {
					factory.close();
				}
			}

}
