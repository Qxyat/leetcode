package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII_119 {
	public List<Integer> getRow(int rowIndex) {
		List<Integer>pre=new ArrayList<Integer>();
		if(rowIndex<0)
			return pre;
		pre.add(1);
		for(int i=1;i<=rowIndex;i++){
			int first=0;
			int rear=0;
			List<Integer> cur=new ArrayList<Integer>();
			for(int j=0;j<pre.size();j++){
				cur.add(first+pre.get(j));
				first=pre.get(j);
			}
			cur.add(first+rear);
			pre=cur;
		}
		return pre;
    }
}
