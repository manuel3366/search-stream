package com.leapfin.search.util;

/**
* Allows to get the inputs and log errors and warnings if the inputs are not correct.
*
* @author  Edwin Saucedo
* @version 1.0
* @since   2022-03-02 
*/
public class InputProcessor {
	private static final String INPUT_NOT_FOUND_MESSAGE = "The value for parameter %d was not present, the default value will be taken";
	
	/**
	* Returns the integer value of a parameter, if the value 
	* is not in the correct format it will log an error and will take the default value
	*
	* @param  arg array of parameters
	* @param  index index of the parameter to be obtained
	* @return      a random string
	*/
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
	
	/**
	* Returns the long value of a parameter, if the value 
	* is not in the correct format it will log an error and will take the default value
	*
	* @param  arg array of parameters
	* @param  index index of the parameter to be obtained
	* @return      a random string
	*/
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
	
	/**
	* Returns the string value of a parameter, if the is not present then it will take the default value
	*
	* @param  arg array of parameters
	* @param  index index of the parameter to be obtained
	* @return      a random string
	*/
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
