package com.leapfin.search.util;

import java.util.Iterator;

import com.leapfin.search.domain.SearchOptions;
import com.leapfin.search.service.StreamGenerator;

public class DataStreamer implements Iterable<String> {
	private StreamGenerator streamGenerator;
	private SearchOptions searchOptions;	
	
	
	public DataStreamer(StreamGenerator streamGenerator, SearchOptions searchOptions) {
		this.streamGenerator = streamGenerator;
		this.searchOptions = searchOptions;
	}

	@Override
	public Iterator<String> iterator() {		
		return new DataStreamerIterator(streamGenerator, searchOptions);
	}

}
