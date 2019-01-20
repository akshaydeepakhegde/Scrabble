// Name: Akshay Deepak Hegde
// USC NetID: hegdeaks
// CS 455 PA4
// FALL 2018

/**
WordFinder Class
The class which contains main method
The class is responsible for processing the command-line argument, and handling any error processing.
This is the place where everything is kind of put together for our application.
It asks user for the rack finding all possible words with their respective scores continuosly till user quits. 

To run it from the command line
java WordFinder [dictionaryFile]

*/

import java.util.*;
import java.io.FileNotFoundException;

public class WordFinder {

   private AnagramDictionary anagramDict;
   private ScoreTable scoresTable;
   private static String fileName = "sowpods.txt";
   /**
   Main method for the Scrabble WordFinder game.
   It creates a wordFinder object called scrabble
   Associates it with working AnagramDictionary and scoreTable objects
   Takes care of dictionary passed as argument and Scanner from System.in
   Tells user to type . to quit the game 
   */
   public static void main(String[] args) throws FileNotFoundException {
      WordFinder scrabble = new WordFinder();
      if (args.length > 0) {
         fileName = args[0];
      }
      
      try {
      scrabble.anagramDict = new AnagramDictionary(fileName);
      }
      catch (FileNotFoundException e) {
    	  System.out.println("File does NOT exist!");
    	  System.exit(0);
      }
      scrabble.scoresTable = new ScoreTable();
      System.out.println("Type . to quit.");
      Scanner in = new Scanner(System.in);
      scrabble.execute(in);

   }
   
   /**
   This method asks the user for the rack and run continuously untill user decides to stop with "."
   After creating the rack it returns all the subset of the rack and finds all possible anagrams
   Then sortScore method is called from which a treemap is created which sorts the words by decreasing score.
   Finally it outputs all the possible words with the scores.
   */
   private void execute(Scanner in){
      System.out.print("Rack? ");
      String str = in.nextLine();
      if (str.equals(".")){
         System.exit(0);
      }

      Rack rack = new Rack(str);
      ArrayList<String> allSubsets = rack.findAllSubsets();
      ArrayList<String> allWords = new ArrayList<String>();
      
      for (int i = 0; i<allSubsets.size(); i++){
         allWords.addAll(anagramDict.getAnagramsOf(allSubsets.get(i)));
      }
      
      TreeMap<Integer,ArrayList<String>> scores = this.sortScores(allWords);

      System.out.println("We can make " + allWords.size() +" words from \"" + (str) + "\"");
      if (allWords.size()>0) {
         System.out.println("All of the words with their scores (sorted by score):");
      }

      for (Map.Entry<Integer, ArrayList<String>> curr : scores.entrySet()) {
         int temp3 = (curr.getValue()).size();
         for (int i = 0; i<temp3; i++) {
               System.out.println(curr.getKey() + ": " + (curr.getValue()).get(i));
         }
      }
      execute(in);
   }

   /**
   The sortscores method creates a treemap with arraylist of all possible words from the dictionary
   as values with the Integers as keys.
   Treemap is then sorted in the decreasing order.
   Each word is considered and score is checked and used as a key.
   If the key doesn't exist, new arraylist with that word is created
   otherwise the word is added to the current arraylist and sorted alphabetically. 
   We have used Collections.reverseOrder() method here.
   */
   private TreeMap<Integer,ArrayList<String>> sortScores(ArrayList<String> allWords) {
      TreeMap<Integer,ArrayList<String>> scores = new TreeMap<Integer,ArrayList<String>>(Collections.reverseOrder());
      for (int i = 0; i<allWords.size(); i++)
      {
         int var1 = scoresTable.calculateScore(allWords.get(i));
         if (!scores.containsKey(var1)) 
         {
            ArrayList<String> var2 = new ArrayList<String>();
            var2.add(allWords.get(i));
            scores.put(var1, var2);
         }
         else 
         {
            ArrayList<String> var2 = scores.get(var1);
            var2.add(allWords.get(i));
            Collections.sort(var2);
            scores.put(var1,var2);
         }
      }
      return scores;
   }
   
   /**
   The method to sort a string
   Uses Arrays.sort() fumction.
   Returns a string sorted in alphabetical order. 
   */
   private String sortString(String s) {
      char charArray[] = s.toCharArray();
      Arrays.sort(charArray);
      return new String(charArray);
   }
}