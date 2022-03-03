package com.leapfin.search.domain;

/**
* SearchOptions contains the options to be used during the search.
*
* @author  Edwin Saucedo
* @version 1.0
* @since   2022-03-02 
*/
public class SearchOptions {
	
	private Integer stringLength;
	private String text;
	private Long timeoutInSeconds;
	
	private final Long DEFAULT_TIMEOUT_IN_SECONDS = 60L;
	private final Integer DEFAULT_STRING_LENGHT = 200;
	private final String DEFAULT_TEXT_VALUE = "Lpfn";
			
	public SearchOptions(Integer stringLength, String text, Long timeoutInSeconds) {
		this.stringLength = stringLength;
		this.text = text;
		this.timeoutInSeconds = timeoutInSeconds;
	}
	public Integer getStringLength() {
		if (stringLength == null) {
			return DEFAULT_STRING_LENGHT;
		}
		return stringLength;
	}
	public void setStringLength(Integer stringLength) {
		this.stringLength = stringLength;
	}
	public String getText() {
		if (text == null) {
			return DEFAULT_TEXT_VALUE;
		}
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Long getTimeoutInSeconds() {
		if (timeoutInSeconds == null) {
			return DEFAULT_TIMEOUT_IN_SECONDS;
		}
		return timeoutInSeconds;
	}
	public void setTimeoutInSeconds(Long timeoutInSeconds) {
		this.timeoutInSeconds = timeoutInSeconds;
	}
	
	
	
	
}
