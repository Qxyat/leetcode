package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BurstBalloons_312 {
	public int maxCoins(int[] nums) {
	    int[] data=new int[nums.length+2];
	    int pos=1;
	    for(int n:nums){
	    		if(n>0){
	    			data[pos++]=n;
	    		}
	    }
	    data[0]=data[pos++]=1;
	    int[][] res=new int[pos][pos];
	    
	    return find(res,data,0,pos-1);
	}
	public int find(int[][] res,int[] data,int left,int right){
		if(left+1==right)
			return 0;
		if(res[left][right]>0)
			return res[left][right];
		int tmp=0;
		for(int i=left+1;i<right;i++){
			tmp=Integer.max(tmp, find(res,data, left, i)+find(res,data,i, right)+data[left]*data[right]*data[i]);
		}
		res[left][right]=tmp;
		return tmp;
	}
}
