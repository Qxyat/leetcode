package leetcode;

public class InsertionSortList_147 {
	public ListNode insertionSortList(ListNode head) {
		ListNode dummyHead=new ListNode(0);
		ListNode pre,cur;
		ListNode insertNode;
		cur=head;
		while(cur!=null){
			pre=dummyHead;
			insertNode=dummyHead.next;
			while(insertNode!=null){
				if(cur.val>insertNode.val){
					insertNode=insertNode.next;
					pre=pre.next;
				}
				else {
					break;
				}
			}
			ListNode tmp=cur.next;
			pre.next=cur;
			cur.next=insertNode;
			cur=tmp;
		}
		return dummyHead.next;
    }
}
