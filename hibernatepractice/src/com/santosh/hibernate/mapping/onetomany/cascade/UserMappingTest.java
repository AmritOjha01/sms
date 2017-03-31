package com.santosh.hibernate.mapping.onetomany.cascade;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserMappingTest {
	public static void main(String[] args) {
		User user = new User();
		user.setCollegeName("IEC");

		Vehicle student1 = new Vehicle();
		student1.setStudentName("Santosh");

		Vehicle student2 = new Vehicle();
		student2.setStudentName("Amiy");
		
		user.getStudentList().add(student1);
		user.getStudentList().add(student2);
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();
		session.close();
	}
}
