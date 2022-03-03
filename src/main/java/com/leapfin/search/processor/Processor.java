package com.leapfin.search.processor;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.leapfin.search.domain.SearchOptions;
import com.leapfin.search.domain.SearchResult;
import com.leapfin.search.domain.SearchResult.SearchStatus;
import com.leapfin.search.util.ErrorPrinter;
import com.leapfin.search.util.SearchResultPrinter;

import io.reactivex.Observable;
import io.reactivex.Single;

public class Processor {
	private SearchOptions searchOptions;
	private Observable<String> dataStream;
	private Long countBytes = 0L;
	private Long startTime;
	
	public Processor(SearchOptions searchOptions, Observable<String> dataStream) {
		super();
		this.searchOptions = searchOptions;
		this.dataStream = dataStream;
	}
	
	public Single<SearchResult> searchText() {
		
		return dataStream
				.scan("", this::countBytes)
				.filter(t -> t.contains(searchOptions.getText()))
				.map(t -> returnResult(SearchStatus.SUCCESS))
				.timeout(searchOptions.getTimeoutInSeconds(), TimeUnit.SECONDS)
				.onErrorReturn(this::processError)
				.doOnSubscribe(t -> startTime = System.currentTimeMillis())
				.firstOrError();
				
	}
	
	private String countBytes(String data, String content) {
		countBytes += content.getBytes().length;
		return content;
	}
	
	private SearchResult returnResult(SearchStatus status) {
		Long elapsedTime = System.currentTimeMillis() - startTime;
		if (status.equals(SearchStatus.SUCCESS)) {
			return new SearchResult(countBytes, elapsedTime, status);
		} else {
			return new SearchResult(null, null, status);
		}
		 
	}
	
	private SearchResult processError(Throwable e) {
		ErrorPrinter.printError(e);
		if (e instanceof TimeoutException) {
			return returnResult(SearchStatus.TIMEOUT);
		}
		return returnResult(SearchStatus.FAILURE);
	}
	
	
	
}
