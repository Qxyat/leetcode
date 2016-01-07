package leetcode;

public class PathSum_112 {
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root==null)
			return false;
		return judge(root,sum);
        
    }
	public boolean judge(TreeNode root, int sum) {
		if(root==null)
			return false;
		if(root.left==null&&root.right==null){
        	if(sum==root.val)
        		return true;
        	else 
        		return false;
        }	
        return judge(root.left, sum-root.val)|judge(root.right, sum-root.val);
	}
}
