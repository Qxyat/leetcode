package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianfromDataStream_295 {
	Queue<Long> right=new PriorityQueue<Long>();
	Queue<Long> left=new PriorityQueue<Long>();
	// Adds a number into the data structure.
    public void addNum(int num) {
        right.add((long)num);
        left.add(-right.poll());
        if(left.size()>right.size())
        		right.add(-left.poll());
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(left.size()==right.size())
        		return (-left.peek()+right.peek())/2.0;
        return right.peek();
    }
}
