package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Triangle_120 {
	public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==0)
        	return 0;
        List<Integer>pre=triangle.get(0);
        for(int i=1;i<triangle.size();i++){
        	List<Integer>cur=new ArrayList<Integer>();
        	for(int j=0;j<triangle.get(i).size();j++){
        		int min=Integer.MAX_VALUE;
        		if(j-1>=0){
        			min=Integer.min(pre.get(j-1)+triangle.get(i).get(j), min);
        		}
        		if(j<triangle.get(i-1).size())
        			min=Integer.min(pre.get(j)+triangle.get(i).get(j), min);
        		cur.add(min);
        	}
        	pre=cur;
        }
        int res=Integer.MAX_VALUE;
        for(int i=0;i<pre.size();i++){
        	res=Integer.min(res, pre.get(i));
        }
        return res;
    }
}
