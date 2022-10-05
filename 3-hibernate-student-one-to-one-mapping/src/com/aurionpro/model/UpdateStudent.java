package com.aurionpro.model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aurionpro.model.entity.Student;
import com.aurionpro.model.entity.StudentDetails;

public class UpdateStudent {
	public static void main(String args[]) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(StudentDetails.class)
				.buildSessionFactory();
		
		Session currentSession;
		try {
			currentSession = factory.getCurrentSession();
			currentSession.beginTransaction();
		//	StudentDetails studentDetails= currentSession.get(StudentDetails.class,1);
			Student student= currentSession.get(Student.class, 2);
			student.setFirstName("RahulUpdated");
			currentSession.save(student);

			currentSession.getTransaction().commit();

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			factory.close();
		}

		
	}
	


}
