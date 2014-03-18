import java.util.Arrays;


public class ThreeSum_1 {

	// as if 2sum plus another term
	public static void main ( String args[]) {
		
		int[] nums = { 4,3,2,1,5,6,7 };
		threeSum(nums, 15);
		
		
	}
	
	public static void threeSum ( int[] nums, int sum) {
						
		// sort the array first
		Arrays.sort(nums);
		
		for (int i =0; i<nums.length; i++) {
			
			int j = i+1;
			int k = nums.length -1;
			
			
			while (j<k) {
				
				if ( nums[j] + nums [k] == (sum - nums[i]) ) {
					System.out.println ("index1: "+i+" = " + nums[i] + "  index2 :" + j +" = " + nums[j] + "  index3 : " + k +" = " + nums[k]);
					j++;
					k--;
				} else if ( nums[j] + nums [k] < (sum - nums[i]) ) {
					j ++;
				} else {
					k--;
				}
								
			}
									
		}
		
		
		
	}
	
	
	
}
