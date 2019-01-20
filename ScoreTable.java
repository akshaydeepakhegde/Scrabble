// Name: Akshay Deepak Hegde
// USC NetID: hegdeaks
// CS 455 PA4
// FALL 2018

import java.util.*;

/**
 ScoreTable class
 The class which stores the score of each character using a treemap.
 The scores are mapped with the ScoreTable constructor.
 So the class returns the score of a given string
 */

public class ScoreTable {

	private final Map<Character, Integer> charcter;

	/**
	 ScoreTable constructor to map each character to its value
     consider both lower case and upper case letters
     Also, 'a' and 'A' will have same score.
	 */
	public ScoreTable() {
		charcter = new TreeMap<Character, Integer>();
		charcter.put('a', 1);
		charcter.put('b', 3);
		charcter.put('c', 3);
		charcter.put('d', 2);
		charcter.put('e', 1);
		charcter.put('f', 4);
		charcter.put('g', 2);
		charcter.put('h', 4);
		charcter.put('i', 1);
		charcter.put('j', 8);
		charcter.put('k', 5);
		charcter.put('l', 1);
		charcter.put('m', 3);
		charcter.put('n', 1);
		charcter.put('o', 1);
		charcter.put('p', 3);
		charcter.put('q', 10);
		charcter.put('r', 1);
		charcter.put('s', 1);
		charcter.put('t', 1);
		charcter.put('u', 1);
		charcter.put('v', 4);
		charcter.put('w', 4);
		charcter.put('x', 8);
		charcter.put('y', 4);
		charcter.put('z', 10);
       
        charcter.put('A', 1);
		charcter.put('B', 3);
		charcter.put('C', 3);
		charcter.put('D', 2);
		charcter.put('E', 1);
		charcter.put('F', 4);
		charcter.put('G', 2);
		charcter.put('H', 4);
		charcter.put('I', 1);
		charcter.put('J', 8);
		charcter.put('K', 5);
		charcter.put('L', 1);
		charcter.put('M', 3);
		charcter.put('N', 1);
		charcter.put('O', 1);
		charcter.put('P', 3);
		charcter.put('Q', 10);
		charcter.put('R', 1);
		charcter.put('S', 1);
		charcter.put('T', 1);
		charcter.put('U', 1);
		charcter.put('V', 4);
		charcter.put('W', 4);
		charcter.put('X', 8);
		charcter.put('Y', 4);
		charcter.put('Z', 10);
	}

	/**
	 calculateScore method computes the score of the given string
	 using the values of each character stored in the map
	 */
	public int calculateScore(String word) {
		int value = 0;
		for (int i = 0; i < word.length(); i++) {
			value = value + charcter.get(word.charAt(i));
		}
		return value;
	}
}