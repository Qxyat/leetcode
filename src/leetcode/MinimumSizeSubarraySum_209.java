package leetcode;

public class MinimumSizeSubarraySum_209 {
	public int minSubArrayLen(int s, int[] nums) {
		int tmp_res=0;
		int res=Integer.MAX_VALUE;
		int begin=0,end=0;
		boolean find=false;
		while(end<nums.length){
			tmp_res+=nums[end];
			if(tmp_res>=s){
				find=true;
				while(begin<=end){
					if(tmp_res>=s){
						res=Integer.min(res, end-begin+1);
						tmp_res-=nums[begin];
						begin++;
					}
					else {
						break;
					}
				}
			}
			end++;
		}
		if(!find)
			return 0;
		return res;
    }
}
