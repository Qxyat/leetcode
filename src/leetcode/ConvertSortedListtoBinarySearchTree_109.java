package leetcode;

import java.util.ArrayList;

public class ConvertSortedListtoBinarySearchTree_109 {
	public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> data=new ArrayList<Integer>();
        while (head!=null) {
        	data.add(head.val);
        	head=head.next;
		}	
        return build(data,0,data.size()-1);
    }
	public TreeNode build(ArrayList<Integer> nums,int left,int right){
		if(left>right)
			return null;
		int mid=(left+right)/2;
		TreeNode root=new TreeNode(nums.get(mid));
		root.left=build(nums, left, mid-1);
		root.right=build(nums, mid+1, right);
		return root;
	}
}
