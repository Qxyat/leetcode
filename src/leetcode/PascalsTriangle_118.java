package leetcode;

import java.util.ArrayList;
import java.util.List;


public class PascalsTriangle_118 {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer> pre=new ArrayList<Integer>();
        for(int i=1;i<=numRows;i++){
        	List<Integer> cur=new ArrayList<Integer>();
        	int first=0;
        	int rear=0;
        	if(i==1)
        		first=1;
        	for(int j=0;j<pre.size();j++){
        		cur.add(first+pre.get(j));
        		first=pre.get(j);
        	}
        	cur.add(first+rear);
        	res.add(cur);
        	pre=cur;
        }
        return res;
    }
}
