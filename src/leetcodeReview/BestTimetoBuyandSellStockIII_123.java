package leetcodeReview;

public class BestTimetoBuyandSellStockIII_123 {
	public int maxProfit(int[] prices) {
		if(prices.length<=1)
			return 0;
		int[] pre=new int[prices.length];
		int[] post=new int[prices.length];
		
		int minValue=prices[0];
		pre[0]=0;
		for(int i=1;i<prices.length;i++){
			pre[i]=Integer.max(prices[i]-minValue,pre[i-1]);
			minValue=Integer.min(minValue, prices[i]);
		}
		int maxValue=prices[prices.length-1];
		post[prices.length-1]=0;
		for(int i=prices.length-2;i>=0;i--){
			post[i]=Integer.max(maxValue-prices[i], post[i+1]);
			maxValue=Integer.max(maxValue, prices[i]);
		}
		int res=Integer.MIN_VALUE;
		for(int i=0;i<prices.length;i++){
			res=Integer.max(pre[i]+post[i], res);
		}
		return res;
    }
}
