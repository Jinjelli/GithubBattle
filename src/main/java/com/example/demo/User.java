package com.example.demo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	
	private String login;
	private String publicRepos; 
	private Long following;
	private Long followers;
	private Object avatarUrl;
	private List<Repository> repositories; 
	
	public User(GHUser og) {
		this.setLogin(og.getLogin());
		this.setPublicRepos(og.getPublic_repos());
		this.setAvatarUrl(og.getAvatar_url());
		this.setFollowers(og.getFollowers());
		this.setFollowing(og.getFollowing());
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPublicRepos() {
		return publicRepos;
	}

	public void setPublicRepos(String publicRepos) {
		this.publicRepos = publicRepos;
	}

	public Long getFollowing() {
		return following;
	}

	public void setFollowing(Long following) {
		this.following = following;
	}

	public Long getFollowers() {
		return followers;
	}

	public void setFollowers(Long followers) {
		this.followers = followers;
	}

	public Object getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(Object avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public List<Repository> getRepositories() {
		return repositories;
	}

	public void setRepositories(List<Repository> repositories) {
		this.repositories = repositories;
	}
	
	
	
	
}
