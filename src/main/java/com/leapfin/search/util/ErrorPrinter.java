package com.leapfin.search.util;

import java.util.concurrent.TimeoutException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
* Prints all of the errors and warnings that occurred during the 
* execution of the application.
*
* @author  Edwin Saucedo
* @version 1.0
* @since   2022-03-02 
*/
public class ErrorPrinter {
	
	private static Logger logger = LogManager.getLogger(ErrorPrinter.class);
	
	public static void printError(Throwable e) {
		if (e instanceof TimeoutException == false) {
			logger.error(e);
		}
		
	}
	
	public static void printWarning(String message) {
		logger.warn(message);
		
	}
}
