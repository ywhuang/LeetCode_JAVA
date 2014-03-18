import java.util.Arrays;
public class InterleavingString {

	public boolean isInterleave(String s1, String s2, String s3) {
        
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        
        
        int m = s1.length();
        int n = s2.length();
        int l = s3.length();
        
        if (m+n != l)
            return false;
            
        if (m<1 && n<1 && l <1)
            return true;
            
        boolean[][] table = new boolean[m+1][n+1];  // boolean because the return value; DP always remember to get an extra space
        for (int i = 0; i <=m; i++) {
            for (int j = 0 ; j <=n ; j++) {
                table[i][j] = false;
            }
            
        }
        
        
        //first instance
        table[0][0] = true;   //empty input matches empty input
        
        //Initialization
        for (int i = 1 ; i <= m ; i++) {
            if (c1[i-1] == c3[i-1])  // zero-based
                table[i][0] = true; //  non-zero-based
        }
        
        for (int j = 1 ; j <= n ; j++) {
            if (c2[j-1] == c3[j-1])  // zero-based
                table[0][j] = true; //  non-zero-based
        }
        
        for ( int i = 1 ; i<=m ; i++) {
            for (int j = 1; j<= n ; j++) {
                // state function
                // table[i][j]  is from   table[i-1][j]   or  table[i][j-1]
                // table is non zero-based , s1,s2 and s3 are zero-based s[i-1] = s[i-2+1]
                table[i][j] =  (table[i-1][j] && (c1[i-1] == c3[i-1+j])) || (table[i][j-1] && (c2[j-1] == c3[i+j-1]));
                
            }
        }
        
        return table[m][n]; // the result we want: full length
    }

}
