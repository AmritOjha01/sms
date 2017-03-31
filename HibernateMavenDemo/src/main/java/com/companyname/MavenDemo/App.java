package com.companyname.MavenDemo;

import java.io.IOException;

import org.hibernate.Session;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try {
			User user = new User();
			user.setName("Test");
			user.setAge(23);
			Session session = HibernateUtil.getSession();
			session.save(user);
			session.getTransaction().commit();
			System.out.println("succes");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
