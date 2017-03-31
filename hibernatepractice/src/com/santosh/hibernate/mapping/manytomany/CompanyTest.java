package com.santosh.hibernate.mapping.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CompanyTest {
	public static void main(String[] args) {
		Company company1 = new Company();
		company1.setCompName("pointclickcare");
		Company company2 = new Company();
		company2.setCompName("zurelsoft");
		
		Employee employee1 = new Employee();
		employee1.setEmpName("Santosh");
		Employee employee2 = new Employee();
		employee2.setEmpName("Subash");

		company1.getEmpList().add(employee1);
		company1.getEmpList().add(employee2);
		employee1.getCompList().add(company1);
		employee1.getCompList().add(company2);
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(employee1);
		session.save(company1);
		session.save(employee2);
		session.save(company2);
		session.getTransaction().commit();
		session.close();
	}
}
