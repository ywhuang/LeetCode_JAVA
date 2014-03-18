import java.util.ArrayList;


public class ValidPalindrome_126 {
	
	
	/*
	Valid Palindrome
	Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
	For example,
	"A man, a plan, a canal: Panama" is a palindrome.
	"race a car" is not a palindrome.
	*/
	public static void main (String args[]) {
		
		String test = "acadaca";
		System.out.println("acadaca ? " + validPalindrome(test));
		String test2 = " Aca! da@ ca";
		System.out.println("Aca! da@ ca ? " + validPalindrome(test2));
		String test3 = "***klim milk !!!";
		System.out.println(test3 +" ? " + validPalindrome(test3));
	}
	
	public static boolean validPalindrome( String s) {
		
		
		ArrayList<Character> l = new ArrayList<Character>();
		for ( int i = 0 ; i < s.length() ; i ++) {
			
			if ( Character.isLetterOrDigit(s.charAt(i))) {
				l.add(Character.toLowerCase(s.charAt(i)));
			}
			
		}
		
		int startIndex = 0;
		int endIndex = l.size()-1;
		
		while (startIndex < endIndex) {
			
			if ( l.get(startIndex).equals(l.get(endIndex))) {
				startIndex++;
				endIndex--;
			}
				
			else 
				return false;							
		}
		
		return true;
	}

}
