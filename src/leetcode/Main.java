package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

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
class A{
	String name;
	void value(){
		name="China";
	}
}
class B extends A{
	public String name;
	void value(){
		name="Hefei";
		super.value();
		System.out.println(name);
		System.out.println(super.name);
	}
}
abstract class C{
	abstract public void Test();
}
public class Main {
	public static void main(String[] args){
		String s="a";
	   
	    System.out.println(s);
	}
}
