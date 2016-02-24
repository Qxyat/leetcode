package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree_297 {
	// Encodes a tree to a single string.
	class Pair{
		public Pair(TreeNode node){
			this.node=node;
		}
		TreeNode node;
	}
    public String serialize(TreeNode root) {
        Queue<Pair>queue=new ArrayDeque<Pair>();
        StringBuffer res=new StringBuffer();
        if(root==null)
        		return res.toString();
        res.append(root.val);
        queue.add(new Pair(root.left));
        queue.add(new Pair(root.right));
        while(!queue.isEmpty()){
        		Pair cur=queue.poll();
		    	if(cur.node==null){
		    		res.append(",");
		    		res.append("null");
		    	}
		    	else{
		    		res.append(",");
		    		res.append(cur.node.val);
		    		queue.add(new Pair(cur.node.left));
		    		queue.add(new Pair(cur.node.right));
		    	}
        }
        	return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0){
        		return null;
        }
        String[] array=data.split(",");
        TreeNode root=_generateTreeNode(array[0]);
        Queue<Pair> cur=new ArrayDeque<Pair>();
        cur.add(new Pair(root));
        Queue<Pair> last;
        int i=1;
        while(i<array.length){
        		last=cur;
        		cur=new ArrayDeque<Pair>();
        		while(!last.isEmpty()){
        			Pair father=last.poll();
        			if(father.node==null)
        				continue;
        			TreeNode left=_generateTreeNode(array[i++]);
        			TreeNode right=_generateTreeNode(array[i++]);
        			cur.add(new Pair(left));
        			cur.add(new Pair(right));
        			father.node.left=left;
        			father.node.right=right;
        		}
        }
        return root;
    }
    public TreeNode _generateTreeNode(String str){
    		if(str.equals("null"))
    			return null;
    		else
    			return new TreeNode(Integer.parseInt(str));
    }
}
