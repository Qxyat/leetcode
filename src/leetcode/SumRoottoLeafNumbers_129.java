package leetcode;

public class SumRoottoLeafNumbers_129 {
	int res=0;
	public int sumNumbers(TreeNode root) {
        find(root,0);
        return res;
    }
	public void find(TreeNode root,int cur){
		if(root==null)
			res+=cur;
		else{
			int tmp=cur*10+root.val;
			if(root.left==null&&root.right==null){
				res+=tmp;
				return;
			}
			if(root.left!=null)
				find(root.left,tmp);
			if(root.right!=null)
				find(root.right,tmp);
		}
	}
}
