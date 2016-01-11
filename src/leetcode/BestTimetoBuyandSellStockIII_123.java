package leetcode;

public class BestTimetoBuyandSellStockIII_123 {
	public int maxProfit(int[] prices) {
		 if(prices.length<1)
			return 0;
		 int[] pre=new int[prices.length];
		 int[] post=new int[prices.length];
		 int min=prices[0];
		 pre[0]=0;
		 for(int i=1;i<prices.length;i++){
			 pre[i]=Integer.max(pre[i-1], prices[i]-min);
			 min=Integer.min(min, prices[i]);	 
		 }
		 int max=prices[prices.length-1];
		 post[prices.length-1]=0;
		 for(int i=prices.length-2;i>=0;i--){
			 post[i]=Integer.max(post[i+1],max-prices[i]);
			 max=Integer.max(max, prices[i]);	
		 }
		 int res=0;
		 for(int i=0;i<prices.length;i++){
			 res=Integer.max(pre[i]+post[i], res);
		 }
		 return res;
    }
}
