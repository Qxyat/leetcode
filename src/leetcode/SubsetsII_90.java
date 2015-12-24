package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII_90 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>res=new ArrayList<List<Integer>>();
       
        for(int l=0;l<=nums.length;l++){
        	List<Integer>one_res=new ArrayList<Integer>();
        	find(res,one_res,nums,0,l);
        }
        return res;
	}
	public void find(List<List<Integer>>res,List<Integer>one_res, int[]nums,int pos,int need){
		if(one_res.size()>=need){
			List<Integer>tmp= new ArrayList<Integer>(one_res);
			res.add(tmp);
			return;
		}
		int i=pos;
		while(i<nums.length){
			one_res.add(nums[i]);
			find(res, one_res, nums, i+1, need);
			one_res.remove(one_res.size()-1);
			while(i+1<nums.length&&nums[i]==nums[i+1]){
				i++;
			}
			i++;
		}
	}
}
