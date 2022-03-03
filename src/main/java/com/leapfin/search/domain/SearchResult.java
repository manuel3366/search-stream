package com.leapfin.search.domain;

/**
* SearchResult class contains the information about the result of a search.
*
* @author  Edwin Saucedo
* @version 1.0
* @since   2022-03-02 
*/
public class SearchResult {
	
	private Long byteCount;
	private Long elapseTime;
	private SearchStatus status;
	
	public SearchResult(Long byteCount, Long elapseTime, SearchStatus status) {
		this.byteCount = byteCount;
		this.elapseTime = elapseTime;
		this.status = status;
		
	}
	
	public enum SearchStatus{
		SUCCESS, TIMEOUT, FAILURE;
	}

	public Long getByteCount() {
		return byteCount;
	}

	public void setByteCount(Long byteCount) {
		this.byteCount = byteCount;
	}

	public Long getElapseTime() {
		return elapseTime;
	}

	public void setElapseTime(Long elapseTime) {
		this.elapseTime = elapseTime;
	}

	public SearchStatus getStatus() {
		return status;
	}

	public void setStatus(SearchStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		if (this.status.equals(SearchStatus.SUCCESS)) {
			return "[" + elapseTime + "] [" + byteCount + "] [" + status + "]";
		}
		return "[] [] [" + this.status.name() + "]";
	}
	
	
	
}
