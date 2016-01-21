package leetcode;

public class LinkedListCycleII_142 {
	 public ListNode detectCycle(ListNode head) {
		 
		 if(head==null)
			 return null;
	      ListNode n1=head;
	      ListNode n2=head.next;
	      while(n1!=null&&n2!=null&&n2.next!=null&&n1!=n2){
	    	  n1=n1.next;
	    	  n2=n2.next.next;
	      }
	      if(n1==n2){
	    	  int count=1;
	    	  n2=n1.next;
	    	  while(n2!=n1){
	    		  n2=n2.next;
	    		  count++;
	    	  }
	    	  ListNode newhead=new ListNode(0);
	    	  newhead.next=head;
	    	  int len=0;
	    	  n2=newhead;
	    	  while(len!=count){
	    		  n2=n2.next;
	    		  len++;
	    	  }
	    	  n1=newhead;
	    	  while(n1.next!=n2.next){
	    		  n1=n1.next;
	    		  n2=n2.next;
	    	  }
	    	  return n1.next;
	      }
	      else
	    	  return null;
	 }
}
