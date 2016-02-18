package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges_228 {
	public List<String> summaryRanges(int[] nums) {
        List<String> res=new ArrayList<String>();
        if(nums.length==0)
        	return res;
        int last=0;
        int begin=0;
        for(int i=0;i<nums.length;i++){
        	if(i!=0){
        		if(nums[i]!=last+1){
        			if(last!=begin)
        				res.add(Integer.toString(begin)+"->"+Integer.toString(last));
        			else
        				res.add(Integer.toString(begin));
        			begin=nums[i];
        		}
        	}
        	else{
        		begin=nums[i];
        	}
        	last=nums[i];
        }
        if(last!=begin)
			res.add(Integer.toString(begin)+"->"+Integer.toString(last));
		else
			res.add(Integer.toString(begin));
        return res;
    }
}
