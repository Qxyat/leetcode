package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class SlidingWindowMaximum_239 {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums==null||nums.length==0){
			return new int[0];
		}
		int[] res=new int[nums.length-k+1];
		int respos=0;
		ArrayDeque<Integer> queue=new ArrayDeque<Integer>();
		int i=0;
		while(i<nums.length){
			while(!queue.isEmpty()&&queue.peek()<i-k+1)
				queue.poll();
			while(!queue.isEmpty()&&nums[queue.peekLast()]<=nums[i])
				queue.pollLast();
			queue.offer(i);
			if(i>=k-1){
				res[respos++]=nums[queue.poll()];
			}
		}
		return res;
    }
}
