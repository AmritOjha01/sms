package com.santosh.log4j;

import org.apache.log4j.Logger;

public class Log4JApplication {
	private static Logger logger = Logger.getLogger(Log4JApplication.class);

	public static void main(String[] args) {
		logger.info("Start app!");
		System.out.println("hello World!!!");
		String number = "X5";
		try {
			Integer.parseInt(number);
		} catch (NumberFormatException e) {
			logger.error("Can not format " + number + " to number!", e);
		}
		logger.info("finish app!");
	}
}
 