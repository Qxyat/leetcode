package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaximumDepthofBinaryTree_104 {
	public int maxDepth(TreeNode root) {
		if(root==null)
			return 0;
		List<TreeNode> cur=new ArrayList<TreeNode>();
		List<TreeNode> next=null; 
		cur.add(root);
		int depth=0;
		while(cur.size()!=0){
			depth++;
			next=new ArrayList<TreeNode>();
			for(int i=0;i<cur.size();i++){
				if(cur.get(i).left!=null)
					next.add(cur.get(i).left);
				if(cur.get(i).right!=null)
					next.add(cur.get(i).right);	
			}
			cur=next;
		}
		return depth;
    }
}
