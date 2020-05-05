package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GHRepository {
	
	private String full_name;
	private String forks_url;
	private String languages_url;
	
	public void setLanguages_url(String languages_url) {
		this.languages_url = languages_url;
	}

	public String getFull_name() {
		return this.full_name;
	}
	
	public String getForks_url() {
		return this.forks_url;
	}

	
	public String getLanguages_url() {
		return languages_url;
	}

	public void setFull_name(String fullName) {
		this.full_name = fullName;
	}
	
	public void setForks_url(String forks) {
		this.forks_url = forks;
	}
	
	
	
	

}
