package leetcode;

import com.sun.org.apache.regexp.internal.recompile;

public class JumpGame_55 {
	public boolean canJump(int[] nums) {
        int farest=0;
        int start_pos=0;
        int next_farest=farest;
        int end=nums.length-1;
        while(true){
	        for(int i=start_pos;i<=farest;i++){
	        	int tmp=i+nums[i];
	        	next_farest=Integer.max(next_farest, tmp);
	        	if(next_farest>=end)
	        		return true;
	        }
	        if(next_farest==farest)
	        	return false;
	        start_pos=farest+1;
	        farest=next_farest;
        }
    }
}
