package leetcode;

import java.util.ArrayList;

public class EditDistance_72 {
	public int minDistance(String word1, String word2) {
        int len1=word1.length();
        int len2=word2.length();
        int[][] res=new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++){
        	res[i][0]=i;
        }
        for(int i=0;i<=len2;i++){
        	res[0][i]=i;
        }
        for(int i=1;i<=len1;i++)
        	for(int j=1;j<=len2;j++){
        		char c1=word1.charAt(i-1);
        		char c2=word2.charAt(j-1);
        		if(c1==c2){
        			res[i][j]=res[i-1][j-1];
        		}
        		else{
        			res[i][j]=Integer.min(res[i-1][j-1]+1, res[i][j-1]+1);
        			res[i][j]=Integer.min(res[i][j], res[i-1][j]+1);
        		}
        	}
        return res[len1][len2];
    }
}
