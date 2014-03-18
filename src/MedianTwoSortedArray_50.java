
public class MedianTwoSortedArray_50 {
	public static void main(String args[]){
		int[] a = {1,3,5,7};
		int[] b = {2,4,6,8,100,120,140};
		
		System.out.println(findMedian(a,b));
		
		
	}
	
	
	
	
	public static int findMedian(int[] a, int[] b){
		
		int k = (a.length+b.length)/2;
		if ( k % 2 == 1) {
			return findk(a,b,k+1);
		} else {
			return ( findk(a,b,k)+findk(a,b,k+1) ) /2 ;
		}
		
	
	}

	private static int findk(int[] a, int[] b, int k) {

		int i = 0 ;
		int j = 0 ;
		int last = 0;
		
		while ( i+1 + j+1 < k) {
			
			
			if (a[i] < b[j]) {
				i++;
				last = a[i];
			}
		
			if (a[i] > b[j])
				j++;
				last = b[j];
			}
		
		return last;
	}
}
