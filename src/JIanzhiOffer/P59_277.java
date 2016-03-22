package JIanzhiOffer;

public class P59_277 {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	boolean isSymmetrical(TreeNode pRoot)
    {
		if(pRoot==null)
			return true;
		return judge(pRoot.left,pRoot.right);
    }
	public boolean judge(TreeNode left,TreeNode right){
		if(left==null&&right==null)
			return true;
		else if(left==null)
			return false;
		else if(right==null)
			return false;
		else{
			if(left.val==right.val)
				return judge(left.left, right.right)&&judge(left.right, right.left);
			else 
				return false;
		}
	}
}
