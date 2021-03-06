package com.santosh.hibernate.mapping.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class UserMappingTest {
	public static void main(String[] args) {
		User user = new User();
		user.setUserName("Santosh");

		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("car");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("bike");

		user.getVehicleList().add(vehicle1);
		user.getVehicleList().add(vehicle2);
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle1);
		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();
	}
}
