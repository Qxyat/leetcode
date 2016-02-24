package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class LongestIncreasingSubsequence_300 {
	public int lengthOfLIS(int[] nums) {
		if(nums.length==0)
			return 0;
		int[]res =new int[nums.length];
		int[]tmp =new int[nums.length];
		res[0]=1;
		tmp[0]=1;
		for(int i=1;i<nums.length;i++){
			int j=0;
			tmp[i]++;
			while(j<i){
				if(nums[j]<nums[i]){
					tmp[i]=Integer.max(tmp[i], tmp[j]+1);
					Arrays.binary
				}
				j++;
			}
			
			res[i]=Integer.max(res[i-1], tmp[i]);
		}
		return res[nums.length-1];
    }
}
