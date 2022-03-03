package com.leapfin.search.util;

import java.util.Comparator;

import com.leapfin.search.domain.SearchResult;

/**
* Permits to order the search results based on the elapsed time.
*
* @author  Edwin Saucedo
* @version 1.0
* @since   2022-03-02 
*/
public class SearchResultComparator implements Comparator<SearchResult> {

	@Override
	public int compare(SearchResult o1, SearchResult o2) {
		if (o1.getElapseTime() == null) {
			return -1;
		} else if (o2.getElapseTime() == null) {
			return 1;
		} else {
			if (o1.getElapseTime() == o2.getElapseTime()) {
				return 0;
			} else if (o1.getElapseTime() > o2.getElapseTime()) {
				return 1;
			} else {
				return -1;
			}
		}
	}

}
