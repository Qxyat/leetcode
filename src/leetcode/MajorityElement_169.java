package leetcode;

public class MajorityElement_169 {
	public int majorityElement(int[] nums) {
        return find(nums, 0, nums.length-1);
    }
	public int find(int[] nums,int left,int right){
		if(left<right){
			int pos =judge(nums,left,right);
			if(pos==nums.length/2){
				return nums[pos];
			}
			else if(pos<nums.length/2){
				return find(nums, pos+1, right);
			}
			else {
				return find(nums, left, pos-1);
			}
		}
		else
		   return nums[left];
	}
	public int judge(int[] nums,int left,int right){
		int judgenum=nums[left];
		while(left<right){
			while(left<right&&nums[right]>judgenum)
				right--;
			if(left<right)
				nums[left++]=nums[right];
			while(left<right&&nums[left]<judgenum)
				left++;
			if(left<right)
				nums[right--]=nums[left];
		}
		nums[left]=judgenum;
		return left;
	}
}
