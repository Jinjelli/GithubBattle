package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class LanguageList {
	private List<Languages> languages;
	
	public LanguageList() {
		languages = new ArrayList<>();
	}

	public List<Languages> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Languages> languages) {
		this.languages = languages;
	}
	
	
}
