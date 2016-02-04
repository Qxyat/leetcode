package leetcode;

public class ReverseWordsinaString_151 {
	public String reverseWords(String s) {
		 StringBuffer result=new StringBuffer();
	        boolean preword=false;
	        int i=s.length()-1;
	        while(i>=0){
	        	if(s.charAt(i)!=' '){
	        		StringBuffer tmp=new StringBuffer();
	        		while(i>=0&&s.charAt(i)!=' '){
	        			tmp.insert(0,s.charAt(i));
	        			i--;
	        		}
	        		if(preword){
	        			result.append(" "+tmp.toString());
	        		}
	        		else{
	        			result.append(tmp.toString());
	        		}
	        		preword=true;
	        	}
	        	else
	        		i--;
	        }
	        return result.toString();
    }
}
