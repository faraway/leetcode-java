package leetcode;
/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
 * (ie, buy one and sell one share of the stock multiple times). 
 * However, you may not engage in multiple transactions at the same time 
 * (ie, you must sell the stock before you buy again).
 * @author patrick
 *
 */
public class BestTimetoBuyandSellStockII {
	public int maxProfit(int[] prices) {
		/**the current on hold price**/
        int min = Integer.MAX_VALUE;
        /**total profit**/
        int total=0;
        
        for(int i=0;i<prices.length;i++){
        	/**
        	 * if the current price is smaller than hold price,
        	 * change it to the smaller one
        	 */
            if(prices[i]<min){
                min=prices[i];
                continue;
            }
            /**
             * if current price is larger than hold one,
             * just sell the hold one, so profit is prices[i]-min
             * and make hold value as current price
             * (if in the next day, we see a smaller value, then change it,
             * 	otherwise, sell it again)
             */
            if(prices[i]>min){
                total+=prices[i]-min;
                min=prices[i];
            }
        }
        return total;
        
    }
}
