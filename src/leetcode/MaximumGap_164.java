package leetcode;

import java.util.Arrays;

public class MaximumGap_164 {
	public int maximumGap(int[] nums) {
		if(nums==null||nums.length<2)
			return 0;
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		for(int num:nums){
			min=Integer.min(min, num);
			max=Integer.max(max, num);
		}
		int gap=(int)Math.ceil((((double)max-min))/(nums.length-1));
		
		int[] bucketMin=new int[nums.length-1];
		int[] bucketMax=new int[nums.length-1];
		Arrays.fill(bucketMin, Integer.MAX_VALUE);
		Arrays.fill(bucketMax, Integer.MIN_VALUE);
		
		for(int num:nums){
			if(num==min||num==max)
				continue;
			int index=(num-min)/gap;
			bucketMin[index]=Integer.min(bucketMin[index], num);
			bucketMax[index]=Integer.max(bucketMax[index], num);
		}
		
		int previous=min;
		int res=0;
		for(int i=0;i<nums.length-1;i++){
			if(bucketMin[i]==Integer.MAX_VALUE&&bucketMax[i]==Integer.MIN_VALUE)
				continue;
			res=Integer.max(bucketMin[i]-previous, res);
			previous=bucketMax[i];
		}
		res=Integer.max(max-previous, res);
		return res;
    }
}
