package leetcode;

public class MaximalSquare_221 {
	public class Pair{
		int row;
		int col;
	}
	public int maximalSquare(char[][] matrix) {
		if(matrix==null||matrix.length==0)
			return 0;
        int maxLen=0;
        int[] lastCache=new int[matrix[0].length];
        for(int i=0;i<matrix[0].length;i++){
        		lastCache[i]=(matrix[0][i]=='1'?1:0);
        		maxLen=Integer.max(maxLen, lastCache[i]);
        }
        for(int i=1;i<matrix.length;i++){
        		int[] curCache=new int[matrix[0].length];
        		curCache[0]=(matrix[i][0]=='1'?1:0);
        		for(int j=1;j<matrix[0].length;j++){
        			if(matrix[i][j]=='1'){
        				curCache[j]=Integer.min(curCache[j-1], Integer.min(lastCache[j], lastCache[j-1]))+1;
        				maxLen=Integer.max(maxLen, curCache[j]);
        			}
        		}
        		lastCache=curCache;
        }
        	return maxLen*maxLen;
    }
}
