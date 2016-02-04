package leetcode;

import java.util.Stack;

public class MinStack_155 {
	Stack<Long> stack;
	int min;
	public MinStack_155(){
		stack=new Stack<Long>();
		min=Integer.MAX_VALUE;
	}
	public void push(int x) {
        if(x<min){
        	stack.push((long)x-min);
        	min=x;
        }
        else{
        	stack.push((long)x-min);
        }
    }

    public void pop() {
        long tmp=stack.pop();
        if(tmp<0)
        	min=(int)(min-tmp);
    }

    public int top() {
        long tmp=stack.get(stack.size()-1);
        if(tmp<0)
        	return min;
        else
        	return (int)(min+tmp);
    }

    public int getMin() {
        return min;
    }
}
