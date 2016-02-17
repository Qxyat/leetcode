package leetcode;

public class ShortestPalindrome_214 {
	 public String shortestPalindrome(String s) {
		 
		 int begin=0;
		 int len=1;
		 int res=1;
		 for(int i=1;i<s.length();i++){
			if(i-1-len>=0&&isPalindrome(s.substring(i-1-len, i+1))){
				begin=i-1-len;
				len=len+2;
			}
			else if(isPalindrome(s.substring(i-len,i+1))){
				begin=i-len;
				len=len+1;
			}
			if(begin==0)
				res=Integer.max(res, len);
		 }
	        
		 StringBuffer tmp=new StringBuffer();
		 for(int i=s.length()-1;i>=res;i--){
			 tmp.append(s.charAt(i));
		 }
		 tmp.append(s);
	     return tmp.toString();
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
