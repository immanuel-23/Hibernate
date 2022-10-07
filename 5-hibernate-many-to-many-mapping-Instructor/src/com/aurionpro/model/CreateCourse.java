package com.aurionpro.model;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aurionpro.model.entity.Course;
import com.aurionpro.model.entity.Instructor;
import com.aurionpro.model.entity.InstructorDetails;

public class CreateCourse {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session currentSession = factory.getCurrentSession();
		try {
			currentSession.beginTransaction();
			
			Instructor instructor = currentSession.get(Instructor.class, 2);
			Course course1 = new Course("java");
			Course course2 = new Course("angular");
			
			instructor.addCourse(course1);
			instructor.addCourse(course2);
			
			currentSession.save(course1);
			currentSession.save(course2);
			currentSession.getTransaction().commit(); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			currentSession.close();
			factory.close();
		}
		
		
				
	}
}