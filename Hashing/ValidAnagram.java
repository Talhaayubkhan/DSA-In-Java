package Hashing; // Declares that this class is part of the "Hashing" package

import java.util.*; // Imports all utility classes from java.util, allowing usage of HashMap, among others

public class ValidAnagram { // Public class definition for ValidAnagram

      // Method to determine if two strings are anagrams
      public static boolean isValidAnagram(String s, String t) {

            // If the lengths of the strings are not the same, they can't be anagrams
            if (s.length() != t.length()) {
                  return false; // Return false immediately if lengths differ
            }

            // Create a HashMap to count character occurrences in string 's'
            HashMap<Character, Integer> map = new HashMap<>(); // A map to store characters as keys and their counts as
                                                               // values

            // Populate the HashMap with character counts from string 's'
            for (int i = 0; i < s.length(); i++) { // Loop through each character in 's'
                  char ch = s.charAt(i); // Get the 'i-th' character from 's'
                  // Increment the count of 'ch' in the map, or start from 1 if it's the first
                  // occurrence
                  map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            // Adjust the HashMap based on characters in string 't'
            for (int i = 0; i < t.length(); i++) { // Loop through each character in 't'
                  char ch = t.charAt(i); // Get the 'i-th' character from 't'

                  // Check if 'ch' exists in the map
                  if (map.get(ch) != null) { // If the character is in the map
                        if (map.get(ch) == 1) { // If its count is 1
                              map.remove(ch); // Remove 'ch' from the map, indicating it's balanced
                        } else { // If the count is greater than 1
                              map.put(ch, map.get(ch) - 1); // Decrement the count by 1
                        }
                  } else { // If 'ch' is not in the map
                        return false; // If any character from 't' isn't in the map, they're not anagrams
                  }
            }

            // If the map is empty, it means all counts were balanced, indicating an anagram
            return map.isEmpty(); // Return true if the map is empty, otherwise false
      }

      public static void main(String[] args) { // The entry point for the program execution
            String s = "heart"; // Define a test string 's'
            String t = "earth"; // Define a test string 't'

            // Call isValidAnagram with 's' and 't' to check if they are anagrams
            System.out.println(isValidAnagram(s, t)); // Print the result to the console (true or false)
      }
}
