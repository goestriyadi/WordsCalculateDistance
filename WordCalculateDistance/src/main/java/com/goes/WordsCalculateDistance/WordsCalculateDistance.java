package com.goes.WordsCalculateDistance;

import java.util.Arrays;
import java.util.List;

public class WordsCalculateDistance {
	 private static final List<String> WORDS = Arrays.asList("blue", "yellow", "red", "brown", "orange", "blue", "red");

	    /**
	     * Calculates the shortest distance between two words in the WORDS list, ignoring case sensitivity.
	     * If the words can repeat in the array, the result is the shortest distance between them.
	     *
	     * @param word1 the first word
	     * @param word2 the second word
	     * @return the shortest distance between the two words
	     * @throws IllegalArgumentException if the input words are null, not found in the list, or same word with different case
	     */
	    public static int calculateDistance(String word1, String word2) {
	        if (word1 == null || word2 == null) {
	            throw new IllegalArgumentException("Invalid input: Words cannot be null");
	        }


	        if (!WORDS.contains(word1) || !WORDS.contains(word2)) {
	            throw new IllegalArgumentException("Invalid input: Words not found in the list");
	        }

	        if (word1.equalsIgnoreCase(word2)) {
	            throw new IllegalArgumentException("Invalid input: Same word with different case");
	        }

	        int distance = Integer.MAX_VALUE;
	        int prevIndex = -1;

	        //("blue", "yellow", "red", "brown", "orange", "blue", "red");
	        for (int i = 0; i < WORDS.size(); i++) {
	            if (WORDS.get(i).equalsIgnoreCase(word1) || WORDS.get(i).equalsIgnoreCase(word2)) {
	                if (prevIndex != -1 && !WORDS.get(prevIndex).equalsIgnoreCase(WORDS.get(i))) {
	                    distance = Math.min(distance, Math.abs(prevIndex - i));
	                }
	                prevIndex = i;
	            }
	        }
	        return distance;
	    }

}
