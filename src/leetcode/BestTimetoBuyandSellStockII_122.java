package leetcode;

public class BestTimetoBuyandSellStockII_122 {
	public int maxProfit(int[] prices) {
        if(prices.length<=1)
        	return 0;
        int[] flow=new int[prices.length-1];
        for(int i=1;i<prices.length;i++)
        	flow[i-1]=prices[i]-prices[i-1];
        int res=0;
        for(int i=0;i<flow.length;i++){
        	if(flow[i]>0)
        		res+=flow[i];
        }
        return res;
    }
}
