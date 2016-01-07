package leetcode;

public class PopulatingNextRightPointersinEachNode_116 {
	public void connect(TreeLinkNode root) {
        if(root==null)
        	return;
        TreeLinkNode pre=root;
        while(pre!=null){
        	TreeLinkNode next_head=new TreeLinkNode(0);
        	TreeLinkNode next_rear=next_head;
        	while(pre!=null){
        		if(pre.left!=null){
        			next_rear.next=pre.left;
        			next_rear=pre.left;
        		}
        		if(pre.right!=null){
        			next_rear.next=pre.right;
        			next_rear=pre.right;
        		}
        		pre=pre.next;
        	}
        	pre=next_head.next;
        }
    }
}
