package leetcodeReview;

import java.util.Arrays;

public class PalindromePartitioningII_132 {
	public int minCut(String s) {
		if(s==null||s.length()<=1)
			return 0;
		int[]cache=new int[s.length()];
		Arrays.fill(cache, Integer.MAX_VALUE);
		for(int i=0;i<s.length();i++){
			cache[i]=Integer.min(cache[i], i-1>=0?cache[i-1]+1:0);
			int left=i-1,right=i+1;
			while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
				cache[right]=Integer.min(cache[right],left-1>=0?cache[left-1]+1:0);
				left--;
				right++;		
			}
			
			left=i-1;
			right=i;
			while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
				cache[right]=Integer.min(cache[right] ,left-1>=0?cache[left-1]+1:0);
				left--;
				right++;		
			}	
		}
		
		return cache[s.length()-1];
    }
}
