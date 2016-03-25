package leetcodeReview;

import java.io.UnsupportedEncodingException;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;

import com.sun.javafx.sg.prism.web.NGWebView;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class main {
	public static void main(String[] argc){
		Set<String> set=new HashSet<String>();
		String[] data=new String[]{"ted","tex","red","tax","tad","den","rex","pee"};
		for(int i=0;i<data.length;i++)
			set.add(data[i]);
		//System.out.println(new PalindromePartitioningII_132().minCut("abbab"));
		new SurroundedRegions_130().solve(new char[][]{{'O','O','O'},{'O','O','O'},{'O','O','O'}});
	}
	public void A(String str,int i){
		byte b[]=new byte[1024];
		int num=0;
		b=str.getBytes();
		System.out.println("b length"+b.length);
		System.out.println((int)b[0]);
		System.out.println((int)b[1]);
		if(b[i-1]>0)
			System.out.println(new String(b,0,i));
		else{
			for(int j=0;j<i;j++){
				if(b[j]<0){
					num++;
					num%=2;
				}
				else{
					num=0;
				}
			}
			if(num==0)
				System.out.println(new String(b, 0, i));
			else
				System.out.println(new String(b,0,i-1));
		}
	}
}
