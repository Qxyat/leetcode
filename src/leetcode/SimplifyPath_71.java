package leetcode;

import java.util.Stack;

public class SimplifyPath_71 {
	public String simplifyPath(String path) {
		Stack<String> stack=new Stack<String>();
		stack.push("/");
		String[] array=path.split("/");
		
		for(int i=0;i<array.length;i++){
			if(array[i].equals(".")||array[i].equals("")){
				
			}
			else if(array[i].equals("..")){
				if(stack.size()==1){
					
				}
				else 
					stack.pop();
			}
			else{
				stack.push(array[i]);
			}
		}
		StringBuffer sBuffer=new StringBuffer();
		if(stack.size()==1)
			return "/";
		while(!stack.isEmpty()){
			sBuffer.insert(0, "/"+stack.pop());
		}
		sBuffer.replace(0, 2, "");
		return sBuffer.toString();
	}
}
