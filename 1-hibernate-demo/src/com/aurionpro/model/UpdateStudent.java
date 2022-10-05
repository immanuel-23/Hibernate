package com.aurionpro.model;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudent {
	public static void main(String[] args) {
		// this factory is a singleton
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session currentSession = factory.getCurrentSession();
		try {
			
			currentSession.beginTransaction();
			Student student = currentSession.get(Student.class, 1);
			
//			student.setEmail("rahulupdated@gmail.com");
//			student.setFirstName("RahulUpdated");
//			currentSession.createQuery("update Student s set s.lastName='raj' where id=1").executeUpdate();
//			
//			currentSession.getTransaction().commit();
			Query spSQLQuery = currentSession.createSQLQuery("update Student s set s.last_name= :param1 where id=:param2");
			spSQLQuery.setParameter("param1","vicky");
			spSQLQuery.setParameter("param2","2");

			spSQLQuery.executeUpdate();
			currentSession.getTransaction().commit();
			

		} catch (Exception e) {
			System.out.println(e);
		}finally {
			currentSession.close();
		}

	}
}
