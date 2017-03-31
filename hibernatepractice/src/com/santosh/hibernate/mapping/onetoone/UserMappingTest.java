package com.santosh.hibernate.mapping.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserMappingTest {
	public static void main(String[] args) {
		User user = new User();
		user.setUserName("Santosh");

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("car");

		user.setVehicle(vehicle);
		vehicle.setUser(user);

		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();
	}
}
