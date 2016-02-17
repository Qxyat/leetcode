package leetcode;

public class HouseRobberII_213 {
	public int rob(int[] nums) {
		if(nums.length==0)
			return 0;
		int[][] res=new int[nums.length][2];
		res[0][0]=0;
		res[0][1]=0;
		for(int i=1;i<nums.length;i++){
			res[i][0]=0+Integer.max(res[i-1][0], res[i-1][1]);
			res[i][1]=nums[i]+res[i-1][0];
		}
		int tmp_res=Integer.max(res[nums.length-1][0], res[nums.length-1][1]);
		res[0][0]=0;
		res[0][1]=nums[0];
		for(int i=1;i<nums.length;i++){
			res[i][0]=0+Integer.max(res[i-1][0], res[i-1][1]);
			res[i][1]=nums[i]+res[i-1][0];
		}
		return Integer.max(tmp_res, res[nums.length-1][0]);
    }
}
