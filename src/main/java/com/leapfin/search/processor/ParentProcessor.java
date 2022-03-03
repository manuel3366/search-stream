package com.leapfin.search.processor;

import com.leapfin.search.domain.SearchOptions;
import com.leapfin.search.domain.SearchResult;
import com.leapfin.search.service.StreamGenerator;
import com.leapfin.search.service.impl.StreamGeneratorImpl;
import com.leapfin.search.util.DataStreamer;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class ParentProcessor {
	private StreamGenerator streamGenerator = new StreamGeneratorImpl();
	private final Integer DEFAULT_NUMBER_OF_PROCESSORS = 10;
	public Flowable<SearchResult> registerProcessors(SearchOptions searchOptions, Integer numberOfProcessors){
		if (numberOfProcessors == null) {
			numberOfProcessors = DEFAULT_NUMBER_OF_PROCESSORS;
		}
		return Flowable.range(1, numberOfProcessors)
				.flatMap(p -> {
					Observable<String> observable = Observable.fromIterable(new DataStreamer(streamGenerator, searchOptions));
					Processor processor = new Processor(searchOptions, observable);					
					return processor
							.searchText()
							.toFlowable()
							.subscribeOn(Schedulers.newThread());
				});
	}
}
