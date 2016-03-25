package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CountofSmallerNumbersAfterSelf_315 {
	class Pair{
		int val;
		int pos;
		int count;
		public Pair(int val,int pos){
			this.pos=pos;
			this.val=val;
			this.count=0;
		}
	}
	public List<Integer> countSmaller(int[] nums) {
		Pair[] data=new Pair[nums.length];
		
		for(int i=0;i<nums.length;i++){
			data[i]=new Pair(nums[i],i);
		}
		
		mergeSort(data,0,data.length-1);
		
		Arrays.sort(data, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				return o1.pos-o2.pos;
			}
		});
		List<Integer> res=new ArrayList<Integer>();
		for(Pair p:data){
			res.add(p.count);
		}
		return res;
    }
	public void mergeSort(Pair[] data,int left,int right){
		if(left>=right)
			return;
		int mid=(left+right)>>1;
		mergeSort(data, left, mid);
		mergeSort(data, mid+1, right);
		int leftPos=0;
		int rightPos=0;
		int leftLen=mid-left+1;
		int rightLen=right-mid;
		int curLen=right-left+1;
		Pair[] cache=new Pair[curLen];
		int pos=0;
		while(leftPos<leftLen&&rightPos<rightLen){
			if(data[left+leftPos].val<=data[mid+1+rightPos].val){
				data[left+leftPos].count+=rightPos;
				cache[pos++]=data[left+leftPos];
				leftPos++;
			}
			else if(data[left+leftPos].val>data[mid+1+rightPos].val){
				cache[pos++]=data[mid+1+rightPos];
				rightPos++;
			}
		}
		while(leftPos<leftLen){
		    data[left+leftPos].count+=rightPos;
		    cache[pos++]=data[left+leftPos];
		    leftPos++;
		}
		while(rightPos<rightLen){
		    cache[pos++]=data[mid+1+rightPos];
		    rightPos++;
		}
		for(int i=0;i<curLen;i++){
			data[left+i]=cache[i];
		}
	}
}
