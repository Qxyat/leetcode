package leetcode;

import java.util.Stack;

public class MaximalRectangle_85 {
	public int maximalRectangle(char[][] matrix) {
		if(matrix.length==0)
			return 0;
		int row=matrix.length;
		int col=matrix[0].length;
        int[][] maxlength=new int[row+1][col+1];
        int[] one_data=new int[col];
        int res=0;
        for(int i=1;i<=col;i++)
        	maxlength[0][i]=0;
        for(int i=1;i<=row;i++){
        	for(int j=1;j<=col;j++){
        		if(matrix[i-1][j-1]=='0'){
        			one_data[j-1]=0;
        			maxlength[i][j]=0;
        		}
        		else{
        			maxlength[i][j]=maxlength[i-1][j]+1;
        			one_data[j-1]=maxlength[i][j];
        		}
        	}
        	res=Integer.max(calOneData(one_data),res);
        }
        return res;
    }
	public static class Pair{
		int pos;
		int val;
		public Pair(int pos,int val){
			this.pos=pos;
			this.val=val;
		}
	}
	public int calOneData(int[] one_data){
		Stack<Pair>stack=new Stack<Pair>();
		stack.push(new Pair(-1, 0));
		int res=0;
		for(int i=0;i<one_data.length;i++){
			Pair top=stack.get(stack.size()-1);
			if(one_data[i]>=top.val)
				stack.push(new Pair(i, one_data[i]));
			else {
				int right=i-1;
				while(stack.size()>=2&&top.val>one_data[i]){
					Pair next_top=stack.get(stack.size()-2);
					int len=right-next_top.pos;
					int tmp_res=len*top.val;
					res=Integer.max(res, tmp_res);
					top=next_top;
					stack.pop();
				}
				stack.push(new Pair(i, one_data[i]));
			}
		}
		
		if(stack.size()>=2){
			int right=one_data.length-1;
			Pair top=stack.get(stack.size()-1);
			while(stack.size()>=2){
				Pair next_top=stack.get(stack.size()-2);
				int len=right-next_top.pos;
				int tmp_res=len*top.val;
				res=Integer.max(res, tmp_res);
				top=next_top;
				stack.pop();
			}
		}
		return res;
	}
}
