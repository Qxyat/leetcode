package leetcodeReview;

import leetcode.ListNode;

public class MergekSortedLists_23 {
	public ListNode mergeKLists(ListNode[] lists) {
        int len=0;
        for(int i=0;i<lists.length;i++)
        		if(lists[i]!=null){
        			lists[len++]=lists[i];
        		}
        buildHeap(lists, len);
        ListNode resHead=new ListNode(0);
        ListNode resRear=resHead;
        while(len>1){
        		resRear.next=lists[0];
        		resRear=lists[0];
        		if(lists[0].next==null){
        			lists[0]=lists[len-1];
        			len--;
        			sortHeap(lists, 0, len);
        		}else{
        			lists[0]=lists[0].next;
        			sortHeap(lists, 0, len);
        		}
        }
        resRear.next=lists[0];
        return resHead.next;
    }
	public void buildHeap(ListNode[] lists,int len){
		int pos=(len>>1)-1;
		for(int i=pos;i>=0;i--)
			sortHeap(lists, i, len);
	}
	public void sortHeap(ListNode[] lists,int pos,int len){
		int left=(pos<<1)+1;
		int right=(pos<<1)+2;
		int minPos=pos;
		if(left<len){
			if(lists[left].val<lists[minPos].val)
				minPos=left;
		}
		if(right<len){
			if(lists[right].val<lists[minPos].val)
				minPos=right;
		}
		if(minPos!=pos){
			ListNode tmp=lists[pos];
			lists[pos]=lists[minPos];
			lists[minPos]=tmp;
			sortHeap(lists, minPos, len);
		}
	}
}
