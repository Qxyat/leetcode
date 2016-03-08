package leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII_212 {
	List<String>res=new ArrayList<String>();
	public List<String> findWords(char[][] board, String[] words) {
		if(board==null||board.length==0)
			return res;
		Tire tire=new Tire();
		for(String word:words){
			tire.insert(word);
		}
		
		boolean[][] visited=new boolean[board.length][board[0].length];
		
		for(int i=0;i<board.length;i++)
			for(int j=0;j<board[0].length;j++){
				visit(board,visited,i,j,tire.root);
			}
		return res;
    }
	public void visit(char[][] board,boolean[][] visited,int row,int col,TireNode pre){
		if(!(row>=0&&row<board.length&&col>=0&&col<board[0].length&&visited[row][col]==false))
			return;
		int index=board[row][col]-'a';
		TireNode cur=pre.children[index];
		if(cur==null)
			return;
		if(cur.isWord){
			if(!res.contains(cur.string))
				res.add(cur.string);
		}
		visited[row][col]=true;
		visit(board, visited, row-1, col, cur);
		visit(board, visited, row+1, col, cur);
		visit(board, visited, row, col-1, cur);
		visit(board, visited, row, col+1, cur);
		visited[row][col]=false;
	}
	class TireNode{
		TireNode[] children=new TireNode[26];
		boolean isWord=false;
		String string;
	}
	class Tire{
		TireNode root=new TireNode();
		public void insert(String word){
			TireNode pre=root;
			for(int i=0;i<word.length();i++){
				int pos=word.charAt(i)-'a';
				TireNode cur=pre.children[pos];
				if(cur==null){
					cur=new TireNode();
					cur.string=word.substring(0,i+1);
					pre.children[pos]=cur;
				}
				pre=cur;
			}
			pre.isWord=true;
		}
	}
}
