package leetcode;

public class ShortestPalindrome_214 {
	 public String shortestPalindrome(String s) {
		String s1=s+new StringBuffer(s).reverse().toString();
		int i=0;
		for(;i<s.length();i++){
			if(s1.charAt(i)!=s1.charAt(s1.length()-1-i))
				break;
		}
		String res=new StringBuffer(s.substring(i)).reverse()+s;
		return res;
	 }
	private boolean isPalindrome(String s) {
		int left=0;
		int right=s.length()-1;
		while(left<right){
			if(s.codePointAt(left)!=s.codePointAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}
}
