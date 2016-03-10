package leetcodeReview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3_15 {
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>res=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int i=0;
        while(i<nums.length-2){
        		int left=i+1;
        		int right=nums.length-1;
        		int target=0-nums[i];
        		while(left<right){
        			if(nums[left]+nums[right]<target){
        				left++;
        			}
        			else if(nums[left]+nums[right]>target){
        				right--;
        			}
        			else{
        				List<Integer>one_res=new ArrayList<Integer>();
        				one_res.add(nums[i]);
        				one_res.add(nums[left]);
        				one_res.add(nums[right]);
        				res.add(one_res);
        				while(left<right&&right-1>left&&nums[right]==nums[right-1])
        					right--;
        				while(left<right&&left+1<right&&nums[left]==nums[left+1])
        					left++;
        				right--;
        				left++;
        			}
        		}
        		while(i<nums.length-2&&i+1<nums.length-2&&nums[i]==nums[i+1])
        			i++;
        		i++;
        }
        return res;
    }
}
