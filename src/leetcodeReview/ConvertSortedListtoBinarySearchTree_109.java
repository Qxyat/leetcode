package leetcodeReview;

import leetcode.ListNode;
import leetcode.TreeNode;

public class ConvertSortedListtoBinarySearchTree_109 {
	private ListNode node;
	public TreeNode sortedListToBST(ListNode head) {
		ListNode cur=head;
		int length=0;
		while(cur!=null){
			length++;
			cur=cur.next;
		}
		node=head;
		return build(0,length-1);
    }
	public TreeNode build(int left,int right){
		if(left>right){
			return null;
		}
		if(left==right){
			TreeNode tmp=new TreeNode(node.val);
			node=node.next;
			return tmp;
		}
		int mid=(left+right)>>1;
		TreeNode leftNode=build(left, mid-1);
		TreeNode cur=new TreeNode(node.val);
		node=node.next;
		TreeNode rightNode=build(mid+1, right);
		cur.left=leftNode;
		cur.right=rightNode;
		return cur;
	}
}
