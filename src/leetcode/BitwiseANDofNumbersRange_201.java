package leetcode;import sun.tools.jar.resources.jar;

public class BitwiseANDofNumbersRange_201 {
	public int rangeBitwiseAnd(int m, int n) {
		String s1=Integer.toBinaryString(m);
		String s2=Integer.toBinaryString(n);
		if(s1.length()!=s2.length())
			return 0;
		int i=0;
		int res=0;
		for(;i<s1.length()&&s1.charAt(i)==s2.charAt(i);i++){
			res=(res<<1)|(s1.charAt(i)-'0');
		}
		res=res<<(s1.length()-i);
		
		return res;
    }
}
