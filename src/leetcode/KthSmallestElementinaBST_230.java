package leetcode;

import java.util.Stack;

public class KthSmallestElementinaBST_230 {
	public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode>stack=new Stack<TreeNode>();
        TreeNode cur=root;
        int count=0;
        while(!stack.isEmpty()||cur!=null){
        	if(cur!=null){
        		stack.push(cur);
        		cur=cur.left;
        	}
        	else{
        		cur=stack.pop();
        		count++;
        		if(count==k)
        			return cur.val;
        		cur=cur.right;
        	}
        }
        return 0;
    }
}
