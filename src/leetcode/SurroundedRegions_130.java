package leetcode;

import java.util.ArrayDeque;

import java.util.HashSet;

import java.util.Queue;

public class SurroundedRegions_130 {
	public class MyPoint{
		public int x;
		public int y;
		public MyPoint(int i,int j){x=i;y=j;};
	}
	int row;
	int col;
	MyPoint[] direction=new MyPoint[]{new MyPoint(-1, 0),new MyPoint(0, -1),new MyPoint(0, 1),new MyPoint(1, 0)};
	
	public void solve(char[][] board) {
		row=board.length;
		if(row==0)
			return ;
		col=board[0].length;
	
		for(int i=0;i<col;i++){
			if(board[0][i]=='O'){
				bread_find(board, 0, i);
			}
		}
		for(int i=1;i<row;i++){
			if(board[i][0]=='O'){
				bread_find(board, i, 0);
			}
		}
		for(int i=1;i<row;i++){
			if(board[i][col-1]=='O'){
				bread_find(board, i, col-1);
			}
		}
		for(int i=1;i<col-1;i++){
			if(board[row-1][i]=='O')
				bread_find(board, row-1, i);
		}
		for(int i=0;i<row;i++)
			for(int j=0;j<col;j++){
				if(board[i][j]=='1')
					board[i][j]='O';
				else
					board[i][j]='X';
			}
    }
	public void bread_find(char[][]board,int i,int j){
		Queue<MyPoint> queue=new ArrayDeque<MyPoint>();
		board[i][j]='1';
		queue.add(new MyPoint(i,j));
		while(!queue.isEmpty()){
			MyPoint cur=queue.poll();
			for(int k=0;k<4;k++){
				int nextI=cur.x+direction[k].x;
				int nextJ=cur.y+direction[k].y;
				if(nextI>=0&&nextI<row&&nextJ>=0&&nextJ<col){
					if(board[nextI][nextJ]=='O'){
						board[nextI][nextJ]='1';
						queue.add(new MyPoint(nextI, nextJ));
					}				
				}
			}
		}
	}
}
