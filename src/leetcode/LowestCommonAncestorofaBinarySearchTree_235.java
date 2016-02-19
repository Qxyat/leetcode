package leetcode;

import sun.net.www.content.text.plain;

public class LowestCommonAncestorofaBinarySearchTree_235 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val>q.val){
        	return lowestCommonAncestor(root, q, p);
        }
        if(p.val==q.val)
        	return p;
		while(root!=null){
        	if(p.val<=root.val&&root.val<=q.val){
        		return root;
        	}
        	else if(q.val<root.val){
        		root=root.left;
        	}
        	else{
        		root=root.right;
        	}
        }
		return root;
    }
}
