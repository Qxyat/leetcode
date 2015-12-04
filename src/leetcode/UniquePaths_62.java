package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class UniquePaths_62 {
	HashSet<pair> used=new HashSet<>();
	HashMap<pair,Integer> count=new HashMap<pair,Integer>();
	public static class pair{
		int a;
		int b;
		public pair(int a,int b){
			this.a=a;
			this.b=b;
		}
	}
	public int uniquePaths(int m, int n) {
		return find(1, 1, m, n); 
    }
	public int find(int row,int col,int m,int n){
		if(used.contains(new pair(row, col)))
			return 0;
		used.add(new pair(row, col));
		
		if(row>m||col>n)
			return 0;
		if(count.containsKey(new pair(m-row, n-col))||count.containsKey(new pair(n-col,m-row))){
			return count.get(new pair(m-row, n-col));
		}
		if(row==m)
			return 1;
		if(col==n)
			return 1;
		int res=find(row+1, col, m, n)+find(row, col+1, m, n);
		count.put(new pair(m-row, n-col), res);
		return res;
	}
}
