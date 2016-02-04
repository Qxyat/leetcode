package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer>result=new ArrayList<Integer>();  
    	Stack<TreeNode>s=new Stack<TreeNode>();
    	TreeNode cur=root;
  
    	while(cur!=null||!s.isEmpty()){
    		if(cur!=null){
    			s.add(cur);
    			result.add(cur.val);
    			cur=cur.right;
    		}
    		else{
    			cur=s.pop();
    			
    			cur=cur.left;
    		}
    	}
    	
    	Collections.reverse(result);
    	return result;
    }
}
