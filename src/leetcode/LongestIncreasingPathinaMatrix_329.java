package leetcode;

public class LongestIncreasingPathinaMatrix_329 {
	public int[][] direction={{-1,0},{1,0},{0,-1},{0,1}};
	
	public int longestIncreasingPath(int[][] matrix) {
		if(matrix==null||matrix.length==0)
			return 0;
		int[][] cache=new int[matrix.length][matrix[0].length];
		int res=Integer.MIN_VALUE;
		for(int i=0;i<matrix.length;i++)
			for(int j=0;j<matrix[0].length;j++){
				int len=DFS(matrix,i,j,cache);
				res=Integer.max(res, len);
			}
		return res;
    }
	public int DFS(int[][]matrix,int row,int col,int[][] cache){
		if(cache[row][col]!=0)
			return cache[row][col];
		int max=1;
		for(int[] dir:direction){
			int nextRow=row+dir[0];
			int nextCol=col+dir[1];
			if(nextRow<0||nextRow>=matrix.length||nextCol<0||nextCol>=matrix[0].length||matrix[row][col]>=matrix[nextRow][nextCol])
				continue;
			int len=1+DFS(matrix, nextRow, nextCol, cache);
			max=Integer.max(len, max);
		}
		cache[row][col]=max;
		return max;
	}
	
}
