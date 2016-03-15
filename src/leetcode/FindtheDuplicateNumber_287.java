package leetcode;

public class FindtheDuplicateNumber_287 {
	public int findDuplicate(int[] nums) {
		if(nums==null||nums.length<2)
			return 0;
        int fast=nums[nums[0]];
        int slow=nums[0];
        while(fast!=slow){
        		slow=nums[slow];
        		fast=nums[nums[fast]];
        }
        fast=0;
        while(slow!=fast){
        		slow=nums[slow];
        		fast=nums[fast];
        }
        return slow;
    }
}
