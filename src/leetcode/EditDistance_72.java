package leetcode;

import java.util.ArrayList;

public class EditDistance_72 {
	public int minDistance(String word1, String word2) {
        int len1=word1.length();
        int len2=word2.length();
        if(len1<len2)
        	return minDistance(word2, word1);
        int len=len1;
        int[][] res=new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++)
        	res[i][0]=0;
        for(int j=0;j<=len2;j++)
        	res[0][j]=0;
        for(int row=1;row<=len1;row++)
        	for(int col=1;col<=len2;col++){
        		if(word1.charAt(row-1)==word2.charAt(col-1)){
        			res[row][col]=res[row-1][col-1]+1;
        		}
        		else{
        			res[row][col]=Integer.max(res[row][col-1], res[row-1][col]);
        		}
        	}
        ArrayList<Integer> tmp1=new ArrayList<Integer>();
        ArrayList<Integer> tmp2=new ArrayList<Integer>();
        int i=len1,j=len2;
        while(i>0&&j>0){
        	if(res[i][j]==res[i][j-1]){
        		j--;
        	}
        	else if(res[i][j]==res[i-1][j]){
        		i--;
        	}
        	else {
        		 tmp1.add(i);
        		 tmp2.add(j);
        		 i--;
        		 j--;
        	}
        	
        }
        int result=0;
        int last1=len+1,last2=len+1;
        for(int pos=0;pos<tmp1.size();pos++){
        	result+=Integer.max(last1-tmp1.get(pos)-1, last2-tmp2.get(pos)-1);
        	last1=tmp1.get(pos);
        	last2=tmp2.get(pos);
        }
        result+=Integer.max(last1-1, last2-1);
        if(result>len)
        	return len;
        return result;
    }
}
