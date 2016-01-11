package leetcode;

public class BinaryTreeMaximumPathSum_124 {
	int max=Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
        find(root);
        return max;
    }
	public int find(TreeNode root){
		if(root.left==null&&root.right==null){
			max=Integer.max(max, root.val);
			return root.val;
		}
		int left=0;
		int right=0;
		if(root.left==null){
			right=find(root.right);
		}
		else if(root.right==null){
			left=find(root.left);
		}
		else {
			left=find(root.left);
			right=find(root.right);
		}
		int danbian=Integer.max(root.val,left+root.val);
		danbian=Integer.max(danbian, right+root.val);
		max=Integer.max(left+right+root.val, max);
		max=Integer.max(danbian, max);
		return danbian;
	}
}
