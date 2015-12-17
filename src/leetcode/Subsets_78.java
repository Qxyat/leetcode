package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_78 {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>result=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<=nums.length;i++){
        	List<Integer>one_res=new ArrayList<Integer>();
        	find_res(result,one_res,nums,0,i);
        }
        return result;
    }
	public void find_res(List<List<Integer>>result,List<Integer>one_res,int[] nums,int pos,int total_level){
		if(one_res.size()==total_level){
			List<Integer>tmp=new ArrayList<>(one_res);
			result.add(tmp);
			return;
		}
		if(pos>=nums.length){
			return;
		}
		for(int i=pos;i<nums.length;i++){
			one_res.add(nums[i]);
			find_res(result, one_res, nums, i+1, total_level);
			one_res.remove(one_res.size()-1);
		}
		
	}
}
