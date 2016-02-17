package leetcode;

import java.util.HashSet;

public class ContainsDuplicate_217 {
	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> res=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
        	if(res.contains(nums[i]))
        		return true;
        	res.add(nums[i]);
        }
        return false;
    }
}
