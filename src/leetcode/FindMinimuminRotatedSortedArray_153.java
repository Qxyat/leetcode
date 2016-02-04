package leetcode;

public class FindMinimuminRotatedSortedArray_153 {
	public int findMin(int[] nums) {
	   int left=0;
       int right=nums.length-1;
       while(left<right){
    	   int mid=(left+right)>>1;
    	   if(nums[left]<=nums[mid]&&nums[mid]<=nums[right]){
    		   return nums[left];
    	   }
    	   else if(nums[left]>=nums[mid]&&nums[mid]>=nums[right]){
    		   return nums[right];
    	   }
    	   else if(nums[mid]>=nums[left]&&nums[mid]>=nums[right]){
       		   left=mid;
       	   }
       	   else if(nums[mid]<=nums[left]&&nums[mid]<=nums[right]){
       		   right=mid;
       	   }
       }
       return nums[left];
    }
}
