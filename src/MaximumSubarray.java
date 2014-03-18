
public class MaximumSubarray {

	
	public int maxSubArray(int[] A) {
        // DP
        // Be greedy - > every step is helpful and constructive to the future step
        int sum = 0 ;
        int max = Integer.MIN_VALUE;
        
    
        for ( int i = 0 ; i < A.length ; i++) {
            if (sum > 0 )
                sum = sum + A[i];
            else
                sum = A[i];
                
            if (max < sum)
                max = sum;
        }
        
        return max;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
