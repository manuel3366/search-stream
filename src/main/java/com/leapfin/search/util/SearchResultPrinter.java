package com.leapfin.search.util;

import java.util.List;
import java.util.concurrent.TimeoutException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leapfin.search.domain.SearchResult;
import com.leapfin.search.domain.SearchResult.SearchStatus;

public class SearchResultPrinter {
	
	private static Logger logger = LogManager.getLogger(SearchResultPrinter.class);
	
	public static void printResults(List<SearchResult> resultList) {
		Double averageBytesRead = 0.0;
		int countSuccessResults = 0;
		for (SearchResult searchResult: resultList) {
			if (searchResult.getStatus().equals(SearchStatus.SUCCESS)) {
				averageBytesRead += searchResult.getByteCount() / searchResult.getElapseTime();
				countSuccessResults++;
			}			
			logger.info(searchResult);
		}
		averageBytesRead = averageBytesRead/countSuccessResults;
		logger.info("[{}]", averageBytesRead);
	}
	
}
