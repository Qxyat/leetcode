package leetcode;

public class KthLargestElementinanArray_215 {
	public int findKthLargest(int[] nums, int k) {
        return find(nums,0,nums.length-1,k-1);
    }
	public int find(int[] nums,int left,int right,int k){
		if(left<right){
			int pos=getPos(nums,left,right);
			if(pos==k){
				return nums[pos];
			}
			else if(pos>k){
				return find(nums, left, pos-1, k);
			}
			else{
				
				return find(nums, pos+1, right, k);
			}
		}
		return nums[left];
	}
	public int getPos(int[]nums,int left,int right){
		int judge=nums[left];
		while(left<right){
			while(left<right&&nums[right]<judge)
				right--;
			if(left<right)
				nums[left++]=nums[right];
			while(left<right&&nums[left]>judge)
				left++;
			if(left<right)
				nums[right--]=nums[left];
		}
		nums[left]=judge;
		return left;
	}
}
