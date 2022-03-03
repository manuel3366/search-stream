package com.leapfin.search;

import java.util.List;

import com.leapfin.search.domain.SearchOptions;
import com.leapfin.search.domain.SearchResult;
import com.leapfin.search.processor.ParentProcessor;
import com.leapfin.search.util.InputProcessor;
import com.leapfin.search.util.SearchResultComparator;
import com.leapfin.search.util.SearchResultPrinter;

import io.reactivex.Flowable;

public class App {
	public static void main(String[] args) {
				
		Integer numberOfProcessors = InputProcessor.getInteger(args, 0);		
		String text = InputProcessor.getString(args, 1);
		Integer stringLength = InputProcessor.getInteger(args, 2); 
		Long timeoutInSeconds = InputProcessor.getLong(args, 3);
		
				
		Flowable<SearchResult> resultListFlowable = new ParentProcessor().registerProcessors(new SearchOptions(stringLength, text, timeoutInSeconds), numberOfProcessors);
		List<SearchResult> resultList = resultListFlowable.sorted(new SearchResultComparator().reversed()).toList().blockingGet();
		SearchResultPrinter.printResults(resultList);
	}
	
	
}
