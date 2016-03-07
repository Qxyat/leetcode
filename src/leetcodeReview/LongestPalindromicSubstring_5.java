package leetcodeReview;

public class LongestPalindromicSubstring_5 {
	public String longestPalindrome(String s) {
		if(s==null)
			return "";
        int beginPos=0;
        int maxLen=1;
        for(int i=1;i<s.length();i++){
	        	if(i-maxLen-1>=0&&isPalindrome(s.substring(i-maxLen-1, i+1))){
	        		beginPos=i-maxLen-1;
	    			maxLen=maxLen+2;
	    			
	    		}
	    		else if(i-maxLen>=0&&isPalindrome(s.substring(i-maxLen, i+1))){
	    			beginPos=i-maxLen;
	    			maxLen=maxLen+1;
	    			
	    		}
        }
        return s.substring(beginPos,beginPos+maxLen);
    }
	public boolean isPalindrome(String s){
		int left=0;
		int right=s.length()-1;
		while(left<right){
			if(s.charAt(left)!=s.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}
}
