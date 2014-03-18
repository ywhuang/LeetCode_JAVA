import java.util.ArrayList;


public class GenerateParenthesis {
	public static void main(String args[]) {
		generateParenthesis(3);
		
		
	}
	
	
	 public static ArrayList<String> generateParenthesis(int n) {
	        
	        
	        ArrayList<String> res = new ArrayList<String>();
	        
	        if (n == 0)
	            return res;
	            
	        int o = n;
	        int c = n;
	        
	        String s = "";
	        int test = 0;
	        combination(o,c,test,s,res);
	        return res;
	    }
	    
	    public static void combination(int o, int c , int test , String s,ArrayList<String> res ) {
	        if (o==0 && c==0) {
	            //if (!res.contains(s))
	        	System.out.println("test="+test+"  "+s);
	            res.add(s);
	            return;
	        }
	        
	        test++;
	        String str = s;
	        if (o == 0) {
	            //str = str+")";
	            //c--;
	            combination(o,c-1,test,str+")",res);
	        }
	        if (o>0) {
	            //str = str+"(";
	           // o--;
	            combination(o-1,c,test,str+"(",res);
	            if (o < c) {
		        	
		           // str = str +")";
		           // c--;
		            combination(o,c-1,test,str+")",res);
		            
		        }
	        }
	        
	        
	    }
}
