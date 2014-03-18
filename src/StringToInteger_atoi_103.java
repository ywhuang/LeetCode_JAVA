
public class StringToInteger_atoi_103 {

	
	
	public static void main(String args[]) {
		
		
		String str = "one two three and four";
		String str2 = "5432 1";
		System.out.println("atoi : " + sti(str));
		
		System.out.println("atoi2 :" + atoi(str2));
	}
	
	public static int sti(String str) {
		
		
		
		String[] str2 = str.trim().split(" "); 
		int res = 0;
		
		
		for (int i = 0 ; i < str2.length ; i ++) {
			System.out.println("processing: " + str2[i]);
			if (isDigit(str2[i]) != -1 ) { // it's a digit
				
				res = res*10 + isDigit(str2[i]);
				System.out.println("res = " + res);
				
			} else { // is a word, not a digit
				
				;
				
			}
			
			
		}
		
		return res;
	}

	private static int isDigit(String string) {
		// TODO Auto-generated method stub
		
		if (string.equals("one"))    // string.equalsIgnoreCase("one")
			return 1;
		else if (string.equals("two"))
			return 2;
		else if (string.equals("three"))
			return 3;
		else if (string.equals("four"))
			return 4;
		else if (string.equals("five"))
			return 5;
		
		return -1;
	}
	
	
	    public static int atoi(String str) {
	        // Start typing your Java solution below
	        // DO NOT write main() function

	        int len = str.length();
	        if (len < 1)
	            return 0;
	        int sign = 1;
	        int index = 0;
	        while (str.charAt(index) == ' ') {
	            index++;
	        }
	        if (str.charAt(index) == '+') {
	            index++;
	        } else if (str.charAt(index) == '-') {
	            sign = -1;
	            index++;
	        }
	        long num = 0;
	        for (; index < len; index++) {
	            if (str.charAt(index) < '0' || str.charAt(index) > '9')
	                break;
	            num = num* 10 + (str.charAt(index) - '0');
	            if (num > Integer.MAX_VALUE && sign == 1)
	                break;
	        }   
	        if (num*sign > Integer.MAX_VALUE)
	            return Integer.MAX_VALUE;
	        if (num*sign < Integer.MIN_VALUE)
	            return Integer.MIN_VALUE;
	        return (int)num*sign;
	    }
	
}
