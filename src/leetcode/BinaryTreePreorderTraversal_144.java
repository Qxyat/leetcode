package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal_144 {
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode cur=root;
        while(cur!=null||!stack.isEmpty()){
        	if(cur!=null){
        		res.add(cur.val);
        		stack.push(cur);
        		cur=cur.left;
        	}
        	else{
        		cur=stack.pop();
        		cur=cur.right;
        	}
        }
        return res;
    }
}
