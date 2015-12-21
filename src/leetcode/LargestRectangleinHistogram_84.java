package leetcode;

import java.util.Stack;

public class LargestRectangleinHistogram_84 {
	public static class Pair{
		int val;
		int pos;
		public Pair(int val,int pos){
			this.val=val;
			this.pos=pos;
		}
	}
	public int largestRectangleArea(int[] height) {
		Stack<Pair> stack=new Stack<Pair>();
		stack.push(new Pair(0,-1));
		int result=0;
		for(int i=0;i<height.length;i++){
			Pair top=stack.get(stack.size()-1);
			if(height[i]>=top.val){
				stack.push(new Pair(height[i], i));
			}
			else{
				int right=i-1;
				while(stack.size()>=2&&top.val>height[i]){
					Pair next_top=stack.get(stack.size()-2);
					int len=right-next_top.pos;
					int tmp_max=len*top.val;
					result=Integer.max(tmp_max, result);
					top=next_top;
					stack.pop();
				}
				stack.push(new Pair(height[i], i));
			}
		}
		int right=height.length-1;
		Pair top=null;
		if(stack.size()>1){
			top=stack.pop();
			Pair next_top=null;
			while(stack.size()>=1){
				next_top=stack.pop();
				int len=right-next_top.pos;
				int tmp_max=len*top.val;
				result=Integer.max(result, tmp_max);
				top=next_top;
			}
		}
		return result;
    }
}
