package JIanzhiOffer;

public class P45_228 {
	public int LastRemaining_Solution(int n, int m) {
		if(n<=1)
			return 0;
		int last=0;
		for(int i=2;i<=n;i++){
			int cur=(last+m)%i;
			last=cur;
		}
		return last;
    }
}
