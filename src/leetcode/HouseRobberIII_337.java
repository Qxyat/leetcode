package leetcode;

public class HouseRobberIII_337 {
	public class Pair{
		int robbed;
		int notRobbed;
		public Pair(int robbed,int notRobbed){
			this.robbed=robbed;
			this.notRobbed=notRobbed;
		}
	}
	public int rob(TreeNode root) {
        Pair res=find(root);
        return Integer.max(res.robbed, res.notRobbed);
    }
	public Pair find(TreeNode root){
		if(root==null)
			return new Pair(0,0);
		Pair left=find(root.left);
		Pair right=find(root.right);
		int robbed=root.val+left.notRobbed+right.notRobbed;
		int notrobbed=Integer.max(left.robbed, left.notRobbed)+Integer.max(right.robbed, right.notRobbed);
		return new Pair(robbed,notrobbed);
	}
}
