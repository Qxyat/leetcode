package leetcode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII_95 {
	public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res=new ArrayList<TreeNode>();
        for(int i=1;i<=n;i++){
        	List<TreeNode>lefts=generate(1,i-1);
        	List<TreeNode>rights=generate(i+1, n);
        	for(int p=0;p<lefts.size();p++)
        		for(int q=0;q<rights.size();q++){
        			TreeNode tmp=new TreeNode(i);
        			tmp.left=lefts.get(p);
        			tmp.right=rights.get(q);
        			res.add(tmp);
        		}
        }
        return res;
    }
	public List<TreeNode> generate(int left,int right){
		List<TreeNode> res=new ArrayList<TreeNode>();
		if(left>right){
			res.add(null);
			return res;
		}
		else{
			for(int i=left;i<=right;i++){
				List<TreeNode>lefts=generate(left,i-1);
	        	List<TreeNode>rights=generate(i+1, right);
	        	for(int p=0;p<lefts.size();p++)
	        		for(int q=0;q<rights.size();q++){
	        			TreeNode tmp=new TreeNode(i);
	        			tmp.left=lefts.get(p);
	        			tmp.right=rights.get(q);
	        			res.add(tmp);
	        		}
			}
			return res;
		}
	}
}
