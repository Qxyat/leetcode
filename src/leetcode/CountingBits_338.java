package leetcode;

public class CountingBits_338 {
	public int[] countBits(int num) {
		if(num<0)
			return new int[0];
		int[] res=new int[num+1];
		res[0]=0;
		int cur=0;
		int nextExcept=1;
		for(int i=1;i<=num;i++){
			if(nextExcept==i){
				res[i]=1;
				cur=nextExcept;
				nextExcept=nextExcept<<1;
			}
			else{
				res[i]=1+res[i-cur];
			}
		}
		return res;
    }
}
