package leetcode;

public class WordSearch_79 {
	public boolean exist(char[][] board, String word) {
		int row=board.length;
		if(row<=0)
			return false;
		int col=board[0].length;
		boolean[][] used=new boolean[row][col];
		for(int i=0;i<row;i++)
		for(int j=0;j<col;j++)
		    used[i][j]=false;
		boolean result=false;
		for(int i=0;i<row&&!result;i++)
			for(int j=0;j<col&&!result;j++){

				result=find_res(board,word,used,0,i,j);

			}
		return result;
    }
	public boolean find_res(char[][] board,String word,boolean[][] used, int pos,int i,int j){
		if(pos>=word.length())
			return true;
		if(i>=0&&i<board.length&&j>=0&&j<board[0].length){
			if(used[i][j]==false&&board[i][j]==word.charAt(pos)){
				used[i][j]=true;
				boolean tmp_res=false;
				tmp_res=find_res(board, word, used, pos+1, i-1, j);
				if(tmp_res){
					used[i][j]=false;
					return tmp_res;
				}
				tmp_res=find_res(board, word, used, pos+1, i+1, j);
				if(tmp_res){
					used[i][j]=false;
					return tmp_res;
				}
				tmp_res=find_res(board, word, used, pos+1, i, j-1);
				if(tmp_res){
					used[i][j]=false;
					return tmp_res;
				}
				tmp_res=find_res(board, word, used, pos+1, i, j+1);
				used[i][j]=false;
				return tmp_res;
			}
			else{
				return false;
			}
		}
		else
			return false;
	}
}
