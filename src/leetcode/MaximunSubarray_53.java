package leetcode;

public class MaximunSubarray_53 {
	public int maxSubArray(int[] nums) {
        int sum=0,result=Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++){
        	if(sum<0){
        		sum=nums[i];
        	}
        	else{
        		sum+=nums[i];
        	}
        	result=Integer.max(sum, result);
        }
        
        return result;
    }
}
