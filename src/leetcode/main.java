package leetcode;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;

import leetcode.InsertInterval_57.Interval;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Interval> data=new ArrayList<Interval>();
		
		//[1,2],[3,5],[6,7],[8,10],[12,16]
		data.add(new Interval(1,2));
		data.add(new Interval(3,5));
		data.add(new Interval(6,7));
		data.add(new Interval(8,10));
		data.add(new Interval(12,16));
		
		System.out.println(new InsertInterval_57().insert(data, new Interval(4, 9)));
	}

}
