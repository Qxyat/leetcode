package leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;

public class UglyNumberII_264 {
	public int nthUglyNumber(int n) {
		int[] res=new int[n];
		res[0]=1;
		int pos=1;
		int t2=0;
		int t3=0;
		int t5=0;
		while(pos<n){
			res[pos]=Integer.min(res[t2]*2, Integer.min(res[t3]*3, res[t5]*5));
			if(res[pos]==res[t2]*2)
				t2++;
			if(res[pos]==res[t3]*3)
				t3++;
			if(res[pos]==res[t5]*5)
				t5++;
			pos++;
		}
		return res[n-1];
    }
}
