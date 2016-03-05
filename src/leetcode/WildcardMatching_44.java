package leetcode;

public class WildcardMatching_44 {
	public boolean isMatch(String s, String p) {
		 	boolean[][]res =new boolean[s.length()+1][p.length()+1];
			res[0][0]=true;
			for(int i=1;i<=p.length();i++){
				char cur=p.charAt(i-1);
				if(cur=='*')
					res[0][i]=res[0][i-1];
				else
					res[0][i]=false;
			}
			for(int i=1;i<=s.length();i++)
				res[i][0]=false;
			for(int i=1;i<=s.length();i++){
				char s_cur=s.charAt(i-1);
				for(int j=1;j<=p.length();j++){
					char p_cur=p.charAt(j-1);
					if(p_cur=='*'){
						res[i][j]=res[i][j-1]|res[i-1][j];
					}
					else if(p_cur=='?'||s_cur==p_cur){
						res[i][j]=res[i-1][j-1];
					}
					else{
						break;
					}
				}
			}
			return res[s.length()][p.length()];
    }
}
