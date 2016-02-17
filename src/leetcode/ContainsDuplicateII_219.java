package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicateII_219 {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> res=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
        	if(res.containsKey(nums[i])){
        		if(i-res.get(nums[i])<=k)
        			return true;
        		else{
            		res.put(nums[i], i);
            	}
        	}
        	else{
        		res.put(nums[i], i);
        	}
        }
        return false;
    }
}
