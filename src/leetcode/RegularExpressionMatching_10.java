·········package leetcode;

public class RegularExpressionMatching_10 {
	public boolean isMatch(String s, String p) {
		if(s==null||p==null)
			return false;
		boolean[][] res=new boolean[s.length()+1][p.length()+1];
		res[0][0]=true;
		for(int i=1;i<=p.length();){
			if(i+1<=p.length()){
				char next=p.charAt(i);
				if(next=='*'){
					res[0][i]=res[0][i-1];
					res[0][i+1]=res[0][i-1];
					i+=2;
					continue;
				}
			}
			res[0][i]=false;
			i+=1;
		}
		for(int i=1;i<=s.length();i++){
			res[i][0]=false;
		}
		for(int i=1;i<=s.length();i++)
			for(int j=1;j<=p.length();){
				char s_cur=s.charAt(i-1);
				char p_cur=p.charAt(j-1);
				if(j+1<=p.length()){
					char p_next=p.charAt(j);
					if(p_next=='*'){
						boolean tmp_res=false;
						if(p_cur=='.'||s_cur==p_cur){
							tmp_res=res[i-1][j]|res[i][j-1];
						}
						else{
							tmp_res=res[i][j-1];
						}
						res[i][j]=tmp_res;
						res[i][j+1]=tmp_res;
						j+=2;
						continue;
					}
				}
				boolean tmp_res=false;
				if(p_cur=='.'||s_cur==p_cur){
					tmp_res=res[i-1][j-1];
				}
				else{
					tmp_res=false;
				}
				res[i][j]=tmp_res;
				j++;
			}
		return res[s.length()][p.length()];
	}
}
