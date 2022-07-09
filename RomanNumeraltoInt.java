
//converts a Roman numeral to an int value (Leet Code Challenge solutioN)
package leetCodeChallenge1;

public class RomanNumeraltoInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
			romanToInt("MCM");
       
		
	}

	
	static int romanToInt(String romanNumeralString) {
		
		int sum = 0; 
		
	for(int index = 0; index < romanNumeralString.length(); index++) {
		
		char firstChar = romanNumeralString.charAt(index);
		if(index + 1 == romanNumeralString.length())  //check to see if firstChar is at end of string
		{
			switch (firstChar)
			{
			case 'I': sum += 1; break;
			case 'V': sum +=5; break;
			case 'X': sum += 10; break;
			case 'L': sum += 50; break;
			case 'C': sum += 100; break;
			case 'D': sum += 500; break;
			case 'M': sum += 1000; break;
			}
	
		}	
		else 
		{
			
			char secondChar = romanNumeralString.charAt(index +1);
			if(firstChar == 'I')
			{
				if(secondChar == 'V' || secondChar == 'X')
				 { sum -= 1; }
				else
				{ sum +=1; }
			}
			
			else if(firstChar == 'V')
			{
				sum += 5;
			}
			
			else if(firstChar == 'X')
			{
				if(secondChar == 'L' || secondChar == 'C')
				 { sum -= 10; }
				else
				{ sum +=10; }
			}
			
			else if(firstChar == 'L')
			{
				sum += 50;
			}
			
			else if(firstChar == 'C')
			{
				if(secondChar == 'D' || secondChar == 'M')
				 { sum -= 100; }
				else
				{ sum +=100; }
			}
			else if(firstChar == 'D')
			{
				sum += 500;
			}
			else if(firstChar == 'M')
			{
				sum += 1000;
			}
	
		 /*
       -read one char from string at a time (until reach the end of string) -Firstchar
       -then, read the *next* (following) char from the same string (also if not end of string) -secondChar
       
       if FirstChar is I:
           if secondChar is V OR if second char is X
           assign value of -1 to firstChar (-1 to total)
           else
           assign value of 1 (+1 to total)
           
           
       if first char is V:
           assign value of 5 (+5 to total)
           
           
       if firstChar is X:
            if secondChar is L OR if second char is C
           assign value of -10 to firstChar (-1 to total)
           else
           assign value of 10 (+10 to total)
           
           
        if firstChar is C:
           if secondChar is D OR if secondchar is M
               assign value of -100
               else
               assign value of +100
           
       */
		}
	} 
	System.out.println(sum);
	 return sum; 
	 
	}
	
}
