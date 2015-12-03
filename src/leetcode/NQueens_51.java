package leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQueens_51 {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result=new ArrayList<List<String>>();
		List<StringBuffer> one_result=new ArrayList<StringBuffer>();
		int[][] used=new int[n][n];
		char[] origin=new char[n];
		for(int i=0;i<n;i++)
			origin[i]='.';
		for(int i=0;i<n;i++){
			one_result.add(new StringBuffer(new String(origin)));
			for(int j=0;j<n;j++)
				used[i][j]=0;
		}
		
		get_result(result,one_result,0,n,used);
		
		return result;
    }
	
	void get_result(List<List<String>>result,List<StringBuffer>one_res,int row,int scale,int[][] used){
		if(row==scale){
			List<String> tmp=new ArrayList<String>();
			for(int i=0;i<scale;i++){
				tmp.add(one_res.get(i).toString());
			}
			result.add(tmp);
			return;
		}
		for(int col=0;col<scale;col++){
			if(used[row][col]==0){
				refresh_effect(scale,row,col,used,1);
				one_res.get(row).replace(col, col+1, "Q");
				get_result(result, one_res, row+1, scale, used);
				one_res.get(row).replace(col, col+1, ".");
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
