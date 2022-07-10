/*move one char at a time along the string. if an "open" symbol, add to an open stack (or queue?)
 * as soon as you get to a "closed" symbol, compare it with the top of your open stack (this is the last open symbol added)
 * if it's a match, validity holds true for now and proceed.
 * if there is not a match - or if the open stack runs empty while trying to make comparions with the closed symbol, then validity false
 * if you reach the end of the string without hitting a "false" condition, the string is valid = true;
 * 
 */




package leetCodeChallenge1;

import java.util.Stack;

public class ValidParentheses2 {

	
public static void main(String[] args) {

System.out.println(isValid("[]{}()(({{[[]]}}))"));

	
}

public static boolean isValid(String s) {
	
Stack<Character> openSymbolStack = new Stack<Character>();   

for(int i = 0; i < s.length(); i++) {
char char1 = s.charAt(i);


if(char1 == '(' || char1 == '[' || char1 == '{') {    //if the char is an open symbol, add it to the stack
openSymbolStack.push(char1);
}
else {        //if the char is a closed symbol, pop the stack to check for a match.
	if(openSymbolStack.isEmpty()) {
		return false;
	}
	else {
	char char2 = openSymbolStack.pop();


if(!isMatch(char2, char1)) {
	return false;
}



}
}

}
if(openSymbolStack.isEmpty())
return true;

else
	return false;	
}


public static boolean isMatch(char char1, char char2) {
	//System.out.println("again char 1 is: " + char1);
	//System.out.println("again char 2 is " + char2);
	
	switch (char1) {
	case '(': {
		if(char2 == ')') {
			
			return true;
		}
		else
			return false;
	}
	case '[': {
		if(char2 == ']') {
			return true;
		}
		else
			return false;
	}
	case '{': {
		if(char2 == '}') {
			return true;
		}
		else
			return false;
	}
	}
	System.out.println("Are we getting to line 76?");
	return false; //needed for syntax, but task parameters for this problem ensure only one of these characters will be provided.
	
}


}



