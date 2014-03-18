import java.util.ArrayList;
import java.util.Arrays;

import java.util.Hashtable;
public class anagram_49 {
	public static void main(String args[]){
		String[] test1 = {"andy", "dyna", "nyda","andys","sand"};
		anagram_49 test = new anagram_49();
		test.anagram(test1);
		// assuming only one kind of anagram (?)
	}
	
	
	public ArrayList<String> anagram(String[] strs) {
		ArrayList<String> res = new ArrayList<String>();
		Hashtable<String, Integer> table = new Hashtable<String, Integer>();
		// assuming only one kind of anagram (?)
		
		for ( int i = 0 ; i < strs.length ; i ++) {
			String sig = signature(strs[i]);
			System.out.println("sig: "+ sig);
			if (table.containsKey(sig)) {
				table.put(sig, table.get(sig)+1);
			} else {
				table.put(sig,1);
			}
		}
		for (int i = 0 ; i < strs.length ; i ++) {
			String sig = signature(strs[i]);
			if (table.get(sig) >1) {
				res.add(strs[i]);
				System.out.print(strs[i]+",");
			}			
		}
		System.out.println();
		
		return res;
	}
	// or use sort to creat the signature
	
	public String signature(String s){
		char[] temp = s.toCharArray();
		Arrays.sort(temp);
		return new String(temp);
		
		
	}
	public String signature2(String s){
		int[] intchars = new int[26];
		for(int i = 0 ; i < s.length(); i++){
			int temp = s.charAt(i) - 'a';
			//System.out.println("tempsig = " + temp);
			intchars[temp]+=1;
		}
		String re = "";
		for (int i = 0 ; i < 26 ; i ++){
			for (int j = 0 ; j<intchars[i];j++){
				re += (char)(i+97);
			}		 
		}
		
		//System.out.println("re:" + re);
		return re;
	}
}
