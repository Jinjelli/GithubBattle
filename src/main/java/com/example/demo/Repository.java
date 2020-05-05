package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository {
	
	private String fullName;
	private String forksUrl;
	private Languages languages;
	
	public Repository(GHRepository og) {
		this.setForksUrl(og.getForks_url());
		this.setFullName(og.getFull_name());
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getForksUrl() {
		return forksUrl;
	}
	public void setForksUrl(String forksUrl) {
		this.forksUrl = forksUrl;
	}
	public Languages getLanguages() {
		return languages;
	}
	public void setLanguages(Languages languages) {
		this.languages = languages;
	}
	
	
	
	
	
	
	

}
