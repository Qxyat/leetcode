package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView_199 {
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<Integer>();
        if(root==null)
        	return result;
        Queue<TreeNode>cur=new ArrayDeque<TreeNode>();
        cur.add(root);
        while(!cur.isEmpty()){
        	Queue<TreeNode> next=new ArrayDeque<TreeNode>();
        	while(!cur.isEmpty()){
        		TreeNode tmp=cur.poll();
        		if(tmp.left!=null){
        			next.add(tmp.left);
        		}
        		if(tmp.right!=null){
        			next.add(tmp.right);
        		}
        		if(cur.isEmpty()){
        			result.add(tmp.val);
        		}
        	}
        	cur=next;
        }
        return result;
    }
}
