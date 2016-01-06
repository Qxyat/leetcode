package leetcode;

public class BalancedBinaryTree_110 {
	public class pair{
		boolean res;
		int height;
		public pair(boolean b,int h){res=b;height=h;}
	}
	public boolean isBalanced(TreeNode root) {
        return judge(root).res;
    }
	public pair judge(TreeNode root){
		if(root==null)
			return new pair(true, 0);
		pair left=judge(root.left);
		if(left.res==false)
			return new pair(false, 0);
		pair right=judge(root.right);
		if(right.res==false)
			return new pair(false, 0);
		if(Math.abs(left.height-right.height)<=1){
			return new pair(true, left.height>right.height?left.height+1:right.height+1);	
		}
		else {
			return new pair(false, 0);
		}
		
	}
}
