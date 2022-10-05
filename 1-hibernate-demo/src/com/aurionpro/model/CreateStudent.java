package com.aurionpro.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudent {
	public static void main(String[] args) {
		// this factory is a singleton
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session currentSession = factory.getCurrentSession();
		try {
			Student student = new Student("qwr", "ajay", "ajay@yahoo.com");
			currentSession.beginTransaction();
			currentSession.save(student);
			currentSession.getTransaction().commit();

		} catch (Exception e) {
			System.out.println(e);
		}finally {
			currentSession.close();
		}

	}
}
