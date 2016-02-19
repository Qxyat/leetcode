package leetcode;

public class LowestCommonAncestorofaBinaryTree_236 {
	boolean findp;
	boolean findq;
	TreeNode res;
	boolean findres;
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		search(root,p,q);
		return res;
    }
	public void search(TreeNode root,TreeNode p,TreeNode q){
		if(root==null)
			return;
		
		findp=false;
		findq=false;
		search(root.left, p, q);
		boolean leftfindp=findp;
		boolean leftfindq=findq;
		
		findp=false;
		findq=false;
		search(root.right, p, q);
		boolean rightfindp=findp;
		boolean rightfindq=findq;
		
		boolean rootfindp=false;
		boolean rootfindq=false;
		if(root.val==p.val)
			rootfindp=true;
		else if(root.val==q.val)
			rootfindq=true;
		if(!findres){
			if(p.val!=q.val){
				if((leftfindp&&rightfindq)||(leftfindq&&rightfindp)||(leftfindp&&rootfindq)||(leftfindq&&rootfindp)||(rootfindp&&rightfindq)||(rootfindq&&rightfindp)){
					res=root;
					findres=true;
				}
			}
			else if(p.val==q.val&&((leftfindp&&rightfindp)||((leftfindp||rightfindp)&&rootfindp))){
				res=root;
				findres=true;
			}
		}
		
		findp=leftfindp|rightfindp|rootfindp;
		findq=leftfindq|rightfindq|rootfindq;
	}
}
