package com.leapfin.search.util;

import java.util.Iterator;

import com.leapfin.search.domain.SearchOptions;
import com.leapfin.search.service.StreamGenerator;

/**
* Generates the iterator element that will return the stream indefinitely.
*
* @author  Edwin Saucedo
* @version 1.0
* @since   2022-03-02 
*/
public class DataStreamerIterator implements Iterator<String>{
	private StreamGenerator streamGenerator;
	private SearchOptions searchOptions;	
	
	public DataStreamerIterator(StreamGenerator streamGenerator, SearchOptions searchOptions) {
		this.streamGenerator = streamGenerator;
		this.searchOptions = searchOptions;
	}

	@Override
	public boolean hasNext() {
		// return true to return always a value
		return true;
	}

	@Override
	public String next() {		
		return streamGenerator.getRandomString(searchOptions.getStringLength());
	}

}
