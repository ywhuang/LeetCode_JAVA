
public class Dividend {

	public static void main(String args[]) {
		
		int dividend = 12023;
		int div = -50;
		System.out.println(divide(dividend,div));
		
		
		
	}
	public static int divide(int dividend, int divisor) {
        boolean negtive = false;
        if (dividend < 0 ) {
            dividend = - dividend;
            negtive = true;
        }
        
        if (divisor < 0 ) {
            divisor = - divisor;
            negtive = true;
        }
        
        if (dividend < 0 && divisor <0)
            negtive = false;
        
        
        if (dividend == 0)
            return 0;
        
        if (dividend < divisor)
            return 0;
        if (dividend == divisor)
            return 1;
        
        if ((dividend - divisor) < divisor)
            return 1;
            
        if (divisor == 1)
            return negtive? (-dividend):dividend ;
        
        
        //int quotient = 0;
        int div2 = divisor;
        int count = 1;
        
        
        while(dividend > div2 + div2) {
            div2 = div2 + div2;
            count = count + count;
        }
            
        while (dividend > div2) {
            div2 = div2+divisor;
            count++;
        }
        
        div2 = div2 - divisor;
        count--;
        if (negtive) 
            return -count;
        else    
            return count;
    }
}
