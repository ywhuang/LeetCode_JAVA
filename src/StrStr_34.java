
public class StrStr_34 {

	public static void main(String args[]) {
		
		String t = "abcd1eeeefg";
		String p = "eeee";
		int res = naiveStrStr(t , p);
		System.out.println("result:" + res );
		
		
		
	}
	
	// find the needle in the haystack
	// subString Match
	
	//KMP Algorithms - the use of the failure function
	
	public static int naiveStrStr(String s1, String p1) {
		
		
		char[] s = s1.toCharArray();
		char[] p = p1.toCharArray();  // substring
		
		for (int i = 0 ; i < s.length-p.length-1 ; i++) {
			
			 int j = 0; 
				
				while (s[i+j] == p[j]) {
					
					j++;
					if (j == p.length-1) {
						return i;
					}									
			}									
		}		
		return -1;
		
	}
					
}
