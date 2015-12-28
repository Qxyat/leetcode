package leetcode;

public class InterleavingString_97 {
	public boolean isInterleave(String s1, String s2, String s3) {
		 int len1=s1.length();
			int len2=s2.length();
			int len3=s3.length();
			if(len1+len2!=len3)
			    return false;
	        boolean[][]res=new boolean[len1+1][len2+1];
	        res[0][0]=true;
	        for(int i=1;i<=len2;i++){
	        	if(s3.charAt(i-1)==s2.charAt(i-1))
	        		res[0][i]|=res[0][i-1];
	        	else
	        		res[0][i]=false;
	        }
	        for(int i=1;i<=len1;i++){
	        	if(s3.charAt(i-1)==s1.charAt(i-1))
	        		res[i][0]|=res[i-1][0];
	        	else
	        		res[i][0]=false;
	        }
	        for(int i=1;i<=s1.length();i++)
	        	for(int j=1;j<=s2.length();j++){
	        	   
	        		char c=s3.charAt(i+j-1);
	        		char a=s1.charAt(i-1);
	        		char b=s2.charAt(j-1);
	        		if(c==a)
	        			res[i][j]|=res[i-1][j];
	        		if(c==b)
	        			res[i][j]|=res[i][j-1];
	        	  
	        	}
	        return res[len1][len2];
    }
}
