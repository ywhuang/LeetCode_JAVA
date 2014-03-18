
public class SetMatrixZero_97 {
	
	
	// set the row or the column to all zeros 
	//when there is one elements in that row or column has a zero
	public static void main (String args[] ) {
		
		int[][] matrix = new int[][]{
				  { 1, 1, 2, 2, 2, 2, 2, 2, 2, 2 },
				  { 0, 2, 0, 2, 0, 0, 0, 0, 0, 0 },
				  { 4, 2, 5, 2, 5, 3, 1, 1, 1, 1 },
				  { 0, 2, 0, 2, 0, 0, 2, 0, 0, 0 },
				  { 0, 2, 0, 3, 1, 0, 0, 0, 5, 0 }
				};
		
		int[][] plants = setMatrixZero(matrix,5,10);
		
		// print out 2D array
		for(int i = 0; i < plants.length; i++)
		{
		    for(int j = 0; j < plants[i].length; j++)
		    {
		        System.out.print(plants[i][j]);
		        System.out.print(" ");
		    }
		    System.out.println();
		}
		
	}

	public static int[][] setMatrixZero(int[][] matrix, int m , int n) {
		
		
		
		// use the first row and the second row to store the information
		
		
		boolean row = false; // m   // false = 1
		boolean column = false; // n  // true = 0;
		// check the first column
		for (int i = 0 ; i < m ; i++) {
			if (matrix[i][0] == 0)
					column = true;
		}
		
		// check first row
		for (int j = 0 ; j < n ; j++) {
			if (matrix[0][j] == 0)
					row = true;
		}
		
		//check every element in the matrix
		for ( int i = 1;i < m ; i++ ) {
			for (int j = 1; j< n ; j++) {
				
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
				
		
		// set zero according to the memory / record
		
		for (int i=1; i < m ; i ++) {
			if (matrix[i][0] == 0) {
				// set all row to be zero
				for (int j =1 ; j<n ; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		
		for (int j=1; j < n ; j ++) {
			if (matrix[0][j] == 0) {
				// set all column to be zero
				for (int i =1 ; i<m ; i++) {
					matrix[i][j] = 0;
				}
			}
		}
		
		// reset the first row and the first column
		
		if (row) {
			for (int j =0;j<n;j++)
				matrix[0][j] = 0;
		}
		
		if (column) {
			for (int i =0;i<m;i++)
				matrix[i][0] = 0;
		}
		
		
		
		return matrix;
	}
}
