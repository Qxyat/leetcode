package leetcode;

public class FindMinimuminRotatedSortedArrayII_154 {
	public int findMin(int[] nums) {
		   int left=0;
	       int right=nums.length-1;
	       while(left<right){
	    	   int mid=(left+right)>>1;
		       if(nums[left]<nums[mid]&&nums[mid]<nums[right]){
	    		   return nums[left];
	    	   }
	    	   else if(nums[left]>nums[mid]&&nums[mid]>nums[right]){
	    		   return nums[right];
	    	   }
	    	   else if(nums[mid]>nums[right]){
	       		   left=mid+1;
	       	   }
	       	   else if(nums[mid]<nums[right]){
	       		   right=mid;
	       	   }
	       	   else
	       	       right--;
	       }
	       return nums[left];
	    }
}
