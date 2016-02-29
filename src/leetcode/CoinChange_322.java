package leetcode;

import java.util.Arrays;

public class CoinChange_322 {
	public int coinChange(int[] coins, int amount) {
		if(amount==0)
			return 0;
		Arrays.sort(coins);
		int[] res=new int[amount+1];
		for(int i=0;i<coins.length;i++){
			if(coins[i]<=amount)
				res[coins[i]]=1;
		}
		for(int i=1;i<=amount;i++){
			boolean find=false;
			int orignialvalue=res[i];
			if(res[i]==0)
				res[i]=Integer.MAX_VALUE;
			for(int j=0;j<coins.length&&coins[j]<i;j++){
				if(res[i-coins[j]]==0)
					continue;
				else{
					find=true;
					res[i]=Integer.min(res[i], 1+res[i-coins[j]]);
				}
			}
			if(!find)
				res[i]=orignialvalue;
		}
		if(res[amount]==0)
			return -1;
		return res[amount];
    }
}
