package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GHUser {
	
	private String login;
	private String public_repos;
	private String repos_url;
	
	public String getRepos_url() {
		return repos_url;
	}

	public void setRepos_url(String repos_url) {
		this.repos_url = repos_url;
	}

	private Long following;
	private Long followers;
	private Object avatar_url;
	
	public GHUser() {
	}
	
	public String getLogin() {
		return this.login;
	}
	
	public String getPublic_repos() {
		return this.public_repos;
	}
	
	public Long getFollowing() {
		return this.following;
	}
	
	public Long getFollowers() {
		return this.followers;
	}
	
	public Object getAvatar_url() {
		return this.avatar_url;
	}
	
	public void setLogin(String name) {
		this.login = name;
	}
	
	
	public void setPublic_repos(String repos) {
		this.public_repos = repos;
	}
	
	public void setFollowing(Long following) {
		this.following = following;
	}
	
	public void setFollowers(Long followers) {
		this.followers = followers;
	} 
	
	public void setAvatar_url(Object avatar_url) {
		this.avatar_url = avatar_url;
	}
	
	@Override
	public String toString() {
		return "User{" + "login=" + login + "repos=" + public_repos + "following=" + following + "followers=" + followers +'\'' + '}';                        
	}
	
	
	
}
