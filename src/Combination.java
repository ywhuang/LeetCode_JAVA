import java.util.ArrayList;


public class Combination {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        
        
        
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>(); // universal access
        
        if ( n< 1 || k <1 || k > n )
            return res;
            
        
        
        
        for (int i = 1 ; i<=n ; i ++) {
            ArrayList<Integer> r = new ArrayList<Integer>(); // local variables
            dfs(i, res, r , n, k );
        }
        return res;
    }
    
    public void dfs(int current, ArrayList<ArrayList<Integer>> res , ArrayList<Integer> r, int n, int k) {
       
        // boundary condition
        if (current > n)
            return;
            
        r.add(current);
        k--;
        
        //success condition
        if ( k == 0) {
            res.add(r);
            return;
        }
        
        for (int i = current+1 ; i <= n ; i++ ) {
            ArrayList<Integer> r2 = new ArrayList<Integer>(r); // or clone
            dfs(i, res, r2, n, k);
        }
        
        
    }
}
