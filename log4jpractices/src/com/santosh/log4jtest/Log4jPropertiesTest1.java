package com.santosh.log4jtest;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Log4jPropertiesTest1 {

	static Logger log = Logger.getLogger(Log4jPropertiesTest1.class);
	public static void main(String[] args) {
		
		BasicConfigurator.configure();
		log.debug("This is a debug message");
		myMethod();
		log.info("This is an info message");

	}
	
	private static void myMethod(){
		try{
			throw new Exception("My Exception");
		}catch(Exception e){
			log.error("This is an exception", e);
		}
	}
}
