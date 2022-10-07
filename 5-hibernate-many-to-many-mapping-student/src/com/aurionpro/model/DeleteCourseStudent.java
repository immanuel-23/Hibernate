package com.aurionpro.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aurionpro.model.entity.Course;
import com.aurionpro.model.entity.Instructor;
import com.aurionpro.model.entity.InstructorDetails;
import com.aurionpro.model.entity.Student;

public class DeleteCourseStudent {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session currentSession = factory.getCurrentSession();
		try {
			currentSession.beginTransaction();
			Student student = currentSession.get(Student.class, 6);
			currentSession.delete(student);
			
			Course course=currentSession.get(Course.class, 7);
			currentSession.delete(course);
			currentSession.getTransaction().commit(); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			currentSession.close();
			factory.close();
		}
	}

}
