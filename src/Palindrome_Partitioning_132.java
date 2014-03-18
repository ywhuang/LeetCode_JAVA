import java.util.ArrayList;


public class Palindrome_Partitioning_132 {
	 public static void main(String args[]) {
		 
		 
		 
		 partition("acca");
	 }
	
	 public static  ArrayList<ArrayList<String>> partition(String s) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        ArrayList<ArrayList<String>> list=new ArrayList<ArrayList<String>>();
	        int length=s.length();
	        if(length==0) return list; 
	        part(s, 0, new ArrayList<String>(), list);
	        return list; 
	    }
	    
	    static void part(String s, int start, ArrayList<String> subList, ArrayList<ArrayList<String>> list)
	    {
	        if(start==s.length()) 
	        {
	            list.add(new ArrayList<String> (subList) ); return ;
	        }
	        for(int i=start+1; i<=s.length(); i++)
	        {   
	        	System.out.println("checking: " + "palindrome("+s + ", "+start+"," + (i-1)+")"  );
	            if(palindrome(s, start, i-1))
	            {
	                subList.add(s.substring(start, i));
	                part(s, i , subList, list);
	                System.out.println("Executing: part("+s+","+ i+ ", subList, list)");
	                subList.remove(subList.size()-1);
	            }
	        }
	    }
	    
	    static boolean palindrome(String s, int i, int j)
	    {
	        while(i<j)
	        {
	            if(s.charAt(i)!=s.charAt(j)) return false; 
	            i++; 
	            j--; 
	        }
	        return true; 
	    }
}
