package leetcode;
/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

   If you were only permitted to complete at most one transaction 
   (ie, buy one and sell one share of the stock), 
   design an algorithm to find the maximum profit.
 * @author patrick
 *
 */
public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
        int max = 0;
        int minPrice=Integer.MAX_VALUE;
        /**
         * just update the min value, if there's a larger profit, 
         * the sell value must show later.
         */
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minPrice){
                minPrice=prices[i];
                continue;
            }
            if(prices[i]-minPrice>max){
                max=prices[i]-minPrice;
            }
        }
        return max;
    }
}
