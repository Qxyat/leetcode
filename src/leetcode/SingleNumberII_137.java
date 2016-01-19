package leetcode;

public class SingleNumberII_137 {
	public int singleNumber(int[] nums) {
		int a=0,b=0;
		for(int i=0;i<nums.length;i++){
			int tmpb=b;
			int c=nums[i];
			b=(~a&~tmpb&c)|(~a&tmpb&~c)|(a&~tmpb&c)|(a&tmpb&~c);
			a=(~a&tmpb&c)|(a&~tmpb&~c)|(a&~tmpb&c)|(a&tmpb&~c);
		}
		return a&b;
    }
}
