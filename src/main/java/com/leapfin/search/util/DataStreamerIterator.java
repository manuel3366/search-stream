package com.leapfin.search.util;

import java.util.Iterator;

import com.leapfin.search.domain.SearchOptions;
import com.leapfin.search.service.StreamGenerator;

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
