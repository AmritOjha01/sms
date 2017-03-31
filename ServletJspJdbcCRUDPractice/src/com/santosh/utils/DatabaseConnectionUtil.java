package com.santosh.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Utility class for database connection.
 * 
 * @author Santosh
 * 
 */
public class DatabaseConnectionUtil {

	private static String url = "jdbc:mysql://localhost:3306/";
	private static String databaseName = "servlet_jsp_jdbc_crud";
	private static String user = "root";
	private static String pass = "root";
	private static String driverName = "com.mysql.jdbc.Driver";

	public static Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName(driverName);
		Connection con = DriverManager.getConnection(url + databaseName, user,
				pass);
		return con;
	}

	public static void closeConnection(Connection con) throws SQLException {
		if (null != con && !con.isClosed()) {
			con.close();

		}
	}

	public static void closeAll(PreparedStatement preparedStatement) {
		try {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			// if (this.resultSet != null) {
			// this.resultSet.close();
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
//	CREATE TABLE `servlet_jsp_jdbc_crud`.`users` (
//			  `user_id` INT NOT NULL AUTO_INCREMENT,
//			  `first_name` VARCHAR(45) NULL,
//			  `last_name` VARCHAR(45) NULL,
//			  `email` VARCHAR(45) NULL,
//			  `dob` DATE NULL,
//			  PRIMARY KEY (`user_id`));


}
