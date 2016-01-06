package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal_103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>res=new ArrayList<List<Integer>>();
        if(root==null)
        	return res;
        List<Integer>one_res=null;
        List<TreeNode> next=null;
        List<TreeNode> cur=new ArrayList<TreeNode>();
        boolean leftToRight=true;
        cur.add(root);
        while(cur.size()!=0){
        	next=new ArrayList<TreeNode>();
        	one_res=new ArrayList<Integer>();
        	if(leftToRight){
        		for(int i=0;i<cur.size();i++){
        			one_res.add(cur.get(i).val);
        			if(cur.get(i).left!=null){
        				next.add(cur.get(i).left);
        			}
        			if(cur.get(i).right!=null){
        				next.add(cur.get(i).right);
        			}
        		}
        	}
        	else{
        		for(int i=cur.size()-1;i>=0;i--){
        			one_res.add(cur.get(i).val);
        			
        			if(cur.get(i).right!=null){
        				next.add(0, cur.get(i).right);
        			}
        			if(cur.get(i).left!=null){
        				next.add(0,cur.get(i).left);
        			}
        		}
        	}
        	leftToRight=!leftToRight;
        	res.add(one_res);
        	cur=next;
        }
        return res;
    }
}
