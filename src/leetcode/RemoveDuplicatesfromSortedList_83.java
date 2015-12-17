package leetcode;


public class RemoveDuplicatesfromSortedList_83 {
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	 public ListNode deleteDuplicates(ListNode head) {
	        ListNode rear=head;
	        ListNode cur=head.next;
	        while(cur!=null){
	        	if(cur.val!=rear.val){
	        		rear.next=cur;
	        		rear=cur;
	        	}
	        	cur=cur.next;
	        }
	        rear.next=null;
	        return head;
	  }
}
