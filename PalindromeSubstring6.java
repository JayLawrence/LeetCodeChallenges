import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;


public class PalindromeSubstring6 {



	
public static void main(String args[]) {
	
	//System.out.println(isPalindrome2("hannah"));
	System.out.println(longestPalindrome("2243svbsssdfdsghannahzzzzz22nffh804"));
	
	//System.out.println(longestPalindrome("262456246hannah34538964"));

	// System.out.println(longestPalindrome("42356246oggo1424081qy1qy51j0dagasdf8a08yasdg"));
}

public static  String longestPalindrome(String s) {
	
	
/*first we make a HashMap, pass through the whole string once, and assign each unique char a key and put the
 * index of each occurence of that key (char) into an ArrayList[int] for later use.
*/
String palindrome = "" + s.charAt(0);

 Map<Character, ArrayList<Integer>> myMap = new HashMap<Character, ArrayList<Integer>>();

for(int i=0; i< s.length(); i++) {
if(!myMap.containsKey(s.charAt(i))) {
	ArrayList<Integer> newArray = new ArrayList<Integer>();
	newArray.add(i);
	myMap.put(s.charAt(i), newArray);

}
else {
myMap.get(s.charAt(i)).add(i);
}

}


/*now we have to traverse the map, one key at a time, and
 * check between the index values associated with each key to find any palindromes and compare lengths.
*/

for(Character key: myMap.keySet()) {
int endPost = myMap.get(key).size() -1;
if( myMap.get(key).get(endPost) - myMap.get(key).get(0) + 1 > palindrome.length() ) {
	 for(int i = 0; i < myMap.get(key).size(); i++) {
	//System.out.println(myMap.get(key).size());
		//check if IsBoolean for the string between (i i+1)
		if(i+1 < myMap.get(key).size()) {
		//	System.out.println("We're at line 54 now");
			A: for(int j = myMap.get(key).size() -1; j > i; j--) {
			//System.out.println("myMap.get(key).get(j) - myMap.get(key).get(j) +1 is: " + myMap.get(key).get(j)+ " - " +  myMap.get(key).get(j) + "1" );
			if(myMap.get(key).get(j) +1 - myMap.get(key).get(i) > palindrome.length() ) {
				
			String testString = s.substring(myMap.get(key).get(i), myMap.get(key).get(j)+1);
		//	System.out.println("We're at line 57 now, the substring of "+ i + " and " + j +" is " + s.substring(myMap.get(key).get(i), myMap.get(key).get(j)+1));
			
			
			if(testString.length() > palindrome.length()&& isPalindrome2(testString)) {
				palindrome = testString;
				break A;
			}
						
			}
			
		}
	}
	 }
}//put an end quote on this line here in a second!		
}


//System.out.println(myMap);
return palindrome;
}



public static boolean isPalindrome(String str){

 {
	//String newStr = "";
	StringBuilder newStr = new StringBuilder();
    int i = str.length();
    while(i >= 1) {
    	//System.out.println("i here is: " + i);
        //newstr.append(str.charAt(i));
    	newStr.append(str.charAt(i-1)); //+= str.charAt(i -1);
        i--;
    }
 //  System.out.println(newstr);
  //  String newString = newstr.toString();
   if(str.equalsIgnoreCase(newStr.toString())) {
	   return true;  
   }
   else {
	   return false;
   }
}
} 
public static boolean isPalindrome2(String s) {

	int endPost = s.length() -1;
	int startPost = 0;
		while(endPost > startPost) {
			if(s.charAt(startPost) != s.charAt(endPost)) {
				return false;		
			}
			endPost--;
			startPost++;
			}
		return true;
		}

		
	
	
	
}
  

 
