package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal_94 {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res=new ArrayList<Integer>();
		Stack<TreeNode> stack=new Stack<TreeNode>();
		TreeNode cur=root;
		while(cur!=null||!stack.isEmpty()){
			if(cur!=null){
				stack.push(cur);
				cur=cur.left;
			}
			else{
				cur=stack.pop();
				res.add(cur.val);
				cur=cur.right;
			}
		}
		return res;
    }
	
}
