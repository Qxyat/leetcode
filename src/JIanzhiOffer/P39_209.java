package JIanzhiOffer;

import java.lang.Integer;
public class P39_209 {
	class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
	}
	public boolean IsBalanced_Solution(TreeNode root) {
		if(find(root)==-1)
			return false;
		return true;
    }
	public int find(TreeNode root){
		if(root==null)
			return 0;
		int left=find(root.left);
		int right=find(root.right);
		if(left==-1||right==-1)
			return -1;
		if(Math.abs(left-right)<=1){
			return Integer.max(left, right)+1;
		}
		return -1;
	}
}
