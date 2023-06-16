package com.goes.WordsCalculateDistance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class WordsCalculateDistanceTest {

	//("blue", "yellow", "red", "brown", "orange", "blue", "red");
	
    @Test
    public void testValidInputs() {
    	
        // Test valid inputs: "orange" and "yellow"
        int distance = WordsCalculateDistance.calculateDistance("orange", "yellow");
        Assertions.assertEquals(3, distance, "The distance between 'orange' and 'yellow' should be 3");

        // Test valid inputs: "blue" and "red"
        distance = WordsCalculateDistance.calculateDistance("blue", "red");
        Assertions.assertEquals(1, distance, "The distance between 'blue' and 'red' should be 1");
    }

    @Test
    public void testNullInput() {
        // Test null input for the first word
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            WordsCalculateDistance.calculateDistance(null, "red");
        }, "Null input for the first word should throw IllegalArgumentException");

        // Test null input for the second word
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            WordsCalculateDistance.calculateDistance("blue", null);
        }, "Null input for the second word should throw IllegalArgumentException");

        // Test null input for both words
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            WordsCalculateDistance.calculateDistance(null, null);
        }, "Null input for both words should throw IllegalArgumentException");
    }

    @Test
    public void testInvalidInputs() {
        // Test invalid input: word not found in the list
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            WordsCalculateDistance.calculateDistance("green", "blue");
        }, "Invalid input: Word 'green' not found in the list should throw IllegalArgumentException");

        // Test invalid input: same word with different case
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            WordsCalculateDistance.calculateDistance("Blue", "blue");
        }, "Invalid input: Same word with different case should throw IllegalArgumentException");
    }

    @Test
    public void testRepeatedWords() {
        // Test repeated words: "blue" and "red" (distance between the first occurrences)
        int distance = WordsCalculateDistance.calculateDistance("blue", "red");
        Assertions.assertEquals(1, distance, "The distance between first 'blue' and first 'red' should be 1");

        // Test repeated words: "blue" and "orange" (distance between the first occurrences)
        distance = WordsCalculateDistance.calculateDistance("blue", "orange");
        Assertions.assertEquals(1, distance, "The distance between first 'blue' and 'orange' should be 2");
    }
}
