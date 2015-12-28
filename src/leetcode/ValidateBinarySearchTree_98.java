package leetcode;

import java.util.Stack;

public class ValidateBinarySearchTree_98 {
	public boolean isValidBST(TreeNode root) {
		Stack<TreeNode>stack =new Stack<TreeNode>();
		TreeNode cur=root;
		int before=Integer.MIN_VALUE;
		boolean find_first=false;
		while(cur!=null||!stack.empty()){
			if(cur!=null){
				stack.push(cur);
				cur=cur.left;
			}
			else{
				cur=stack.pop();
				if(!find_first){
					find_first=true;
				}
				else{
					if(before>=cur.val)
						return false;
				}
				before=cur.val;
				cur=cur.right;
			}
		}
		return true;
    }
}
