package leetcode;

import java.util.ArrayList;


public class SymmetricTree_101 {
	public boolean isSymmetric(TreeNode root) {
		if(root==null)
			return true;
        ArrayList<TreeNode>cur=new ArrayList<TreeNode>();
        cur.add(root);
       
        while(cur.size()!=0){
        	 ArrayList<TreeNode>next=new ArrayList<TreeNode>();
        	 int left=0;
        	 int right=cur.size()-1;

    		 while(left<right){
        		 if(!isEqual(cur.get(left),cur.get(right)))
        			 return false;
        		 if(!isEqual(cur.get(left),cur.get(right)))
        			 return false;
        		 left++;
        		 right--;
    		 }    		 
        	 
        	 for(int i=0;i<cur.size();i++){
        		 TreeNode tmp=cur.get(i);
        		 if(tmp!=null){
        		 next.add(tmp.left);
        		 next.add(tmp.right);}
        	 }
        	 cur=next;
        }
        return true;
    }
	public boolean isEqual(TreeNode a,TreeNode b){
		if(a==null&&b==null)
			return true;
		else if(a==null||b==null)
			return false;
		else{
			if(a.val==b.val)
				return true;
			return false;
		}
	}
}
