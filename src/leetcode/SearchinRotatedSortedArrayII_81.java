package leetcode;

public class SearchinRotatedSortedArrayII_81 {
	public boolean search(int[] nums, int target) {
      int offset;
      int i=1;
      while(i<nums.length){
    	  if(nums[i-1]>nums[i])
    		  break;
    	  i++;
      }
      offset=i;
      int left=0,right=nums.length-1;
      while(left<=right){
    	  int mid=(left+right)/2;
    	  int real_mid=(mid+offset)%nums.length;
    	  if(nums[real_mid]==target)
    		  return true;
    	  else if(nums[real_mid]<target)
    		  left=mid+1;
    	  else 
    		  right=mid-1;
      }
      return false;
    }
}
