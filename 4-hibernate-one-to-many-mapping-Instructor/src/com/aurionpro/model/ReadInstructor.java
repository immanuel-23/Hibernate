package com.aurionpro.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aurionpro.model.entity.Instructor;
import com.aurionpro.model.entity.InstructorDetails;

public class ReadInstructor {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.buildSessionFactory();

		Session currentSession = factory.getCurrentSession();
		try {
			currentSession.beginTransaction();
			InstructorDetails instructorDetails = currentSession.get(InstructorDetails.class, 1); 
			System.out.println(instructorDetails);
			Instructor instructor = instructorDetails.getInstructor();
			System.out.println(instructor);
			
			currentSession.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}
}