package leetcode;

public class PalindromeLinkedList_234 {
	public boolean isPalindrome(ListNode head) {
		if(head==null)
		    return true;
		ListNode cur1=head;
		ListNode cur2=head;
		while(cur2!=null&&cur2.next!=null){
			if(cur2.next.next==null){
				break;
			}
			cur1=cur1.next;
			cur2=cur2.next.next;
		}
		ListNode mid=cur1;
		cur2=mid.next;
		mid.next=null;
		while(cur2!=null){
			ListNode tmp=cur2.next;
			cur2.next=mid.next;
			mid.next=cur2;
			cur2=tmp;
		}
		cur2=mid.next;
		cur1=head;
		while(cur2!=null){
			if(cur1.val!=cur2.val)
				return false;
			cur1=cur1.next;
			cur2=cur2.next;
		}
		return true;
	}
}
