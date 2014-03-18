
public class ClimbingStairs {
	public int climbStairs(int n) {
	     
        int[] res = new int[n+1];
        
       
        
        for (int i = 0 ; i<= n && i<3 ; i++) {
            res[i] = i;
        }
        
        for (int i = 3; i <=n ; i++) {
            
            
            res[i] = res[i-1] + res[i-2];
        }
     
        return res[n];
    }
}
