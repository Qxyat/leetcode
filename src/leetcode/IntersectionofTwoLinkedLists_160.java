package leetcode;

public class IntersectionofTwoLinkedLists_160 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur;
        int countA=0;
        int countB=0;
        cur=headA;
        while(cur!=null){
        	countA++;
        	cur=cur.next;
        }
        cur=headB;
        while(cur!=null){
        	countB++;
        	cur=cur.next;
        }
        while(countB>countA){
        	headB=headB.next;
        	countB--;
        }
        while(countA>countB){
        	headA=headA.next;
        	countA--;
        }
        while(headA!=null&&headB!=null){
        	if(headA==headB)
        		return headA;
        	headA=headA.next;
        	headB=headB.next;
        }
        return null;
    }
}
