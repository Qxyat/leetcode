package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII_113 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer>one_res=new ArrayList<Integer>();
        find(res,one_res,root,sum);
        return res;
    }
	public void find(List<List<Integer>>res,List<Integer>one_res,TreeNode root,int sum){
		if(root==null)
			return;
		one_res.add(root.val);
		if(root.left==null&&root.right==null){
			if(sum==root.val){
				res.add(new ArrayList<>(one_res));
			}
		}
		find(res, one_res, root.left, sum-root.val);
		find(res, one_res, root.right, sum-root.val);
		one_res.remove(one_res.size()-1);
	}
}
