package leetcode;

public class SortList_148 {
	class Pair{
		ListNode head;
		ListNode rear;
		public  Pair() {
			head=null;
			rear=null;
		}
	}
	public ListNode sortList(ListNode head) {
		Pair pair=new Pair();
		sort(head,pair);
		return pair.head; 
    }
	public void sort(ListNode head,Pair pair) {
		if(head==null){
			return;
		}
        ListNode lefthead=new ListNode(0);
        ListNode leftrear=lefthead;
        ListNode midhead=new ListNode(0);
        ListNode midrear=midhead;
        ListNode righthead =new ListNode(0);
        ListNode rightrear=righthead;
        ListNode judgenode=head;
        ListNode cur=head;
        
        while(cur!=null){
        	ListNode tmp=cur.next;
        	cur.next=null;
        	if(cur.val<judgenode.val){
        		leftrear.next=cur;
        		leftrear=cur;
        	}
        	else if(cur.val>judgenode.val){
        		rightrear.next=cur;
        		rightrear=cur;
        	}
        	else{
        		midrear.next=cur;
        		midrear=cur;
        	}
        	cur=tmp;
        }
        Pair left=new Pair();
        Pair right=new Pair();
        sort(lefthead.next,left);
        sort(righthead.next,right);
        midrear.next=right.head;
        if(left.rear==null){
    		pair.head=midhead.next;
        }
        else{
        	left.rear.next=midhead.next;
        	pair.head=left.head;
        }
        if(right.rear!=null)
    		pair.rear=right.rear;
    	else
    		pair.rear=midrear;
	}
}
