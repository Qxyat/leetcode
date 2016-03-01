package leetcode;

public class OddEvenLinkedList_328 {
	public ListNode oddEvenList(ListNode head) {
		ListNode newOldHead=new ListNode(0);
		ListNode newEvenHead=new ListNode(0);
		ListNode newOldRear=newOldHead;
		ListNode newEvenRear=newEvenHead;
		int count=1;
		while(head!=null){
			if((count&1)==1){
				newOldRear.next=head;
				newOldRear=head;
			}
			else{
				newEvenRear.next=head;
				newEvenRear=head;
			}
			head=head.next;
			count++;
		}
		newOldRear.next=newEvenHead.next;
		newEvenRear.next=null;
		return newOldHead.next;
    }
}
