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
		try {
			test(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			double a=0.0;
			if(a==0.00){
				System.out.println("yes");
			}
			System.out.println(wrongCode.C);
		}
	}
}
