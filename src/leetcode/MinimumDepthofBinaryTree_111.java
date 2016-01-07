package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MinimumDepthofBinaryTree_111 {
	public int minDepth(TreeNode root) {
		if(root==null)
			return 0;
		List<TreeNode> cur=new ArrayList<TreeNode>();
		cur.add(root);
		int depth=0;
		while(cur.size()!=0){
			depth++;
			List<TreeNode>next=new ArrayList<TreeNode>();
			for(int i=0;i<cur.size();i++){
				TreeNode tmp=cur.get(i);
				if(tmp.left==null&&tmp.right==null)
					return depth;
				if(tmp.left!=null)
					next.add(tmp.left);
				if(tmp.right!=null)
					next.add(tmp.right);
			}
			cur=next;
		}
		return 0;
    }
}
