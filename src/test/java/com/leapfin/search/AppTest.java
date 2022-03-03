package com.leapfin.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.leapfin.search.domain.SearchOptions;
import com.leapfin.search.domain.SearchResult;
import com.leapfin.search.processor.ParentProcessor;
import com.leapfin.search.util.SearchResultComparator;
import com.leapfin.search.util.SearchResultPrinter;

import io.reactivex.Flowable;

public class AppTest {
    
  @Test
  public void runDefaultValues() {
	  
	  Integer numberOfProcessors = 10;		
	  String text = null;
	  Integer stringLength = null; 
	  Long timeoutInSeconds = 2L;


	  Flowable<SearchResult> resultListFlowable = new ParentProcessor().registerProcessors(new SearchOptions(stringLength, text, timeoutInSeconds), numberOfProcessors);
	  List<SearchResult> resultList = resultListFlowable.sorted(new SearchResultComparator().reversed()).toList().blockingGet();
	  SearchResultPrinter.printResults(resultList);
	  assertEquals(numberOfProcessors, resultList.size());

  }
}
