package leetcode;

public class BestTimetoBuyandSellStockwithCooldown_309 {
	public int maxProfit(int[] prices) {
		int buy=0,sell=0,preBuy=Integer.MIN_VALUE,preSell=0;
		for(int price:prices){
			buy=Integer.max(preBuy, preSell-price);
			preSell=sell;
			sell=Integer.max(preSell, preBuy+price);
			preBuy=buy;
			
		}
		return sell;
    }
}
