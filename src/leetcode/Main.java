package leetcode;

import java.util.ArrayList;
import leetcode.PeekingIterator_284.PeekingIterator;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> list=new ArrayList<Integer>();
		list.add(3);
		list.add(1);
		list.add(4);
		list.add(2);
		PeekingIterator iterator=new PeekingIterator(list.iterator());
		System.out.println(iterator.peek());
		System.out.println(iterator.next());
		System.out.println(iterator.next());

		System.out.println(iterator.hasNext());
		System.out.println(iterator.hasNext());
		
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		
		System.out.println(iterator.hasNext());
		
		System.out.println(iterator.peek());
		System.out.println(iterator.next());
		System.out.println(iterator.peek());
		
		System.out.println(iterator.hasNext());
		
		System.out.println(iterator.peek());
	}
}
