package leetcode;

public class RemoveDuplicatesfromSortedListII_82 {
	
	  public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	
	public class Solution {
		public ListNode deleteDuplicates(ListNode head) {
            ListNode newhead=new ListNode(0);
	        ListNode rear=newhead;
	        if(head==null)
	        	return null;
	        int last=head.val;
	        boolean findNewVal=true;
	        ListNode cur=head.next;
	        while(cur!=null){
	        	if(cur.val==last){
	        		findNewVal=false;
	        	}
	        	else{
	        		if(findNewVal==true){
	        		    ListNode tmp=new ListNode(last);
	        			rear.next=tmp;
	        			rear=tmp;
	        		}else
	        			findNewVal=true;
	        	    last=cur.val;
	        	}
	        	cur=cur.next;
	        }
	        if(findNewVal==true){
	        		    ListNode tmp=new ListNode(last);
	        			rear.next=tmp;
	        			rear=tmp;
	        		}
	        rear.next=null;
	        return newhead.next;
    }
	}
}
