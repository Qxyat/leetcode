package leetcode;

public class SameTree_100 {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)
        	return true;
        else if(p==null||q==null)
        	return false;
        else{
        	if(p.val==q.val){
        		boolean left=isSameTree(p.left, q.left);
        		if(left)
        			return isSameTree(p.right, q.right);
        		else
        			return left;
        	}
        	return false;
        }
    }
}
