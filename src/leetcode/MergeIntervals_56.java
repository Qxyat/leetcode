package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals_56 {
	public static class Interval {
		int start;
	    int end;
	    public Interval() { start = 0; end = 0; }
	    public Interval(int s, int e) { start = s; end = e; }
	    @Override
	    public String toString(){
	    	return "["+start+","+end+"]";
	    }
	}
	public List<Interval> merge(List<Interval> intervals) {
		Interval[] data=(Interval[])intervals.toArray(new Interval[intervals.size()]);
        Arrays.sort(data, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start-o2.start;
			}
		});
        List<Interval>result=new ArrayList<Interval>();
        int i=0;
        while(i<data.length){
        	int start=data[i].start;
        	int end=data[i].end;
        	while(i<data.length&&end>=data[i].start){
        		end=Integer.max(end, data[i].end);
        		i++;
        	}
        	result.add(new Interval(start, end));
        }
        return result;
    }
}
