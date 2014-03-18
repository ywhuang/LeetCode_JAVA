
public class MedianTwoSortedArray_50_Sol {
	
	public static void main(String args[]){
		int[] a = {1,3,5,7};
		int[] b = {20,40,60,80,100,120,140};
		
		System.out.println(findMedianSortedArrays(a,b));
		
		
	}
	
	public static double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
	 
		if ((m + n) % 2 != 0) // odd
			return (double) findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1);
		else { // even
			return (findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1) 
				+ findKth(A, B, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
		}
	}
	
	public static int findKth(int A[], int B[], int k, 
			int aStart, int aEnd, int bStart, int bEnd) {
			System.out.println("k = " + k);
			int aLen = aEnd - aStart + 1;
			int bLen = bEnd - bStart + 1;
		 
			// Handle special cases
			if (aLen == 0)
				return B[bStart + k];
			if (bLen == 0)
				return A[aStart + k];
			if (k == 0)
				return A[aStart] < B[bStart] ? A[aStart] : B[bStart];
		 
			int aMid = aLen * k / (aLen + bLen); // a's middle count
			int bMid = k - aMid - 1; // b's middle count
		 
			// make aMid and bMid to be array index
			aMid = aMid + aStart;
			bMid = bMid + bStart;
		 
			if (A[aMid] > B[bMid]) {
				System.out.println("A[mid] = " +A[aMid] + " B[bMid] = " +  B[bMid]);
				k = k - (bMid - bStart + 1);
				aEnd = aMid;
				bStart = bMid + 1;
				System.out.println("new k = " + k );
				
				System.out.println(" aStart = "+aStart);
				System.out.println("new aEnd = "+aEnd);
				System.out.println("new bStart = "+bStart);
				System.out.println(" bEnd = "+bEnd);
			} else {
				System.out.println("A[mid] = " +A[aMid] + " B[bMid] = " +  B[bMid]);
				k = k - (aMid - aStart + 1);
				bEnd = bMid;
				aStart = aMid + 1;
				System.out.println("new k = " + k );
				
				System.out.println("new aStart = "+aStart);
				System.out.println(" aEnd = "+aEnd);
				System.out.println(" bStart = "+bStart);
				System.out.println("new bEnd = "+bEnd);
			}
		 
			return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
		}
}
