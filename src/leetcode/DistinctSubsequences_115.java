package leetcode;

public class DistinctSubsequences_115 {
	public int numDistinct(String s, String t) {
       int row=t.length();
       int col=s.length();
       int[][]res=new int[row+1][col+1];
       for(int i=0;i<=col;i++){
    	   res[0][i]=1;
       }
       for(int i=1;i<=row;i++)
    	   for(int j=0;j<=col;j++){
    		   if(j<i)
    			   res[i][j]=0;
    		   else{
    			   char a=t.charAt(i-1);
    			   char b=s.charAt(j-1);
    			   if(a==b){
    				   res[i][j]=res[i-1][j-1]+res[i][j-1];
    			   }
    			   else{
    				   res[i][j]=res[i][j-1];
    			   }
    		   }
    	   }
       return res[row][col];
    }
}
