package com.lov2code.hibernet.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lov2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// Create session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create session

		Session session = factory.getCurrentSession();

		try {

			// Start transaction
			session.beginTransaction();

			// Query Students
			List<Student> theStudents = session.createQuery("from Student").list();
			// Display the Students
			displayStudents(theStudents);

			// Query Students: last_name='Singh'
			theStudents = session.createQuery("from Student s where s.lastName='Singh'").list();

			// Display the Students
			System.out.println("\n\nStudents who have last name of  Singh");
			displayStudents(theStudents);

			// Query Students: last_name='Mishra' OR first_name='Pawan'
			theStudents = session.createQuery("from Student s where" + " s.lastName='Mishra' OR s.firstName='Pawan'")
					.list();

			System.out.println("\n\nStudents who have last name of Mishra OR first name Pawan");
			displayStudents(theStudents);
			
			// Query Student where email like '%999@gmail.com'
			theStudents=session.createQuery("from Student s where s.email like '%999@gmail.com'").list();
			System.out.println("\n\nStudents whose email ends with 999@gmail.com " );
			displayStudents(theStudents);
			// Commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
