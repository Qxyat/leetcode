package leetcodeReview;

import java.util.Stack;

import sun.net.www.content.text.plain;

public class MaximalRectangle_85 {
	public int maximalRectangle(char[][] matrix) {
		if(matrix==null||matrix.length==0)
			return 0;
		int[][] matrixParser=new int[matrix.length][matrix[0].length];
		int res=Integer.MIN_VALUE;
		for(int i=0;i<matrix[0].length;i++){
			matrixParser[0][i]=(matrix[0][i]=='1'?1:0);
		}
		res=Integer.max(res, find(matrixParser,0));
		for(int i=1;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				matrixParser[i][j]=(matrix[i][j]=='1'?1+matrixParser[i-1][j]:0);
			}
			res=Integer.max(res, find(matrixParser,i));
		}
		return res;
    }
	class Pair{
		int height;
		int pos;
		public Pair(int height,int pos){
			this.height=height;
			this.pos=pos;
		}
	}
	public int find(int[][] matrix,int row){
		int res=0;
		Stack<Pair> stack=new Stack<Pair>();
		for(int i=0;i<=matrix[row].length;i++){	
			Pair cur=null;
			if(i==matrix[row].length)
				cur=new Pair(0,i);
			else{
				cur=new Pair(matrix[row][i],i);
			}
			Pair rear=null;
			while(stack.size()>0&&stack.peek().height>cur.height){
				Pair tmp=stack.pop();
				if(rear==null)
					rear=tmp;
				int left=-1;
				if(stack.size()>0){
					left=stack.peek().pos;
				}
				res=Integer.max(res, (rear.pos-left)*tmp.height);
			}
			stack.push(cur);
		}
		
		
		return res;
	}
}
