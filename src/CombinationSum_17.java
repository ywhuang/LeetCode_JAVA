import java.util.ArrayList;
import java.util.Collections;

public class CombinationSum_17 {
	
	public static void main (String args[]) {
		CombinationSum_17 test = new CombinationSum_17();
		ArrayList<ArrayList<Integer>> testres = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> candidates = new ArrayList<Integer>();
		candidates.add(1);
		candidates.add(3);
		candidates.add(5);
		testres = test.combinationSum(candidates,10);
		
		for (int i = 0 ; i < testres.size() ; i++) {
			if (testres.get(i).isEmpty()) {
				System.out.println("empty");
			} else {
				System.out.println("sub size"+testres.get(i).size());
			}
			for (int j = 0 ; j < testres.get(i).size() ; j++) {
				
				
				System.out.print(testres.get(i).get(j)+" ");
			}
			System.out.println("testres size = " + testres.size());
		}
	}
	
	public ArrayList<ArrayList<Integer>> combinationSum (ArrayList<Integer> candidates, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (candidates.size() == 0)
			return res;
		Collections.sort(candidates);
		ArrayList<Integer> r = new ArrayList<Integer>();
		dfs(candidates,target,res, r , 0);
		return res;
		
		
	}
	
	// DFS - exhuasted search
	void dfs( ArrayList<Integer> candidates, int target, 
				ArrayList<ArrayList<Integer>> res, ArrayList<Integer> r, int i) {
		
		if (target < 0) { //STOP condition
			
			
			return;
		} else {
			if (target == 0) { // achieve the result
				ArrayList<Integer> r2 = new ArrayList<Integer>(r);
				//if(!res.contains(r2))
					res.add(r2);
				for (int j= 0 ; j < res.size() ; j++) {
					System.out.print(res.get(j)+" ");					
				}
				System.out.println();
				// why not add return here?
			} else {
				
				while ( i < candidates.size() && target - candidates.get(i) >= 0) {
					r.add(candidates.get(i));
					for (int j = i ; j > 0 ; j--){
						System.out.print(" ");
					}
					System.out.println(" DFS - target = "+ target + " candidates add: " + candidates.get(i) +" i = "+ i);
					dfs(candidates, target - candidates.get(i), res, r ,i);
					i++;// note this has to be after dfs, in order to consider the duplicate elements
					r.remove(r.size()-1); // undo the change for recurrsion calculation 
				}
				
			}
				
		}
		
	}
	
	
}
