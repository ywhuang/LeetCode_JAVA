
public class SearchRange_93 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] searchForARange(int[] array, int target) {
		
		int[] res = {-1,-1};
		boolean left = true;
		boolean right = false;
		res[0] = findtarget(array,target,0,array.length-1, left);
		res[1] = findtarget(array,target,0,array.length-1, right);
		
		
		return res;
	}
	
	
	public int findtarget(int[] array, int target, int start, int end,
			boolean left){
		
		// boundary condition : should be determined by the variables that would change
		//                  when running the recursion
		
		if (start > end) 
			return -1;
		
		int k = (start + end)/2;
		if (array[k] == target) {						
			
			if ( left ) {
				if (k == 0 || array[k-1]!=target) // boundary condition
					return k;
				else
					return findtarget(array, target, start, k-1,left);
			}
			else { // right
				if (k== array.length-1 || array[k+1] != target ) // boundaryy condition
					return k;
				else
					return findtarget(array,target, k+1, end,left);
				
				
			}
		}
		
		else if (array[k] < target) 
			return findtarget(array, target, k+1,end, left);
		else //(array[k] > target)
			return findtarget(array, target, start, k-1, left);
		
		
	}
	

}
