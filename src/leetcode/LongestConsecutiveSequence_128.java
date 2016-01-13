package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutiveSequence_128 {
	public class Pair{
		int pre;
		int after;
		public Pair(int i,int j){pre=i;after=j;}
	}
	public int longestConsecutive(int[] nums) {
		int len=nums.length;
		HashSet<Integer> data=new HashSet<Integer>();
		for(int i=0;i<len;i++){
			int cur=nums[i];
			data.add(cur);
		}
		HashSet<Integer> used=new HashSet<Integer>();
		int res=1;
		for(int i=0;i<len;i++){
			int cur=nums[i];
			if(!used.contains(cur)){
				int tmp=1;
				if(cur!=Integer.MIN_VALUE){
					int needPre=cur-1;
					while(data.contains(needPre)){
						used.add(needPre);
						tmp++;
						if(needPre==Integer.MIN_VALUE)
							break;
						needPre--;	
					}
				}
				if(cur!=Integer.MAX_VALUE){
					int needAfter=cur+1;
					while(data.contains(needAfter)){
						used.add(needAfter);
						tmp++;
						if(needAfter==Integer.MAX_VALUE)
							break;
						needAfter++;
					}
				}
				res=Integer.max(res, tmp);
			}
		}
		return res;
    }
}
