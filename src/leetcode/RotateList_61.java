package leetcode;

public class RotateList_61 {
	public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
	}
	public ListNode rotateRight(ListNode head, int k) {
		int len=0;
		ListNode cur=head;
		while(cur!=null){
			cur=cur.next;
			len++;
		}
		if(len==0)
		    return head;
		k=k%len;
		if(k==0)
			return head;
		ListNode tmp_head=new ListNode(0);
		tmp_head.next=head;
		ListNode rear=tmp_head;
		cur=tmp_head;
		int count=0;
		while(count<k){
			count++;
			cur=cur.next;
		}
		while(cur.next!=null){
			rear=rear.next;
			cur=cur.next;
		}
	    cur.next=tmp_head.next;
		tmp_head.next=rear.next;
		rear.next=null;

		return tmp_head.next;
	}
}
