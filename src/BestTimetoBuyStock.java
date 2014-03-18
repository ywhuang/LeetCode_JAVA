
public class BestTimetoBuyStock {
	public int maxProfit(int[] prices) {
        //int min
		 if (prices.length<2)
	            return 0;
        
        int[] mins = new int[prices.length];
        int res = 0;//Integer.MIN_VALUE;
        mins[0] = prices[0];
        for (int i = 1 ; i < prices.length ; i++) {
            if (prices[i] < mins[i-1])
                mins[i] = prices[i];
            else
                mins[i] = mins[i-1];
        }
        
        for (int i =1 ; i < prices.length ; i ++) {
            if (res < prices[i] - mins[i-1])
                res = prices[i] - mins[i-1];
        }
        return res;
    }
}
