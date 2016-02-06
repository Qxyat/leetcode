package leetcode;

public class HouseRobber_198 {
	public int rob(int[] nums) {
		   if(nums.length==0)
		        return 0;
	       int[][]res=new int[2][nums.length];
	       for(int i=0;i<nums.length;i++){
	    	   res[0][i]=0+(i-1>=0?Integer.max(res[0][i-1], res[1][i-1]):0);
	    	   res[1][i]=nums[i]+(i-1>=0?res[0][i-1]:0);
	       }
	       return Integer.max(res[0][nums.length-1], res[1][nums.length-1]);
    }
}
