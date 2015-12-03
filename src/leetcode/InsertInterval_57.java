package leetcode;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval_57 {
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
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result=new ArrayList<Interval>();
		boolean used=false;
		boolean isInUse=false;
		int start=0;
		int end=0;
		for(int i=0;i<intervals.size();i++){
			if(!used){
				if(!isInUse){
					if(newInterval.end<intervals.get(i).start){
						result.add(newInterval);
						used=true;
						i--;
					}
					else{
						if(newInterval.start<=intervals.get(i).end){
							start=Integer.min(newInterval.start, intervals.get(i).start);
							end=Integer.max(newInterval.end, intervals.get(i).end);
							isInUse=true;
						}
						else{
							result.add(intervals.get(i));
						}
					}
				}
				else{
					if(end<intervals.get(i).start){
						result.add(new Interval(start, end));
						used=true;
						i--;
					}
					else{
						end=Integer.max(end, intervals.get(i).end);
					}
				}
				
			}
			else{
				result.add(intervals.get(i));
			}
		}
		if(!used)
			if(!isInUse)
				result.add(newInterval);
			else
				result.add(new Interval(start, end));
		return result;
	}
}
