import java.util.ArrayList;
public class RestoreIPAddress {
	
	   public static void main(String args[]) {
		   String test = "010010";
		   restoreIpAddresses(test);
	   }

	   public static ArrayList<String> restoreIpAddresses(String s) {
	        
	        //char[] c = s.toCharArray();
	        ArrayList<String> res = new ArrayList<String>();
	        if (s.length() == 0 )
	            return res;
	        
	        for (int i = 1 ; i <= 3 && i< s.length() ; i ++) {
	            //if (i > s.length -1)
	                //break;
	            for (int j = i+1 ; j <= i+3 &&  j< s.length() ; j++ ){
	                //if (j > s.length -1)
	                    //break;
	                for (int k = j+1; k <= j+3 && k< s.length() ; k++) {
	                    //if (k > s.length -1)
	                        //break;
	                    
	                    	 System.out.print(i+";"+j+";"+k);
	                         System.out.println();
	                        String[] seg = new String [4];
	                        
	                        seg[0] = s.substring(0,i);
	                        System.out.print(seg[0]+".");
	                        seg[1] = s.substring(i,j);
	                        System.out.print(seg[1]+".");
	                        seg[2] = s.substring(j,k);
	                        System.out.print(seg[2]+".");
	                        seg[3] = s.substring(k,s.length());
	                        System.out.print(seg[3]+".");
	                        System.out.println();
	                        for (int m = 0 ; m < 4 ; m++){
	                            if ( !valid(seg[m],m) )
	                                break;
	                            if ( m == 3)
	                                res.add(seg[0]+"."+seg[1]+"."+seg[2]+"."+seg[3]);
	                        
	                        
	                    }
	                }
	            }
	        }
	        
	        return res;
	        
	    }
	    
	    public static boolean valid (String sub, int m) {
	        
	        if (sub.length() == 0)
	        	return false;
	        
	        if (sub.length() > 3)
	            return false;
	        int x =Integer.parseInt(sub);
	        
	        if (x > 255 )
	            return false;
	      
	        if (sub.length() >1 && sub.charAt(0) == '0')
	            return false;
	        //if (sub.length() == 1 && x == 0 && m != 0)
	        //    return false;
	            
	        return true;    
	    }
}
