package leetcode;

public class MoveZeroes_283 {
	public void moveZeroes(int[] nums) {
		int count=0;
        for(int a:nums){
        	if(a!=0){
        		nums[count++]=a;
        	}
        }
        for(int i=count;i<nums.length;i++)
        	nums[i]=0;
    }
}
