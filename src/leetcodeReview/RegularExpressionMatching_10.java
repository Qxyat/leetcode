package leetcodeReview;

import leetcode.RandomListNode;

public class RegularExpressionMatching_10 {
	public boolean isMatch(String s, String p) {
		if(s==null||p==null)
			return false;
		boolean[][]res=new boolean[s.length()+1][p.length()+1];
		res[0][0]=true;
		for(int i=1;i<=p.length();i++){
			if(i+1<=p.length()&&p.charAt(i)=='*'){
				res[0][i]=res[0][i-1];
				res[0][i+1]=res[0][i-1];
				i++;
			}else{
				res[0][i]=false;
			}
		}
		for(int i=1;i<=s.length();i++){
			char s_cur=s.charAt(i-1);
			for(int j=1;j<=p.length();j++){
				char p_cur=p.charAt(j-1);
				if(j+1<=p.length()&&p.charAt(j)=='*'){
					if(p_cur==s_cur||p_cur=='.'){
						res[i][j]=res[i][j-1]|res[i-1][j];
					}
					else{
						res[i][j]=res[i][j-1];
					}
					res[i][j+1]=res[i][j];
					j++;
				}
				else{
					if(p_cur==s_cur||p_cur=='.'){
						res[i][j]=res[i-1][j-1];
					}
					else{
						res[i][j]=false;
					}
				}
			}
		}
		return res[s.length()][p.length()];
    }
}
