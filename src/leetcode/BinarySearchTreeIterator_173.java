package leetcode;

import java.util.Stack;

public class BinarySearchTreeIterator_173 {
	Stack<TreeNode> stack;
	public BinarySearchTreeIterator_173(TreeNode root) {
        stack=new Stack<TreeNode>();
        TreeNode cur=root;
        while(cur!=null){
        	stack.push(cur);
        	cur=cur.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    	if(!stack.isEmpty())
    		return true;
    	else
    		return false;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node=stack.pop();
        int res=node.val;
        TreeNode cur=node.right;
        while(cur!=null){
        	stack.push(cur);
        	cur=cur.left;
        }
        return res;
    }
}
