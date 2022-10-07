package com.aurionpro.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aurionpro.model.entity.Course;
import com.aurionpro.model.entity.Instructor;
import com.aurionpro.model.entity.InstructorDetails;
import com.aurionpro.model.entity.Student;

public class ReadCourseStudent {

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
			List<Course> courses = student.getCourses();
			for(Course c:courses) {
				System.out.println(c.toString());
			}
			
			Course course=currentSession.get(Course.class, 7);
			List<Student> student2 = course.getStudent();
			for(Student s: student2) {
				System.out.println(s);
			}
			currentSession.getTransaction().commit(); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			currentSession.close();
			factory.close();
		}
	}

}
