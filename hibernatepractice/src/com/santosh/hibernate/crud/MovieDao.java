package com.santosh.hibernate.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MovieDao {
	public static void save(Movie movie) {
		Session session = getSession();
		session.beginTransaction();
		session.save(movie);
		closeSession(session);
	}

	public static Movie getMovieById(int movieId) {
		Session session = getSession();
		session.beginTransaction();
		Movie movie = (Movie) session.get(Movie.class, movieId);
		closeSession(session);
		if (movie == null) {
			System.out.println("movie id does not found in database!!!");
			return null;
		}
		return movie;
	}

	public static void update(Movie movie) {
		Session session = getSession();
		session.beginTransaction();
		Movie moviee = (Movie) getMovieById(movie.getMovieId());
		if (moviee != null) {
			session.update(movie);
		}
		System.out.println("movie id does not found in database!!!");
		closeSession(session);
		System.out.println("The movie id is: " + movie.getMovieId()
				+ " and the movie name is:" + movie.getMovieName());
	}

	public static void delete(int movieId) {
		Session session = getSession();
		session.beginTransaction();
		Movie movie = (Movie) getMovieById(movieId);
		if (movie != null) {
			session.delete(movie);
		}
		System.out.println("movie id does not found in database!!!");
		closeSession(session);
	}

	public static List<Movie> listMovies() {
		return getSession().createCriteria(Movie.class).list();
	}

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	public static Session getSession() {
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		return session;
	}

	private static void closeSession(Session session) {
		session.getTransaction().commit();
		session.close();
	}
}
