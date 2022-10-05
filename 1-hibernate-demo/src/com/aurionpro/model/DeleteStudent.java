package com.aurionpro.model;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {
	public static void main(String[] args) {
		// this factory is a singleton
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session currentSession = factory.getCurrentSession();
		try {
			
			currentSession.beginTransaction();
			Student student = currentSession.get(Student.class, 6);
			System.out.println(student);
			currentSession.delete(student);
//			student.setEmail("rahulupdated@gmail.com");
//			student.setFirstName("RahulUpdated");
//			currentSession.createQuery("update Student s set s.lastName='raj' where id=1").executeUpdate();
//			
//			currentSession.getTransaction().commit();
			
			Query spSQLQuery = currentSession.createQuery("delete Student s where id= :param1");
			spSQLQuery.setParameter("param1",1);

			spSQLQuery.executeUpdate();
			currentSession.getTransaction().commit();
			

		} catch (Exception e) {
			System.out.println(e);
		}finally {
			currentSession.close();
		}

	}
}
