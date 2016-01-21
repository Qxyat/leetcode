package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		ListNode head=new ListNode(0);
		ListNode rear=head;
		int[] data=new int[]{1};
		for(int i=0;i<data.length;i++){
			ListNode cur=new ListNode(data[i]);
			rear.next=cur;
			rear=cur;
		}
		new ReorderList_143().reorderList(head.next);
		System.out.println("hah");
	}
}
