package leetcode;


public class ValidPalindrome_125 {
	public boolean isPalindrome(String s) {
        int left=0;
        int right=s.length()-1;
        while(left<right){
        	while(left<right&&!isAlphaNumeric(s.charAt(left)))
        		left++;
        	while(left<right&&!isAlphaNumeric(s.charAt(right)))
        		right--;
        	if(left==right)
        		break;
        	if(!isEqual(s.charAt(left),s.charAt(right)))
        		return false;
        	left++;
        	right--;
        }
        return true;
    }
	public boolean isAlphaNumeric(char c){
		if((c>='a'&&c<='z')||(c>='A'&&c<='Z')||(c>='0'&&c<='9'))
			return true;
		return false;
	}
	public boolean isEqual(char a,char b){
		if((a>='0'&&a<='9')||(b>='0'&&b<='9'))
			return a==b;
		if(a==b||Math.abs(a-b)==Math.abs('a'-'A'))
			return true;
		else 
			return false;
	}
}
