package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class UniquePaths_62 {
	
	public int uniquePaths(int m, int n) {
		int sum=m+n;
		int min=Integer.min(m, n);
	    long fenmu=1,fenzi=1;
		for(int count=1;count<=min;count++){
			fenmu=fenmu*(sum-count+1);
			fenzi=fenzi*count;
		}
		return (int) (fenmu/fenzi);
    }
	
}
