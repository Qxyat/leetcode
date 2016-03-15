package leetcodeReview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PermutationsII_47 {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		List<Integer> one_res=new ArrayList<Integer>();
        find(res,one_res,nums,0);
        return res;
    }
	public void find(List<List<Integer>> res,List<Integer> one_res,int[]nums,int pos){
		if(pos==nums.length){
			ArrayList<Integer> tmp=new ArrayList<Integer>(one_res);
			res.add(tmp);
			return ;
		}
		
		HashSet<Integer> set=new HashSet<Integer>();
		for(int i=pos;i<nums.length;i++){
			if(!set.contains(nums[i])){
				set.add(nums[i]);
				int  tmp=nums[i];
				nums[i]=nums[pos];
				nums[pos]=tmp;
				one_res.add(nums[pos]);
				find(res, one_res, nums, pos+1);
				one_res.remove(one_res.size()-1);
				tmp=nums[i];
				nums[i]=nums[pos];
				nums[pos]=tmp;
			}
		}
	}
}
