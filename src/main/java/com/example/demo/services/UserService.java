package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;

import com.example.demo.GHRepository;
import com.example.demo.GHUser;
import com.example.demo.Languages;
import com.example.demo.Repository;
import com.example.demo.User;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class UserService {
	
	private final RestTemplate restTemplate;
		
	public UserService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder
                .basicAuthentication("Jinjelli", "dowlsAJ1224")
                .build();
	}
	
    public User fetchUser(String username) {
		GHUser user = restTemplate.getForObject("https://api.github.com/users/" + username, GHUser.class);
		User result = new User(user);
		result.setRepositories(fetchRepositories(user.getRepos_url()));
		return result;
	}

	public Languages fetchLanguages(String url) {
		JsonNode languages = restTemplate.getForObject(url, JsonNode.class);
		Languages result = new Languages();
		List<String> names = new ArrayList<String>();
		languages.fieldNames().forEachRemaining(names::add);//collecting all the names
		//for(String name: languages.fieldNames()) { (same as ^)
		//	names.add(name);
		//}
		result.setNames(names);
		return result;
	}

	public List<Repository> fetchRepositories(String url) {
		ResponseEntity<List<GHRepository>> repositoryResponse = restTemplate.exchange(
				url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<GHRepository>>() {
				});
		List<GHRepository> repositories = repositoryResponse.getBody();
		List<Repository> result = new ArrayList<>();
		for(GHRepository repo: repositories) {
			Repository r = new Repository(repo);
			
			r.setLanguages(fetchLanguages(repo.getLanguages_url()));
			result.add(r);
		}
		return result;
	}

	public List<User> acceptForm2(String username1, String username2) {
		List<User> users = new ArrayList<>();
		users.add(fetchUser(username1));
		users.add(fetchUser(username2));
		return users;
	}

	public User acceptForm1(String username) {
		return fetchUser(username);

		/*
		 * RestTemplate restTemplate = new RestTemplate(); GHUser user1 =
		 * restTemplate.getForObject("https://api.github.com/users/" + username1,
		 * GHUser.class); ResponseEntity<List<Repository>> repositoryResponse =
		 * restTemplate.exchange("https://api.github.com/users/" + username1 + "/repos",
		 * HttpMethod.GET, null, new ParameterizedTypeReference<List<Repository>>() {
		 * }); List<Repository> repositories = repositoryResponse.getBody();
		 * 
		 * 
		 * LanguageList languageResponse =
		 * restTemplate.getForObject("https://api.github.com/repos/" + username1 +
		 * repositories + "/languages", LanguageList.class); List<Languages> languages =
		 * languageResponse.getLanguages();
		 * 
		 * Repository repoLanguage = new Repository();
		 * repoLanguage.setLanguages_url(languages);
		 * user1.setRepositories(repositories); return user1;
		 */
	}


	

}
