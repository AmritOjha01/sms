package test;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		String loadQuery = "LOAD DATA LOCAL INFILE '"
				+ "C://Users/user/Desktop/survey.txt"
				+ "' INTO TABLE survey FIELDS TERMINATED BY ','"
				+ " LINES TERMINATED BY '\n' IGNORE 1 LINES (projectId, surveyId, views, dateTime) ";
		Session session = getSession();
		session.beginTransaction();
		long start = System.currentTimeMillis();
		session.createSQLQuery(loadQuery).executeUpdate();
		System.out
				.println("Time Taken=" + (System.currentTimeMillis() - start));
		closeSession(session);
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
