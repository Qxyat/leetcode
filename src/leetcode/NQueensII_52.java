package leetcode;

public class NQueensII_52 {
	int result=0;
	public int totalNQueens(int n) {
		int[][] used=new int[n][n];

		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++)
				used[i][j]=0;
		}
		
		get_result(0,n,used);
		
		return result;
    }
	
	void get_result(int row,int scale,int[][] used){
		if(row==scale){
			result+=1;
			return;
		}
		for(int col=0;col<scale;col++){
			if(used[row][col]==0){
				refresh_effect(scale,row,col,used,1);
				
				get_result(row+1, scale, used);
				
				refresh_effect(scale, row, col, used, -1);
			}
		}
		
	}
	void refresh_effect(int scale,int row,int col,int[][] used,int value){
		for(int i=row+1,j=col-1;i<scale&&j>=0;i++,j--)
			used[i][j]+=value;
		
		for(int i=row+1,j=col;i<scale;i++)
			used[i][j]+=value;
		
		for(int i=row+1,j=col+1;i<scale&&j<scale;i++,j++)
			used[i][j]+=value;
	}
}
