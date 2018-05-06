package forFuture;

/**
 * Taken from leetcode: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * 
 *
 */
public class BestTimeToBuySell {
	
	public static void main(String[] args) {
		int[] input = {7,1,5,3,6,4};
		//should be 5;
		System.out.println("Biggest increase in value: " + maxProfit(input));
	}
	
	public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, diff = 0;
        for (int price : prices) {
            if (price < min) min = price;
            if (price - min > diff) diff = price - min;
        }
        return diff;
    }
}
