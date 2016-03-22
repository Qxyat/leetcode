package JIanzhiOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P65_290 {
	public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
		ArrayList<Integer> res=new ArrayList<Integer>();
		if(num==null||num.length==0||size<=0)
			return res;
		LinkedList<Integer> queue=new LinkedList<Integer>();
		for(int i=0;i<num.length;i++){
			while(!queue.isEmpty()&&queue.peekFirst()<i-size+1)
				queue.poll();
			while(!queue.isEmpty()&&num[queue.peekLast()]<num[i])
				queue.pollLast();
			queue.add(i);
			if(i>=size-1)
				res.add(num[queue.peekFirst()]);
		}
		//hrow new Exception();
		return res;
    }
}
