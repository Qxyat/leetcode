package leetcode;

public class MaximumProductSubarray_152 {
	public int maxProduct(int[] nums) {
        int max_result=Integer.MIN_VALUE;
        int tmp_max_res=0;
        int tmp_min_res=0;
        for(int i=0;i<nums.length;i++){
        	if(tmp_max_res<=0){
        		tmp_max_res=nums[i];
        	}
        	else{
        		tmp_max_res=tmp_max_res*nums[i];
        	}
        	if(tmp_min_res>=0){
        		tmp_min_res=nums[i];
        	}
        	else{
        		tmp_min_res=tmp_min_res*nums[i];
        	}
        	if(tmp_max_res<tmp_min_res){
        		int tmp=tmp_max_res;
        		tmp_max_res=tmp_min_res;
        		tmp_min_res=tmp;
        	}
        	max_result=Integer.max(max_result,tmp_max_res);
        }
        return max_result;
    }
}
