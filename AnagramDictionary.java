// Name: Akshay Deepak Hegde
// USC NetID: hegdeaks
// CS 455 PA4
// Fall 2018

import java.util.*;
import java.io.*;


/**
 AnagramDictionary class
 A dictionary of all anagram sets. 
 Note: the processing is case-sensitive; so if the dictionary has all lower
 case words, you will likely want any string you test to have all lower case
 letters too, and likewise if the dictionary words are all upper case.
 
 It stores the file name and the HashMap
 */
public class AnagramDictionary {
   private HashMap<String,ArrayList<String>> anagramDict;
   private File file;
   

   /**
    Create an anagram dictionary from the list of words given in the file
    indicated by fileName.  
    PRE: The strings in the file are unique.
    @param fileName  the name of the file to read from
    @throws FileNotFoundException  if the file is not found
    
    exits if the file not found
    try catch with resources
    */
   public AnagramDictionary(String fileName) throws FileNotFoundException {
      file = new File(fileName);
      try (Scanner in = new Scanner(file)) {
         anagramDict = createDict(in);
      }
      catch (FileNotFoundException exception) {
          System.out.println("File not found: " + exception.getMessage());
          System.exit(0); 
      }
   }
   

   /**
    Get all anagrams of the given string. This method is case-sensitive.
    E.g. "CARE" and "race" would not be recognized as anagrams.
    @param s string to process
    @return a list of the anagrams of s
    
    getAnagramsOf method converts the string into its canonical form
    then that is used as keys for the dictionary hashmap
    If the key exists, it returns the corresponding arraylist
    returns empty arraylist if the doesn't exist
    */
   public ArrayList<String> getAnagramsOf(String s) {
      String rack = sortString(s);
      if (anagramDict.containsKey(rack)){
         return new ArrayList<String>(anagramDict.get(rack));
      }
      return new ArrayList<String>(); 
   }
   
   
   /**
   The createDict method creates the hashmap that contains all possible anagrams.
   Each word is converted to its canonical form of characters and used as key.
   If key doesn't exist, a new arraylist with that word is created.
   Otherwise, corresponding arraylist is called and word is added to it.
   */
   private HashMap<String,ArrayList<String>> createDict(Scanner in){
      
      HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
      String var1;
      String var2;
      
      while(in.hasNext()) {
         var1 = in.next();
         var2 = sortString(var1);
         ArrayList<String> temp = new ArrayList<String>();
         if (!map.containsKey(var2))
         {
            temp.add(var1);
            map.put(var2,temp);
         }
         else 
         {
            temp = map.get(var2);
            temp.add(var1);
            map.put(var2,temp);
         }
      }
      return map;
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
