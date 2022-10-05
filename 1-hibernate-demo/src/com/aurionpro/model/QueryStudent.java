package com.aurionpro.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class QueryStudent {
	public static void main(String[] args) {
		// this factory is a singleton
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session currentSession = factory.getCurrentSession();
		try {
//
//			currentSession.beginTransaction();
//			List<Student> resultList = currentSession.createQuery("from Student").getResultList();
//			currentSession.getTransaction().commit();
//			for(Student student:resultList) {
//				System.out.println("id:"+student.getEmail());
//				currentSession = factory.getCurrentSession();
//				currentSession.beginTransaction();
//				
//				List <Student>resultList2 = currentSession.createQuery("from Student f where f.firstName='immanuel'").getResultList();
//				System.out.println(resultList);
//				currentSession.getTransaction().commit();

			currentSession.beginTransaction();
			List resultList3 = currentSession.createQuery("from Student s where s.email like '%yahoo%'").getResultList();
			System.out.println(resultList3);
			currentSession.getTransaction().commit();
		}

		catch (Exception e) {
			System.out.println(e);
		} finally {
			currentSession.close();
		}

	}
}
