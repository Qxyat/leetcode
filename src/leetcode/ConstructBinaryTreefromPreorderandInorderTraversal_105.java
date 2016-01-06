package leetcode;

public class ConstructBinaryTreefromPreorderandInorderTraversal_105 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
	public TreeNode build(int[] preorder,int pre_left,int pre_right,int[] inorder,int in_left,int in_right){
		if(pre_left>pre_right)
			return null;
		TreeNode root=new TreeNode(preorder[pre_left]);
		int pos=in_left;
		for(;pos<=in_right;pos++){
			if(inorder[pos]==preorder[pre_left])
				break;
		}
		root.left=build(preorder, pre_left+1, pre_left+pos-in_left, inorder, in_left, pos-1);
		root.right=build(preorder, pre_left+pos-in_left+1, pre_right, inorder, pos+1, in_right);
		return root;
	}
}
