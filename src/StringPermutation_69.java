import java.util.ArrayList;


public class StringPermutation_69 {

	public static void main (String args[]) {
		
		char[] c = {'1','2','3','4'};
		//ArrayList<char[]>  result = new ArrayList<char[]>();
		ArrayList<char[]> res = permutation(c);;
		int j = 0;
		for (;j<res.size();j++) {
			char[] c1 = res.get(j);
 			System.out.println();
			for (int i = 0 ; i<c1.length ;i++) {
				System.out.print(c1[i]+",");
				
			}
			
		}
		
		
		
		
	}
	
	public static ArrayList<char[]> permutation(char[] c) {
		ArrayList<char[]>  result = new ArrayList<char[]>();
		permutation(c, 0, (c.length-1) , result);
		return result;
	}
	
	public static  void permutation(char[] c, int start, int end, ArrayList<char[]> result) {
		
		if (start == end) {
			
			for (char x: c) {
				System.out.print(x +",");
			}
			result.add(c);
			
			
			System.out.println("-- result size:" + result.size());
			//System.out.println("-- check " + result.get(0)[0]);
		} else {
		for (int i = start ; i <= end ; i++) {
			
			// fixed the first one(with various possibility
			// swap first
			char temp = c[start];
			c[start] = c[i];
			c[i] = temp;
			//System.out.println(" " + c[i]);
			//permute the rest
			permutation(c, start+1, end, result);
			
			//swap back -> becuz there's a next iteration
			temp = c[start];
			c[start] = c[i];
			c[i] = temp;
		}
		}
		//return result;
	}
}
