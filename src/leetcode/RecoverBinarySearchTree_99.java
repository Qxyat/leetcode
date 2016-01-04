package leetcode;

import java.util.Stack;

public class RecoverBinarySearchTree_99 {
	public void recoverTree(TreeNode root) {
		Stack<TreeNode> stack=new Stack<TreeNode>();
		TreeNode left=null;
		TreeNode right=null;
		TreeNode last=null;
		
		TreeNode cur=root;

		boolean first=true;
		boolean find_left=false;
		
		while(!stack.empty()||cur!=null){
			if(cur!=null){
				stack.push(cur);
				cur=cur.left;
			}
			else{
				cur=stack.pop();
				if(first){
					first=false;
				}else{
					if(last.val>cur.val){
						if(!find_left){
							find_left=true;
							left=last;
							right=cur;
						}
						else{
							right=cur;
							break;
						}
					}
				}
				last=cur;
				cur=cur.right;
			}
		}
		
		int tmp=left.val;
		left.val=right.val;
		right.val=tmp;
	}
}
