
public class POW_74 {

	public static void main (String args[]) {
		
		
		System.out.println("2^1024 = " + pow(2,10));
		System.out.println("2^1024 = " + powBU(2,10));
		
	}
	
	public static int pow(int x, int n ) {
		System.out.println("k");
		// k for testing the number of the recurrence 
		if ( n == 0 )
			return 1;
		
		if ( n == 1) 
			return x;
		if ( n ==2 )
			return x * x;
		
		int remain = n % 2;
				
		return pow(x,  n/2) * pow(x, n/2 ) * pow (x, remain );						
	}	
	
	public static double powBU(int x , int n){
		
		boolean signPositive = true;
		
		if ( n == 1)
			return x;
		if ( x == 0)
			return 0;
		if ( n < 0) {
			signPositive = false;
			n = - n;
		}
			
		double res = 1;
		double np = x; 
		System.out.println("n = " + n);
		while ( n > 1) {   // how do you know in advance, it's n>0, not n>1
			
			
			
			if ((n % 2) == 1)
				res = res * np;					
			System.out.println("res = " + res);
			
			np = np * np ;
			System.out.println("np = " + np);
			
			n = n/2;
			System.out.println("n = " + n);
		}
		
		res = res * np;
		
		return signPositive? res:(1/res);
	}
}

// Bottom up

