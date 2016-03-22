package leetcodeReview;

public class BestTimetoBuyandSellStockIV_188 {
	public int maxProfit(int k, int[] prices) {
		if(prices.length<=1)
			return 0;
		if(k>(prices.length>>1))
			return cheat(prices);
		int[][] res=new int[k+1][prices.length];
		
		for(int i=1;i<=k;i++){
			int lastBuy=-prices[0];
			for(int j=1;j<prices.length;j++){
				res[i][j]=Integer.max(res[i][j-1], lastBuy+prices[j]);
				lastBuy=Integer.max(res[i-1][j-1]-prices[j], lastBuy);
			}
		}
		return res[k][prices.length-1];
    }
	public int cheat(int[] prices){
		int res=0;
		for(int i=0;i<prices.length-1;i++){
			if(prices[i+1]>prices[i]){
				res+=prices[i+1]-prices[i];
			}
		}
		return res;
	}
}
