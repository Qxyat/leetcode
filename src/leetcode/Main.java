package leetcode;

import java.util.ArrayList;
import leetcode.PeekingIterator_284.PeekingIterator;

class myException extends Exception{
	public myException() {
		// TODO Auto-generated constructor stub
		
	}
	public void printStackTrace(){
		System.out.println("HaHa");
		super.printStackTrace();
		
	}
}
public class Main {
	static enum wrongCode {A,B,C};
	public static void test(int a) throws myException{
		if(a==0)
			throw new myException();
	}
	public static void main(String[] args) {
		//String data="9,3,4,#,#,1,#,#,2,#,6,#,#";
		//String data="1,#";
		String[][] data=new String[][]{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		System.out.println(new ReconstructItinerary_332().findItinerary(data));
	}
}
