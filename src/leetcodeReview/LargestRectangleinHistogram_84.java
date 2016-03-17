package leetcodeReview;

import java.util.Stack;

public class LargestRectangleinHistogram_84 {
	public static class Pair{
		int height;
		int pos;
		public Pair(int val,int pos){
			this.height=val;
			this.pos=pos;
		}
	}
	public int largestRectangleArea(int[] height) {
		int res=0;
		Stack<Pair> stack=new Stack<Pair>();
		for(int i=0;i<=height.length;i++){	
			Pair cur=null;
			if(i==height.length)
				cur=new Pair(0,i);
			else{
				cur=new Pair(height[i],i);
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
