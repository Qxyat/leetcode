package leetcode;

public class ReorderList_143 {
	public void reorderList(ListNode head) {
		if(head==null)
	        return;
        ListNode l1=head;
		ListNode l2=head;
		
		while(l2.next!=null&&l2.next.next!=null){
			l1=l1.next;
			l2=l2.next.next;
		}
		
		ListNode rear=l1;
		ListNode cur=l1.next;
		rear.next=null;
		while(cur!=null){
			ListNode tmp=cur.next;
			cur.next=rear.next;
			rear.next=cur;
			cur=tmp;
		}

	    cur=head;
	    rear=l1.next;
	    l1.next=null;
		while(rear!=null){
			ListNode tmp=cur.next;
			cur.next=rear;
			rear=rear.next;
			cur.next.next=tmp;
			cur=tmp;
		}
		
	}
}
