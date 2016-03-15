package leetcodeReview;

import java.io.UnsupportedEncodingException;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.SortedSet;

public class main {
	public static void main(String[] argc){
		int[] data=new int[]{};
		new PermutationsII_47().permuteUnique(data);
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
