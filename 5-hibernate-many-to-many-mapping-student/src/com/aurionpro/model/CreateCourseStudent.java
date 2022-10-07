package com.aurionpro.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aurionpro.model.entity.Course;
import com.aurionpro.model.entity.Instructor;
import com.aurionpro.model.entity.InstructorDetails;
import com.aurionpro.model.entity.Student;

public class CreateCourseStudent {
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
			Student student1 = new Student("rahul", "rg", "flameZ@og.com");
			Student student2 = new Student("xbau", "navi", "xbau@navi.com");
			Course course1 = new Course("histroy");
			Course course2 = new Course("css");
			Course course3 = new Course("html");
		
			currentSession.save(course1);
			currentSession.save(course2);
			currentSession.save(course3);
			
			course1.addStudent(student1);
			course2.addStudent(student2);
			course3.addStudent(student1);
			
			currentSession.save(student1);
			currentSession.save(student2);
			currentSession.getTransaction().commit(); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			currentSession.close();
			factory.close();
		}
		
		
				
	}
}