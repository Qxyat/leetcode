package leetcode;

public class MergekSortedLists_23 {
	public ListNode mergeKLists(ListNode[] lists) {
        ListNode resHead=new ListNode(0);
        ListNode resRear=resHead;
        int heapSize=0;
        for(int i=0;i<lists.length;i++){
        		if(lists[i]!=null){
        			lists[heapSize++]=lists[i];
        		}
        }
        _buildMinHeap(lists, heapSize);
        while(heapSize>1){
        		ListNode minNode=lists[0];
        		ListNode next=minNode.next;
        		minNode.next=null;
        		resRear.next=minNode;
        		resRear=minNode;
        		if(next==null){
        			lists[0]=lists[heapSize-1];
        			heapSize--;		
        		}
        		else{
        			lists[0]=next;
        		}
        		_keepMinHeap(lists, 0, heapSize);
        }
        if(heapSize==1)
        		resRear.next=lists[0];
        
        return resHead.next;
    }
	private void _buildMinHeap(ListNode[] lists,int heapSize){
		for(int pos=(heapSize>>1)-1;pos>=0;pos--){
			_keepMinHeap(lists, pos, heapSize);
		}
	}
	private void _keepMinHeap(ListNode[] lists,int pos,int heapSize){
		int left=((pos+1)<<1)-1;
		int right=(pos+1)<<1;
		int min=pos;
		if(left<heapSize&&lists[left].val<lists[min].val)
			min=left;
		if(right<heapSize&&lists[right].val<lists[min].val)
			min=right;
		if(min!=pos){
			ListNode tmp=lists[min];
			lists[min]=lists[pos];
			lists[pos]=tmp;
			_keepMinHeap(lists, min, heapSize);
		}
	}
	
}
