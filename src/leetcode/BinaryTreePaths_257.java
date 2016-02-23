package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_257 {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String>reStrings=new ArrayList<String>();
		StringBuffer sBuffer=new StringBuffer();
		if(root==null){
			return reStrings;
		}
		sBuffer.append(root.val);
		if(root.left==null&&root.right==null){
			reStrings.add(sBuffer.toString());
			
			return reStrings;
		}
		find(reStrings,sBuffer,root.left);
		find(reStrings, sBuffer, root.right);
		return reStrings;
    }
	public void find(List<String>res,StringBuffer sBuffer,TreeNode root){
		if(root==null)
			return;
		
		else{
			String tmp="->"+Integer.toString(root.val);
			sBuffer.append(tmp);
			if(root.left==null&&root.right==null){
				res.add(sBuffer.toString());
				sBuffer.delete(sBuffer.length()-tmp.length(), sBuffer.length());
				return ;
			}
			find(res, sBuffer, root.left);
			find(res, sBuffer, root.right);
			sBuffer.delete(sBuffer.length()-tmp.length(), sBuffer.length());
		}
	}
}
