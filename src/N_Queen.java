import java.util.ArrayList;


public class N_Queen {
	
	

	public static void main(String args[]) {
		System.out.println("<<<<<<<<<<<<<<start>>>>>>>>>>>>>>");
		N_Queen test = new N_Queen();
		test.solveNQueens(8);
	
	}
	public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> res = new ArrayList<String[]>();
        if (n == 0) {
            String[] s = {};
            res.add(s);
            return res;
        }
        if (n==1) {
            String[] s = {"Q"};
            res.add(s);
            return res;
        }
        
        char[] board = new char[n*n];
        
        for (int i = 0 ; i < board.length ; i++) {
            board[i] = 'o';
        }
        
        placeQ(board,0,n,res);
    
        return res;
    }
    
    
    public void placeQ(char[] board, int n_q, int n, ArrayList<String[]> res) {
        
        
        if (n_q == n) {
            cleanB(board);
            System.out.println("Success:==================!!!!!!!!!!!!!!!!!!!!!!!!!!");
            printB(board,n);
            String[] r = toStrArray(board,n);
            res.add(r);
            try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return;
        }
        if( boardFull(board)) {
            return;
        }
        
        for (int i = 0 ; i < board.length ; i ++) {
        	System.out.println("i="+i);
        	printB(board,n);
        	
            if (board[i]=='o') {
                //char[] temp = board.clone();
                //board[i] = 'Q';
                char[] changedB = changeB2(board, i, n);
                placeQ(changedB, n_q+1, n , res);
                //changeB(changedB, i, n);
                //placeQ(board, n_q+1, n , res);
                //board = temp;
                
            }
        }
        
        
    }
    private char[] changeB2(char[] board2, int i, int n) {
    	
    	char[] board = board2.clone();
        int c = i % n; // 14 % 8 = 6
        int r = i / n; // 14 / 8 = 1
        // i = r * n + c
        
        for (int j = n*r; j< n*(r+1) ; j++) {
            board[j] = '.';
        }
        for (int j = 0 ; (j*n + c) < board.length ; j++) {board[j*n + c] = '.';}
        
        
        
        for (int j = r, k = c; j < n && k < n && (j*n+k < n*n); j++, k++) {        	
        		board[j*n+k] = '.';        	
        }
        for (int j = r, k = c; j < n && k > 0 && (j*n+k < n*n); j++, k--) {        	
    		board[j*n+k] = '.';        	
        }
        for (int j = r, k = c; j >= 0 && k >= 0 && (j*n+k >= 0); j--, k--) {        	
    		board[j*n+k] = '.';        	
        }
        for (int j = r, k = c; j >= 0 && k < n && (j*n+k >= 0); j--, k++) {        	
    		board[j*n+k] = '.';        	
        }
        
      
        //for (int j = 0; (i + j*(n+1) )< board.length; j++) {board[i + j*(n+1)] ='.';}
        
        //for (int j = 0; (i + j*(n-1) )< board.length; j++) {board[i + j*(n-1)] ='.';}
        
        //for (int j = 0; (i - j*(n+1) )>=0; j++) {board[i - j*(n+1)] ='.';}
        //for (int j = 0; (i - j*(n-1) )>=0; j++) {board[i - j*(n-1)] ='.';}
        
        board[i] = 'Q';
        System.out.println("after changed  i="+i);
        
        printB(board,n);
        //System.out.println("after changed i="+i);
		return board;
	}
	public void changeB(char[] board, int i, int n) {
        
        int c = i % n; // 14 % 8 = 6
        int r = i / n; // 14 / 8 = 1
        // i = r * n + c
        
        for (int j = n*r; j< n*(r+1) ; j++) {
            board[j] = '.';
        }
        for (int j = 0 ; (j*n + c) < board.length ; j++) {
           board[j*n + c] = '.';
        }
        
        for (int j = 0; (i + j*(n+1) )< board.length; j++) {
            board[i + j*(n+1)] ='.';
        }
        for (int j = 0; (i + j*(n-1) )< board.length; j++) {
            board[i + j*(n-1)] ='.';
        } 
        for (int j = 0; (i - j*(n+1) )>=0; j++) {
            board[i - j*(n+1)] ='.';
        }
        for (int j = 0; (i - j*(n-1) )>=0; j++) {
            board[i - j*(n-1)] ='.';
        }
        
        board[i] = 'Q';
        System.out.println("after changed  i="+i);
        
        printB(board,n);
        System.out.println("after changed i="+i);
    }
    public void cleanB (char[] board) {
        for (int i = 0 ; i < board.length ; i++) {
            if (board[i]=='o')
                board[i] = '.';
        }
    }
    public boolean boardFull (char[] board) {
        
        for (int i = 0 ; i < board.length ; i++) {
            if (board[i]=='o')
                return false;
        }
        return true;
    }
    public String[] toStrArray(char[] board,int n) {
        String[] r = new String[n];
        
        //copy array
        for (int i = 0 ; i < n ; i++) {
            char[] temp = new char[n];
            for (int j = 0; j < n ; j ++) {
                temp[j] = board[i*n+j];
            }
            r[i] = new String(temp);
        }
        
        return r;
    }
    
    public void printB(char[] board,int n) {
    	System.out.println("=================");
    	for (int i = 0 ; i < n ; i ++) {
    		for ( int j = 0 ; j < n ; j++) {
    			System.out.print(board[i*n+j]+" ");
    		}
    		System.out.println();
    	}
    	System.out.println("=================");
    }
}
