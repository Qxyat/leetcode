package JIanzhiOffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

import com.sun.org.apache.bcel.internal.generic.NEW;

import JIanzhiOffer.P26_150.RandomListNode;

public class main {
	static class Solution {
	    public int minNumberInRotateArray(int [] array) {
	    	if(array.length==0)
	    		return 0;
	    	int left=0,right=array.length-1;
		        while(left<right){
		            int mid=(left+right)>>1;
			        if(array[left]==array[right]){
			        		right--;
			        		continue;
			        }
	            if(array[left]<array[mid]&&array[mid]<array[right]){
	                return array[left];
	            }
	            else if(array[left]<=array[mid]&&array[mid]>array[right]){
	                left=mid+1;
	            }
	            else if(array[left]>array[mid]&&array[mid]<array[right]){
	                right=mid;
	            }
	            else{
	                right--;
	            }
	      
	        }
	        //return left;
	        return array[left];
	    }
	}
	
	public static void main(String[] argc){
		int[]data={};
		System.out.println(new Solution().minNumberInRotateArray(data));
	}
}
