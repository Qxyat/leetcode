package leetcode;

public class ScrambleString_87 {
	public boolean isScramble(String s1, String s2) {
		if(s1.length()!=s2.length())
			return false;
        int len=s1.length();
        if(len==0)
        	return true;
        boolean[][][] res=new boolean[len+1][len][len];
        for(int i=0;i<=len-1;i++)
        	for(int j=0;j<=len-1;j++){
        		char c1=s1.charAt(i);
        		char c2=s2.charAt(j);
        		if(c1==c2)
        			res[1][i][j]=true;
        		else
        			res[1][i][j]=false;
        	}
        for(int l=2;l<=len;l++)
        	for(int i=0;i<=len-l;i++)
        		for(int j=0;j<=len-l;j++){
        			boolean tmp_res=false;
        			for(int k=1;k<=l-1;k++){
        				boolean tmp_res_one=false;
        				tmp_res_one=(res[k][i][j]&res[l-k][i+k][j+k])|(res[k][i][j+l-k]&res[l-k][i+k][j]);
        				tmp_res=tmp_res|tmp_res_one;
        			}
        			res[l][i][j]=tmp_res;
        		}
        return res[len][0][0];
    }
}
