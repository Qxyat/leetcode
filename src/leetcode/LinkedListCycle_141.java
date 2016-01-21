package leetcode;

public class LinkedListCycle_141 {
	public boolean hasCycle(ListNode head) {
		if(head==null)
			return false;
		ListNode node1=head;
		ListNode node2=head.next;
		while(node1!=null&&node2!=null&&node2.next!=null&&node1!=node2){
			node1=node1.next;
			node2=node2.next.next;
		}
		if(node1==null||node2==null||node2.next==null)
			return false;
		else
			return true;
    }
}
