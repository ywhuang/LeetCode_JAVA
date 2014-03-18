public class ReverseInteger_84 {
    public int reverse(int x) {
        
        int res = 0;
        boolean neg = false;
        if (x<0) {
           x = -x;
           neg = true;
        }
        
         while (x>0) {
             
             int y = x % 10;
             res = res*10 + y;
             
             x = x/10;
         }
        
        if (neg)
            return -res;
        else
            return res;
        
    }
}
