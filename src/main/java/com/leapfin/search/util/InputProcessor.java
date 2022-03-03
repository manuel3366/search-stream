package com.leapfin.search.util;

public class InputProcessor {
	private static final String INPUT_NOT_FOUND_MESSAGE = "The value for parameter %d was not present, the default value will be taken";
	public static Integer getInteger(String[] arg, int index) {
		Integer response = null;
		try {
			response = new Integer(arg[index]);
		} catch (NumberFormatException e) {
			ErrorPrinter.printError(e);
		} catch (ArrayIndexOutOfBoundsException e) {
			ErrorPrinter.printWarning(String.format(INPUT_NOT_FOUND_MESSAGE, index));
		} 
		return response;
	}
	
	public static Long getLong(String[] arg, int index) {
		Long response = null;
		try {
			response = new Long(arg[index]);
		} catch (NumberFormatException e) {
			ErrorPrinter.printError(e);
		} catch (ArrayIndexOutOfBoundsException e) {
			ErrorPrinter.printWarning(String.format(INPUT_NOT_FOUND_MESSAGE, index));
		} 
		return response;
	}
	
	public static String getString(String[] arg, int index) {
		String response = null;
		try {
			response = arg[index];
		} catch (ArrayIndexOutOfBoundsException e) {
			ErrorPrinter.printWarning(String.format(INPUT_NOT_FOUND_MESSAGE, index));
		} 
		return response;
	}
}
