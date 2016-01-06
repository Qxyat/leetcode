package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII_107 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>>res =new ArrayList<List<Integer>>();
		if(root==null)
			return res;
		List<TreeNode> cur=new ArrayList<TreeNode>();
		List<TreeNode> next=null;
		cur.add(root);
		while(cur.size()!=0){
			next=new ArrayList<TreeNode>();
			List<Integer>one_res=new ArrayList<Integer>();
			for(int i=0;i<cur.size();i++){
				one_res.add(cur.get(i).val);
				if(cur.get(i).left!=null){
					next.add(cur.get(i).left);
				}
				if(cur.get(i).right!=null){
					next.add(cur.get(i).right);
				}
			}
			cur=next;
			res.add(0, one_res);
		}
		return res;
    }
}
