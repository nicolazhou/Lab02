package it.polito.tdp.alien.model;

import java.util.*;

public class Translate {

	Map<String, List<String>> dictionary;
	
	
	public Translate() {
		this.dictionary = new HashMap<String, List<String>>();
	}
	
	public void addWord(String alienWord, String word) {
		
		if(! this.dictionary.containsKey(alienWord)) { // Se non contiene la parola aliena
			this.dictionary.put(alienWord, new ArrayList<String>());
		}
		
		this.dictionary.get(alienWord).add(word);
	}
	
	public String stampaTraduzione(String alienWord) {
		
		if(this.dictionary.containsKey(alienWord)) {
			String s = "";
			
			for(String tr : this.dictionary.get(alienWord)) {
				
				s += tr + "\n";
				
			}
			
			return s;
		}
		return null;
	}
	
	
}
