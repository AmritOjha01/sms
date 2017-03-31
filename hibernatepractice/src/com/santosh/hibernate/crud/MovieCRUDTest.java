package com.santosh.hibernate.crud;

import java.util.List;
import java.util.Scanner;

public class MovieCRUDTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("what do yo want do?");
		String key = sc.next();
		int movieId;
		switch (key) {
		case "save":
			for (int i = 0; i < 10; i++) {
				Movie movie = new Movie();
				movie.setMovieName("Cast Away");
				MovieDao.save(movie);
			}
			break;
		case "update":
			System.out.println("please enter the id: ");
			movieId = sc.nextInt();
			Movie moviee = new Movie();
			moviee.setMovieName("Dabang");
			moviee.setMovieId(movieId);
			MovieDao.update(moviee);
			break;
		case "get":
			System.out.println("please enter the id: ");
			movieId = sc.nextInt();
			Movie movie = MovieDao.getMovieById(movieId);
			if (movie != null) {
				System.out.println("The movie id is: " + movie.getMovieId()
						+ " and the movie name is:" + movie.getMovieName());
			}
			break;
		case "delete":
			System.out.println("please enter the id: ");
			movieId = sc.nextInt();
			MovieDao.delete(movieId);
			break;
		case "list":
			List<Movie> moviesList = MovieDao.listMovies();
			for (Movie movie2 : moviesList) {
				System.out.println(movie2.getMovieId() + " "
						+ movie2.getMovieName());
			}
			break;
		default:
			System.out.println("you have entered wrong choice!!!!");
		}
		sc.close();
	}
}
