package leetcode;

import java.util.Stack;

public class WiggleSortII_324 {
	public void wiggleSort(int[] nums) {
        buildMaxHeap(nums);
        Stack<Integer> s=new Stack<Integer>();
        int pos=0;
        int[] res=new int[nums.length];
        int resPos=0;
        while(pos<nums.length||!s.isEmpty()){
        		if(pos<nums.length){
        			s.push(pos);
        			pos=(pos<<1)+1;
        		}
        		else{
        			pos=s.pop();
        			res[resPos++]=nums[pos];
        			pos=(pos<<1)+2;
        		}
        }
        for(int i=0;i<nums.length;i++){
        		nums[i]=res[i];
        }
    }
	public void buildMaxHeap(int[] nums){
		for(int i=(nums.length>>1)-1;i>=0;i--){
			adjust(nums, i);
		}
	}
	public void adjust(int[] nums,int pos){
		if(pos>=nums.length)
			return;
		int max=nums[pos];
		int maxPos=pos;
		int left=(pos<<1)+1;
		int right=(pos<<1)+2;
		if(left<nums.length&&nums[left]>max){
			max=nums[left];
			maxPos=left;
		}
		if(right<nums.length&&nums[right]>max){
			max=nums[right];
			maxPos=right;
		}
		if(maxPos!=pos){
			int tmp=nums[pos];
			nums[pos]=max;
			nums[maxPos]=tmp;
			adjust(nums, maxPos);
		}
	}
}
