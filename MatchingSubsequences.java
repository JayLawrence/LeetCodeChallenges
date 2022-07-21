 /* Number of Matching Subsequences (LeetCode challenge 792: Solution by Jason Lawrence - July 20 2022
Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".

Constraints:

1 <= s.length <= 5 * 104
1 <= words.length <= 5000
1 <= words[i].length <= 50
s and words[i] consist of only lowercase English letters.


Algorithm overview:
test each word of the array one at a time, increment count if it is a substring of the String s.
		
		  * To test if a given string words[i] is a substring of s:
		  * --start with the first char of words[i]: words[i].charAt(0)
		  * --iterate from words[i].charAt(0) to words[i].charAt(words[i].length() - UNLESS test fails, then break and iterate to next
		  *check to see (left-> right) one char at atime, if the 1st char of words[i] is in the String s
		  *if Yes, proceed (if no, not a substring - break)
		  *Look at the 2nd char of words[i]. picking up at the index where you left off in s,
		  *repeat the same check you just did: continue moving left to right to see if you can find 
		  *a matching char.
		  *If yes, proceed. (if no, not  a substring - break).
		  *Proceed until EITHER:
		  *-> test fails (break) OR
		  *-> reach the end of words[i] without failing (true)
		  *note: if you are not yet at the end of words[i] and you reach the end of 
		  *String s, test also fails (since you wont' have found a match for that char
		  *in words[i]
		  *
		  *
		  */




package finalSrcCodesEclipseFolder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MatchingSubsequences {

	
	public static void main(String args[]) {
		String s = "yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyj";
		String[] words = {"yj","yj","yj","yj","yj","yj","yj","yj","yj","yj","yj","yj","yj","yj","yj","yj","yj","yj","yj"};
		System.out.println(numMatchingSubseq(s, words));
		
		 
	}
	
	
	
	
	 public static int numMatchingSubseq(String s, String[] words) {
	       int numSubseqWords = 0; // will track the # of strings that are matches        
	      /*  HashSet<Character> sSet = new HashSet<Character>();  //making a HashSet of the String s... might shortcut later
	       for(int i = 0; i < stringLength i++) {
	    	   sSet.add(s.charAt(i));	    	
	       } */
	       HashSet<String> notSubsequencesList = new HashSet<String>();   //making a list to track disqualifed words so we don't have to test them later
	       List<String> subsequencesList = new ArrayList<String>();  //making a list to track qualified words so we don't have to test them later
	       
	   	
	       int stringLength = s.length();
	       for(int i = 0; i < words.length; i ++) {         //first easy disqualifier: if word[i] is longer than the String s.
			 
	    	   if(words[i].length() >= stringLength) {
	    		   notSubsequencesList.add(words[i]); 
	    	   }
	    	   else if(subsequencesList.contains(words[i])){   //second easy disqualifier: if we've already identifed another word that is a subsequence, don't need to check again
	    		   numSubseqWords++;	
	    	   }
	    	   else if(notSubsequencesList.contains(words[i])){  //third easy disqualifier: if we've already identifed another word that is a subsequence, don't need to check again
	    		     //do nothing
	    	   }
	    	   else {	   	    		
		    		   {
						int sIndexTracker = 0;
						 boolean hasMatchingCharSoFar = false;
						 for(int k = 0; k < words[i].length(); k++) { //for each letter of each String word in the array
							  hasMatchingCharSoFar = false;
							 char testChar = words[i].charAt(k);  //look at 1 char of the word in the array at a time
							 // p is the	index of the String s we are comparing to.									
							 	
							 	while(sIndexTracker < stringLength) {
							 		if(testChar == s.charAt(sIndexTracker) ) {
							 			hasMatchingCharSoFar = true;
							 			sIndexTracker++; //pick up at the next index of s
							 			break; //leave 'while' loop and increment k;	
							 		}
							 		else {
							 			sIndexTracker++;
							 		}
							 		
							 	}
							 		
							 }
							 if(hasMatchingCharSoFar == true) {   // if hasMatchingChar is true after exiting the loop, the word is a substring. increment by 1
								 numSubseqWords++;
								 subsequencesList.add(words[i]); //be sure to add this to the list of known matching strings, so we don't have to check duplicates in words[]
								 
							 }
							 else {
								 notSubsequencesList.add(words[i]); //be sure to add this to the list of known NONmatching strings, so we don't have to check duplicates in words[]
								 //System.out.print("disqualified words: "); System.out.println(notSubsequencesList);
							 }
							 
						 }
		    	   
	    		   }
		    		 
			 }
		 
		 return numSubseqWords;
		 }
		
	 }





