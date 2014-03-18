import java.util.HashMap;


public class TwoSum_113 {
/*
*
Two Sum _113

Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, 
where index1 must be less than index2. 
Please note that your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution.
Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

*
*/
	
// Brute Force
	
 public static void main ( String args[]) {
	 
	 int[] nums = { 1000,1,2,3,4,5,6,7,8};
	 findTwoSum(nums, 7);
	 
	 findTwoSum2(nums, 7);
	 
	 
	 
 }
	
 
 // O( N^2)
 public static void findTwoSum (int[] nums, int sum) {
	 
	 for (int i=0; i< nums.length ; i++) {   // better:   i < nums.length -1
		 
		 for (int j = nums.length-1; j > i ; j --) { // better:   j = i+1 ; j < nums.length ; j++
			 
			 if (i == j) {
				 ;
			 } else if (i > j) {
				 ;				
			 } else if ( nums[i] + nums[j] == sum ) {
				 
				 int index1;
				 int index2;
				 
				 if ( nums[i]<nums[j]) { 
					 index1 = i;
					 index2 = j;
				 } else {
					 
					 index1 = j;
					 index2 = i;					 
				 }
				 
				 System.out.println( " index1-> " + index1 + " value = "+ nums[index1]+"  "+" index2-> " + index2 + " value = "+ nums[index2]);
			 }			 			 			 
		 }		 				 
	 }	 	 
	  System.out.println("");
 }
 
 // A linear method
 // Sum - A[i]  = A[j]
 // use additional memory to store the result
 // O(n)
 
 public static void findTwoSum2 (int[] nums, int sum) {
	 
	 int i;
	 int key;
	 
	 HashMap<Integer, Integer > hashMap = new HashMap(); 
	 
	 for (i=0; i<nums.length; i++ ) {
		 
		 hashMap.put(nums[i], i);
		 
	 } 
	 
	 
	 for (i=0 ; i<nums.length;i++) {
		 
		 key = sum - nums[i];
		 
		 if (hashMap.get(key) != null) {
			 
			 if ( i < hashMap.get(key)) {
				 
				 System.out.println("index1:" + i + "  index2:" + hashMap.get(key));
				 
				 
			 } else if ( i > hashMap.get(key) ) {
				 
				 System.out.println("index1:" + hashMap.get(key)+ "  index2:" + i);
			 }
			 
		 }
		 
		 
	 }
	 
 }
 
 
 
 
 
}
