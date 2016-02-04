package leetcode;

public class Main {
	public static void main(String[] args) {
		int[] data=new int[]{1,3,2,4};
		ListNode head=new ListNode(0);
		ListNode rear=head;
		for(int i=0;i<data.length;i++){
			ListNode cur=new ListNode(data[i]);
			rear.next=cur;
			rear=cur;
		}
		//new SortList_148().sortList(head.next);
		
		int[] data1=new int[]{-2,-3,7};
		int res=new MaximumProductSubarray_152().maxProduct(data1);
		System.err.println(res);
	}
}
