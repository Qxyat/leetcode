package leetcode;

import java.util.Stack;

public class FlattenBinaryTreetoLinkedList_114 {
	public void flatten(TreeNode root) {
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode newRoot=new TreeNode(0);
        TreeNode rear=newRoot;
        while(root!=null||!stack.isEmpty()){
        	if(root==null){
        		root=stack.pop();
        	}

    		rear.right=root;
    		rear=root;
    		TreeNode tmp=root.left;
    		root.left=null;
    		if(root.right!=null)
    			stack.push(root.right);
    		root=tmp;
        }
    }
}
