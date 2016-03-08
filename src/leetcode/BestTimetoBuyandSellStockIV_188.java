package leetcode;

public class BestTimetoBuyandSellStockIV_188 {
	public int maxProfit(int k, int[] prices) {
		if(prices==null||k<1||prices.length<2){
			return 0;
		}
		if(k>=(prices.length>>1))
			return cheat(prices);
		int[][]res=new int[k+1][prices.length];
		for(int i=1;i<=k;i++){
			int tmpMax=-prices[0];
			for(int j=1;j<prices.length;j++){
				res[i][j]=Integer.max(res[i][j-1], tmpMax+prices[j]);
				tmpMax=Integer.max(tmpMax, res[i-1][j-1]-prices[j]);
			}
		}
		return res[k][prices.length-1];
    }
	public int cheat(int[] prices){
		int res=0;
		for(int i=1;i<prices.length;i++){
			if(prices[i]>prices[i-1])
				res+=(prices[i]-prices[i-1]);
		}
		return res;
	}
}
