package leetcode;

import java.util.Stack;

public class EvaluateReversePolishNotation_150 {
	public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<Integer>();
        for(int i=0;i<tokens.length;i++){
        	if(tokens[i].equals("+")){
        		int b=stack.pop();
        		int a=stack.pop();
        		stack.push(a+b);
        	}
        	else if(tokens[i].equals("-")){
        		int b=stack.pop();
        		int a=stack.pop();
        		stack.push(a-b);
        	}
        	else if(tokens[i].equals("*")){
        		int b=stack.pop();
        		int a=stack.pop();
        		stack.push(a*b);
        	}
        	else if(tokens[i].equals("/")){
        		int b=stack.pop();
        		int a=stack.pop();
        		stack.push(a/b);
        	}
        	else{
        		int a=Integer.parseInt(tokens[i]);
        		stack.push(a);
        	}
        }
        return stack.pop();
    }
}
