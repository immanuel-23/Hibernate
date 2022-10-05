package com.aurionpro.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudent {
	public static void main(String[] args) {
		// this factory is a singleton
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session currentSession = factory.getCurrentSession();
		try {
//			Student student = new Student("Immanuel", "Nadar", "immanuelgk@gmail.com");
//			currentSession.beginTransaction();
//			currentSession.save(student);
//			currentSession.getTransaction().commit();
//
//			System.out.println("Student  data added ..." + student.getId());
			//currentSession = factory.getCurrentSession();
			
			currentSession.beginTransaction();

			
			Student tempStudent = currentSession.get(Student.class,1);
			
			System.out.println(tempStudent);
			currentSession.getTransaction();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			currentSession.close();
		}

	}
}
