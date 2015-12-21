package leetcode;

public class PartitionList_86 {
	 public static class ListNode {
		 int val;
		 ListNode next;
	     ListNode(int x) { val = x; }
	 }
	 public ListNode partition(ListNode head, int x) {
	      ListNode lefthead=new ListNode(0);
	      ListNode righthead=new ListNode(0);
	      ListNode leftrear=lefthead;
	      ListNode rightrear=righthead;
	      ListNode cur=head;
	      while(cur!=null){
	    	  if(cur.val<=x){
	    		  leftrear.next=cur;
	    		  leftrear=cur;
	    	  }
	    	  else{
	    		  rightrear.next=cur;
	    		  rightrear=cur;
	    	  }
	    	  cur=cur.next;
	      }
	      leftrear.next=righthead.next;
	      rightrear.next=null;
	      return lefthead.next;
	 }
}
