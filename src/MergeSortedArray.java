import java.util.Arrays;


public class MergeSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = {1,3,5,7,0,0,0,0};
		int[] B = {2,4,6,8};
		merge(A,4,B,4);
		
		for (int x:A) {
			System.out.print(x+",");
		}
		
		int[] A2 = {0};
		int[] B2 = {1};
		merge(A2,0,B2,1);
		
		
		System.out.println();
		for (int i = 0; i < A2.length; i++) {
			System.out.print(A2[i]+",");
		}

	}
	public static void merge(int[] A, int m, int[] B, int n) {
		if (m < 1 ) {
	           for (int i = 0 ; i < n ; i++) {
	                A[i] = B[i];
	           }
		
	            return;
	        }
	        
	        if (n<1 ) {
	            return;
	        }
        int i = m -1;
        int j = n -1;
        
        if ( n == 0) 
            return;
        
            
        
        while (i>=0 && j >=0) {
            
            if (A[i]>= B[j]) {
                A[i+j+1] = A[i];
                i--;
            } else {
                A[i+j+1]  = B[j];
                j--;
            }
            
            
            
        }
        
        while (j>-0) {
            A[j] = B[j];
            j--;
        }
    }
}
