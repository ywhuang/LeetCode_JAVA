import java.util.ArrayList;
import java.util.Arrays;


public class CombinationSum_17_solution {
	public static void main (String args[]) {
		CombinationSum_17_solution test = new CombinationSum_17_solution();
		ArrayList<ArrayList<Integer>> testres = new ArrayList<ArrayList<Integer>>();
		int[] candidates = {1,3,5};
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
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> li = new ArrayList<Integer>();
        getlist(candidates,target,li,re,0);
        
        return re;
        
    } 
    
    public void getlist(int[] candidates, int target, ArrayList<Integer> li,ArrayList<ArrayList<Integer>> reli,int start){
        if(target == 0){
            ArrayList<Integer> t = new ArrayList<Integer>(li); // use new!!!!!
            if(!reli.contains(t))
                reli.add(t);
            return;
        }
        
        for(int i=start; i<candidates.length; i++){
            if(target-candidates[i]>=0){
                li.add(candidates[i]);
                getlist(candidates,target-candidates[i],li,reli,i);
                li.remove(li.size()-1);                
            }
        }
    }
}
