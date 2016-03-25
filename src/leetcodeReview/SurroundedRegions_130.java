package leetcodeReview;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions_130 {
	public void solve(char[][] board) {
        if(board==null||board.length==0)
            return;
        for(int i=0;i<board[0].length;i++){
            BFS(board,0,i);
            BFS(board,board.length-1,i);
        }
        for(int i=0;i<board.length;i++){
            BFS(board,i,0);
            BFS(board,i,board[0].length-1);
        }
        
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
                board[i][j]=board[i][j]=='1'?'O':'X';
        
        return ;
    }
	class Pair{
		int row;
		int col;
		public Pair(int i,int j){
			this.row=i;
			this.col=j;
		}
	}
    public void BFS(char[][] board,int i,int j){
        if(board[i][j]=='O'){
        		Queue<Pair> queue=new LinkedList<Pair>();
        		queue.offer(new Pair(i, j));
        		board[i][j]='1';
        		while(!queue.isEmpty()){
        			Pair p=queue.poll();    
        			if(judge(board,p.row-1,p.col)){
        				board[p.row-1][p.col]='1';
        				queue.add(new Pair(p.row-1, p.col));
        			}
        			if(judge(board,p.row+1,p.col)){
        				board[p.row+1][p.col]='1';
        				queue.add(new Pair(p.row+1, p.col));
        			}
        			if(judge(board,p.row,p.col-1)){
        				board[p.row][p.col-1]='1';
        				queue.add(new Pair(p.row, p.col-1));
        			}
        			if(judge(board,p.row,p.col+1)){
        				board[p.row][p.col+1]='1';
        				queue.add(new Pair(p.row, p.col+1));
        			}
        		}
        }
    }
    public boolean judge(char[][] board, int i, int j){
    		if(i>=0&&i<board.length&&j>=0&&j<board[0].length){
    			if(board[i][j]=='X'||board[i][j]=='1')
    				return false;
    			return true;
    		}
    		return false;
    }
}
