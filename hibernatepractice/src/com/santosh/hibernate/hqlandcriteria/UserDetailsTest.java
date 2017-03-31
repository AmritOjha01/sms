package com.santosh.hibernate.hqlandcriteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class UserDetailsTest {
	public static void main(String[] args) {

		// using hql
//		Session session = getSession();
//		session.beginTransaction();
//		Query query = session.createQuery("from UserDetails where userId > 2");
//		List<UserDetails> userDetails = query.list();
//		closeSession(session);
//		System.out.println("Size of list result is: " + userDetails.size());

		// criteria restrictions example
//		@SuppressWarnings("deprecation")
//		Session session = getSession();
//		session.beginTransaction();
//		Criteria criteria = session.createCriteria(UserDetails.class);
//		criteria.add(Restrictions.eq("userName", "m"));
//		List<UserDetails> userDetailss = criteria.list();
//		closeSession(session);
//		for (UserDetails userDetails2 : userDetailss) {
//			System.out.println(userDetails2.getUserId());
//		}

//		// criteria projections example
//		Session session = getSession();
//		session.beginTransaction();
//		Criteria criteriaa = session.createCriteria(UserDetails.class)
////		 .setProjection(Projections.count("userId"))
//				.addOrder(Order.asc("userId"));
//		List<UserDetails> userDetailsss = criteriaa.list();
//		closeSession(session);
//		for (UserDetails userDetails2 : userDetailsss) {
//			System.out.println(userDetails2.getUserId());
//		}
		
		Session session = getSession();
		session.beginTransaction();
		Criteria criteria= session.createCriteria(UserDetails.class)
				                  .setProjection(Projections.rowCount());
		long l=(long)criteria.uniqueResult();
		session.getTransaction().commit();
		session.close();
		System.out.println(l);

	}

	@SuppressWarnings("deprecation")
	private static Session getSession() {
		return new Configuration().configure().buildSessionFactory()
				.openSession();
	}

	private static void closeSession(Session session) {
		session.getTransaction().commit();
		session.close();
	}

}
