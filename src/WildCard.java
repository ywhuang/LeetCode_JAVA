
public class WildCard {
	public boolean isMatch(String s, String p) {
	     
	     
        char[] s1 = s.toCharArray();
        char[] p1 = s.toCharArray();
        
        int i = 0 ; 
        int j = 0 ;
        
        int starIndex = -1;
        boolean star = false;
        
        while ( i < s1.length && j < p1.length){
            if (s1[i] == p1[j]) {
                i++;
                j++;
                star = false;
                continue;
            }
                
            if ( p1[j] == '?') {
                i++;
                j++;
                continue;
            }
            
            if (p1[j] == '*') {
                star = true;
                starIndex = i;
                
                j++;
                
            }
            
            if (s1[i] != p1[j]) {
                if (star) {
                     i++;
                     continue;
                } 
            }
            return false;
        } // end while
        
        if ( i < s1.length && starIndex < 0)
            return false;
        
        if (i == s1.length)
            return true;
		
        while (p1[j] == '*' && j < p1.length) {
        	j++;
    	}
		
		if (j == p1.length)
			return true;
		else 
			return false;
	}
}
