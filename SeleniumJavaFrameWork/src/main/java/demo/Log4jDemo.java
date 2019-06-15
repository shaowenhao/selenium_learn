package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {

	// also would use log4j2.xml to define configuration.
	public static Logger logger = LogManager.getLogger(Log4jDemo.class);
	
	public static void main(String[] args) {
		System.out.println("Hello Ryan");
		logger.debug("This is a debug message");
		logger.info("This is an info message");
		logger.warn("This is a warn message");
		logger.error("This is an error message");
		logger.fatal("This is a fatal message");
		System.out.println("End Test");
	}

}
