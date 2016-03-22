package JIanzhiOffer;

public class P56_270 {
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null||pHead.next==null)
        		return null;
		ListNode slow=pHead;
        ListNode fast=pHead;
        slow=slow.next;
        fast=fast.next.next;
        while(slow!=null&&fast!=null&&slow!=fast){
        		slow=slow.next;
        		if(fast.next==null)
        			return null;
        		fast=fast.next.next;
        }
        if(slow!=fast)
        		return null;
        fast=pHead;
        while(fast!=slow){
        		fast=fast.next;
        		slow=slow.next;
        }
        return slow;
    }
}
