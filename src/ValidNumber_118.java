import java.io.BufferedInputStream;
import java.util.Scanner;


public class ValidNumber_118 {

	// checking if an input is a "number
	// .5   1.5  -1.5
	// 2e+5
	// 3e-5
	//-3e+5
	// +1
	// -7/3
	// 1/5
	
	//False:
	// +/ -
	// - e
	// 1/0   denominator cannot be zero
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(new BufferedInputStream(System.in));
		String input = scanner.next();
		System.out.println("Reading input as :" + input);
		System.out.println("Validating...");
		System.out.println("result:" + validNumber(input));
	}
	
	
	public static boolean validNumber ( String input) {
		
		// trim for spaces
		input = input.trim();
		char[] inChar = input.toCharArray(); 
		
		// check from the first character
		  // general check if there is at least one digit v
		  // the last character must be a digit v
		 // specific rules
				//e	//if it's a scientic representation
				    //   e can be anywhere but can only show once v
					//   e can only go before a sign or a number
					//   e can only go after a number v
				
				//dot  // dot can start at the beginning
					// can only have one dot
					// must be followed by a digit
				
				//division // division can go before a zero
					// can only have one divion
					// must be btw the two digits
				
				//sign // can only be in the first character or after 'e'
		boolean atLeastOneDigit =false;
		boolean e = false;
		boolean dot = false;
		// check the first character
		if (!Character.isDigit(inChar[0])) {
			if (inChar[0]=='+' || inChar[0] == '-' || inChar[0] =='.') {
				
			}else {
				return false;
			}
		}
		
		// general check if there is at least one digit
		for (int i=0;i<inChar.length;i++) {
			if (Character.isDigit(inChar[i])) {
				System.out.println(inChar[i]);
				atLeastOneDigit = true;
			}			
					
		}
		
		
		  
		
		
		
		// specific rules
		//e	//if it's a scientic representation
		    //   e can be anywhere but can only show once
			//   e can only go before a sign or a number
			//   e can only go after a number
		
		for (int i=0;i<inChar.length;i++) {
						
			if (inChar[i] == 'e') {
				System.out.println("Detected:" +inChar[i]);
				if (e) 
					return false; // cannot exist two es
				if (i>=1){ 
					if (!Character.isDigit(inChar[i-1]))
					return false;
				}	
				if (i+1 < inChar.length) {
					if (!Character.isDigit(inChar[i+1]) && inChar[i+1] !='+' && inChar[i+1]!='-')
						return false;
				}
				e = true;
				
				
			}			
		}
		
		//dot  // dot can start at the beginning
			// can only have one dot
			// must be followed by a digit
		for (int i=0;i<inChar.length;i++) {
			
			if (inChar[i] == '.') {
				System.out.println("Detected:" +inChar[i]);
				if (dot) 
					return false; // cannot exist two dots
				if (i>=1){
					if (!Character.isDigit(inChar[i-1]) )
						return false;
				}
				if (i+1 < inChar.length) {
					if (!Character.isDigit(inChar[i+1]) )
						return false;
				}
				dot = true;								
			}			
		}
		
		//division // division can go before a zero
			// can only have one divion
			// must be btw the two digits
		
		//sign // can only be in the first character or after 'e'
			   
		
		
		  // check the last character, must be a digit
				if (atLeastOneDigit == false) {
					return false;
				} else {
					System.out.println("atLeastOneDigit:" + atLeastOneDigit);
				}
				if (!Character.isDigit(inChar[inChar.length-1])) {
					System.out.println("last character is not a digit");
					return false;
				} else {
				 return true;	
				}
		
	}
	
	
	
	
}
