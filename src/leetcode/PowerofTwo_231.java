package leetcode;

public class PowerofTwo_231 {
	public boolean isPowerOfTwo(int n) {
		int left=0,right=30;
		while(left<right){
			int mid=(left+right)>>1;
			int tmp=1<<mid;
			if(n==tmp)
				return true;
			else if(n>tmp)
				left=mid+1;
			else
				right=mid-1;
		}
		return n==(1<<left);
    }
}
