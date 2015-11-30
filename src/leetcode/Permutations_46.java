package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.omg.PortableInterceptor.INACTIVE;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;


public class Permutations_46 {
	public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> result=new ArrayList<List<Integer>>();
       
       Arrays.sort(nums);
  
       get_result(result,nums);
       return result;
    }
	private void get_result(List<List<Integer>>result,int[]nums){
		List<Integer>one_res=new ArrayList<Integer>();
		for(int i=0;i<nums.length;i++)
			one_res.add(nums[i]);
		result.add(one_res);
		
		int break_point=0;
		
		for(int i=nums.length-1;i>=1;i--){
			if(nums[i-1]<nums[i]){
				break_point=i;
				break;
			}
		}
		if(break_point==0)
			return;
		for(int i=nums.length-1;i>=break_point;i--){
			if(nums[i]>nums[break_point-1]){
				int tmp=nums[i];
				nums[i]=nums[break_point-1];
				nums[break_point-1]=tmp;
				break;
			}
		}
		
		int left=break_point;
		int right=nums.length-1;
		while(left<right){
			int tmp=nums[left];
			nums[left]=nums[right];
			nums[right]=tmp;
			left++;
			right--;
		}
		
		get_result(result,nums);
	}
}
