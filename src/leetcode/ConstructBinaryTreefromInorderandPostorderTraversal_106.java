package leetcode;

public class ConstructBinaryTreefromInorderandPostorderTraversal_106 {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
	public TreeNode build(int[] inorder,int in_left,int in_right,int[] postorder,int post_left,int post_right){
		if(post_left>post_right)
			return null;
		TreeNode root=new TreeNode(postorder[post_right]);
		int pos=in_left;
		for(;pos<=in_right;pos++){
			if(inorder[pos]==postorder[post_right]){
				break;
			}
		}
		root.left=build(inorder, in_left, pos-1, postorder, post_left, pos-in_left+post_left-1);
		root.right=build(inorder, pos+1, in_right, postorder, pos-in_left+post_left, post_right-1);
		return root;
	}
}
