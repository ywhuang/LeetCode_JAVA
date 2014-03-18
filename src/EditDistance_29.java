
public class EditDistance_29 {

	 public int minDistance(String word1, String word2) {
	        
	        //The array: 2D because 2 states
	        int[][] table = new int[word1.length()+1][word2.length()+1]; // +1 because the condition that there might be zero length word
	        
	     
	        
	        
	        //Initialization:
	        // we can initialize as zeors...  // try initialize as zero later
	        
	         for (int i = 0 ; i <= word1.length();i++ ) { 
	             table[i][0] = i ;      
	         }    
	         for (int j = 0 ; j <= word2.length();j++) {
	              table[0][j] = j;
	          }
	          
	          /***
	           *  for (int i = 0 ; i <= word1.length();i++) {
	           *     for (int j = 0 ; j <= word2.length();j++) {
	           *        table[i][j] = 0;
	           *     }
	           *  }
	           * table[0][1] = 1;
	           * table[1][0] = 1;
	           */ 
	        
	        // 
	        //
	        
	         // we want to find ou table[i][j]
	        // bottome up 
	        for (int i = 1 ; i <= word1.length();i++ ) {  // start from 0 is okay, but start from 1 is more readable
	            for (int j = 1 ; j <= word2.length();j++) {
	                
	            	table[i][j] =  Math.min(table[i-1][j]+1, table[i][j-1]+1);
	                // since min can only compare 2 variables
	                
	                if ( word1.charAt(i-1) == word2.charAt(j-1)) {
	                
	                    table[i][j] = Math.min( table[i][j], table[i-1][j-1]);
	                    //+1 since for a shorter word to become longer word, at least one step needed;
	                    //table[i-1][j], table[i][j-1] means word shift
	                } else  { //word1.charAt(i-1) != word2.charAt(j-1)
	                    table[i][j] = Math.min( table[i][j], table[i-1][j-1]+1);
	                    // relax the solution
	                }
	            }
	        }
	            
	        return table[word1.length()][word2.length()];
	        
	    }

}
