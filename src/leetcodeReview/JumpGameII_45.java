package leetcodeReview;

import java.util.ArrayDeque;
import java.util.Queue;

public class JumpGameII_45 {
	public int jump(int[] nums) {
		if(nums==null||nums.length<2)
			return 0;
		int curMin=0;
		int curMax=0;
		int res=0;
		while(true){
			res++;
			int lastMin=curMin;
			int lastMax=curMax;
			curMin=curMax+1;
			curMax=curMin;
			for(int i=lastMin;i<=lastMax;i++){
				curMax=Integer.max(curMax, i+nums[i]);
				if(curMax>=nums.length-1)
					return res;
			}
		}
	
    }
}
