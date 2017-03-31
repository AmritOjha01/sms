package com.santosh.hibernate.basic;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class UserDetailsTest {
	public static void main(String[] args) {

		UserDetails user = new UserDetails();
		//user.setUserId(2);
		user.setUserName("Santosh");
		user.setAddress("Sanepa");
		user.setJoinedDate(new Date());
		user.setEmail("santoshkarna@gmail.com");
		user.setDescription("description goes here.........description goes here.........description goes here.........description goes here.........description goes here.........description goes here.........description goes here.........description goes here.........description goes here.........description goes here.........description goes here.........description goes here.........description goes here.........description goes here.........description goes here.........description goes here.........");

		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();

//		 user = null;
//		 session = sessionFactory.openSession();
//		 session.beginTransaction();
//		 user = (UserDetails) session.get(UserDetails.class, 1);
//		 System.out.println("The user name is: " + user.getUserName());

	
	}
}
