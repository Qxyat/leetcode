package JIanzhiOffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

import JIanzhiOffer.P26_150.RandomListNode;

public class main {
	public static void main(String[] argc){
		P28_154 p28_154=new P28_154();

		ArrayList<Integer> data=new ArrayList<Integer>();
		String s1="1";
		switch(s1){
			case "2":
				System.out.println("hello");
				break;
				
		}
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					main.class.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		for (Integer integer : data) {
			
		}
		HashMap<Integer, Integer>lMa=new HashMap<Integer,Integer>();
	    lMa.put(1, 2);
	    
	    lMa.put(3, 4);
	    lMa.put(2,3);
	    List<Integer> list=new ArrayList<Integer>();
	  
	    for(Iterator<Integer> iterator=lMa.values().iterator();iterator.hasNext();)
	    	System.out.println(iterator.next());
		
		Vector<Integer> v=new Vector<Integer>();
		Iterator<Integer> iterator=data.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
			iterator.remove();
			
		}
		System.out.println("haha");
		iterator=data.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
			iterator.remove();
			
		}
	}
}
