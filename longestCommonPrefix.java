
 /* 
  * Compares an array of strings to find the greatest common prefix (assumes all
  * lowercase English letters).
  * Algorithm overview:
	 * -> First, find the shortest element (word) of the string array. 
	 * Then, take the first char of that shortest word and put it into a
	 * String, called "PrefixCandidate."  
	 * Continue one character at a time (for each element of the prefixCandidate
	 * , as long as less than the prefixCandidate length). Compare that charAt[i]
	 * to each charAt[i] for ALL members of the array.
	 * If that charAt[i]== testChar  holds true for ALL array members, add that char
	 * to the prefix string (concatenate).  
	 * Stop (break) once the prefix candidate == is false.
	 *
     Code by Jason Lawrence - July 3, 2022
	 */
	





package leetCodeChallenge1;

public class longestCommonPrefix {

	
	
	
public static void main(String[] args) {
	
String[] testArray  = {"Cat", "Call", "Camera"};
longestCommonPrefixFinder(testArray);

}

public static String longestCommonPrefixFinder(String[] strs) {

int shortestWordLength = strs[0].length();
int shortestWordIndex = 0;
boolean charIsMatch = false;
String prefix = "";
char testChar = '\0';

for(int i =1; i < strs.length ; i++) {  //This part is to find shortest word	
	if (strs[i].length() < shortestWordLength) {
		shortestWordLength = strs[i].length();
		shortestWordIndex = i;
	}
}
	
String prefixCandidate = strs[shortestWordIndex]; //this is now the first letter of the shortest string in the array.
// String prefixCandidate = Character.toString(strs[shortestWordIndex].charAt(0));


for(int x = 0; x < prefixCandidate.length(); x++) { //check each letter of PrefixCandidate
 // System.out.println("Now comparing prefixCandidate["+ x + "]");
	for(int y = 0; y < strs.length; y++) { //compare with corresponding letter of each array element.
		 testChar = strs[y].charAt(x);
		
		 if(prefixCandidate.charAt(x) == testChar) {
			 charIsMatch = true;
		 }
		 else {
			 charIsMatch = false;
			 break;
		 }		
	}
	
	if(charIsMatch == true) {
	prefix = prefix + testChar;
	//System.out.println("Finished a pass of the array. testChar is true here.");
	}
	else {
		//System.out.println("Did I get here? 1");
		break;
	
	}
	//System.out.println("Did I get here? 2");
}

//System.out.println("Did I get here? 3");

System.out.println("The longest prefix from the array is: "+ prefix);
return prefix;
}
}
	 
	


	

