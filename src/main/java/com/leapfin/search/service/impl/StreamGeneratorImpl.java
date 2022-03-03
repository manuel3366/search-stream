package com.leapfin.search.service.impl;

import org.apache.commons.lang3.RandomStringUtils;

import com.leapfin.search.service.StreamGenerator;

/**
* StreamGeneratorImpl implements the operations of the StreamGenerator interface, 
* the operations are used to generate a data stream.
*
* @author  Edwin Saucedo
* @version 1.0
* @since   2022-03-02 
*/
public class StreamGeneratorImpl implements StreamGenerator {
	private final boolean RANDOM_USE_LETTERS = true;
	private final boolean RANDOM_USE_NUMBERS = false;
			
	/**
	* Returns a string that is generated randomly
	*
	* @param  stringLength the length random string to be generated
	* @return      a random string
	*/
	@Override
	public String getRandomString(Integer stringLength) {		
		boolean useLetters = RANDOM_USE_LETTERS;
	    boolean useNumbers = RANDOM_USE_NUMBERS;
	    String generatedString = RandomStringUtils.random(stringLength, useLetters, useNumbers);
	    return generatedString;
	}

}
