package com.aurionpro.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aurionpro.model.entity.Student;
import com.aurionpro.model.entity.StudentDetails;

public class CreateStudent {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(StudentDetails.class)
				.buildSessionFactory();
		Session currentSession = factory.getCurrentSession();

		
		try {
			Student student = new Student("rahul","xyc","rahulgk@gmail.com");
			StudentDetails studentDetails= new StudentDetails("rahul@linkedin","xrahul@github");
			currentSession.beginTransaction();
			studentDetails.setStudent(student);
			currentSession.save(studentDetails);
			currentSession.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			factory.close();
		}
		
		
	}

}
