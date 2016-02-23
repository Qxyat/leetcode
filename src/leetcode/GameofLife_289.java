package leetcode;

public class GameofLife_289 {
	public void gameOfLife(int[][] board) {
		int[] cur=null;
		int[] last=null;
        for(int i=0;i<board.length;i++){
        	cur=new int[board[i].length];
        	for(int j=0;j<board[0].length;j++){
        		cur[j]=board[i][j];
        		int liveCellCount=0;
        		liveCellCount=getIsLive(last, j-1)+getIsLive(last, j)+getIsLive(last, j+1)+getIsLive(cur, j-1)+getIsLive(board[i], j+1)+(i==board.length-1?0:(getIsLive(board[i+1], j-1)+getIsLive(board[i+1], j)+getIsLive(board[i+1], j+1)));
        		
        		int res=0;
        		if(board[i][j]==1){
	        		if(liveCellCount<2||liveCellCount>3)
	        			res=0;
	        		else 
	        			res=1; 
        		}
        		else{
        			if(liveCellCount==3)
        				res=1;
        		}
        		board[i][j]=res;
        	}
        	last=cur;
        }
    }
	public int getIsLive(int[] data,int pos){
		if(data==null)
			return 0;
		if(pos<0||pos>data.length-1)
			return 0;
		return data[pos];
	}
}
