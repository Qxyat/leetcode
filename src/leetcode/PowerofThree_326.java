package leetcode;

public class PowerofThree_326 {
	public boolean isPowerOfThree(int n) {
		
		return n<1?false:((int)Math.pow(3, Math.log(0x7fffffff)/Math.log(3))%n==0);
    }
}
