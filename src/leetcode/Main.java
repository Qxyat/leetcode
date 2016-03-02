package leetcode;

import java.util.ArrayList;
import java.util.List;

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
	private String value=null;
	
	public Main(String v){
		value=v;
	}
	public boolean equals(Main m){
		System.out.println("hERE");
		if(m==this)
			return true;
		if(m instanceof Main){
			Main mn=(Main)m;
			return mn.value.equals(value);
		}
		return false;
	}
	public static void main(String[] args){
		System.out.println(new GenerateParentheses_22().generateParenthesis(3));
	}
}
