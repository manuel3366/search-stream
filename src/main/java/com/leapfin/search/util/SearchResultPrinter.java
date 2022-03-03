package com.leapfin.search.util;

import java.util.List;
import java.util.concurrent.TimeoutException;

import com.leapfin.search.domain.SearchResult;
import com.leapfin.search.domain.SearchResult.SearchStatus;

public class SearchResultPrinter {
	public static void printResults(List<SearchResult> resultList) {
		Double averageBytesRead = 0.0;
		int countSuccessResults = 0;
		for (SearchResult searchResult: resultList) {
			if (searchResult.getStatus().equals(SearchStatus.SUCCESS)) {
				averageBytesRead += searchResult.getByteCount() / searchResult.getElapseTime();
				countSuccessResults++;
			}			
			System.out.println(searchResult);
		}
		averageBytesRead = averageBytesRead/countSuccessResults;
		System.out.println("["+averageBytesRead+"]");
	}
	
}
