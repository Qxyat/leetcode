package JIanzhiOffer;

public class P26_150 {
	public static class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;

	    RandomListNode(int label) {
	        this.label = label;
	    }
	}
	 public RandomListNode Clone(RandomListNode pHead)
	    {
	        RandomListNode cur=pHead;
	        while(cur!=null){
	            RandomListNode newOne=new RandomListNode(cur.label);
	            newOne.next=cur.next;
	            newOne.random=null;
	            cur.next=newOne;
	            cur=newOne.next;
	        }
	        cur=pHead;
	        while(cur!=null){
	            RandomListNode original=cur;
	            RandomListNode newOne=cur.next;
	            if(original.random!=null){
	                newOne.random=original.random.next;
	            }
	            cur=newOne.next;
	        }
	        RandomListNode newHead=new RandomListNode(0);
	        RandomListNode newRear=newHead;
	        cur=pHead;
	        while(cur!=null){
	            RandomListNode newOne=cur.next;
	            newRear.next=newOne;
	            newRear=newOne;
	            cur=newOne.next;
	        }
	        return newHead.next;
	    }
}
