package com.leapfin.search.processor;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.leapfin.search.domain.SearchOptions;
import com.leapfin.search.domain.SearchResult;
import com.leapfin.search.domain.SearchResult.SearchStatus;
import com.leapfin.search.util.ErrorPrinter;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
* Executes the logic to search the stream for the required text.
*
* @author  Edwin Saucedo
* @version 1.0
* @since   2022-03-02 
*/
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
	
	/**
	* Performs the search according to the search options	*
	* 
	* @return      Single containing the result of the search
	*/
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
	
	/**
	* Count the bytes that are read to find the target, 
	* it's used to summarize the number of bytes
	*
	* @param  data data that will be added to line of the stream
	* @param  content content onf the line of the stream
	* @return      String containing the content of the string
	*/
	private String countBytes(String data, String content) {
		countBytes += content.getBytes().length;
		return content;
	}
	
	/**
	* Returns the result of the search based on the status,
	*
	* @param  SearchStatus status of the search
	* @return      SearchResult the information about the result of the search
	*/
	private SearchResult returnResult(SearchStatus status) {
		Long elapsedTime = System.currentTimeMillis() - startTime;
		if (status.equals(SearchStatus.SUCCESS)) {
			return new SearchResult(countBytes, elapsedTime, status);
		} else {
			return new SearchResult(null, null, status);
		}
		 
	}
	
	/**
	* Process the error which includes returning the search status and printing the log error,
	*
	* @param  Throwable exception that caused the error
	* @return      SearchResult the information about the result of the search
	*/
	private SearchResult processError(Throwable e) {
		ErrorPrinter.printError(e);
		if (e instanceof TimeoutException) {
			return returnResult(SearchStatus.TIMEOUT);
		}
		return returnResult(SearchStatus.FAILURE);
	}
	
	
	
}
