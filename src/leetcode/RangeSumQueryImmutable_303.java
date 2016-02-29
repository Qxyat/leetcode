package leetcode;

import java.util.ArrayList;

public class RangeSumQueryImmutable_303 {
	int[]res;
	public RangeSumQueryImmutable_303(int[] nums) {
        res=nums;
        for(int i=1;i<nums.length;i++)
        		res[i]+=res[i-1];
    }
	public int sumRange(int i, int j) {
		if(i==0)
			return res[j];
		return res[j]-res[i-1];
	}
}
