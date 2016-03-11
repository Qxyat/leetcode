package leetcodeReview;

public class FirstMissingPositive_41 {
	public int firstMissingPositive(int[] nums) {
		int i=0;
		while(i<nums.length){
			if(nums[i]!=i+1&&nums[i]>=1&&nums[i]<=nums.length&&nums[nums[i]-1]!=nums[i]){
				int tmp=nums[nums[i]-1];
				nums[nums[i]-1]=nums[i];
				nums[i]=tmp;
			}
			else{
				i++;
			}
		}
		for(i=0;i<nums.length;i++){
			if(i+1!=nums[i])
				return i+1;
		}
		return nums.length+1;
    }
}
