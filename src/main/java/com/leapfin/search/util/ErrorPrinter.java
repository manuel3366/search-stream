package com.leapfin.search.util;

import java.util.concurrent.TimeoutException;

public class ErrorPrinter {

	public static void printError(Throwable e) {
		if (e instanceof TimeoutException == false) {
			e.printStackTrace();
		}
		
	}
	
	public static void printWarning(String message) {
		System.err.println(message);
		
	}
}
