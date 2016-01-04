package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal_102 {
	public List<List<Integer>> levelOrder(TreeNode root) {
        
		List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(root==null)
        	return res;
		ArrayList<TreeNode>cur=new ArrayList<TreeNode>();
		cur.add(root);
		while(cur.size()!=0){
			ArrayList<Integer>one_res=new ArrayList<Integer>();
			ArrayList<TreeNode>next=new ArrayList<TreeNode>();
			for(int i=0;i<cur.size();i++){
				TreeNode tmp=cur.get(i);
				one_res.add(tmp.val);
				if(tmp.left!=null)
					next.add(tmp.left);
				if(tmp.right!=null)
					next.add(tmp.right);
			}
			cur=next;
			res.add(one_res);
		}
        return res;
    }
}
