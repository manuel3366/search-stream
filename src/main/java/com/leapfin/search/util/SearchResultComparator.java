package com.leapfin.search.util;

import java.util.Comparator;

import com.leapfin.search.domain.SearchResult;

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
