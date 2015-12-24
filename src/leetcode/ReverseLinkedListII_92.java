package leetcode;

public class ReverseLinkedListII_92 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newhead=new ListNode(0);
        newhead.next=head;
        
        int pos=1;
        ListNode up_rear=newhead;
        ListNode down_rear=null;
        ListNode cur=head;
        
        while(cur!=null){
        	if(pos<m){
        		up_rear=up_rear.next;
        		cur=cur.next;
        	}
        	else if(pos==m){
        		down_rear=cur;
        		cur=cur.next;
        	}
        	else if(pos>m&&pos<=n){
        		ListNode tmp=cur.next;
        		cur.next=up_rear.next;
        		up_rear.next=cur;
        		cur=tmp;
			}
        	else {
				break;
			}
        	pos++;
        	
        }
        down_rear.next=cur;
        return newhead.next;
    }
}
