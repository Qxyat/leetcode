package leetcode;

public class PerfectSquares_279 {
	public int numSquares(int n) {
		int[]res =new int[n+1];
		res[0]=0;
		for(int i=1;i<=n;i++){
			
			int min=Integer.MAX_VALUE;
			for(int j=1;j*j<=i;j++){
				min=Integer.min(min,1+res[i-j*j]);
			}
			res[i]=min;
		}
		return res[n];
    }
	
}
