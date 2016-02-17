package leetcode;

public class CountCompleteTreeNodes_222 {
	public int countNodes(TreeNode root) {
       int height=level(root);
       if(height<0)
    	   return 0;
       if(level(root.right)==height-1){
    	   int res=(1<<height)+countNodes(root.right);
    	   return res;
       }
       int res=(1<<(height-1))+countNodes(root.left);
       return res;
    }
	public int level(TreeNode root){
		return root==null?-1:1+level(root.left);
	}
}
