package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReorderList_143 {
	public void reorderList(ListNode head) {
		ListNode l1=head;
		ListNode l2=head;
		
		while(l2.next!=null&&l2.next.next!=null){
			l1=l1.next;
			l2=l2.next.next;
		}
		
		ListNode middle=l1;
		ListNode halfhead=l1.next;
		while(halfhead!=null){
			middle.next=halfhead
		}
    }
}
